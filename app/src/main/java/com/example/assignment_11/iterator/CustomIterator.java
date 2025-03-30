package com.example.assignment_11.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * A custom iterator for traversing a list of generic items.
 *
 * @param <T> The type of elements in the list.
 */
public class CustomIterator<T> implements Iterator<T> {

    // List of items to iterate over
    private final List<T> items;

    // Current index in the iteration
    private int currentIndex = 0;

    /**
     * Constructor to initialize the iterator with a list of items.
     *
     * @param items The list of items to iterate over.
     */
    public CustomIterator(List<T> items) {
        this.items = items;
    }

    /**
     * Checks if there are more items to iterate over.
     *
     * @return True if there are more items, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return currentIndex < items.size();
    }

    /**
     * Returns the next item in the iteration.
     *
     * @return The next item in the list.
     */
    @Override
    public T next() {
        return items.get(currentIndex++);
    }
}
