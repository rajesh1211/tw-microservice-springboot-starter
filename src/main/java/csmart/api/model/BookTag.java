package csmart.api.model;

import csmart.db.gen.tables.records.BookTagsRecord;

public class BookTag {
    private int id;
    private int book_id;
    private String tag;

    BookTag() {}
    BookTag(BookTagsRecord bookTag) {
        this.id = bookTag.getId();
        this.book_id = bookTag.getBookId();
        this.tag = bookTag.getTag();
    }
}
