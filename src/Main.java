import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int input;
        System.out.println("Welcome to the Grand Circus Library");
        TextFileReader.readTextFile("Books.txt");   //Reading the books that are available
        TextFileReader.readTextFile("CheckedOutBooks.txt"); //Reading the books that are checked out
        do {    //a loop to let the user choose there options until they want to exit the program
            instructions();
            optionsSwitch(Validation.getValidInteger(1, 4));
            System.out.println("Would you like to continue? (1. yes / 2. no)");
            input = Validation.getValidInteger(1, 2);
        } while (input == 1);

    }

    private static void instructions() {    //this method is just to print out the menu for the user to choose from
        System.out.println("What would you like to do?\n1. Print out book list\n2. Search for Book\n3. Checkout Book\n4. Return Book ");
        System.out.print("Choice: ");
    }

    private static void optionsSwitch(int option) {     //this method takes the users option and sends them to the correct method
        switch (option) {
            case 1: {   //Prints the current booklist, whats available and whats checked out

                printBookList();
                break;
            }
            case 2: {   //Search for author or title, asks the user which they would like to do.
                System.out.println("Search for 1. author or 2. title?");
                search(Validation.getValidInteger(1, 2));   //validates the input
                break;
            }
            case 3: {   //Checks out a book
                System.out.print("Enter the number of the book you would like to checkout: ");
                checkoutBook(Validation.getValidInteger(1, 12));    //validates the input
                break;
            }
            case 4: {   //Returns a books
                returnbooklistprint();
                System.out.print("Enter the number of the book you want to return: ");
                returnBook(Validation.getValidInteger(1, ArrayHolder.bookNameCheckout.size() + 1));
                break;
            }

        }
    }

    private static void printBookList() {
        //this prints out the books that are available
        System.out.println(" ");
        System.out.println("------------Books that are available------------");
        System.out.println(" ");
        for (int i = 0; i < ArrayHolder.bookName.size(); i++) {
            System.out.println((i + 1) + ". " + ArrayHolder.bookName.get(i).toString());
        }
        //this prints out the books that are checked out
        System.out.println(" ");
        System.out.println("------------Books that are not available------------");
        System.out.println(" ");
        for (int i = 0; i < ArrayHolder.bookNameCheckout.size(); i++) {
            System.out.println((i + 1) + ". " + ArrayHolder.bookNameCheckout.get(i).toString());
        }
    }

    private static void checkoutBook(int userInput) {

        ArrayHolder.bookName.get(userInput - 1);     // gets the peculiar book the from the available list
        System.out.println(" ");
        System.out.println("Are you sure you want to checkout: ");
        System.out.println(ArrayHolder.bookName.get(userInput - 1).toString());
        System.out.println("(1.yes / 2.no)");      //this allows the user to say no if they actually want a different book
        int answer = Validation.getValidInteger(1, 2);  //validates the input
        if (answer == 1) {

            //takes the book, puts it in the checkout array, removes from available list and puts it on the checked out list
            ArrayHolder.bookNameCheckout.add(new CheckedOutBook(ArrayHolder.bookName.get(userInput - 1).title, ArrayHolder.bookName.get(userInput - 1).getAuthor(), dueDate()));
            CheckedOutBook book = new CheckedOutBook(ArrayHolder.bookName.get(userInput - 1).title, ArrayHolder.bookName.get(userInput - 1).getAuthor(), dueDate());
            Book removeBook = new Book(ArrayHolder.bookName.get(userInput - 1).title, ArrayHolder.bookName.get(userInput - 1).getAuthor());
            TextFileReader.writeTextToCheckedOutBooksFile("CheckedOutBooks.txt", book);
            TextFileReader.removeLineFromBookFile("Books.txt", removeBook);
            ArrayHolder.bookName.remove(userInput - 1);

        }


    }

    private static String dueDate() {   //gets the due date for the books that are checked out.
        LocalDate today = LocalDate.now();
        //add 2 week to the current date
        LocalDate next2Week = today.plus(2, ChronoUnit.WEEKS);


        return next2Week.toString();

    }

    private static void search(int option) {
        String userInput;
        Scanner scan1 = new Scanner(System.in);
        int count = 0;
        switch (option) {

            //allows the user to search for a book with just the authors name
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
                    System.out.println("Sorry Author not found!!!");   //if that author is not found
                }
                break;
            }

            //allows the user to search for a book with just the title
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
                    System.out.println("Sorry book not found!!!"); //if that book is not found
                }
                break;
            }

        }

    }

    private static void searchCheckout(int input) {     //if they search and find they book they want they can check it out right then
        System.out.println("Would you like to check this book out? ");
        System.out.println(ArrayHolder.bookName.get(input));
        System.out.println("(1. yes /2. no)");
        int answer = Validation.getValidInteger(1, 2);
        if (answer == 1) {

            //takes the book, puts it in the checkout array, removes from available list and puts it on the checked out list
            ArrayHolder.bookNameCheckout.add(new CheckedOutBook(ArrayHolder.bookName.get(input).title, ArrayHolder.bookName.get(input).getAuthor(), dueDate()));
            CheckedOutBook book = new CheckedOutBook(ArrayHolder.bookName.get(input).title, ArrayHolder.bookName.get(input).getAuthor(), dueDate());
            Book removeBook = new Book(ArrayHolder.bookName.get(input).title, ArrayHolder.bookName.get(input).getAuthor());
            TextFileReader.writeTextToCheckedOutBooksFile("CheckedOutBooks.txt", book);
            TextFileReader.removeLineFromBookFile("Books.txt", removeBook);
            ArrayHolder.bookName.remove(input);


        }

    }

    private static void returnBook(int userInput) {

        // allows the user to return the book
        ArrayHolder.bookNameCheckout.get(userInput - 1);
        System.out.println("Are you sure you want to return ");
        System.out.println(ArrayHolder.bookNameCheckout.get(userInput - 1).toString());
        System.out.println("(1. yes /2. no)");
        int answer = Validation.getValidInteger(1, 2);
        if (answer == 1) {
            //takes the book, puts it in the available array, removes from checked out list and puts it on the available list
            ArrayHolder.bookName.add(new Book(ArrayHolder.bookNameCheckout.get(userInput - 1).title, ArrayHolder.bookNameCheckout.get(userInput - 1).getAuthor()));
            Book book = new Book(ArrayHolder.bookNameCheckout.get(userInput - 1).title, ArrayHolder.bookNameCheckout.get(userInput - 1).getAuthor());
            CheckedOutBook removeBook = new CheckedOutBook(ArrayHolder.bookNameCheckout.get(userInput - 1).title, ArrayHolder.bookNameCheckout.get(userInput - 1).getAuthor(), ArrayHolder.bookNameCheckout.get(userInput - 1).getDueDate());
            TextFileReader.writeTextToBooksFile("Books.txt", book);
            TextFileReader.removeLineFromCheckedOutFile("CheckedOutBooks.txt", removeBook);
            ArrayHolder.bookNameCheckout.remove(userInput - 1);

        }

    }

    private static void returnbooklistprint() {
        //this prints out the books that are checked out
        System.out.println(" ");
        System.out.println("------------What book would you like to return------------");
        System.out.println(" ");
        for (int i = 0; i < ArrayHolder.bookNameCheckout.size(); i++) {
            System.out.println((i + 1) + ". " + ArrayHolder.bookNameCheckout.get(i).toString());
        }
    }
}


