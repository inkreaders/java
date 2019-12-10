package org.datastructure.tree;

public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private final Key key;
        private Value value;
        private Node left, right;
        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
    
    public BST(){
    }
    
    public int size(){
        return 0;
    }
}
