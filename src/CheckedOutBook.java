//our class to make an checked out books
public class CheckedOutBook {
     String author;
     String title;
     String dueDate;


    //constructor
    CheckedOutBook(String title, String author, String dueDate) {
        this.title = title;
        this.author = author;
        this.dueDate = dueDate;

    }

    //getters
    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    String getDueDate() {
        return dueDate;
    }

    //overriding the toString function to format text the user sees
    @Override
    public String toString() {
        return String.format("%-40s %-30s %-30s", title, author, dueDate);
    }
}
