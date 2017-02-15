import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static ArrayList<String> movies = new ArrayList<>();  // change this array to take in Sams book .txt

    public static void main(String[] args) {
        int loop = 1;
        System.out.println("Welcome to the GC Library");
        while (loop == 1) {

            instructions();
            populatePrint(choice(Validation.getValidInteger(1, 4)));            //getting the user input to convert to string then sending it along to populate the array then print
            System.out.println("Would you like to continue (1. yes/2. no)");         // loop continue or not

            loop = Validation.getValidInteger(1, 2);
            if (loop == 1) {
                movies.clear();

                // clears array list if the user decides to continue
            }
        }

    }

    private static void instructions() {                                                // instructions for the user to follow
        System.out.println("What would you like to do?\n1. Print out book list\n2. Checkout Book\n3. Return Book\n4. Search for Book");
        System.out.print("Choice: ");
    }

    private static String choice(int choice) {                  // turning the user number choice into a string

        switch (choice) {
            case 1: {
                return "animated";
            }
            case 2: {
                return "drama";
            }
            case 3: {
                return "horror";
            }
            case 4: {
                return "scifi";
            }
            default:
                return null;
        }

    }

    private static void populatePrint(String category) {
        for (int i = 1; i < 100; i++) {                                             //running through the movie i/o switch searching for movie categories and returning them
            String listCategory = MovieIO.getMovie(i).getCatagory();                //to put into the array list
            if (category.equalsIgnoreCase(listCategory)) {
                array(MovieIO.getMovie(i).getName());
            }

        }

        Collections.sort(movies);                                                   //sorting the array alphabetically
        System.out.println(" ");
        int listnumber = 1;

        for (String token : movies) {                                                // printing the array
            System.out.println(listnumber + ". " + token.toString());
            listnumber++;
        }
    }

    private static void array(String movie) {                   // method to add the movie names to the array list

        movies.add(movie);
    }

}