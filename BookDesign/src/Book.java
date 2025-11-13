import java.util.Date;

public class Book {
    long bookID;
    String bookName;
    Author author;
    Category category;
    int pages;
    double price;
    Date dateOfRelease;

    public Book(long bookID,String bookName, Author author, Category category, int pages, double price,Date dateOfRelease) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.pages = pages;
        this.price = price;
        this.dateOfRelease = dateOfRelease;
    }

}
