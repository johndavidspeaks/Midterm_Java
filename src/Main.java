import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int input;
        System.out.println("Welcome to the GC Library");
        TextFileReader.readTextFile("Books.txt");
        TextFileReader.readTextFile("CheckedOutBooks.txt");
        do {
            instructions();
            optionsSwitch(Validation.getValidInteger(1, 4));
            System.out.println("Would you like to continue? (1. yes/2. no)");
            input = Validation.getValidInteger(1, 2);
        } while (input == 1);

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
                System.out.println("Search for 1. author or 2. title?");
                search(Validation.getValidInteger(1, 2));
                break;
            }
            case 3: {
                System.out.print("Enter the number of the book you would like to checkout: ");
                checkoutBook(Validation.getValidInteger(1, 12));
                break;
            }
            case 4: {
                System.out.print("Enter the number you want to return: ");
                returnBook(Validation.getValidInteger(1, ArrayHolder.bookNameCheckout.size() + 1));
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
            System.out.println((i + 1) + ". " + ArrayHolder.bookNameCheckout.get(i).toString());
        }
    }

    private static void checkoutBook(int userInput) {
        int count = 0;

        ArrayHolder.bookName.get(userInput - 1);
        System.out.println("Are you sure you want to checkout ");
        System.out.println(ArrayHolder.bookName.get(userInput - 1).toString());
        System.out.println("(1. yes /2. no)");
        int answer = Validation.getValidInteger(1, 2);
        if (answer == 1) {

            ArrayHolder.bookNameCheckout.add(new CheckedOutBook(ArrayHolder.bookName.get(userInput - 1).title, ArrayHolder.bookName.get(userInput - 1).getAuthor(), dueDate()));
            CheckedOutBook book = new CheckedOutBook(ArrayHolder.bookName.get(userInput - 1).title, ArrayHolder.bookName.get(userInput - 1).getAuthor(), dueDate());
            Book removeBook = new Book(ArrayHolder.bookName.get(userInput - 1).title, ArrayHolder.bookName.get(userInput - 1).getAuthor());
            TextFileReader.writeTextToFile2("CheckedOutBooks.txt", book);
            TextFileReader.removeLine("Books.txt", removeBook);
            ArrayHolder.bookName.remove(userInput - 1);
            count++;
        }

        if (count < 1) {
            System.out.println("Book not found!!!!!!!");
        }

    }

    private static String dueDate() {
        LocalDate today = LocalDate.now();
        //add 2 week to the current date
        LocalDate next2Week = today.plus(2, ChronoUnit.WEEKS);


        return next2Week.toString();

    }

    public static void search(int option) {
        String userInput;
        Scanner scan1 = new Scanner(System.in);
        int count = 0;
        switch (option) {

            case 1: {
                System.out.println("What author would you like to search for?");
                userInput = scan1.nextLine();
                for (int i = 0; i < ArrayHolder.bookName.size(); i++) {
                    if (ArrayHolder.bookName.get(i).getAuthor().equalsIgnoreCase(userInput)) {
                        searchCheckout(i);
                        count++;
                    }
                }
                if (count < 1) {
                    System.out.println("Sorry Author not found");
                }
                break;
            }

            case 2: {
                System.out.println("What book would you like to search for");
                userInput = scan1.nextLine();
                for (int i = 0; i < ArrayHolder.bookName.size(); i++) {

                    if (ArrayHolder.bookName.get(i).getTitle().equalsIgnoreCase(userInput)) {
                        searchCheckout(i);
                        count++;
                    }
                }
                if (count < 1) {
                    System.out.println("Sorry book not found");
                }
                break;
            }

        }

    }

    private static void searchCheckout(int input) {
        int count = 0;
        System.out.println("Would you like to check this book out? ");
        System.out.println(ArrayHolder.bookName.get(input));
        System.out.println("(1. yes /2. no)");
        int answer = Validation.getValidInteger(1, 2);
        if (answer == 1) {

            ArrayHolder.bookNameCheckout.add(new CheckedOutBook(ArrayHolder.bookName.get(input).title, ArrayHolder.bookName.get(input).getAuthor(), dueDate()));
            CheckedOutBook book = new CheckedOutBook(ArrayHolder.bookName.get(input).title, ArrayHolder.bookName.get(input).getAuthor(), dueDate());
            Book removeBook = new Book(ArrayHolder.bookName.get(input).title, ArrayHolder.bookName.get(input).getAuthor());
            TextFileReader.writeTextToFile2("CheckedOutBooks.txt", book);
            TextFileReader.removeLine("Books.txt", removeBook);
            ArrayHolder.bookName.remove(input);
            count++;

        }

        if (count < 1) {
            System.out.println("Sorry book not found");
        }
    }

    private static void returnBook(int userInput) {
        int count = 0;

        ArrayHolder.bookNameCheckout.get(userInput - 1);
        System.out.println("Are you sure you want to return ");
        System.out.println(ArrayHolder.bookNameCheckout.get(userInput - 1).toString());
        System.out.println("(1. yes /2. no)");
        int answer = Validation.getValidInteger(1, 2);
        if (answer == 1) {

            ArrayHolder.bookName.add(new Book(ArrayHolder.bookNameCheckout.get(userInput - 1).title, ArrayHolder.bookNameCheckout.get(userInput - 1).getAuthor()));
            Book book = new Book(ArrayHolder.bookNameCheckout.get(userInput - 1).title, ArrayHolder.bookNameCheckout.get(userInput - 1).getAuthor());
            CheckedOutBook removeBook = new CheckedOutBook(ArrayHolder.bookNameCheckout.get(userInput - 1).title, ArrayHolder.bookNameCheckout.get(userInput - 1).getAuthor(), ArrayHolder.bookNameCheckout.get(userInput - 1).getDueDate());
            TextFileReader.writeTextToFile("Books.txt", book);
            TextFileReader.removeLine2("CheckedOutBooks.txt", removeBook);
            ArrayHolder.bookNameCheckout.remove(userInput - 1);
            count++;
        }

        if (count < 1) {
            System.out.println("Book not found!!!!!!!");
        }

    }
}


