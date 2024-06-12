package cz.petr.tree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import cz.petr.queue.AbstrFifo;
import cz.petr.stack.AbstrLifo;

/**
 *
 * @author Petr
 */
public class AbstrTable<K extends Comparable<K>, V> implements IAbstrTable<K, V> {

    private Node root;

    private class Node {

        K key;
        V value;
        Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public AbstrTable() {
        this.root = null;
    }

    @Override
    public void cancel() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public V find(K key) {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return findRec(root, key);
    }

    private V findRec(Node node, K key) {
        if (node == null) {
            return null;
        }
        int result = key.compareTo(node.key);
        if (result < 0) {
            return findRec(node.left, key);
        } else if (result > 0) {
            return findRec(node.right, key);
        } else {
            return node.value;
        }
    }

    @Override
    public void insert(K key, V value) {
        root = insertRec(root, key, value);
    }

    private Node insertRec(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        int result = key.compareTo(node.key);
        if (result < 0) {
            node.left = insertRec(node.left, key, value);
        } else if (result > 0) {
            node.right = insertRec(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        root = removeRec(root, key);
        return !isEmpty() ? root.value : null;
    }

    private Node removeRec(Node node, K key) {
        if (node == null) {
            return null;
        }
        int result = key.compareTo(node.key);
        if (result < 0) {
            node.left = removeRec(node.left, key);
        } else if (result > 0) {
            node.right = removeRec(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node minNode = findMinNode(node.right);
            node.key = minNode.key;
            node.value = minNode.value;
            node.right = removeRec(node.right, minNode.key);
        }
        return node;
    }

    private Node findMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public Iterator<K> createIterator(eTraversalType type) {
        if (type == eTraversalType.DEPTH) {
            return new InOrderIteratorStack(root);
        } else {
            return new InOrderIteratorQueue(root);
        }
    }

    private class InOrderIteratorStack implements Iterator<K> {

        private AbstrLifo<Node> stack;

        InOrderIteratorStack(Node node) {
            stack = new AbstrLifo<>();
            moveLeft(node);
        }

        private void moveLeft(Node currentNode) {
            while (currentNode != null) {
                stack.insert(currentNode);
                currentNode = currentNode.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Node current = stack.remove();

            if (current.right != null) {
                moveLeft(current.right);
            }

            return current.key;
        }
    }

    private class InOrderIteratorQueue implements Iterator<K> {

        private AbstrFifo<Node> queue;

        InOrderIteratorQueue(Node node) {
            queue = new AbstrFifo<>();
            if (node != null) {
                queue.insert(node);
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Node current = queue.remove();

            if (current.left != null) {
                queue.insert(current.left);
            }

            if (current.right != null) {
                queue.insert(current.right);
            }

            return current.key;
        }
    }

}
