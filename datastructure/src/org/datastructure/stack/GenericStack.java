package org.datastructure.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

import org.datastructure.util.IteratorToStream;

public class Stack<Item> implements Iterable<Item> {

    private int n; // size of the stack
    private Node first; // top of stack

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Initializes an empty stack.
     */
    public Stack() {
        first = null;
        n = 0;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            stack.push(scanner.nextInt());
        }
        scanner.close();
        System.out.println(stack.size());
        //System.out.println("Size of stack: " + stack.pop());
        Stream<Integer> streamFromIterator = IteratorToStream.getStreamFromIterator(stack.iterator());
        streamFromIterator.forEach(item -> {
            System.out.println(item);
        });

    }
}
