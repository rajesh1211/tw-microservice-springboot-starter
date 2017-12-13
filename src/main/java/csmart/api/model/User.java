package csmart.api.model;

import csmart.api.db.JsonType;
import csmart.db.gen.tables.records.UsersRecord;

/**
 * Created by sethur on 1/10/2016.
 */
public class User {
    private String emailid;
    private String password;
    private String name;

    public User(UsersRecord user) {
        this.emailid = user.getEmailid();
        this.password = user.getPassword();
        this.name = user.getName();
    }

    public User() {

    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
