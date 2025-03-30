package com.example.assignment_11.iterator;

import java.util.Iterator;
import java.util.List;

public class CustomIterator<T> implements Iterator<T> {
    private final List<T> items;
    private int currentIndex = 0;

    public CustomIterator(List<T> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < items.size();
    }

    @Override
    public T next() {
        return items.get(currentIndex++);
    }
}