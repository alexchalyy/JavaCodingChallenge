import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class JavaCodingChallenge {

//---------------------------------------------------------------------------------------

    static void WordCount() {

        // This method opens the text files, counts the words in it, and displays it on
        // console.

        try {
            File f1 = new File("passage.txt"); // Creation of File Descriptor for input file
            String[] words = null; // Intialize the word Array
            int wc = 0; // Intialize word count to zero
            FileReader fr = new FileReader(f1); // Creation of File Reader object
            BufferedReader br = new BufferedReader(fr); // Creation of BufferedReader object
            String s;

            while ((s = br.readLine()) != null) // Reading Content from the file
            {
                words = s.split(" "); // Split the word using space
                wc = wc + words.length; // increase the word count for each word
            }
            fr.close();
            System.out.println("Number of words in the file:" + (wc - 2)); // Print the word count
        } catch (Exception e) {
            System.out.println("Something did not work:(");
        }
    }

    //---------------------------------------------------------------------------------------------
    public static void main(String args[]) throws IOException

    /*
     * 
     * This Java program reads a text file and does the following:
     * 
     * 1. Give a total word count.
     * 
     * 2. Identify the top 10 words used and display them in sorted order.
     * 
     * 3. Pull the last sentence on the file that contains the most used word.
     * 
     * Your output can be written directly to the console window or a log.
     * 
     * Written by Alex Chalyy on 10/29/2019.
     */

    {
        WordCount(); // Give a total word count.
    }
}