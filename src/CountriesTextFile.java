import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by adamm on 2/13/2017.
 */
class CountriesTextFile {

    static void writeTextToFile(String fileName, String input) {
        Path filePath = Paths.get(fileName);                        // getting the file path

        File countriesFile = filePath.toFile();                     //opening the file

        try {
            FileReader r = new FileReader(countriesFile);
            BufferedReader reader = new BufferedReader(r);
            PrintWriter out = new PrintWriter(new FileOutputStream(countriesFile, true));
            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                if (line.equalsIgnoreCase(input)) {                         //verifying that the country they entered isn't already on there
                    System.out.println("That countries is already listed.");
                    count += 1;
                }

                line = reader.readLine();
            }
            if (count < 1) {
                out.println(input);                                     // adding the new country to the list
                System.out.println("This country has been saved!");
            }


            reader.close();                                            // closing out the reader and writer
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException ex) {


        }

    }

    static StringBuilder readTextFile(String fileName) {      // reading the text file and returning the results of that text file

        Path filePath = Paths.get(fileName);
        File countriesFile = filePath.toFile();
        StringBuilder result = new StringBuilder();
        try {
            FileReader r = new FileReader(countriesFile);
            BufferedReader reader = new BufferedReader(r);


            String line = reader.readLine();

            while (line != null) {
                result.append(line + "\n");
                line = reader.readLine();
            }

            reader.close();
            return result;

        } catch (FileNotFoundException ex) {
            return null;

        } catch (IOException ex) {
            return null;

        }

    }

    static void removeLine(String fileName, String lineToRemove) {                   //Removing the country from the list
        //opening old text file
        Path filePath = Paths.get(fileName);
        File countries = filePath.toFile();
        //opening the new temp text file
        Path temp = Paths.get("Temp.txt");
        File tempfile = temp.toFile();
        try {
            FileReader r = new FileReader(countries);
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
            countries.delete();
            tempfile.renameTo(countries);


        } catch (FileNotFoundException ex) {


        } catch (IOException ex) {


        }

    }
}
