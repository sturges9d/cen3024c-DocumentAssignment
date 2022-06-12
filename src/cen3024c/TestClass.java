package cen3024c;

import java.util.Scanner;

/**
 * Displays the requested nth value of the Fibonacci sequence using both recursive and iterative methods
 * and displays the elapsed time.
 * 
 * @author Stephen Sturges Jr.
 * @version 6/7/2022.
 */
public class TestClass {

	/**
	 * This is the main method. The only call is to the TestClass() constructor.
	 * 
	 * @param args Strings passed into the main.
	 */
    public static void main(String[] args) {
        new TestClass();
    }
    
    /**
     * Implements the iterative and recursive methods for displaying the nth value of the Fibonacci sequence and the elapsed time for each.
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
     * Iterative method. Calculates and displays the nth term of the Fibonacci sequence based on 0 being the first term of the sequence using iteration.
     * 
     * @param n Integer data type passed into this function to limit the Fibonacci sequence iterations to n. In other words, the user enters n
     * referring to nth term of the Fibonacci sequence.
     */
    public static void iterativeFibSeq(int n) {
        long previous_number = 0;
        long current_number = 1;
        long result = 0;
        if (n == 1) {
            System.out.println("nth Term = " + previous_number);
        } else if (n == 2) {
            System.out.println("nth Term = " + current_number);
        } else if (n > 2) {
            for (int i = 0; i < (n - 2); i++) {
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
     * Recursive method.Calculates and displays the nth term of the Fibonacci sequence based on 0 being the first term of the sequence using recursion.
     * 
     * @param n Long data type value passed into this function to limit the Fibonacci sequence iterations to n. In other words, the user enters n
     * referring to nth term of the Fibonacci sequence.
     * @return Returns the values n-1 and n-2 from this method (recursive) resulting in the value of the nth term of the Fibonacci sequence.
     */
    public static long recursiveFibSeq(long n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        return recursiveFibSeq(n - 1) + recursiveFibSeq(n - 2); // F(n) = F(n-1) + F(n-2)
    }
}