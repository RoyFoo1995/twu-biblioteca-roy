package biblioteca.data;

import biblioteca.bean.Book;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.Iterator;

public class BookData {
    private ArrayList<Book> bookArrayList;
    private static BookData bookData;

    private BookData() {
    }

    public static BookData getInstance() {
        if (bookData == null) {
            synchronized (BookData.class) {
                if (bookData == null) {
                    bookData = new BookData();
                    bookData.generateBookData();
                }
            }
        }
        return bookData;
    }

    private void generateBookData() {
        try {
            bookArrayList = new ArrayList<>();
            SAXReader reader = new SAXReader();
            Document doc = reader.read(BookData.class.getResource("/bookList.xml"));
            Element root = doc.getRootElement();
            Element foo;
            for (Iterator i = root.elementIterator("book");i.hasNext();){
                foo = (Element)i.next();
                String bookName = foo.elementText("name");
                String bookAuthor = foo.elementText("author");
                String bookTime = foo.elementText("time");
                Book book = new Book(bookName,bookAuthor,bookTime);
                bookArrayList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getBookData() {
        return bookArrayList;
    }

}
