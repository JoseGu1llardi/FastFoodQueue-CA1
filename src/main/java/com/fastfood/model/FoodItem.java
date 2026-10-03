package main.java.com.fastfood.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class that represents a food item in storage.
 * Encapsules all necessary information: name, weight, best-before date, and added time.
 */
public class FoodItem {

    private String id;
    private String name;
    private double weight;
    private final LocalDateTime bestBeforeDate;
    private final LocalDateTime addedTime;

    public FoodItem(String name, double weight, LocalDateTime bestBeforeDate, LocalDateTime addedTime) {
        this.name = name;
        this.weight = weight;
        this.bestBeforeDate = bestBeforeDate;
        this.addedTime = addedTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime getBestBeforeDate() {
        return bestBeforeDate;
    }

    // setBestBeforeDate(LocalDateTime bestBeforeDate)

    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    // setAddedTime(LocalDateTime addedTime)

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
