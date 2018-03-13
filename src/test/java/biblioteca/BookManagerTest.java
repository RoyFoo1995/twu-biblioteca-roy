package biblioteca;

import biblioteca.entity.Book;
import biblioteca.model.BookData;
import biblioteca.entity.Menu;
import biblioteca.manager.BookManager;
import biblioteca.manager.IManager;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BookManagerTest {
    private IManager manager;
    private ArrayList<Book> list;
    private ByteArrayOutputStream bo;



    @Before
    public void setUp() {
        list = BookData.getInstance().getData();
        manager = new BookManager();
        bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
    }


    @Test
    public void showBookListWhenIChooseFun() {
        manager.showList();
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
        manager.returnByName(bookName);
        assertThat(bo.toString(),is("Thank you for returning the book.\n"));
        bo.reset();
        String bookName2 = "unKnowBook";
        manager.returnByName(bookName2);
        assertThat(bo.toString(),is("That is not a valid book to return.\n"));
    }
}
