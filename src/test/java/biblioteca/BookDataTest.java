package biblioteca;

import biblioteca.bean.Book;
import biblioteca.data.BookData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookDataTest {

    private BookData bookData;

    @Before
    public void setUp() {
        bookData = BookData.getInstance();
    }


    @Test
    public void returnTheSameListWhenICallGetBookData() {
        ArrayList<Book> bookArrayList = bookData.getBookData();
        assertThat(bookData.getBookData(), is(bookArrayList));
    }

}
