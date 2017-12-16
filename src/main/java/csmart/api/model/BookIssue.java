package csmart.api.model;

import csmart.db.gen.tables.records.BookIssuesRecord;

public class BookIssue {
    private int id;
    private int user_id;
    private int book_id;

    BookIssue() {}
    public BookIssue(BookIssuesRecord bookIssue) {
        this.id = bookIssue.getId();
        this.user_id = bookIssue.getUserId();
        this.book_id = bookIssue.getBookId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
}
