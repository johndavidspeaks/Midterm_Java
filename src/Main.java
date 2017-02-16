import java.util.Scanner;

public class Main {
    private static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        int input;
        System.out.println("Welcome to the GC Library");
        TextFileReader.readTextFile();
        do {
            instructions();
            optionsSwitch(Validation.getValidInteger(1, 4));
            System.out.println("Would you like to continue? (1. yes/2. no)");
            input = Validation.getValidInteger(1,2);
        }while (input == 1);

    }

    private static void instructions() {                                                // instructions for the user to follow
        System.out.println("What would you like to do?\n1. Print out book list\n2. Search for Book\n3. Checkout Book\n4. Return Book ");
        System.out.print("Choice: ");
    }

    private static void optionsSwitch(int option) {
        switch (option) {
            case 1: {
                printBookList();
                break;
            }
            case 2: {
//               search
                break;
            }
            case 3: {
                System.out.print("Enter the number of the book you would like to checkout: ");
                checkoutBook(Validation.getValidInteger(1, 12));
                break;
            }
            case 4: {
//                return
                break;
            }

        }
    }

    private static void printBookList() {
        System.out.println("Books that are available -------------------------");
        for (int i = 0; i < ArrayHolder.bookName.size(); i++) {
            System.out.println((i + 1) + ". " + ArrayHolder.bookName.get(i).toString());
        }
        System.out.println("Books that are not available -------------------------");
        for (int i = 0; i < ArrayHolder.bookNameCheckout.size(); i++) {
            System.out.println(ArrayHolder.bookNameCheckout.get(i).toString());
        }
    }

    private static void checkoutBook(int userInput) {
        int count = 0;

        ArrayHolder.bookName.get(userInput-1);
        System.out.println("Are you sure you want to checkout ");
        System.out.println(ArrayHolder.bookName.get(userInput-1).toString());
        System.out.println("(1. yes /2. no)");
        int answer = Validation.getValidInteger(1, 2);
        if (answer == 1) {

            ArrayHolder.bookNameCheckout.add(new CheckedOutBook(ArrayHolder.bookName.get(userInput-1).title,ArrayHolder.bookName.get(userInput-1).getAuthor(),"date"));
            ArrayHolder.bookName.remove(userInput-1);
            count++;
        }



        if (count < 1) {
            System.out.println("Book not found!!!!!!!");
        }

    }


}