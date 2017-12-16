package csmart.api.service;

import csmart.api.model.Book;
import org.jooq.tools.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface IBookService {
    Book createBook(Book book);

    void deleteBookById(int id);

    Book updateBook(Book book);

    List<Book> searchBooks(JSONObject jsonParams);
}
