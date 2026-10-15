
package main.java.com.fastfood.ui;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
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
}
