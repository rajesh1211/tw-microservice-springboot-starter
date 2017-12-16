package csmart.api.dao;

import csmart.api.model.Book;
import csmart.api.model.User;
import csmart.db.gen.tables.records.BookIssuesRecord;
import csmart.db.gen.tables.records.BooksRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.tools.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//TODO This has to be changed to Java DateTime
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static csmart.db.gen.tables.Books.BOOKS;
import static csmart.db.gen.tables.BookIssues.BOOK_ISSUES;


@Repository
@Transactional
public class BookRepo{
    @Autowired
    private DSLContext dsl;

    private void setDialact() {
        ((DefaultConfiguration) ((DefaultDSLContext) dsl).configuration()).setSQLDialect(SQLDialect.POSTGRES);
    }

    public Book createBook(Book book){
        setDialact();
        BooksRecord record = dsl.insertInto(BOOKS)
                .columns(
                        BOOKS.NAME,
                        BOOKS.ISBN,
                        BOOKS.GENRE_ID,
                        BOOKS.TYPE_ID,
                        BOOKS.AUTHOR_ID,
                        BOOKS.PUBLICATION_DATE,
                        BOOKS.EDITION,
                        BOOKS.PRICE,
                        BOOKS.QUANTITY_LEFT
                        )
                .values(
                        book.getName(),
                        book.getIsbn(),
                        book.getGenre_id(),
                        book.getType_id(),
                        book.getAuthor_id(),
                        (Timestamp) book.getPublication_date(),
                        book.getEdition(),
                        book.getPrice(),
                        book.getQuantity_left()
                        )
                .returning()
                .fetchOne()
                .into(BooksRecord.class);
        return new Book(record);
    }

    public void deleteBookById(int id){
        setDialact();
        if ( ! bookIssuedToSomeone(id)) {
            dsl.delete(BOOKS)
                    .where(BOOKS.ID.eq(id))
                    .execute();
        }else{
            throw new RuntimeException("Can not delete the book as it is already assigned");
        }

    }

    public boolean bookIssuedToSomeone(int id) {
        BookIssuesRecord bookIssue =
                dsl.select()
                        .from(BOOK_ISSUES)
                        .where(BOOK_ISSUES.BOOK_ID.eq(id))
                        .fetchOne()
                        .into(BookIssuesRecord.class);
        if (bookIssue == null){
            return true;
        }else{
            return false;
        }
    }

    public Book updateBook(Book book){
        setDialact();
        BooksRecord record = dsl.update(BOOKS)
                .set(BOOKS.NAME, book.getName())
                .set(BOOKS.ISBN, book.getIsbn())
                .set(BOOKS.GENRE_ID, book.getGenre_id())
                .set(BOOKS.TYPE_ID, book.getType_id())
                .set(BOOKS.AUTHOR_ID, book.getAuthor_id())
                .set(BOOKS.PUBLICATION_DATE, (Timestamp) book.getPublication_date())
                .set(BOOKS.EDITION, book.getEdition())
                .set(BOOKS.PRICE, book.getPrice())
                .set(BOOKS.QUANTITY_LEFT, book.getQuantity_left())
                .where(BOOKS.ID.eq(book.getId()))
                .returning()
                .fetchOne()
                .into(BooksRecord.class);
        return new Book(record);
    }

    // Created for testing purpose
    public Book getBookById(int id) {
        setDialact();
        BooksRecord book =
                dsl.select()
                        .from(BOOKS)
                        .where(BOOKS.ID.eq(id))
                        .fetchOne()
                        .into(BooksRecord.class);

        return new Book(book);
    }

    public List<Book> searchBooks(JSONObject jsonParams) {
        // TODO Join query to be written between books and book_tags table
        return new ArrayList<Book>();
    }
}
