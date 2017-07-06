/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LL;

import java.util.Iterator;

/**
 *
 * @author Marvin
 */
public class App {

    public static void main(String[] args) {
        LL<Integer> list = new LL<>();
        list.add(3);
        list.add(4);
        list.add(9);
        list.add(6);
        list.add(30);
        list.add(21);
        list.add(33);
        list.add(15);
        list.add(18);
        list.add(20);
        list.sort(LL.QUICKSORT, LL.INTEGERCOMPERATOR);
        for (int s : list) {
            System.out.println(s);
        }
        System.out.println("-------------------");

    }
}
