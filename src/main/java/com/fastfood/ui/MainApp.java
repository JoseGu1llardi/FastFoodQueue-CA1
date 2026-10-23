
package main.java.com.fastfood.ui;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import main.java.com.fastfood.model.FoodItem;
import main.java.com.fastfood.model.FoodType;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("TEST: Updated MainApp is running!");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== FAST FOOD STORAGE ===");
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Display food");
            System.out.println("4. Peek first food");
            System.out.println("5. Search food");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    FoodItem item = readFoodItem(scanner);

                    if (item != null) {
                        System.out.println("Food item validated: " + item);
                        System.out.println("Queue integration pending.");
                    }
                    break;

                case "2":
                case "3":
                case "4":
                case "5":
                    System.out.println("Feature coming soon.");
                    break;

                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    // Reads and validates food information
    private static FoodItem readFoodItem(Scanner scanner) {

        try {
            System.out.print("Enter food type (Burger, Pizza, Fries, Sandwich, Hotdog): ");
            FoodType type = FoodType.fromString(scanner.nextLine());

            System.out.print("Enter weight in grams: ");
            double weight = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter best-before date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            return new FoodItem(
                    type,
                    weight,
                    date.atStartOfDay()
            );

        } catch (IllegalArgumentException | DateTimeParseException e) {
            System.out.println();
            System.out.println("ERROR: " + (e.getMessage() != null ? e.getMessage() : "Invalid input format."));
            System.out.println("Food item was not added.");
            System.out.println("Please try again.");
            System.out.println();
            return null;
        }
    }
}