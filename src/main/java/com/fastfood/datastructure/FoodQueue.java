
package com.fastfood.datastructure;

import com.fastfood.model.FoodItem;
import com.fastfood.model.FoodType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Implements the Queue data structure (FIFO) for fast-food storage.
 * Maximum capacity is 8 trays.
 */
public class FoodQueue {

    private static final int MAX_CAPACITY = 8;
    private final Queue<FoodItem> queue;

    public FoodQueue() {
        this.queue = new LinkedList<>();
    }

    public boolean isFull() {
        return queue.size() >= MAX_CAPACITY;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    /**
     * Adds a food item to the storage.
     * @return true if added, false if storage is full.
     */
    public boolean addFood(FoodItem item) {
        if (isFull()) {
            return false;
        }

        return queue.add(item);
    }

    /**
     * Removes and returns the first food item (FIFO).
     * @return the FoodItem, or null if empty.
     */
    public FoodItem remove() {
        if (isEmpty()) {
            return null;
        }

        return queue.poll();
    }

    /**
     * Returns the first food item without removing it.
     * @return the FoodItem, or null if empty.
     */
    public FoodItem peek() {
        if (isEmpty()) {
            return null;
        }

        return queue.peek();
    }

    /**
     * Searches the storage for all items of a given food type.
     * @return a list with the matching items (empty if none found).
     */
    public List<FoodItem> searchByType(FoodType type) {
        List<FoodItem> result = new ArrayList<>();

        for (FoodItem item : queue) {
            if (item.getFoodType() == type) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Displays all items in the storage.
     */
    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Storage is currently empty.");
            return;
        }

        System.out.println("--- Current Storage (" + size() + "/" + MAX_CAPACITY + " trays) ---");

        for (FoodItem item : queue) {
            System.out.println(" -> " + item.toString());
        }

        System.out.println("---------------------------------------------");
    }
}
