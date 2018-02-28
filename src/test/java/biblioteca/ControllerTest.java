package biblioteca;

import biblioteca.data.Menu;
import biblioteca.util.Console;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ControllerTest {
    ByteArrayOutputStream bo;

    @Before
    public void setUp() {
        bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
    }

    @Test
    public void showMainMenuTest() {
        Controller controller = new Controller();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Menu.mainMenu.length; i++) {
            builder.append((i + 1) + ". " + Menu.mainMenu[i]+"\n");
        }
        String msg = builder.toString();
        controller.showMainMenu();
        assertThat(bo.toString(), is(msg));
    }

    @Test
    public void showWelcomeMsgTest() {
        Controller controller = new Controller();
        String msg = "----Welcome to Biblioteca Application----";
        controller.showWelcomeMsg(msg);
        assertThat(bo.toString(),is(msg+"\n"));
    }

    @Test
    public void quitTest() {
        Controller controller = new Controller();
        controller.quit();
        assertThat(bo.toString(),is("Quit Success!"));
    }
}