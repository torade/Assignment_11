package com.example.assignment_11.repository;

import android.os.Build;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * A generic repository class for managing a collection of items.
 * Implements basic CRUD operations and filtering functionality.
 *
 * @param <T> The type of elements in this repository.
 */
public class Repository<T> {

    // List to hold items
    private final List<T> items;

    /**
     * Constructor to initialize an empty repository.
     */
    public Repository() {
        this.items = new ArrayList<>();
    }

    /**
     * Returns a list of all items in the repository.
     *
     * @return A list containing all items.
     */
    public List<T> getAll() {
        return items;
    }

    /**
     * Adds an item to the repository.
     *
     * @param item The item to add.
     */
    public void add(T item) {
        items.add(item);
    }

    /**
     * Filters the items in the repository based on the given predicate.
     *
     * @param predicate The filter criteria.
     * @return A list of items that match the predicate.
     */
    @RequiresApi(api = Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    public List<T> filter(Predicate<T> predicate) {
        return items.stream()
                .filter(predicate)
                .collect(Collectors.toList()); // Use collect(Collectors.toList()) for compatibility
    }
}
