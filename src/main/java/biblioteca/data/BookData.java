package biblioteca.data;

import biblioteca.bean.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.Collections;
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
            for (Iterator i = root.elementIterator("book"); i.hasNext(); ) {
                foo = (Element) i.next();
                String bookName = foo.elementText("name");
                String bookAuthor = foo.elementText("author");
                String bookTime = foo.elementText("time");
                String bookStatue = foo.elementText("status");
                Book book = new Book(bookName, bookAuthor, bookTime, Integer.valueOf(bookStatue));
                bookArrayList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getBookData() {
        return bookArrayList;
    }

    public void deleteBookByName(String bookName) {
        for (Book book : bookArrayList) {
            if (book.getBookName().equals(bookName)) {
                book.setBookStatue(Menu.CHECK_OUTED);
                changeBookStatusFromXml(bookName);
            }
        }
    }

    private void changeBookStatusFromXml(String bookName) {
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(BookData.class.getResource("/bookList.xml"));
            Element root = doc.getRootElement();
            Element foo;
            for (Iterator i = root.elementIterator("book"); i.hasNext(); ) {
                foo = (Element) i.next();
                String bookNameToDelete = foo.elementText("name");
                int bookStatus = Integer.valueOf(foo.elementText("status"));
//                System.out.println(foo.element("status"));
                if (bookNameToDelete.equals(bookName) && bookStatus == (Menu.CAN_READ)) {
                    Element element = foo.element("status");
//                    element.getText("status");
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
