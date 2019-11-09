package org.inkreaders.queue;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {

        public boolean hasNext() {
            return false;
        }

        public Item next() {
            return null;
        }
    }
}
