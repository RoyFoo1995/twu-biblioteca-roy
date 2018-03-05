package biblioteca;

import biblioteca.bean.Book;
import biblioteca.data.BookData;
import biblioteca.data.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BookManagerTest {
    private BookManager manager;
    private ArrayList<Book> list;
    private ByteArrayOutputStream bo;



    @Before
    public void setUp() {
        manager = new BookManager();
        bo = new ByteArrayOutputStream();
        list = BookData.getInstance().getBookData();
        System.setOut(new PrintStream(bo));
    }


    @Test
    public void showBookListWhenIChooseFun() {
        manager.showBookList();
    }

    @Test
    public void showRightMsgWhenICheckoutTheBookByName() {
        String bookName = "A brief history of humankind";
        manager.checkOutByName(bookName);
        assertThat(bo.toString(),is("Thank you! Enjoy the book.\n"));
        bo.reset();
        String bookName2 = "unKnowName";
        manager.checkOutByName(bookName2);
        assertThat(bo.toString(),is("That book is not available.\n"));
    }

    @Test
    public void showRightMsgWhenIReturnTheBookByName() {
        String bookName = "A brief history of humankind";
        list.get(0).setBookStatue(Menu.CHECK_OUTED);
        manager.returnTheBookByName(bookName);
        assertThat(bo.toString(),is("Thank you for returning the book.\n"));
        bo.reset();
        String bookName2 = "unKnowBook";
        manager.returnTheBookByName(bookName2);
        assertThat(bo.toString(),is("That is not a valid book to return.\n"));
    }
}
