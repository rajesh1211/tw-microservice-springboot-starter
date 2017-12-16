package csmart.api.builders;

import com.fasterxml.jackson.databind.ObjectMapper;
import csmart.api.model.Book;
import org.jooq.tools.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BookBuilder {
    private Object params;
    public BookBuilder(Object params) {
        this.params = params;
    }

    public List<Book> getBooks() throws IOException {
        List<Book> books;
        books = new ArrayList<Book>();
        if (params instanceof LinkedHashMap) {
            books.add(mapFromJson(new JSONObject((LinkedHashMap) params).toString(), Book.class));
        } else if (params instanceof ArrayList) {
            for (LinkedHashMap book : (List<LinkedHashMap>) params) {
                Book newBook = mapFromJson(new JSONObject(book).toString(), Book.class);
                books.add(newBook);
            }
        }
        return books;
    }

    // TODO This has to moved to a utility class
    private <T> T mapFromJson(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }
}
