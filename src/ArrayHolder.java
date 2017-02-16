import java.util.ArrayList;

/**
 * Created by adamm on 2/15/2017.
 */
public class ArrayHolder {

   public static ArrayList<Book> bookName = new ArrayList<Book>();
   public static ArrayList<Book> bookNameCheckout = new ArrayList<Book>();
   public static ArrayList<String> authorCheckout = new ArrayList<>();

    public static void addBookName(Book name) {
        bookName.add(name);
    }
    public static void addbookNameCheckout(Book name) {
        bookNameCheckout.add(name);
    }
    public static void addauthorCheckout(String name) {
        authorCheckout.add(name);
    }



}
