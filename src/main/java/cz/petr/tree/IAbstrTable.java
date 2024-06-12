package cz.petr.tree;

import java.util.Iterator;

/**
 *
 * @author Petr
 */
public interface IAbstrTable<K extends Comparable<K>, V> {
    
    // Cancel the entire table
    void cancel();

    // Test if the table is empty
    boolean isEmpty();

    // Find an element by key
    V find(K key);

    // Insert an element into the table
    void insert(K key, V value);

    // Remove an element by key
    V remove(K key);

    // Create an iterator that allows traversal of the tree in breadth/depth (in-order)
    Iterator createIterator(eTraversalType type);
}
