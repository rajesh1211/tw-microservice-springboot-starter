package csmart.api.model;

import com.sun.xml.internal.ws.wsdl.writer.document.Types;
import csmart.db.gen.tables.records.GenresRecord;
import csmart.db.gen.tables.records.TypesRecord;

public class Type {
    private int id;
    private String name;

    public Type() {
    }

    public Type(TypesRecord type) {
        this.id= type.getId();
        this.name= type.getName();
    }

    public Type(int id, String name) {
        this.id= id;
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
