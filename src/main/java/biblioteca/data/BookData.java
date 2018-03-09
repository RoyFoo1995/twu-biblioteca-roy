package biblioteca.data;

import biblioteca.bean.Book;
import biblioteca.util.XMLUtil;
import org.dom4j.Attribute;
import org.dom4j.Element;
import java.util.ArrayList;
import java.util.Iterator;

public class BookData implements IData {
    private ArrayList<Book> bookArrayList;
    private static BookData bookData;

    private BookData() {
    }

    public static BookData getInstance() {
        if (bookData == null) {
            synchronized (BookData.class) {
                if (bookData == null) {
                    bookData = new BookData();
                    bookData.generateData();
                }
            }
        }
        return bookData;
    }

    /**
     * 生成Book列表
     */
    public void generateData() {
        try {
            bookArrayList = new ArrayList<>();
            Element root = XMLUtil.getRootElement("/bookList.xml");
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


    /**
     * 获取当前book列表
     *
     * @return
     */
    public ArrayList<Book> getData() {
        return bookArrayList;
    }

    public void changeBookStatusFromXml(String bookName, int status) {
        Element root = XMLUtil.getRootElement("/bookList.xml");
        Element foo;
        for (Iterator i = root.elementIterator("book"); i.hasNext(); ) {
            foo = (Element) i.next();
            String bookNameToDelete = foo.elementText("name");
            int bookStatus = Integer.valueOf(foo.elementText("status"));
            if (bookNameToDelete.equals(bookName) && bookStatus != status) {
                Element test = foo.element("status");
                test.setText(String.valueOf(status));
            }
        }

    }


    /**
     * 通过书名获取对应图书
     *
     * @param name
     * @return
     */
    public Book getTheClassByName(String name) {
        for (Book book : bookArrayList) {
            if (book.getBookName().equals(name)) {
                return book;
            }
        }
        return null;
    }
}
