import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


class TextFileReader {

    //this writes the arrays to the text files for available books
    static void writeTextToBooksFile(String fileName, Book input) {
        Path filePath = Paths.get(fileName);                        // getting the file path

        File txtFile = filePath.toFile();

        try {
            FileReader r = new FileReader(txtFile);
            BufferedReader reader = new BufferedReader(r);
            PrintWriter out = new PrintWriter(new FileOutputStream(txtFile, true));


            out.println(input.getTitle() + "/" + input.getAuthor());


            System.out.println("Success!");


            reader.close();     //makes sure we close the file when done
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException ex) {

        }


    }

    ////this writes the arrays to the text files for checked out books
    static void writeTextToCheckedOutBooksFile(String fileName, CheckedOutBook input) {
        Path filePath = Paths.get(fileName);                        // getting the file path

        File txtFile = filePath.toFile();

        try {
            FileReader r = new FileReader(txtFile);
            BufferedReader reader = new BufferedReader(r);
            PrintWriter out = new PrintWriter(new FileOutputStream(txtFile, true));


            out.println(input.getTitle() + "/" + input.getAuthor() + "/" + input.getDueDate());


            System.out.println("Success!");


            reader.close();     //makes sure we close the file when done
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException ex) {

        }


    }

    static StringBuilder readTextFile(String fileName) {      // reading the text file and returning the results of that text file
        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                //these put in their respective arrays
                //Available books
                if (fileName.equalsIgnoreCase("Books.txt")) {
                    String delims = "/";                                    //Braking the sentence into separate words.
                    String[] tokens = line.split(delims);
                    String token1 = tokens[0];
                    String token2 = tokens[1];
                    ArrayHolder.bookName.add(new Book(token1, token2));
                }
                //checked out books
                else if (fileName.equalsIgnoreCase("CheckedOutBooks.txt")) {
                    String delims = "/";                                    //Braking the sentence into separate words.
                    String[] tokens = line.split(delims);
                    String token1 = tokens[0];
                    String token2 = tokens[1];
                    String token3 = tokens[2];
                    ArrayHolder.bookNameCheckout.add(new CheckedOutBook(token1, token2, token3));
                }

            }
            reader.close();     //makes sure we close the file when done

        } catch (IOException e) {

            System.out.println(e);
        }

        return null;


    }

    //this removes the appropriate book from the correct file and puts it in the other book
    static void removeLineFromBookFile(String fileName, Book book) {
        //opening old text file
        Path filePath = Paths.get(fileName);
        File booksFile = filePath.toFile();
        //opening the new temp text file
        Path temp = Paths.get("Temp.txt");
        File tempfile = temp.toFile();
        try {
            FileReader r = new FileReader(booksFile);
            BufferedReader reader = new BufferedReader(r);
            PrintWriter out = new PrintWriter(new FileOutputStream(tempfile, false));


            String line = reader.readLine();
            //finding the name of the book to skip over
            while (line != null) {
                if (!line.equalsIgnoreCase(book.getTitle() + "/" + book.getAuthor())) {
                    out.println(line);
                }

                line = reader.readLine();
            }
            out.close();
            reader.close();
            //deleting the old file and renaming the new one
            booksFile.delete();
            tempfile.renameTo(booksFile);


        } catch (FileNotFoundException ex) {
            System.out.println(ex);

        } catch (IOException ex) {
            System.out.println(ex);


        }

    }

    //this removes the appropriate book from the correct file and puts it in the other book
    static void removeLineFromCheckedOutFile(String fileName, CheckedOutBook book) {
        //opening old text file
        Path filePath = Paths.get(fileName);
        File booksFile = filePath.toFile();
        //opening the new temp text file
        Path temp = Paths.get("Temp.txt");
        File tempfile = temp.toFile();
        try {
            FileReader r = new FileReader(booksFile);
            BufferedReader reader = new BufferedReader(r);
            PrintWriter out = new PrintWriter(new FileOutputStream(tempfile, false));


            String line = reader.readLine();
            //finding the name of the book to skip over
            while (line != null) {
                if (!line.equalsIgnoreCase(book.getTitle() + "/" + book.getAuthor() + "/" + book.getDueDate())) {
                    out.println(line);
                }
                line = reader.readLine();
            }
            out.close();
            reader.close();
            //deleting the old file and renaming the new one
            booksFile.delete();
            tempfile.renameTo(booksFile);


        } catch (FileNotFoundException ex) {


        } catch (IOException ex) {


        }
    }
}
