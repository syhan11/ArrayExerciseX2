import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayExerciseX2 {
    public static void main(String[] args) {

        /*
         * Write a program to print a string in reverse:
         * Eg: Welcome
         */
        Scanner keyboard = new Scanner(System.in);
        System.out.println("***** Exercise 1: \nEnter a message: ");
        String msg = keyboard.nextLine();

        int maxSz = msg.length();

        System.out.println("\nEntered string: " + msg);
        System.out.print("Reversed string: ");
        for (int i = maxSz - 1; i >= 0; i--) {
            System.out.print(msg.charAt(i));
        }



        /*
         * Write a program that will find the length of an input string without using the library function.
         */

        System.out.println("\n\n***** Exercise 2: \nEnter a message: ");
        msg = keyboard.nextLine();

        /*
         * using enhanced for loop
         */
        char[] charArray = msg.toCharArray();
        int count = 0;

        for (char charVal : charArray )
            count++;

        System.out.printf("1) Length of \"%s\" is %d.\n", msg, count);

        /*
         * Reading one char at a time....   using a Reader instance
         */

        Reader reader = new StringReader(msg);
        int ch, tmpCount = 0;
        boolean flag = true;

        while (flag) {
            try {
                ch = reader.read();

                if (ch == -1)
                    flag = false;            // EOF
                else
                    tmpCount++;

            } catch (Exception e) {
                System.out.println(e);
                break;
            }
        }

        System.out.printf("2) Length of \"%s\" is %d.\n", msg, tmpCount);

        /*
         * Prompt the user to input 10 values and store them into an array.
         * If there are any duplicate values in that array, remove them and print out the remaining values.
         */

        System.out.println("\n\n***** Exercise 3: \nEnter 10 values: ");

        double[] doubleArray = new double[10];
        for (int i = 0; i < 10; i++ )
            doubleArray[i] = keyboard.nextDouble();

        ArrayList<Double> tmpDArray = new ArrayList<Double>();
        double tmp;

        for (int i = 0; i < 10; i++) {
            tmp = doubleArray[i];
            flag = false;

            for (int j = i + 1; j < 10; j++) {
                if (tmp == doubleArray[j])
                    flag = true;

            }

            if (!flag)
                tmpDArray.add (tmp);    // duplication not found.
        }

        double sum = 0;
        int max = tmpDArray.size();
        for (int i = 0; i < max; i++)
            sum += tmpDArray.get(i);

        System.out.println("\nEntered numbers are " + Arrays.toString(doubleArray));
        System.out.println("Array of unique numbers is " + tmpDArray);
        System.out.println("Sum of unique numbers is " + sum);

    }
}
