package biblioteca.manager;


public interface IManager {
    void showList();

    void checkOutByName(String bookName);

    void returnByName(String bookName);
}
