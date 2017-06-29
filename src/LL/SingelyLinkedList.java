/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LL;
/**
 *
 * @author Marvin
 */
interface SingelyLinkedList <T> {
    void add(T object);
    void clear();
    void sort(int sortSelection);
    void insertAfter(T object, int index);
    void insertBefore(T object, int index);
    void addFirst(T object);
    boolean isEmpty();
    int size();
    T getFirst();
    T getLast();
    T get(int index);
}
