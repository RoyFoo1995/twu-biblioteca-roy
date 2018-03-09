package biblioteca.manager;


public interface IManager {
    void showList();

    void checkOutByName(String name);

    void returnByName(String name);
}
