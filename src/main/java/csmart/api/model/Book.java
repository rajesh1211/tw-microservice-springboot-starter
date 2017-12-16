package csmart.api.model;

import csmart.db.gen.tables.records.BooksRecord;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Book {
    private int id;
    private String name;
    private String isbn;
    private int genre_id;
    private int type_id;
    private int author_id;
    private Date publication_date;
    private String edition;
    private BigDecimal price;
    private int quantity_left;

    public Book() {}
    public Book(BooksRecord book) {
        id = book.getId();
        name = book.getName();
        isbn = book.getIsbn();
        genre_id = book.getGenreId();
        type_id = book.getTypeId();
        author_id = book.getAuthorId();
        publication_date = book.getPublicationDate();
        edition = book.getEdition();
        price = book.getPrice();
        quantity_left = book.getQuantityLeft();
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity_left() {
        return quantity_left;
    }

    public void setQuantity_left(int quantity_left) {
        this.quantity_left = quantity_left;
    }

    public boolean valid() {
        // TODO We can put the validations on book model here
        if (this.getIsbn() == null) {
            return false;
        }
        return true;
    }
}
