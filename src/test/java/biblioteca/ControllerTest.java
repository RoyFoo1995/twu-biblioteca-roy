package biblioteca;

import biblioteca.data.Menu;
import biblioteca.util.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ControllerTest {
    private ByteArrayOutputStream bo;
    private Controller controller;

    @Before
    public void setUp() {
        bo = new ByteArrayOutputStream();
        controller = new Controller();
        System.setOut(new PrintStream(bo));
    }

    @Test
    public void showMainMenuTest() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Menu.mainMenu.length; i++) {
            builder.append(i + 1).append(". ").append(Menu.mainMenu[i]).append("\n");
        }
        String msg = builder.toString();
        controller.showMainMenu();
        assertThat(bo.toString(), is(msg));
    }

    @Test
    public void showWelcomeMsgTest() {
        String msg = "----Welcome to Biblioteca Application----";
        controller.showWelcomeMsg(msg);
        assertThat(bo.toString(),is(msg+"\n"));
    }

    @Test
    public void quitTest() {
        controller.quit();
        assertThat(bo.toString(),is("Quit Success!"));
    }
}