package biblioteca.model;

import biblioteca.entity.Movie;
import biblioteca.util.XMLUtil;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.Iterator;

public class MovieData implements IData<Movie> {

    private static MovieData movieData;
    private ArrayList<Movie> movies;

    private MovieData() {
    }

    public static MovieData getInstance(){
        if (movieData == null) {
            synchronized (BookData.class) {
                if (movieData == null) {
                    movieData = new MovieData();
                    movieData.generateData();
                }
            }
        }
        return movieData;
    }

    @Override
    public void generateData() {
        try {
            movies = new ArrayList<>();
            Element root = XMLUtil.getRootElement("/movieList.xml");
            Element foo;
            for (Iterator i = root.elementIterator("movie"); i.hasNext(); ) {
                foo = (Element) i.next();//todo 考虑用反射
                String name = foo.elementText("name");
                String director = foo.elementText("director");
                String year = foo.elementText("year");
                String status = foo.elementText("status");
                String rating = foo.elementText("rating");
                Movie movie = new Movie(name,year,director,rating,Integer.valueOf(status));
                movies.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Movie> getData() {
        return movies;
    }

    @Override
    public Movie getTheClassByName(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }
}
