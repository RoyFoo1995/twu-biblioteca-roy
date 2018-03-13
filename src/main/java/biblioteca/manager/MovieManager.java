package biblioteca.manager;

import biblioteca.entity.Menu;
import biblioteca.entity.Movie;
import biblioteca.model.MovieData;
import biblioteca.util.Console;

import java.util.ArrayList;

public class MovieManager implements IManager {

    private ArrayList<Movie> movies;

    public MovieManager() {
        this.movies = MovieData.getInstance().getData();
    }

    @Override
    public void showList() {
        Console.getInstance().println("The movie List:");
        int index = 0;
        for (int i = 1; i <= movies.size(); i++) {
            Movie movie = movies.get(i -1);
            if (movie.getStatus() == Menu.CHECK_OUTED) {
                index++;
                continue;
            }
            String msg = String.format("%d. %-30s director:%-20s rating:%-10s time:%s",
                    (i - index), movie.getName(),movie.getDirector(),movie.getRating(),movie.getYear());
            Console.getInstance().println(msg);
        }
    }

    @Override
    public void checkOutByName(String name) {
        Movie movie = MovieData.getInstance().getTheClassByName(name);
        if (movie != null && movie.getStatus() == Menu.CAN_READ) {
            movie.setStatus(Menu.CHECK_OUTED);
            Console.getInstance().println("Thank you! Enjoy the movie.");
            return;
        }
        Console.getInstance().println("That movie is not available.");
    }

    @Override
    public void returnByName(String name) {
        Movie movie = MovieData.getInstance().getTheClassByName(name);
        if (movie != null && movie.getStatus() == Menu.CHECK_OUTED) {
            movie.setStatus(Menu.CAN_READ);
            Console.getInstance().println("Thank you for returning the movie.");
            return;
        }
        Console.getInstance().println("That is not a valid movie to return.");
    }
}
