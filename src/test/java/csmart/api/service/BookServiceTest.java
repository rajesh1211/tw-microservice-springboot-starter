package csmart.api.service;

import csmart.AbstractTest;
import csmart.api.dao.BookRepo;
import csmart.api.model.Book;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

public class BookServiceTest extends AbstractTest{
    @MockBean
    private BookRepo bookRepo;

    @Autowired
    private BookService service;

    @Test
    public void shouldReturnTheSuccessfullySavedBooks(){
        Book book1 = new Book();
        book1.setId(1);
        book1.setIsbn("A01");
        Book book2 = new Book();
        book2.setId(2);
        book2.setIsbn("A02");

        when(bookRepo.createBook(book1)).thenReturn(book1);
        when(bookRepo.createBook(book2)).thenReturn(book2);
        List<Book> booksEntered = new ArrayList<Book>();
        booksEntered.add(book1);
        booksEntered.add(book2);
        Map response = service.createBooks(booksEntered);

        Assert.assertEquals("Saved successfully",
                "All Records saved Successfully", response.get("message").toString());
        Assert.assertEquals("Returns the list of saved records", 2,
                ((List<Book>)response.get("records")).size());
    }

    @Test
    public void shouldReturnTheSuccessfullyWithUnsavedMessage(){
        Book book1 = new Book();
        book1.setId(1);
        book1.setIsbn("A01");

        Book book2 = new Book();
        book2.setId(2);
        book2.setIsbn(null);

        when(bookRepo.createBook(book1)).thenReturn(book1);
        when(bookRepo.createBook(book2)).thenReturn(book2);
        List<Book> booksEntered = new ArrayList<Book>();
        booksEntered.add(book1);
        booksEntered.add(book2);
        Map response = service.createBooks(booksEntered);
        Assert.assertEquals("Few Records Saved successfully",
                "Some Records failed to save",response.get("message").toString());
        Assert.assertEquals("Returns the list of invalid records", 1,
                ((List<Book>)response.get("records")).size());
    }

//    @Test(expected = RuntimeException.class)
//    public void shouldNotDeleteTheBookWhenItIsAlreasyIssued(){
//        Book book1 = new Book();
//        book1.setId(1);
//        book1.setIsbn("A01");
//        when(bookRepo.bookIssuedToSomeone(1)).thenReturn(false);
//        bookRepo.deleteBookById(1);
//    }
}
