/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements DoublyLinkedListInterface<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Private inner Node class for doubly linked list
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        if (head == null) {  // List is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;  // Link the new node
            newNode.prev = tail;
            tail = newNode;       // Update the tail
        }
        size++;
    }

    @Override
    public boolean add(int position, T newEntry) {
        if (position < 1 || position > size + 1) {
            return false;
        }

        Node<T> newNode = new Node<>(newEntry);

        if (position == 1) { // Insert at head
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (size == 0) tail = newNode;  // First node
        } else if (position == size + 1) { // Insert at tail
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else { // Insert in the middle
            Node<T> current = getNodeAt(position);
            Node<T> prevNode = current.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
        return true;
    }

    @Override
    public T remove(int position) {
        if (position < 1 || position > size) return null;

        Node<T> targetNode = getNodeAt(position);
        T data = targetNode.data;

        if (targetNode.prev != null) {
            targetNode.prev.next = targetNode.next;
        } else {
            head = targetNode.next;  // Removing head
        }

        if (targetNode.next != null) {
            targetNode.next.prev = targetNode.prev;
        } else {
            tail = targetNode.prev;  // Removing tail
        }

        size--;
        return data;
    }

    @Override
    public boolean replace(int position, T newEntry) {
        if (position < 1 || position > size) return false;
        Node<T> node = getNodeAt(position);
        node.data = newEntry;
        return true;
    }

    @Override
    public T getEntry(int position) {
        if (position < 1 || position > size) return null;
        return getNodeAt(position).data;
    }

    @Override
    public boolean contains(T anEntry) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(anEntry)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Helper method to retrieve the node at a specific position
     */
    private Node<T> getNodeAt(int position) {
        Node<T> current;
        if (position <= size / 2) {
            current = head;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size; i > position; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}

