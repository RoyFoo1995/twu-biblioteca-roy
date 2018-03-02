package biblioteca;

import biblioteca.bean.Book;
import biblioteca.data.BookData;
import biblioteca.data.Menu;
import biblioteca.util.Console;

import java.util.ArrayList;

public class BookManager implements IBookManager {
    @Override
    public void showBookList(ArrayList<Book> list) {
        Console.getInstance().println("The book List:");
        int index = 0;
        for (int i = 1; i <= list.size(); i++) {
            Book book = list.get(i - 1);
            if (book.getBookStatue() == Menu.CHECK_OUTED) {
                index++;
                continue;
            }
            String msg = String.format("%d. %-42s author:%-20s time:%s", (i - index), book.getBookName(), book.getBookAuthor(), book.getBookTime());
            Console.getInstance().println(msg);
        }

    }

    @Override
    public boolean checkOutByName(String bookName) {
        ArrayList<Book> bookList = BookData.getInstance().getBookData();
        for (Book book : bookList) {
            if (book.getBookName().equals(bookName) && book.getBookStatue() == Menu.CAN_READ) {
                BookData.getInstance().deleteBookByName(bookName);
                Console.getInstance().println("Thank you! Enjoy the book.");
                return true;
            }
        }
        Console.getInstance().println("That book is not available.");
        return false;
    }

    @Override
    public void returnTheBook(String bookName) {
        ArrayList<Book> bookArrayList = BookData.getInstance().getBookData();
        for (Book book : bookArrayList) {
            if (book.getBookName().equals(bookName) && book.getBookStatue() == Menu.CHECK_OUTED) {
                book.setBookStatue(Menu.CAN_READ);
                Console.getInstance().println("Thank you for returning the book.");
                return;
            }
        }
        Console.getInstance().println("That is not a valid book to return.");
    }


}
