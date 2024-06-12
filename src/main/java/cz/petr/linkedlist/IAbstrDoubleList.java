package cz.petr.linkedlist;

import java.util.Iterator;

/**
 *
 * @author Petr
 */
public interface IAbstrDoubleList<T> extends Iterable<T> {

    // Cancel the entire list
    void cancel();

    // Test if the list is empty
    boolean isEmpty();

    // Insert an element at the first position of the list
    void insertFirst(T data);

    // Insert an element at the last position of the list
    void insertLast(T data);

    // Insert an element after the current element
    void insertAfter(T data);

    // Insert an element before the current element
    void insertBefore(T data);

    // Access the current element in the list
    T accessCurrent();

    // Access the first element in the list
    T accessFirst();

    // Access the last element in the list
    T accessLast();

    // Access the successor of the current element in the list
    T accessSuccessor();

    // Access the predecessor of the current element in the list
    T accessPredecessor();

    // Remove the current element from the list; the current element is then set to the first element
    T removeCurrent();

    // Remove the first element from the list
    T removeFirst();

    // Remove the last element from the list
    T removeLast();

    // Remove the successor of the current element from the list
    T removeSuccessor();

    // Remove the predecessor of the current element from the list
    T removePredecessor();

    // Iterator as per the Iterable interface
    @Override
    Iterator<T> iterator();
}
