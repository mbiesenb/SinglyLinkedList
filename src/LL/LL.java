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
    private Node currentRunpointer = null;

    public LL() {
       currentSize = 0; 
    }
    public LL(LL ll){
        
    }
    
    private void bubblesort(){
        
    }
    private void insertionsort(){
        
    }
    @Override
    public void quicksort(Comparator comp) {
        if(size() < 2) return;
        T pivot = getFirst();
        LL <T> less = new LL();
        LL <T> equal = new LL();
        LL <T> greater = new LL();
        for(T element  : this){
            int compared = comp.compare(element, pivot);
            if(compared > 0) greater.addFirst(element);
            if(compared < 0) less.addFirst(element);
            if(compared == 0) equal.addFirst(element);        
        }
        less.quicksort(comp);
        greater.quicksort(comp);
        this.clear();
        for(T element : less){
            add(element);
        }
        for(T element : equal){
            add(element);
        }
        for(T element : greater){
            add(element);
        }
        
    }

    @Override
    public Iterator <T> iterator() {
        Iterator iterator = new Iterator() {
            Node runfpointer  = first;
            @Override
            public boolean hasNext() {
                return runfpointer != null;
            }

            @Override
            public Object next() {
              if (runfpointer == null) throw new NoSuchElementException();
              T result = runfpointer.data;
              runfpointer = runfpointer.next;
              return result;  
            }
        };
        return iterator;
    }

    @Override
    public void remove(int index) {
        if(isEmpty())throw new NoSuchElementException();
        
        //Node runpointer = new Node(data, index);
        if(index <  0 || index >= currentSize) throw new IndexOutOfBoundsException();
        if(index == 0){
            first = first.next;
            return;
        }
        Node runpointer = first;
        for(int i = 0; i < index; i++){
            runpointer = runpointer.next;
        }
        runpointer.next = runpointer.next.next;
        currentSize--;
        
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
    public void sort( int sortSelection, int comp) {
        Comparator comparator = null;
        if(comp == INTEGERCOMPERATOR) comparator = new IntegerComperator();
        if(comp == STRINGCOMPERATOR) comparator = new StringComperator();
        //if(sortSelection == BUBBLESORT)     bubblesort(comparator);
        //if(sortSelection == INSERTIONSORT)  insertionsort(comparator);
        if(sortSelection == QUICKSORT)      quicksort(comparator);
    
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
