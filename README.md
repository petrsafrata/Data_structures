<h1>Data Structures Implementation in Java</h1>
<p>This repository contains implementations of various fundamental data structures in Java, including a priority queue using a leftist heap, a binary search tree, a stack, a queue, and a doubly linked list.</p>
<h2>Table of Contents</h2>
  <ul>
    <li><a href="#getting-started">Getting Started</a></li>
    <li><a href="#data-structures">Data Structures</a>
    <ul>
      <li><a href="#priority-queue-heap">Priority Queue (Heap)</a></li>
      <li><a href="#binary-search-tree-abstrtable">Binary Search Tree (AbstrTable)</a></li>
      <li><a href="#stack">Stack</a></li>
      <li><a href="#queue">Queue</a></li>
      <li><a href="#doubly-linked-list">Doubly Linked List</a></li>
    </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
  </ul>
  <h2 id="getting-started">Getting Started</h2>
  <p>To get started with this project, you need to have Java installed on your system. Clone this repository to your local machine and open it in your preferred Java development environment.</p>
  <h3>Prerequisites</h3>
  <ul>
    <li>Java Development Kit (JDK) 8 or higher</li>
    <li>A Java IDE (e.g., IntelliJ IDEA, Eclipse)</li>
  </ul>
    <h2 id="data-structures">Data Structures</h2>
    <h3 id="priority-queue-heap">Priority Queue (Heap)</h3>
    <p>The <code>AbstrHeap</code> class implements a priority queue using a leftist heap stored in an array. It supports operations such as building the heap, reorganizing based on a comparator, inserting elements, and removing the element with the highest priority.</p>
    <h3 id="binary-search-tree-abstrtable">Binary Search Tree (AbstrTable)</h3>
    <p>The <code>AbstrTable</code> class implements a binary search tree (BST). It supports standard BST operations such as insertion, deletion, and search. Additionally, it provides iterators for in-order traversal using both stack and queue-based implementations.</p>
    <h3 id="stack">Stack</h3>
    <p>The <code>AbstrLifo</code> class implements a stack (Last In, First Out) using an underlying linked list. It supports typical stack operations such as push, pop, and checking if the stack is empty.</p>
    <h3 id="queue">Queue</h3>
    <p>The <code>AbstrFifo</code> class implements a queue (First In, First Out) using an underlying linked list. It supports typical queue operations such as enqueue, dequeue, and checking if the queue is empty.</p>
    <h3 id="doubly-linked-list">Doubly Linked List</h3>
    <p>The <code>AbstrDoubleList</code> class implements a doubly linked, non-cyclic list. It supports insertion, deletion, and traversal operations, allowing bidirectional traversal of elements.</p>
    <h2 id="usage">Usage</h2>
    <p>Here are examples of how to use these data structures in your Java code:</p>
    <h3>Using the Priority Queue (Heap)</h3>
    <pre><code>
Comparator<Integer> comparator = Comparator.naturalOrder();
AbstrHeap<Integer> heap = new AbstrHeap<>(comparator, Integer.class);

Integer[] data = {3, 1, 4, 1, 5, 9};
heap.build(data);

heap.insert(2);
Integer max = heap.removeMax();
System.out.println("Max element: " + max);
    </code></pre>

<h3>Using the Binary Search Tree</h3>
<pre><code>
AbstrTable<String, Integer> bst = new AbstrTable<>();

bst.insert("apple", 1);
bst.insert("banana", 2);
bst.insert("cherry", 3);

Integer value = bst.find("banana");
System.out.println("Value for 'banana': " + value);

bst.remove("apple");
    </code></pre>

<h3>Stack Operations</h3>
<pre><code>
AbstrLifo<Integer> stack = new AbstrLifo<>();
stack.insert(10);
stack.insert(20);

while (!stack.isEmpty()) {
    System.out.println("Stack element: " + stack.remove());
}
    </code></pre>

<h3>Queue Operations</h3>
<pre><code>
AbstrFifo<Integer> queue = new AbstrFifo<>();
queue.insert(10);
queue.insert(20);

while (!queue.isEmpty()) {
    System.out.println("Queue element: " + queue.remove());
}
    </code></pre>

<h3>Doubly Linked List Operations</h3>
<pre><code>
AbstrDoubleList<String> list = new AbstrDoubleList<>();

list.insertFirst("first");
list.insertLast("last");

String first = list.accessFirst();
System.out.println("First element: " + first);

String last = list.accessLast();
System.out.println("Last element: " + last);
    </code></pre>

<h2 id="contributing">Contributing</h2>
<p>Contributions are welcome! Please fork this repository and submit a pull request for any enhancements, bug fixes, or improvements.</p>

<h2 id="license">License</h2>
<p>This project is licensed under the MIT License - see the <a href="LICENSE">LICENSE</a> file for details.</p>

<p>Happy coding!</p>
