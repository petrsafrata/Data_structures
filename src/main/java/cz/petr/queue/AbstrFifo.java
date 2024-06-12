package cz.petr.queue;

import cz.petr.linkedlist.AbstrDoubleList;
import java.util.Iterator;

/**
 *
 * @author Petr
 */

//Implemented as a linked list

public class AbstrFifo<T> implements IAbstrFifo<T> {
    
    private AbstrDoubleList<T> queue;
    
    public AbstrFifo() {
        queue = new AbstrDoubleList<>();
    }
    
    @Override
    public void cancel() {
        queue.cancel();
    }
    
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    @Override
    public void insert(T data) {
        queue.insertLast(data);
    }
    
    @Override
    public T remove() {
        if (queue.isEmpty()) {
            return null;
        } else {
            return queue.removeFirst();
        }
    }
    
    @Override
    public Iterator<T> createIterator() {
        return queue.iterator();
    }
}
