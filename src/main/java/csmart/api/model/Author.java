package csmart.api.model;

import csmart.db.gen.tables.Authors;
import csmart.db.gen.tables.records.AuthorsRecord;

public class Author {
    private int id;
    private String name;

    Author() {

    }

    Author(AuthorsRecord author) {
        this.id = author.getId();
        this.name = author.getName();
    }

    Author(int id , String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
