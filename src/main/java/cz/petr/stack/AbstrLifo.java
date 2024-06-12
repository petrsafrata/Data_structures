package cz.petr.stack;

import cz.petr.linkedlist.AbstrDoubleList;
import java.util.Iterator;

/**
 *
 * @author Petr
 */

//Implemented as a linked list

public class AbstrLifo<T> implements IAbstrLifo<T> {

    private AbstrDoubleList<T> stack;

    public AbstrLifo() {
        stack = new AbstrDoubleList<>();
    }

    @Override
    public void cancel() {
        stack.cancel();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void insert(T data) {
        stack.insertFirst(data);
    }

    @Override
    public T remove() {
        if (stack.isEmpty()) {
            return null;
        } else {
            return stack.removeFirst();
        }
    }

    @Override
    public Iterator<T> createIterator() {
        return stack.iterator();
    }

}
