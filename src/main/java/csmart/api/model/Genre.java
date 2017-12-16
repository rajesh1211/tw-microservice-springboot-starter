package csmart.api.model;

import csmart.db.gen.tables.records.GenresRecord;

public class Genre {
    private int id;
    private String name;

    public Genre(GenresRecord genre) {
        this.id= genre.getId();
        this.name= genre.getName();
    }

    public Genre(int id, String name) {
        this.id= id;
        this.name = name;
    }

    public Genre() {
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
