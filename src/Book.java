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
    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }


    //overriding the toString function to format text the user sees
    @Override
    public String toString() {
        return String.format("%-40s %-30s", title, author);
    }


}
