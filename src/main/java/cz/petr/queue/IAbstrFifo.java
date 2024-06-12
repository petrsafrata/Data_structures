package cz.petr.queue;

import java.util.Iterator;

/**
 *
 * @author Petr
 */
public interface IAbstrFifo<T> {
    
    // Cancel the entire queue
    void cancel();

    // Test if empty
    boolean isEmpty();

    // Insert an element into the queue
    void insert(T data);

    // Remove an element from the queue
    T remove();

    // Returns an iterator for the queue
    Iterator<T> createIterator();
}
