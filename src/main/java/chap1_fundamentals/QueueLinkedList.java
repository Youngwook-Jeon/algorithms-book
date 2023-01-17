package chap1_fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueLinkedList<Item> implements Iterable<Item> {

    private int n; // size of the queue
    private Node<Item> first; // beginning of queue
    private Node<Item> last; // last of queue

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public QueueLinkedList() {
        n = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        Node<Item> newNode = new Node<>();
        newNode.item = item;
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue has no elements");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null; // to avoid loitering
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new RuntimeException("Queue has no elements");
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item).append(" ");
        return s.toString();
    }

    public Iterator<Item> iterator()  {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
