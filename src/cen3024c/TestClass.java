package cen3024c;

import java.util.Scanner;

/**
 * Name: Stephen Sturges Jr.
 * Date: 6/7/2022
 * Description: Implements the Fibonacci function in both recursive and iterative fashions and displays the runtime efficiency of both.
 */
public class TestClass {

	/**
	 * This is the main class. This class holds the methods for displaying the nth value of the Fibonacci sequence.
	 * @param args Strings passed into the main.
	 */
    public static void main(String[] args) {
        // Request nth Fibonacci sequence iteration from the user.
    	System.out.print("Please enter the nth term of the Fibonacci sequence you want to view: ");
        Scanner input = new Scanner(System.in);
        int iterations = input.nextInt();
        
        // Implement iterative method.
        System.out.println("Iterative method:");
        long startTime = System.nanoTime();
        iterativeFibSeq(iterations);
        long endTime = System.nanoTime();
        System.out.println("Time to complete: " + (endTime - startTime) + " ns.");

        // Implement recursive method.
        System.out.println("Recusive method:");
        startTime = System.nanoTime();
        System.out.println(recursiveFibSeq(iterations));
        endTime = System.nanoTime();
        System.out.println("Time to complete: " + (endTime - startTime) + " ns.");
        
        // Implement borrowed recursive method to compare speed to the above method.
        System.out.println("Borrowed Recusive method:");
        startTime = System.nanoTime();
        System.out.println(recursiveFibSeqBorrowed(iterations));
        endTime = System.nanoTime();
        System.out.println("Time to complete: " + (endTime - startTime) + " ns.");

        // Close the input Scanner.
        input.close();
    }

    /**
     * My iterative method. Works based on 0 as the 1st term in the Fibonacci sequence.
     * @param iterations Integer passed into this function to limit the Fibonacci sequence iterations.
     */
    public static void iterativeFibSeq(int iterations) {
        long previous_number = 0;
        long current_number = 1;
        long result = 0;
        if (iterations == 1) {
            System.out.println(previous_number);
        } else if (iterations == 2) {
            System.out.println(current_number);
        } else if (iterations > 2) {
            for (int i = 0; i < (iterations - 2); i++) {
                result = previous_number + current_number;
                previous_number = current_number;
                current_number = result;
            }
            System.out.println(result);
        } else {
            System.out.println("Please enter a valid integer.");
        }
    }

    /**
     * My recursive method. Works based on 0 as the 1st term in the Fibonacci sequence.
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
    
    /**
     * I Googled for solutions to this problem, this is essentially two of them that I saw. I wanted to compare this to what I had done above.
     * This works based on 1 as the 1st term in the Fibonacci sequence.
     * @param n Long value passed into this function to limit the Fibonacci sequence iterations.
     * @return Returns the values n-1 and n-2 from this method (recursive).
     */
    public static int recursiveFibSeqBorrowed(int n) {
    	if (n <= 1) {
    		return n;
    	}
    	return recursiveFibSeqBorrowed(n - 1) + recursiveFibSeqBorrowed(n - 2);
    }
}