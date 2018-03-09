package biblioteca.manager;

import biblioteca.bean.Book;
import biblioteca.data.BookData;
import biblioteca.bean.Menu;
import biblioteca.util.Console;

import java.util.ArrayList;

public class BookManager implements IManager {

    private ArrayList<Book> books;

    public BookManager(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public void showList() {
        Console.getInstance().println("The book List:");
        int index = 0;
        for (int i = 1; i <= books.size(); i++) {
            Book book = books.get(i - 1);
            if (book.getBookStatue() == Menu.CHECK_OUTED) {
                index++;
                continue;
            }
            String msg = String.format("%d. %-42s author:%-20s time:%s", (i - index), book.getBookName(), book.getBookAuthor(), book.getBookTime());
            Console.getInstance().println(msg);
        }

    }

    @Override
    public void checkOutByName(String bookName) {
        Book book = BookData.getInstance().getTheClassByName(bookName);
        if (book != null && book.getBookStatue() == Menu.CAN_READ) {
            book.setBookStatue(Menu.CHECK_OUTED);
//            BookData.getInstance().changeBookStatusFromXml(bookName,Menu.CHECK_OUTED);
            Console.getInstance().println("Thank you! Enjoy the book.");
            return;
        }
        Console.getInstance().println("That book is not available.");
    }

    @Override
    public void returnByName(String bookName) {
        Book book = BookData.getInstance().getTheClassByName(bookName);
        if (book != null && book.getBookStatue() == Menu.CHECK_OUTED) {
            book.setBookStatue(Menu.CAN_READ);
//            BookData.getInstance().changeBookStatusFromXml(bookName,Menu.CAN_READ);
            Console.getInstance().println("Thank you for returning the book.");
            return;
        }
        Console.getInstance().println("That is not a valid book to return.");
    }


}
