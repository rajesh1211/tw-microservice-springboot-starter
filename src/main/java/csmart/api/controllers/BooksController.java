package csmart.api.controllers;

import csmart.api.builders.BookBuilder;
import csmart.api.model.Book;
import csmart.api.service.BookService;
import org.jooq.tools.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity createBooks(@RequestBody Object bookObject){
        try {
            BookBuilder bookBuilder = new BookBuilder(bookObject);
            List<Book> books = bookBuilder.getBooks();
            Map response = bookService.createBooks(books);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBookById(@PathVariable("id") int id){
        try {
            if (id != 0) {
                bookService.deleteBookById(id);
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        try {
            if (book.valid()) {
                return new ResponseEntity<Book>(bookService.updateBook(book), HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/search-book", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> searchBooks(@RequestBody LinkedHashMap params){
        JSONObject jsonParams = new JSONObject(params);
        return new ResponseEntity(bookService.searchBooks(jsonParams), HttpStatus.OK);
    }
}