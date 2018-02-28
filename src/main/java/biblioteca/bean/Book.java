package biblioteca.bean;

public class Book {
    private String bookName;
    private String bookAuthor;
    private String bookTime;

    public Book(String bookName, String bookAuthor, String bookTime) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookTime = bookTime;
    }

    public Book() {
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookTime() {
        return bookTime;
    }

    public void setBookTime(String bookTime) {
        this.bookTime = bookTime;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
