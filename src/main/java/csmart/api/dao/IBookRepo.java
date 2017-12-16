package csmart.api.dao;

import csmart.api.model.Book;
import org.springframework.stereotype.Component;

@Component
public interface IBookRepo {
    void createBooks(Book book);
    void deleteBookById(int id);
    Book updateBook(Book book);
}
