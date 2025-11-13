package members;

import java.util.ArrayList;
import books.Book;

public class Members {
    private String username;
    private String phonenumber;
    public ArrayList<Book> borrowedBooks;

    public Members(String username, String phonenumber) {
        this.username = username;
        this.phonenumber = phonenumber;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBooks(Book book) {
        borrowedBooks.add(book);
    }

    public String getUsername() {
        return username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
