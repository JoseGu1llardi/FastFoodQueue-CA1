
package com.fastfood.ui;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import com.fastfood.datastructure.FoodQueue;
import com.fastfood.model.FoodItem;
import com.fastfood.model.FoodType;

public class MainApp {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            FoodQueue storage = new FoodQueue();
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

                if (!scanner.hasNextLine()) {
                    break;
                }

                String choice = scanner.nextLine().trim();

                switch (choice) {

                    case "1":
                        if (storage.isFull()) {
                            System.out.println(
                                "Storage is full (8 trays). Remove an item first."
                            );
                            break;
                        }

                        FoodItem item = readFoodItem(scanner);

                        if (item != null) {
                            storage.addFood(item);
                            System.out.println("Food added: " + item);
                        }
                        break;

                    case "2":
                        FoodItem removed = storage.remove();

                        if (removed == null) {
                            System.out.println(
                                "Storage is empty. Nothing to remove."
                            );
                        } else {
                            System.out.println("Removed: " + removed);
                        }
                        break;

                    case "3":
                        storage.displayAll();
                        break;

                    case "4":
                        FoodItem first = storage.peek();

                        if (first == null) {
                            System.out.println("Storage is empty.");
                        } else {
                            System.out.println("First in line: " + first);
                        }
                        break;

                    case "5":
                        searchFood(scanner, storage);
                        break;

                    case "0":
                        running = false;
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }
    }

    // Search the storage by food type
    private static void searchFood(Scanner scanner, FoodQueue storage) {

        System.out.print("Enter food type to search: ");

        if (!scanner.hasNextLine()) {
            return;
        }

        try {
            FoodType type = FoodType.fromString(scanner.nextLine());
            List<FoodItem> found = storage.searchByType(type);

            if (found.isEmpty()) {
                System.out.println(
                    "No " + type + " found in storage."
                );
            } else {
                System.out.println(
                    "Found " + found.size() + " " + type + " item(s):"
                );

                for (FoodItem food : found) {
                    System.out.println(" -> " + food);
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // Read and validate food information
    private static FoodItem readFoodItem(Scanner scanner) {

        try {
            System.out.print(
                "Enter food type (Burger, Pizza, Fries, Sandwich, Hotdog): "
            );

            if (!scanner.hasNextLine()) {
                return null;
            }

            String foodInput = scanner.nextLine();
            FoodType type = FoodType.fromString(foodInput);

            System.out.print("Enter weight in grams: ");

            if (!scanner.hasNextLine()) {
                return null;
            }

            String weightInput = scanner.nextLine().trim();
            double weight;

            try {
                weight = Double.parseDouble(weightInput);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                    "Weight must be a number. Got: '" + weightInput + "'"
                );
            }

            System.out.print(
                "Enter best-before date (YYYY-MM-DD): "
            );

            if (!scanner.hasNextLine()) {
                return null;
            }

            String dateInput = scanner.nextLine().trim();
            LocalDate date;

            try {
                date = LocalDate.parse(dateInput);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException(
                    "Date must be a valid date in the format YYYY-MM-DD. Got: '"
                    + dateInput + "'"
                );
            }

            return new FoodItem(
                type,
                weight,
                date.atStartOfDay()
            );

        } catch (IllegalArgumentException e) {

            System.out.println();
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Food item was not added.");
            System.out.println("Please try again.");
            System.out.println();

            return null;
        }
    }
}
