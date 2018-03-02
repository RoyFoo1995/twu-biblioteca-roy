package biblioteca.bean;

public class Book {
    private String bookName;
    private String bookAuthor;
    private String bookTime;
    private int bookStatue;

    public Book(String bookName, String bookAuthor, String bookTime, int bookStatue) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookTime = bookTime;
        this.bookStatue = bookStatue;
    }

    public Book() {
    }

    public int getBookStatue() {
        return bookStatue;
    }

    public void setBookStatue(int bookStatue) {
        this.bookStatue = bookStatue;
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
