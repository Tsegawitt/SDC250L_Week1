/*******************************************************************
* Name: Tsegawit G
* Date: 03/31/2026
* Assignment: Calculator Project - Phase #4 (Exception Handling)
*
* Description:
* This program performs division and uses exception handling to
* manage invalid input and division by zero. The program continues
* running until the user chooses to quit.
*******************************************************************/

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // Method to perform division
    public static double divide(double num1, double num2) {
        return num1 / num2;
    }

    // Method to display welcome message
    public static void displayWelcome() {
        System.out.println("Welcome to the Calculator Application!");
        System.out.println("You will enter two numbers to perform division.");
        System.out.println("Enter 0 as the second number to test division by zero.");
        System.out.println("Type 'q' anytime to quit.\n");
    }

    public static void main(String[] args) {

        System.out.println("Your Name - Week 4 Calculator Project (Exception Handling)\n");

        Scanner scanner = new Scanner(System.in);
        displayWelcome();

        boolean running = true;

        while (running) {
            try {
                System.out.print("Enter first number: ");

                if (scanner.hasNext("q")) {
                    break;
                }
                double num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");

                if (scanner.hasNext("q")) {
                    break;
                }
                double num2 = scanner.nextDouble();

                // Handle division by zero
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }

                double result = divide(num1, num2);
                System.out.println("Result: " + result + "\n");

            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Invalid input. Please enter numeric values.\n");
                scanner.nextLine(); // clear input

            } catch (ArithmeticException e) {
                System.out.println(e);
                System.out.println("Please enter a non-zero denominator.\n");
            }
        }

        System.out.println("\nThank you for using the calculator!");
        scanner.close();
    }
}