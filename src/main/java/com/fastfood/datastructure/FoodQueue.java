package com.fastfood.datastructure;

import com.fastfood.model.FoodItem;

import java.util.LinkedList;
import java.util.Queue;

/*
    Implements de Queue data structure (FIFO) for the fast-food storage.
    Maximum capacity is 8 trays.
 */
public class FoodQueue {
    private static final int MAX_CAPACITY = 8;
    private Queue<FoodItem> queue;

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

    /*
        Adds a food item to the storage.
        @return true if added, false if storage is full.
     */
    public boolean addFood(FoodItem item) {
        if (isFull()) {
            return false;
        }
        return queue.add(item);
    }

    /*
        Removes and return the first food item (FIFO).
        @return the FoodItem, or null if empty.
     */
    public FoodItem remove() {
        if (isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    /*
        Return the first food item without removing it.
        @return the FoodItem, or null if empty.
     */
    public FoodItem peek() {
        if (isEmpty()) {
            return null;
        }
        return queue.peek();
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