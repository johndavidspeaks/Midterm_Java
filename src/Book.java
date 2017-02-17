//our class to make an available books
public class Book {
    String author;
    String title;


    //constructor
    Book(String title, String author) {
        this.title = title;
        this.author = author;

    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    //overriding the toString function to format text the user sees
    @Override
    public String toString() {
        return String.format("%-40s %-30s", title, author);
    }


}
