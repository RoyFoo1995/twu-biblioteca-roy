package biblioteca;


import biblioteca.util.Console;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ConsoleTest {
    ByteArrayOutputStream bo;

    @Before
    public void setUp() {
        bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
    }

    @Test
    public void printlnHelloWorldWhenIComeIn(){
        Console.getInstance().println("HelloWorld");
        assertThat(bo.toString(),is("HelloWorld\n"));
    }

    @Test
    public void printHelloWorldWhenIComeIn(){
        Console.getInstance().print("HelloWorld");
        assertThat(bo.toString(),is("HelloWorld"));
    }
}
