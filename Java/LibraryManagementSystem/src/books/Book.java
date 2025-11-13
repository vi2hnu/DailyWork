package books;

public class Book {
    private String title;
    private String authorName;

    public Book(String title, String authorName) {
        this.title = title;
        this.authorName = authorName;
    }

	public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }
}
