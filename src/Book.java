/**
 * Created by adamm on 2/14/2017.
 */
public class Book {
    String autor;
    String title;

    Book(String name, String catagory) {
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
