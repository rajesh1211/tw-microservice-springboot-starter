package csmart.api.model;

public class Class {
    private int id;
    private String subject;
    private int userId;

    public Class(ClassesRecord klass) {
        this.id = klass.getId();
        this.subject = klass.getSubject();
        this.userId = klass.getUserId();
    }

    public Class() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
