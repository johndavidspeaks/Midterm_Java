import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;


class TextFileReader {

    static void writeTextToFile(String fileName, CheckedOutBook input) {
        Path filePath = Paths.get(fileName);                        // getting the file path

        File txtFile = filePath.toFile();

        try {
            FileReader r = new FileReader(txtFile);
            BufferedReader reader = new BufferedReader(r);
            PrintWriter out = new PrintWriter(new FileOutputStream(txtFile, true));


                out.println(input.getTitle()+"/"+input.getAuthor()+"/"+input.getDueDate());


            System.out.println("Your book has been checked out!");


            reader.close();
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
                String delims = "/";                                    //Braking the sentence into separate words.
                String[] tokens = line.split(delims);
                String token1 = tokens[0];
                String token2 = tokens[1];
                ArrayHolder.bookName.add(new Book(token1, token2));

            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {

            System.out.println(e);
        }

        return null;


    }

    static void removeLine(String fileName, String lineToRemove) {                   //Removing the country from the list
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
            //finding the name of the country to skip over
            while (line != null) {
                if (!line.equalsIgnoreCase(lineToRemove)) {
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
    @Override
    public String toString(){
        return String.format("%s/%s/%s");
    }
}
