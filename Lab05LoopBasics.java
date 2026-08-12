/*
 * COSC 1173 Programming Lab - Lab 05: Loop Fundamentals
 * Textbook reference: Liang, Chapter 5 (Loops)
 *
 * Student name: [TYPE YOUR NAME HERE]
 * Date:         [TYPE TODAY'S DATE HERE]
 *
 * REQUIREMENT: every executable statement below must carry a line comment.
 */
import java.util.Scanner;

public class Lab05LoopBasics {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // creates the keyboard reader

        // PART A - counter-controlled loop
        System.out.print("Enter n: ");
        int n = input.nextInt(); // reads the upper limit of the summation

        // STEP 1 - TODO: use a for loop to add every integer from 1 through n into sum.
        int sum = 0; // accumulator: starts at 0 because nothing has been added yet

        // STEP 2 - TODO: print the result in exactly this form (n and sum come from variables):
        //              Sum 1 to 10: 55

        // PART B - a multiplication table row
        System.out.print("Enter a multiplier: ");
        int m = input.nextInt(); // reads the number whose table row will be printed

        // STEP 3 - TODO: print the label "Table row: " with print (NOT println) so the
        //          numbers stay on the same line, then loop k from 1 through 9 and print
        //          m * k. Separate the values with single spaces. Finish with println()
        //          to end the line. Expected for m = 7:
        //              Table row: 7 14 21 28 35 42 49 56 63

        // PART C - sentinel-controlled loop
        System.out.println("Enter numbers, then -1 to stop:");

        // STEP 4 - TODO: repeatedly read integers until the user enters -1.
        //          The sentinel -1 must NOT be counted and must NOT be added to the total.
        //          A while loop that reads one value before the test is the standard pattern.
        int count = 0;    // how many real values have been read
        double total = 0; // running total of the real values

        // STEP 5 - TODO: print   Count: 3
        // STEP 6 - TODO: if count is greater than 0, print the average to two decimals:
        //              Average: 9.00
        //          If count is 0, print exactly:
        //              Average: N/A
        //          Guarding the division prevents a divide-by-zero defect.
    }
}
