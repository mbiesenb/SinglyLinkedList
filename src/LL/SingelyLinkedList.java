/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LL;

import java.util.Comparator;

/**
 *
 * @author Marvin
 */
interface SingelyLinkedList <T> {
    void add(T object);
    void clear();
    void sort(int sortSelection, int comp);
    void insertAfter(T object, int index);
    void insertBefore(T object, int index);
    void addFirst(T object);
    void remove(int index);
    void quicksort(Comparator comp);
    boolean isEmpty();
    int size();
    T getFirst();
    T getLast();
    T get(int index);
}
