import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the GC Library");
        TextFileReader.readTextFile("Books.txt");
        TextFileReader.readTextFile("Author.txt");

        instructions();
        for (int i = 0; i <12 ; i++) {
            System.out.println(arrayBook(i)+" "+ arrayAutor(i));
        }




    }

    private static void instructions() {                                                // instructions for the user to follow
        System.out.println("What would you like to do?\n1. Print out book list\n2. Checkout Book\n3. Return Book\n4. Search for Book");
        System.out.print("Choice: ");
    }



}