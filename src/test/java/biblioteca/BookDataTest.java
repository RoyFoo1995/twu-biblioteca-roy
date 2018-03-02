package biblioteca;

import biblioteca.bean.Book;
import biblioteca.data.BookData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookDataTest {

    private BookData bookData;
    private ArrayList<Book> bookArrayList;

    @Before
    public void setUp() {
        bookData = BookData.getInstance();
        bookArrayList = bookData.getBookData();
    }


    @Test
    public void returnTheSameListWhenICallGetBookData() {
        bookArrayList = bookData.getBookData();
        assertThat(bookData.getBookData(), is(bookArrayList));
    }

    @Test
    public void deleteTheBookWhenICallDeleteFunByName() {
        String bookName = "A brief history of humankind";
        bookData.deleteBookByName(bookName);
        Book book2 = null;
        for (Book book :
                bookArrayList) {
            if (book.getBookName().equals(bookName)) {
                book2 = book;
            }
        }
        assertThat(BookData.getInstance().getBookData(),hasItem(book2));
    }
}
