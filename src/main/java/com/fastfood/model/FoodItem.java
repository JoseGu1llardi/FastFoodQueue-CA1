package main.java.com.fastfood.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * Class that represents a food item in storage.
 * Encapsules all necessary information: name, weight, best-before date, and added time.
 * Includes validation methods to ensure data integrity.
 */
public class FoodItem {

    private String id;
    private String name;
    private double weight;
    private final LocalDateTime bestBeforeDate;
    private final LocalDateTime addedTime;

    // Valid food types
    private static final List<String> VALID_FOOD_TYPES = Arrays.asList(
            "Burger", "Pizza", "Fries", "Sandwich", "Hotdog"
    );

    // Maximum days for best-before date (2 weeks)
    private static final int MAX_BEST_BEFORE_DAYS = 14;

    public FoodItem(String name, double weight, LocalDateTime bestBeforeDate, LocalDateTime addedTime) {
        // Validate all inputs before setting
        validateName(name);

        this.name = name;
        this.weight = weight;
        this.bestBeforeDate = bestBeforeDate;
        this.addedTime = addedTime;
    }

    /**
     * Validates that the food name is not empty and is one of the valid types
     * @param name The food to validate
     * @throws IllegalArgumentException if name is invalid
     */
    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Food name cannot be null or empty.");
        }

        if (!VALID_FOOD_TYPES.contains(name)) {
            throw new IllegalArgumentException(
                    String.format("Food name '%s' is invalid. Must be one of the %s", name, VALID_FOOD_TYPES)
            );
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Setters for id, bestBeforeDate, and addedTime are intentionally omitted for these fields.
     * The best-before date and added time should not be changed after creation
     * to maintain data integrity, traceability, and compliance with food safety requirements.
     */
    public LocalDateTime getBestBeforeDate() {
        return bestBeforeDate;
    }

    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd/MM HH:mm:ss");

        return String.format("Food: %-10s | Weight: %6.1fg | Best Before: %s | Added at: %s",
                name,
                weight,
                bestBeforeDate.format(dateFormatter),
                addedTime.format(timeFormatter));
    }
}
