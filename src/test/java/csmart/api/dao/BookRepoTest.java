package csmart.api.dao;

import csmart.AbstractTest;
import csmart.api.model.Book;
import csmart.api.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Date;

public class BookRepoTest extends AbstractTest{

    @MockBean
    private BookRepo bookRepo;

    private Book book;

    @Before
    public void createBook() {
        book = new Book();
        book.setName("Prisoner of Azkaban");
        book.setId(1);
        book.setAuthor_id(1);
        book.setGenre_id(1);
        book.setIsbn("A01010");
        book.setType_id(1);
        book.setEdition("4");
        book.setPrice(BigDecimal.valueOf(100.0));
        book.setQuantity_left(1);
    }

    @Test
    public void shouldDeleteTheBookFromDb(){
//        TODO
    }
}
