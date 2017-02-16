import java.util.Scanner;

public class Main {
private static Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) {


        System.out.println("Welcome to the GC Library");
        TextFileReader.readTextFile();
        instructions();
        optionsSwitch(Validation.getValidInteger(1, 4));


    }

    private static void instructions() {                                                // instructions for the user to follow
        System.out.println("What would you like to do?\n1. Print out book list\n2. Checkout Book\n3. Return Book\n4. Search for Book");
        System.out.print("Choice: ");
    }

    private static void optionsSwitch(int option) {
        switch (option) {
            case 1: {
                printBookList();
                break;
            }
            case 2: {
                System.out.print("Enter the name of the book you would like to checkout: ");
                checkoutBook(scnr.nextLine());
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }

        }
    }

    private static void printBookList() {
        for (int i = 0; i < ArrayHolder.bookName.size(); i++) {
            System.out.println(ArrayHolder.bookName.get(i));
        }
        System.out.println("Books that are not available -------------------------");
        for (int i = 0; i < ArrayHolder.bookNameCheckout.size() && i < ArrayHolder.authorCheckout.size(); i++) {
            System.out.println(ArrayHolder.bookNameCheckout.get(i) + " " + ArrayHolder.authorCheckout.get(i));
        }
    }

    private static void checkoutBook(String userInput) {
//        int count = 0;
//        for (int i = 0; i < ArrayHolder.bookName.size(); i++) {
//            if (ArrayHolder.bookName.get(i).equalsIgnoreCase(userInput)) {
//                ArrayHolder.bookNameCheckout.add(ArrayHolder.bookName.get(i));
//                ArrayHolder.bookName.remove(i);
//                ArrayHolder.authorCheckout.add(ArrayHolder.author.get(i));
//                ArrayHolder.author.remove(i);
//                count++;
//            }
//        }
//        if (count<1){
//            System.out.println("Book not found!!!!!!!!!");
//        }
//        printBookList();

    }


}