import java.time.LocalDate;

/**
 * Created by adamm on 2/16/2017.
 */
public class CheckedOutBook {
    String author;
    String title;
    LocalDate dueDate;


    CheckedOutBook(String title, String author, LocalDate dueDate) {
        this.title = title;
        this.author = author;
        this.dueDate = dueDate;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return String.format("%-40s %-30s %-30s", title, author, dueDate);
    }
}
