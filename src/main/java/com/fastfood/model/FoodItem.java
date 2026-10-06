package main.java.com.fastfood.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Class that represents a food item in storage.
 * Encapsulates all necessary information: name, weight, best-before date, and added time.
 * Includes validation methods to ensure data integrity.
 */
public class FoodItem {

    private final String id;
    private FoodType foodType;
    private double weight;
    private final LocalDateTime bestBeforeDate;
    private final LocalDateTime addedTime;

    // Maximum days for best-before date (2 weeks)
    private static final int MAX_BEST_BEFORE_DAYS = 14;

    public FoodItem(FoodType foodType, double weight, LocalDateTime bestBeforeDate) {
        id = UUID.randomUUID().toString();

        // Validate all inputs before setting
        validateFoodType(foodType);
        validateWeight(weight);
        validateBestBeforeDate(bestBeforeDate);

        this.foodType = foodType;
        this.weight = weight;
        this.bestBeforeDate = bestBeforeDate;
        this.addedTime = LocalDateTime.now();
    }

    /**
     * Validates that the food type is not null
     * @param foodType The food type to validate
     * @throws IllegalArgumentException if food type is null
     */
    private void validateFoodType(FoodType foodType) {
        if (foodType == null) {
            throw new IllegalArgumentException("FoodType cannot be null");
        }
    }

    /**
     * Validates that the weight is positive
     * @param weight The weight to validate
     * @throws IllegalArgumentException if weight is not positive
     */
    private void validateWeight(double weight) {
        if (!Double.isFinite(weight) || weight <= 0) {
            throw new IllegalArgumentException("Food weight must be greater than 0.");
        }
    }

    /**
     * Validates that the best-before date is not in the past and is within 14 days
     * @param dateTime The best-before date to validate
     * @throws IllegalArgumentException if date is invalid
     */
    private void validateBestBeforeDate(LocalDateTime dateTime) {
        if (dateTime == null) {
            throw new IllegalArgumentException("Food best before date cannot be null.");
        }

        LocalDate date = dateTime.toLocalDate();
        LocalDate today = LocalDate.now();
        LocalDate maxDate = today.plusDays(MAX_BEST_BEFORE_DAYS);

        if (date.isBefore(today)) {
            throw new IllegalArgumentException(
                    "Best-before date cannot be in the past. Got: " + date
            );
        }

        if (date.isAfter(maxDate)) {
            throw new IllegalArgumentException(
                    "Best-before date cannot be more than " + MAX_BEST_BEFORE_DAYS +
                            " days from today. Got: " + date
            );
        }
    }

    public String getId() {
        return id;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        validateFoodType(foodType);
        this.foodType = foodType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        validateWeight(weight);
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
                foodType.getDisplayName(),
                weight,
                bestBeforeDate.format(dateFormatter),
                addedTime.format(timeFormatter));
    }

}
