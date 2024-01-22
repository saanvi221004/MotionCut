import java.util.Scanner;

public class TextAdventureGame {

    public static void main(String[] args) {
        // Start the game
        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("You find yourself in a mysterious forest...");

        // Call the first decision point
        decisionPoint1();
    }

    // Decision point 1
    public static void decisionPoint1() {
        System.out.println("\nDecision Point 1: You come across a fork in the path.");
        System.out.println("1. Take the left path.");
        System.out.println("2. Take the right path.");

        // Get user input
        int choice = getUserChoice(1, 2);

        // Process user choice
        if (choice == 1) {
            System.out.println("\nYou chose to take the left path.");
            // Call the next decision point or end the game
            decisionPoint2a();
        } else {
            System.out.println("\nYou chose to take the right path.");
            // Call the next decision point or end the game
            decisionPoint2b();
        }
    }

    // Decision point 2a
    public static void decisionPoint2a() {
        System.out.println("\nDecision Point 2a: You find a hidden cave.");
        System.out.println("1. Enter the cave.");
        System.out.println("2. Continue on the path.");

        // Get user input
        int choice = getUserChoice(1, 2);

        // Process user choice
        if (choice == 1) {
            System.out.println("\nYou entered the cave and discovered a treasure!");
            // End the game
            endGame();
        } else {
            System.out.println("\nYou decided to continue on the path.");
            // End the game or continue with more decision points
            endGame();
        }
    }

    // Decision point 2b
    public static void decisionPoint2b() {
        System.out.println("\nDecision Point 2b: You encounter a friendly creature.");
        System.out.println("1. Befriend the creature.");
        System.out.println("2. Ignore the creature and move on.");

        // Get user input
        int choice = getUserChoice(1, 2);

        // Process user choice
        if (choice == 1) {
            System.out.println("\nYou befriended the creature, and it helps you on your journey.");
            // End the game
            endGame();
        } else {
            System.out.println("\nYou ignored the creature and continued your journey.");
            // End the game or continue with more decision points
            endGame();
        }
    }

    // Function to get user choice within a specified range
    public static int getUserChoice(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            try {
                System.out.print("Enter your choice (" + min + "-" + max + "): ");
                choice = Integer.parseInt(scanner.nextLine());

                if (choice >= min && choice <= max) {
                    break; // Valid input, exit loop
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return choice;
    }

    // End the game
    public static void endGame() {
        System.out.println("\nThanks for playing the Text Adventure Game! Goodbye!");
        System.exit(0);
    }
}
