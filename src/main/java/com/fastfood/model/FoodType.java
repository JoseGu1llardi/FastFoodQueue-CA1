package main.java.com.fastfood.model;

import java.util.Arrays;

/**
 * Enum representing the valid food types available in the fast-food restaurant.
 * Using an enum provides type safety and prevents invalid food type names.
 */
public enum FoodType {

    BURGER("Burger"),
    PIZZA("Pizza"),
    FRIES("Fries"),
    SANDWICH("Sandwich"),
    HOTDOG("Hotdog");

    private final String displayName;

    /**
     * Constructor for FoodType enum
     * @param displayName The display name of the food type
     */
    FoodType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    /**
     * Returns a string representation of the food type
     * @return The display name
     */
    @Override
    public String toString() {
        return displayName;
    }

    /**
     * Converts a string to FoodType enum (case-insensitive)
     * @param foodTypeString The string to convert
     * @return The corresponding FoodType enum
     * @throws IllegalArgumentException if the string doesn't match any food type
     */
    public static FoodType fromString(String foodTypeString) {
        if (foodTypeString == null || foodTypeString.trim().isEmpty()) {
            throw new IllegalArgumentException("Food type cannot be null or empty");
        }

        for (FoodType type : FoodType.values()) {
            if (type.displayName.equalsIgnoreCase(foodTypeString.trim())) {
                return type;
            }
        }

        throw new IllegalArgumentException(
                String.format("Invalid food type: %s. Must be one of: %s",
                        foodTypeString,
                        Arrays.toString(FoodType.values())
                )
        );
    }
}
