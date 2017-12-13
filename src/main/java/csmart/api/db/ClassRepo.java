package csmart.api.db;

import csmart.api.model.Class;
import csmart.api.model.User;
import csmart.db.gen.tables.records.ClassesRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectJoinStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import static csmart.db.gen.tables.Classes.CLASSES;
import static csmart.db.gen.tables.Users.USERS;


/**
 * Created by sethur on 1/10/2016.
 */
@Repository
@Transactional
public class ClassRepo {

    @Autowired
    private DSLContext dsl;

    public void createClass(Class klass){
        dsl.insertInto(CLASSES)
                .columns(CLASSES.ID, CLASSES.SUBJECT, CLASSES.USER_ID)
                .values(
                        klass.getId(),
                        klass.getSubject(),
                        klass.getUserId())
                .execute();
    }

    public Class getClass(int id){
        ClassesRecord klass =
                dsl.select()
                        .from(CLASSES)
                        .where(CLASSES.ID.eq(id))
                        .fetchOne()
                        .into(ClassesRecord.class);

        return new Class(klass);
    }

    public List<Class> getClasses() throws SQLException {
        ResultSet rs2 = dsl.selectFrom(CLASSES).fetchResultSet();
        List<Class> records = new ArrayList<Class>();
        Class klass;
        while(rs2.next()) {
            klass = new Class();
            klass.setId(rs2.getInt("id"));
            klass.setUserId(rs2.getInt("user_id"));
            klass.setSubject(rs2.getString("subject"));
            records.add(klass);
        }
        return records;
    }

    public List<User> getUsersByClass(int id) throws SQLException{
        ResultSet rs2 = dsl.select()
                .from(CLASSES)
                .join(USERS)
                .onKey()
                .where(CLASSES.ID.eq(id))
                .fetchResultSet();
        List<User> records = new ArrayList<User>();
        User user;
        while(rs2.next()) {
            user = new User();
            user.setEmail(rs2.getString(5));
            user.setId(rs2.getInt(4));
            user.setName(rs2.getString(7));
            records.add(user);
        }
        return records;
    }
}
