package csmart.api.service;

import csmart.api.dao.BookRepo;
import csmart.api.model.Book;
import org.jooq.tools.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookService implements IBookService{
    @Autowired
    private BookRepo bookRepo;

    public Book createBook(Book book){
        return bookRepo.createBook(book);
    }

    public void deleteBookById(int id){
         bookRepo.deleteBookById(id);
    }

    public Book updateBook(Book book){
        return bookRepo.updateBook(book);
    }

    public List<Book> searchBooks(JSONObject jsonParams) {
        return bookRepo.searchBooks(jsonParams);
    }

    public Map createBooks(List<Book> books){
        List<Book> invalidBooks = null;
        List<Book> savedBooks = null;
        boolean successfullCreate = true;
        for (Book book : books) {
            if (book.valid()) {
                if (savedBooks == null) {
                    savedBooks = new ArrayList<Book>();
                }
                savedBooks.add(createBook(book));
            }else{
                successfullCreate = false;
                if (invalidBooks == null) {
                    invalidBooks = new ArrayList<Book>();
                }
                invalidBooks.add(book);
            }
        }
        Map response = new HashMap();
        if (successfullCreate) {
            response.put("message", "All Records saved Successfully");
            response.put("records", savedBooks);
        }else{
            response.put("message", "Some Records failed to save");
            response.put("records", invalidBooks);
        }
        return response;
    }
}
