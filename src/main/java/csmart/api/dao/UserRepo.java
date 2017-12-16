package csmart.api.dao;

import csmart.api.model.User;
import csmart.db.gen.tables.records.UsersRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static csmart.db.gen.tables.Users.USERS;


/**
 * Created by Rajesh Raikwar on 14/12/2017.
 */
@Repository
@Transactional
public class UserRepo {

    @Autowired
    private DSLContext dsl;

    private void setDialact() {
        ((DefaultConfiguration) ((DefaultDSLContext) dsl).configuration()).setSQLDialect(SQLDialect.POSTGRES);
    }

    public User createUser(User user){
        setDialact();
        UsersRecord record = dsl.insertInto(USERS)
                .columns(USERS.ID, USERS.EMAIL, USERS.PASSWORD, USERS.NAME)
                .values(
                        user.getId(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getName())
                .returning()
                .fetchOne()
                .into(UsersRecord.class);

        return new User(record);
    }

    public User getUserById(int id){
        setDialact();
        UsersRecord user =
                dsl.select()
                        .from(USERS)
                        .where(USERS.ID.eq(id))
                        .fetchOne()
                        .into(UsersRecord.class);

        return new User(user);
    }

    public List<User> getUsers() throws SQLException {
        setDialact();
        ResultSet rs2 = dsl.selectFrom(USERS).fetchResultSet();
        List<User> records = new ArrayList<User>();
        User user;
        while(rs2.next()) {
            user = new User();
            user.setId(rs2.getInt("id"));
            user.setName(rs2.getString("name"));
            user.setEmail(rs2.getString("email"));
            records.add(user);
        }

        return records;
    }

    public User updateUserById(User user) {
        setDialact();
        UsersRecord record = dsl.update(USERS)
                .set(USERS.NAME, user.getName())
                .where(USERS.ID.eq(user.getId()))
                .returning()
                .fetchOne()
                .into(UsersRecord.class);

        return new User(record);
    }
}
