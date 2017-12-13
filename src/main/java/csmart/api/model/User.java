package csmart.api.model;

import csmart.api.db.JsonType;
import csmart.db.gen.tables.records.UsersRecord;

/**
 * Created by sethur on 1/10/2016.
 */
public class User {
    private int id;
    private String email;
    private String password;
    private String name;

    public User(UsersRecord user) {
        this.id= user.getId();
        this.email= user.getEmail();
        this.password = user.getPassword();
        this.name = user.getName();
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
