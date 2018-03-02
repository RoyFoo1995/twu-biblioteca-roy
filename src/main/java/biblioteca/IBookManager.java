package biblioteca;

import biblioteca.bean.Book;

import java.util.ArrayList;

public interface IBookManager {
    void showBookList(ArrayList<Book> list);

    boolean checkOutByName(String bookName);

    void returnTheBook(String bookName);
}
