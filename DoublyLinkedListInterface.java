/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

/**
 *
 * @author shixu
 */

public interface DoublyLinkedListInterface<T> {

    void add(T newEntry);

    boolean add(int position, T newEntry);

    T remove(int position);

    boolean replace(int position, T newEntry);

    T getEntry(int position);

    boolean contains(T anEntry);

    int size();

    boolean isEmpty();

    void clear();
}

