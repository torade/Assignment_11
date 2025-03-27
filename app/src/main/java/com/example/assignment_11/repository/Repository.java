package com.example.assignment_11.repository;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Generic repository class for soccer teams.
 * Demonstrates generics and implements Iterable interface.
 *
 * @param <T> the type of elements in this container
 */
public class Repository<T> {

    //attributes
    private List<T> items;

    //constructor
    public Repository() { this.items = new ArrayList<>(); }

    //methods
    public List<T> getAll() { return items; }
    public void add(T item) { this.items.add(item); }

    /**
     * Filters the items in the repository based on the given predicate.
     * @param predicate filter criteria
     * @return list of items using stream and lambda functions
     * @RequiresApi(api = Build.VERSION_CODES.UPSIDE_DOWN_CAKE) // otherwise the .toList() throws an error
     */
    @RequiresApi(api = Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    public List<T> filter(Predicate<T> predicate)
    {
        return items.stream().filter(predicate).toList();
    }


}
