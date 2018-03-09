package biblioteca;

import biblioteca.entity.Menu;
import biblioteca.entity.Movie;
import biblioteca.model.MovieData;
import biblioteca.manager.IManager;
import biblioteca.manager.MovieManager;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MovieManagerTest {
    private IManager movieManager;
    private ArrayList<Movie> list;
    private ByteArrayOutputStream bo;

    @Before
    public void setUp(){
        list = MovieData.getInstance().getData();
        movieManager = new MovieManager(list);
        bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
    }

    @Test
    public void showListWhenIChooseFun() {
        movieManager.showList();
    }
    
    @Test
    public void showRightMsgWhenICheckoutTheMovieByName() {
        String movieName = "Lady Bird";
        movieManager.checkOutByName(movieName);
        assertThat(bo.toString(),is("Thank you! Enjoy the movie.\n"));
        bo.reset();
        String movieName2 = "unKnowMovie";
        movieManager.checkOutByName(movieName2);
        assertThat(bo.toString(),is("That movie is not available.\n"));
    }

    @Test
    public void showRightMsgWhenIReturnTheMovieByName() {
        String movieName = "Lady Bird";
        list.get(0).setStatus(Menu.CHECK_OUTED);
        movieManager.returnByName(movieName);
        assertThat(bo.toString(),is("Thank you for returning the movie.\n"));
        bo.reset();
        String movieName2 = "unKnowMovie";
        movieManager.returnByName(movieName2);
        assertThat(bo.toString(),is("That is not a valid movie to return.\n"));
    }
}
