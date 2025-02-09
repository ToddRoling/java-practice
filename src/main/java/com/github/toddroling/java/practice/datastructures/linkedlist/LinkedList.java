package com.github.toddroling.java.practice.datastructures.linkedlist;

public final class LinkedList {

    private int size;
    private Node head;

    public LinkedList(final Node head) {
        this.head = head;
        initializeSize();
    }

    public LinkedList(final String[] data) {
        size = data.length;
        if (size > 0) {
            head = new Node(data[0]);
            Node currentNode = head;
            for (int i = 1; i < data.length; ++i) {
                currentNode.next = new Node(data[i]);
                currentNode = currentNode.next;
            }
        }
    }

    private void initializeSize() {
        if (head == null)
            size = 0;
        else {
            size = 1;
            Node nextNode = head.next;
            while (nextNode != null) {
                ++size;
                nextNode = nextNode.next;
            }
        }
    }

    public String getData(final int index) {
        return getNode(index).data;
    }

    private Node getNode(final int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(index);
        else {
            int currentIndex = 0;
            Node currentNode = head;
            Node nextNode = currentNode.next;
            while (currentIndex < index && nextNode != null) {
                currentNode = nextNode;
                ++currentIndex;
                nextNode = nextNode.next;
            }
            return currentNode;
        }
    }

    public int getSize() {
        return size;
    }

    public static final class Node {
        private Node next;
        private final String data;

        public Node(final String data) {
            this.data = data;
        }
    }
}
