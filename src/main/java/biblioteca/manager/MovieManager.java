package biblioteca.manager;

import biblioteca.bean.Menu;
import biblioteca.bean.Movie;
import biblioteca.util.Console;

import java.util.ArrayList;

public class MovieManager implements IManager {

    private ArrayList<Movie> movies;

    public MovieManager(ArrayList<Movie> movies) {
        this.movies = movies;
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
    public void checkOutByName(String bookName) {

    }

    @Override
    public void returnByName(String bookName) {

    }
}
