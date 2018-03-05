package biblioteca;


public interface IBookManager {
    void showBookList();

    void checkOutByName(String bookName);

    void returnTheBookByName(String bookName);
}
