package cz.petr.stack;

import java.util.Iterator;

/**
 *
 * @author Petr
 */
public interface IAbstrLifo<T> {
    
    // Cancel the entire stack
    void cancel();

    // Test if empty
    boolean isEmpty();

    // Insert an element into the stack
    void insert(T data);

    // Remove an element from the stack
    T remove();

    // Returns an iterator for the stack
    Iterator<T> createIterator();
}
