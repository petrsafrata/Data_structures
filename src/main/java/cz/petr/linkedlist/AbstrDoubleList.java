package cz.petr.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *
 * @author Petr
 */
public class AbstrDoubleList<T> implements IAbstrDoubleList<T> {

    private Element<T> first;
    private Element<T> last;
    private Element<T> current;
    private int size = 0;

    private static class Element<T> {

        private Element<T> next;
        private Element<T> previous;
        private final T data;

        public Element(T data) {
            this.data = data;
        }
    }

    public AbstrDoubleList() {
        this.first = null;
        this.last = null;
        this.current = null;
    }

    public int size() {
        return size;
    }

    @Override
    public void cancel() {
        this.first = null;
        this.last = null;
        this.current = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public void insertFirst(T data) {
        Objects.requireNonNull(data);
        Element<T> element = new Element<>(data);
        if (isEmpty()) {
            first = element;
            last = first;
            current = element;
        } else {
            element.next = first;
            first.previous = element;
            first = element;
        }
        size++;
    }

    @Override
    public void insertLast(T data) {
        Objects.requireNonNull(data);
        Element<T> element = new Element<>(data);
        if (isEmpty()) {
            insertFirst(data);
        } else {
            last.next = element;
            element.previous = last;
            last = element;
            size++;
        }
    }

    @Override
    public void insertAfter(T data) {
        Objects.requireNonNull(data);
        if (current == null) {
            throw new IllegalStateException();
        }
        Element<T> element = new Element<>(data);
        element.next = current.next;
        element.previous = current;
        if (current.next != null) {
            current.next.previous = element;
        } else {
            last = element;
        }
        current.next = element;
        size++;
    }

    @Override
    public void insertBefore(T data) {
        Objects.requireNonNull(data);
        if (current == null) {
            throw new IllegalStateException();
        }
        Element<T> element = new Element<>(data);
        element.previous = current.previous;
        element.next = current;
        if (current.previous != null) {
            current.previous.next = element;
        } else {
            first = element;
        }
        current.previous = element;
        size++;
    }

    @Override
    public T accessCurrent() {
        if (isEmpty() || current == null) {
            throw new IllegalStateException();
        }
        return current.data;
    }

    @Override
    public T accessFirst() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        current = first;
        return first.data;
    }

    @Override
    public T accessLast() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        current = last;
        return last.data;
    }

    @Override
    public T accessSuccessor() {
        if (current == null || current.next == null) {
            throw new IllegalStateException();
        }
        current = current.next;
        return current.data;
    }

    @Override
    public T accessPredecessor() {
        if (current == null || current.previous == null) {
            throw new IllegalStateException();
        }
        current = current.previous;
        return current.data;
    }

    @Override
    public T removeCurrent() {
        if (isEmpty() || current == null) {
            throw new IllegalStateException();
        }
        T removeElement = current.data;
        if (current.previous != null) {
            current.previous.next = current.next;
        } else {
            first = current.next;
        }
        if (current.next != null) {
            current.next.previous = current.previous;
        } else {
            last = current.previous;
        }
        current = null;
        size--;
        return removeElement;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else if (first == last) {
            T data = first.data;
            cancel();
            return data;
        } else {
            T data = first.data;
            first = first.next;
            first.previous = null;
            if (current == first) {
                current = null;
            }
            size--;
            return data;
        }
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException();
        } else if (last == first) {
            T data = last.data;
            cancel();
            return data;
        } else {
            T data = last.data;
            last = last.previous;
            last.next = null;
            if (current == last) {
                current = null;
            }
            size--;
            return data;
        }
    }

    @Override
    public T removeSuccessor() {
        if (current == null || current.next == null) {
            throw new IllegalStateException();
        }
        T removeElement = current.next.data;
        if (current.next.next != null) {
            current.next.next.previous = current;
        } else {
            last = current;
        }
        current.next = current.next.next;
        size--;
        return removeElement;
    }

    @Override
    public T removePredecessor() {
        if (current == null || current.previous == null) {
            throw new IllegalStateException();
        }
        T removeElement = current.previous.data;
        if (current.previous.previous != null) {
            current.previous.previous.next = current;
        } else {
            first = current;
        }
        current.previous = current.previous.previous;
        size--;
        return removeElement;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Element<T> iteration = first;

            @Override
            public boolean hasNext() {
                return iteration != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = iteration.data;
                iteration = iteration.next;
                return data;
            }
        };
    }

}
