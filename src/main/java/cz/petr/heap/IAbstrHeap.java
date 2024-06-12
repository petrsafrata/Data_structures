package cz.petr.heap;

import cz.petr.tree.eTraversalType;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Petr
 */
public interface IAbstrHeap<T> {
    
    // Builds the required priority queue, input parameter is an array of municipalities
    void build(T[] municipalityArray);

    // Rebuilds the priority queue according to the required priority
    void reorganize(Comparator<T> priority);

    // Cancels the priority queue
    void cancel();

    // Tests if the priority queue is empty
    boolean isEmpty();

    // Inserts an element into the priority queue
    void insert(T element);

    // Removes the element with the highest priority from the priority queue
    T removeMax();

    // Accesses the element with the highest priority in the priority queue
    T accessMax();

    // Prints the elements of the priority queue (uses breadth-first and depth-first iterator)
    Iterator<T> print(eTraversalType type);
}
