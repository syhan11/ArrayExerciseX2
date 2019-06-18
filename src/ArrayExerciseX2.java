import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayExerciseX2 {
    public static void main(String[] args) {

        /*
         * Exercise 1:
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
         * Exercise 2:
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
         * Exercise 3:
         * Prompt the user to input 10 values and store them into an array.
         * If there are any duplicate values in that array, remove them and print out the remaining values.
         */

        System.out.println("\n\n***** Exercise 3: \nEnter 10 values: ");

        int[] doubleArray = new int[10];
        for (int i = 0; i < 10; i++ )
            doubleArray[i] = keyboard.nextInt();

        System.out.println("\nEntered numbers are " + Arrays.toString(doubleArray));
        Arrays.sort(doubleArray);

        ArrayList<Integer> tmpDArray = new ArrayList<Integer>();
        int tmp;

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

        int sum = 0;
        int max = tmpDArray.size();
        for (int i = 0; i < max; i++)
            sum += tmpDArray.get(i);

        System.out.println("Array of unique numbers is " + tmpDArray);
        System.out.println("Sum of unique numbers is " + sum);

        /*
         * Exercise 4:
         * Given array 1: [1,7,6,5,9] and array 2: [2,7,6,3,4]
         * Write a program that will print out all pairs from arrays 1 and 2 that
         * gives a sum of 13:
         * Expected output:
         * (6,7)
         * (9,4)
         */

        int[] array1 = {1,7,6,5,9}, array2 = {2,7,6,3,4};
        int sumInt = 0, maxIdx = 0;

        System.out.println("\n\n***** Exercise 4: print out all pairs from 2 arrays that gives a sum of 13.");

        ArrayList<Integer> tmpArray1 = new ArrayList <Integer>();
        ArrayList<Integer> tmpArray2 = new ArrayList <Integer>();

        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));

        Arrays.sort(array1);
        Arrays.sort(array2);

        // check each element of first array
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                // look for sum of 13
                if ((array1[i] + array2[j]) == 13) {
                    // System.out.printf("(%d,%d)\n", array1[i], array2[j]);
                    tmpArray1.add(array1[i]);
                    tmpArray2.add(array2[j]);
                }
            }
        }

        int tmp1 = 0, tmp2 = 0;
        boolean found;

        /*
         * tmpArray1 & tmpArray2 holds numbers that their sum is 13
         * look for redundancy of pair combination
         */
        int arraySz = tmpArray1.size();
        int j = 0;

        for (int i = 0; i < arraySz; i++) {
            tmp1 = tmpArray1.get(i);
            found = false;

            j = 1;
            while ( j < arraySz && !found) {
                tmp2 = tmpArray2.get(j);

                if ((tmp1 == tmp2) && (tmpArray1.get(j) == tmpArray2.get(i))) {
                    found = true;
                    tmpArray1.remove(j);
                    tmpArray2.remove(j);
                    arraySz = tmpArray1.size();
                }
                j++;
            }
        }

        for (int i = 0; i < tmpArray1.size(); i++) {
            System.out.printf("(%d, %d)\n", tmpArray1.get(i), tmpArray2.get(i));
        }

        /*
         * Exercise 5: Prompt the user to input 10 values and store them into an array.
         * Output the total number of odd and even values in the array.
         */
        System.out.println("\n\n***** Exercise 5: \nEnter 10 values: ");

        int[] intArray5 = new int[10];
        ArrayList<Integer> evenArray = new ArrayList<Integer>();
        ArrayList<Integer> oddArray = new ArrayList<Integer>();

        int maxLoop = intArray5.length;
        for (int i = 0; i < maxLoop; i++ ) {
            tmp1 = keyboard.nextInt();
            intArray5[i] = tmp1;
            if ( tmp1 % 2 == 0)
                evenArray.add(tmp1);
            else
                oddArray.add(tmp1);
        }

        System.out.println("\nEntered numbers are " + Arrays.toString(intArray5));
        System.out.println("There are " + evenArray.size() + " even numbers: " + evenArray);
        System.out.println("There are " + oddArray.size() + " odd numbers: " + oddArray);

    }
}
