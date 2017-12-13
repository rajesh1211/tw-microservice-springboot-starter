package csmart.api.db;

import csmart.api.model.User;
import csmart.db.gen.tables.records.UsersRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static csmart.db.gen.tables.Users.USERS;


/**
 * Created by sethur on 1/10/2016.
 */
@Repository
@Transactional
public class UserRepo {

    @Autowired
    private DSLContext dsl;

    public void createUser(User user){
        dsl.insertInto(USERS)
                .columns(USERS.ID, USERS.EMAIL, USERS.PASSWORD, USERS.NAME)
                .values(
                        user.getId(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getName())
                .execute();
    }

    public User getUserById(int id){
        UsersRecord user =
                dsl.select()
                        .from(USERS)
                        .where(USERS.ID.eq(id))
                        .fetchOne()
                        .into(UsersRecord.class);

        return new User(user);
    }

    public List<User> getUsers() throws SQLException {
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
}
