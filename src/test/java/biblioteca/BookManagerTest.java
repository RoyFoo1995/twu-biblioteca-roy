package biblioteca;

import biblioteca.bean.Book;
import biblioteca.data.BookData;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BookManagerTest {
    private IBookManager manager;
    private ArrayList<Book> list;
    ByteArrayOutputStream bo;

    @Before
    public void setUp() {
        manager = new BookManager();
        bo = new ByteArrayOutputStream();
        list = BookData.getInstance().getBookData();
        System.setOut(new PrintStream(bo));
    }


    @Test
    public void showBookListWhenIChooseFun() {
        manager.showBookList(list);
        StringBuilder builder = new StringBuilder();
        builder.append("The book List:\n");
        for (int i = 0; i < list.size(); i++) {
            Book book = list.get(i);
            builder.append(i+1).append(". ")
                    .append(book.getBookName())
                    .append("  author:")
                    .append(book.getBookAuthor())
                    .append("  time:")
                    .append(book.getBookTime())
                    .append("\n");
        }
        assertThat(bo.toString(), is(builder.toString()));
    }

    @Test
    public void showRightMsgWhenICheckoutTheBook() {

    }
}
