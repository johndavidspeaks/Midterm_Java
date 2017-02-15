import java.util.ArrayList;

/**
 * Created by adamm on 2/15/2017.
 */
public class ArrayHolder {

   public static ArrayList<String> bookName = new ArrayList<>();
   public static ArrayList<String> author = new ArrayList<>();
   public static ArrayList<String> bookNameCheckout = new ArrayList<>();
   public static ArrayList<String> authorCheckout = new ArrayList<>();

    public static void addBookName(String name) {
        bookName.add(name);
    }
    public static void addAuthor(String name) {
        author.add(name);
    }
    public static void addbookNameCheckout(String name) {
        bookNameCheckout.add(name);
    }
    public static void addauthorCheckout(String name) {
        authorCheckout.add(name);
    }



}
