import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


class TextFileReader {

    static void writeTextToFile(String fileName, String input) {
        Path filePath = Paths.get(fileName);                        // getting the file path

        File booksFile = filePath.toFile();                     //opening the file

        try {
            FileReader r = new FileReader(booksFile);
            BufferedReader reader = new BufferedReader(r);
            PrintWriter out = new PrintWriter(new FileOutputStream(booksFile, true));
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

    static StringBuilder readTextFile() {      // reading the text file and returning the results of that text file
        try {

            BufferedReader reader = new BufferedReader(new FileReader("Books.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String delims = "/";                                    //Braking the sentence into separate words.
                String[] tokens = line.split(delims);
                String token1 = tokens[0];
                String token2 = tokens[1];
                ArrayHolder.bookName.add(new Book(token1,token2,"in"));

            }
            reader.close();

        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){

            System.out.println(e);
        }


//try {
//
//    BufferedReader reader = new BufferedReader(new FileReader("Books.txt"));
//    String line;
//    while ((line = reader.readLine()) != null) {
//        ArrayHolder.addBookName(line);
//    }
//    reader.close();
//
//}catch (FileNotFoundException e){
//    System.out.println(e);
//}catch (IOException e){
//
//    System.out.println(e);
//}

return null;
















//        Path filePath = Paths.get(fileName);
//        File booksFile = filePath.toFile();
//        StringBuilder result = new StringBuilder();
//        try {
//            FileReader r = new FileReader(booksFile);
//            BufferedReader reader = new BufferedReader(r);
//
//
//            String line = reader.readLine();
//
//            while (line != null) {
//
//                ArrayHolder.addBookName(line);
//                result.append(line + "\n");
//                line = reader.readLine();
//            }
//
//            reader.close();
//            return result;
//
//        } catch (FileNotFoundException ex) {
//            return null;
//
//        } catch (IOException ex) {
//            return null;
//
//        }

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
}
