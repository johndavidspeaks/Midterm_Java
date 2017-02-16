
public class Book {
    String autor;
    String title;

    Book(String name, String catagory, String inOut) {
        this.autor = name;
        this. title = catagory;
    }

    public String getName() {
        return autor;
    }

    public String getCatagory() {
        return title;
    }


}
