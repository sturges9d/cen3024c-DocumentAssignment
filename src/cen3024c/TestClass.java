package cen3024c;

import java.util.Scanner;

/**
 * Displays the nth value of the Fibonacci function using both recursive and iterative methods
 * and displays the elapsed time for each method.
 * 
 * @author Stephen Sturges Jr.
 * @version 6/7/2022.
 */
public class TestClass {

	/**
	 * This is the main method and its only call is to the constructor.
	 * 
	 * @param args Strings passed into the main.
	 */
    public static void main(String[] args) {
        new TestClass();
    }
    
    /**
     * Implements the methods for displaying the nth value of the Fibonacci sequence and the elapsed time for each.
     */
    public TestClass() {
    	// Request nth term from the user.
    	System.out.print("Please enter the nth term of the Fibonacci sequence you want to view: ");
        Scanner input = new Scanner(System.in);
        int iterations = input.nextInt();
        
        // Implement iterative method.
        System.out.println("\nIterative method:");
        long startTime = System.nanoTime();
        iterativeFibSeq(iterations);
        long endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " ns.");

        // Implement recursive method.
        System.out.println("\nRecusive method:");
        startTime = System.nanoTime();
        System.out.println("nth Term = " + recursiveFibSeq(iterations));
        endTime = System.nanoTime();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " ns.");

        // Close the input Scanner.
        input.close();
    }

    /**
     * Iterative method. Displays the nth term of the Fibonacci sequence with 0 being the 1st term.
     * 
     * @param iterations Integer passed into this function to limit the Fibonacci sequence iterations.
     */
    public static void iterativeFibSeq(int iterations) {
        long previous_number = 0;
        long current_number = 1;
        long result = 0;
        if (iterations == 1) {
            System.out.println("nth Term = " + previous_number);
        } else if (iterations == 2) {
            System.out.println("nth Term = " + current_number);
        } else if (iterations > 2) {
            for (int i = 0; i < (iterations - 2); i++) {
                result = previous_number + current_number;
                previous_number = current_number;
                current_number = result;
            }
            System.out.println("nth Term = " + result);
        } else {
            System.out.println("Please enter a valid integer.");
        }
    }

    /**
     * Recursive method. Displays the nth term of the Fibonacci sequence with 0 being the 1st term.
     * 
     * @param n Long value passed into this function to limit the Fibonacci sequence iterations. Considered as entering the nth term.
     * @return Returns the values n-1 and n-2 from this method (recursive) resulting in the value of the nth term of the Fibonacci sequence.
     */
    public static long recursiveFibSeq(long n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        return recursiveFibSeq(n - 1) + recursiveFibSeq(n - 2); // I needed to Google this part.
    }
}