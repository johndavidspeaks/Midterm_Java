
public class Book {
    String author;
    String title;


    Book(String title, String author) {
        this.title = title;
        this.author = author;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    @Override
    public String toString() {
        return String.format("%-40s %-30s", title, author);
    }


}
