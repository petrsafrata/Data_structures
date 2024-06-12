package cz.petr.heap;

import cz.petr.queue.AbstrFifo;
import cz.petr.stack.AbstrLifo;
import cz.petr.tree.eTraversalType;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Petr
 */
public class AbstrHeap<T> implements IAbstrHeap<T> {

    private T[] heap;
    private int size;
    private Comparator<T> priority;
    private static final int DEFAULT_CAPACITY = 5;

    public AbstrHeap(Comparator<T> priority, Class<T> myClass) {
        this.heap = (T[]) Array.newInstance(myClass, DEFAULT_CAPACITY);
        this.size = 0;
        this.priority = priority;
    }

    @Override
    public void build(T[] municipalityArray) {
        this.heap = Arrays.copyOf(municipalityArray, municipalityArray.length);
        this.size = municipalityArray.length;
        for (int i = parentIndex(size - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    @Override
    public void reorganize(Comparator<T> priority) {
        this.priority = priority;
        for (int i = parentIndex(size - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    @Override
    public void cancel() {
        this.heap = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(T element) {
        addCapacity();
        heap[size++] = element;
        heapifyUp(size - 1);
    }

    @Override
    public T removeMax() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        T maxElement = accessMax();
        heap[0] = heap[size - 1];
        size--;
        return maxElement;
    }

    @Override
    public T accessMax() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return heap[0];
    }

    @Override
    public Iterator<T> print(eTraversalType type) {
        if (type == eTraversalType.DEPTH) {
            return new InOrderIteratorStack();
        } else {
            return new InOrderIteratorQueue();
        }
    }

    private void addCapacity() {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, 2 * size);
        }
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int comparePriority(T item1, T item2) {
        if (priority != null) {
            return priority.compare(item1, item2);
        } else {
            throw new IllegalStateException();
        }
    }

    private int parentIndex(int i) {
        return (i - 1) / 2;
    }

    private int leftChildIndex(int i) {
        return 2 * i + 1;
    }

    private int rightChildIndex(int i) {
        return 2 * i + 2;
    }

    private void heapifyDown(int index) {
        int maxIndex = index;
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);

        if (leftChildIndex < size && comparePriority(heap[leftChildIndex], heap[maxIndex]) > 0) {
            maxIndex = leftChildIndex;
        }

        if (rightChildIndex < size && comparePriority(heap[rightChildIndex], heap[maxIndex]) > 0) {
            maxIndex = rightChildIndex;
        }

        if (index != maxIndex) {
            swap(index, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    private void heapifyUp(int index) {
        while (index > 0 && comparePriority(heap[index], heap[parentIndex(index)]) > 0) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private class InOrderIteratorStack implements Iterator<T> {

        private AbstrLifo<T> stack;

        public InOrderIteratorStack() {
            this.stack = new AbstrLifo<>();
            for (int i = size - 1; i >= 0; i--) {
                stack.insert(heap[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            return stack.remove();
        }
    }

    private class InOrderIteratorQueue implements Iterator<T> {

        private AbstrFifo<T> queue;

        public InOrderIteratorQueue() {
            this.queue = new AbstrFifo<>();
            for (int i = 0; i < size; i++) {
                queue.insert(heap[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            return queue.remove();
        }
    }

}
