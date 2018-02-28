package biblioteca;

import biblioteca.bean.Book;
import biblioteca.data.BookData;
import biblioteca.util.Console;

import java.util.ArrayList;

public class BookManager implements IBookManager {
    @Override
    public void showBookList(ArrayList<Book> list) {
        Console.getInstance().println("The book List:");
        for (int i = 0; i < list.size(); i++) {
            Book book = list.get(i);
            Console.getInstance().println((i+1)+". "+book.getBookName()+"  author:"+book.getBookAuthor()+"  time:"+book.getBookTime());
        }
    }
}
