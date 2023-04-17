import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
* This program takes number input from a file,
* and does a factorial for said number.
*
* @author Logan S
* @version 1.0
* @since 2023-04-17
*/

public final class Factorial {

    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */

    private Factorial() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the main method.
    *
    * @param args Unused.
    */

    public static void main(String[] args) {

        try {

            final ArrayList<String> input = new ArrayList<String>();

            // Create input file.
            final File inputFile = new File("input.txt");
            // Create output
            final FileWriter outputFile = new FileWriter("output.txt");

            // Creating the file into a String variable.
            final Scanner sc = new Scanner(inputFile);

            while (sc.hasNextLine()) {
                // Add each line of the file to the ArrayList.
                input.add(sc.nextLine());
            }

            for (String strLine : input) {

                // Parse the input to an int
                final int factor = recFactorial(Integer.parseInt(strLine));
                // Write and print the reversed text to the output file.
                outputFile.write(factor + "\n");
                System.out.println(factor);

            }
            // Closing FileWriter
            outputFile.close();

            // Closing Scanner
            sc.close();

        } catch (IOException exception) {
            System.out.println("Error: File does not exist.");
        }
    }

    /**
    * This is the main method.
    *
    * @param number The number.
    * @return the reversed string.
    */

    public static int recFactorial(int number) {

        // Check if the string is empty
        if (number <= 1) {
            // If the string is empty, tell the user
            return number;
        } else {
            // Otherwise, if the string ISN'T empty, return reversed string
            return recFactorial(number - 1) * number;
        }
    }
}
