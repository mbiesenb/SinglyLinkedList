/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LL;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Marvin
 * @param <T>
 */
public class LL<T> implements SingelyLinkedList<T>, Iterable<T> {
    
    public static final int BUBBLESORT    = 0;
    public static final int INSERTIONSORT = 1;
    public static final int QUICKSORT     = 2;
    
    public static final int STRINGCOMPERATOR = 0;
    public static final int INTEGERCOMPERATOR = 1;
    
    private Node first = null;
    private int currentSize;
    private Node currentRunpointer = first;

    public LL() {
       currentSize = 0; 
    }
    public LL(LL ll){
        
    }
    
    private void bubblesort(){
        
    }
    private void insertionsort(){
        
    }
    private void quicksort(){
        
    }

    @Override
    public Iterator <T> iterator() {
        Iterator <T> iterator;
        iterator = new Iterator<T>() {
            private Node runpointer = first;
               
            @Override
            public boolean hasNext() {
                return (runpointer.next != null);
            }

            @Override
            public T next() {
                if(isEmpty()) throw new NoSuchElementException();
                Node temp = runpointer;
                runpointer = runpointer.next;
                return temp.data;
            }
        };
        return iterator;
    }

    private class Node {
        public T data;
        public Node next;
        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private class StringComperator implements Comparator<T>{
        @Override
        public int compare(T o1, T o2) {
            return o1.toString().compareTo(o2.toString());
        }     
    }
    private class IntegerComperator implements Comparator<T>{
        @Override
        public int compare(T o1, T o2) {
            int num1, num2;
            try{
                num1 = Integer.parseInt(o1.toString());
                num2 = Integer.parseInt(o2.toString());
            }catch(NumberFormatException e){
                throw new NumberFormatException();
            }
            if(num1 > num2) return 1;
            if(num1 < num2) return -1;
            else return 0;
        }     
    }
    /**
     *
     * @param object
     */
    @Override
    /*public void add(T object) {
        if (isEmpty()) {
            first = new Node(object, null);
            currentSize++;
            return;
        }

        Node runpointer = first;
        while (runpointer.next != null) {
            runpointer = runpointer.next;
        }
        currentSize++;
        runpointer.next = new Node(object, null);
    }*/
    public void add(T object) {
        if (isEmpty()) {
            first = new Node(object, null);
            currentSize++;
            currentRunpointer = first;
            return;
        }
        currentRunpointer.next = new Node(object, null);
        currentRunpointer = currentRunpointer.next;
        currentSize++;
    }

    @Override
    public void clear() {
        first = null;
        currentSize = 0;
        currentRunpointer = first;
    }

    @Override
    public void sort( int sortSelection) {
        if(sortSelection == BUBBLESORT)     bubblesort();
        if(sortSelection == INSERTIONSORT)  insertionsort();
        if(sortSelection == QUICKSORT)      quicksort();
    }

    @Override
    public void insertAfter(T object, int index) {
        if(index<0) throw new NegativeArraySizeException();
        if(first == null) throw new IndexOutOfBoundsException();
        Node runpointer = first;
        int counter = 0;
        while(runpointer.next != null){
            if(counter == index){
                runpointer.next = new Node(object, runpointer.next);
                return;
            }
            runpointer = runpointer.next;
            counter++;
        }
        if(index == counter){
            runpointer.next = new Node(object, runpointer.next);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void insertBefore(T object, int index) {
    
    }

    @Override
    public void addFirst(T object) {
        first = new Node(object, first);
        currentSize++;
    }

    @Override
    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        /*int counter = 1;
        Node runpointer = first;
        while (runpointer.next != null) {
            runpointer = runpointer.next;
            counter++;
        }
        return counter;*/
        return currentSize;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node runpointer = first;
        while (runpointer.next != null) {
            runpointer = runpointer.next;
        }
        return runpointer.data;

    }
    @Override
    public T get(int index){
        if(isEmpty()) throw new NoSuchElementException();
        int counter = 0;
        Node runpointer = first;
        while(runpointer != null){
            if(counter == index) return runpointer.data;
            runpointer = runpointer.next;
            counter++;
        }
        throw new NoSuchElementException();
    }
    
}
