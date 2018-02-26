package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ControllerTest {
    ByteArrayOutputStream bo;

    @Before
    public void setUp() {
        bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
    }

    @Test
    public void showMainMenu() {

    }

    @Test
    public void showWelcomeMsg() {

    }

    @Test
    public void choose() {

    }

    @Test
    public void quit() {

    }

    @Test
    public void showBookList() {

    }
}