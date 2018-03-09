package biblioteca.model;

import java.util.ArrayList;

public interface IData<T> {
    void generateData();
    ArrayList<T> getData();
    T getTheClassByName(String name);
}
