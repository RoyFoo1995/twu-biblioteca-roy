package biblioteca;

import biblioteca.bean.Movie;
import biblioteca.data.BookData;
import biblioteca.data.MovieData;
import biblioteca.manager.BookManager;
import biblioteca.manager.IManager;
import biblioteca.manager.MovieManager;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class MovieManagerTest {
    private IManager movieManager;
    private ArrayList<Movie> list;
    private ByteArrayOutputStream bo;

    @Before
    public void setUp() throws Exception {
        list = MovieData.getInstance().getData();
        movieManager = new MovieManager(list);
        bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
    }

    @Test
    public void showListWhenIChooseFun() {
        movieManager.showList();
    }
}
