import java.util.Scanner;

/**
 * Created by adamm on 2/14/2017.
 */
public class Validation {
    private static int getValidInteger() {
        Scanner scan1 = new Scanner(System.in);
        //validation for numbers
        while (!scan1.hasNextInt()) {
            scan1.nextLine(); //clears the buffer
            System.out.println("Please enter an integer! "); //tells user to enter number
        }
        return scan1.nextInt(); //takes the correct integer
    }

    private static boolean checkRange(int input, int min, int max) {
        return input >= min && input <= max;
    }

    static int getValidInteger(int min, int max) {
        int userInput = getValidInteger();
        while (!checkRange(userInput, min, max)) {
            System.out.println("Please provide a number within range!");
            userInput = getValidInteger();
        }
        return userInput;
    }
}
