package chap1_fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Represents a bag of generic items.
// It supports insertion and iterating over the items in arbitrary order.
public class Bag<Item> implements Iterable<Item> {

    private int N; // number of elements in bag
    private Node first; // beginning of bag

    private class Node {
        private Item item;
        private Node next;
    }

    public Bag() {
        first = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Iterator<Item> iterator()  {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

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
