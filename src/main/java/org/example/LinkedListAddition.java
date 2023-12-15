package org.example;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListAddition {
    public static void main(String[] args) {
        LinkedList one = new LinkedList();
        LinkedList two = new LinkedList();
        one.add(1);
        one.add(2);
        one.add(3);
        two.add(4);
        two.add(5);
        two.add(6);

        System.out.println("Adding Linked Lists Result: " + addingLinkedLists(one, two));

    }

    public static LinkedList addingLinkedLists(LinkedList firstList, LinkedList secondList) {

        Iterator<Integer> first = firstList.descendingIterator();
        Iterator<Integer> second = secondList.descendingIterator();

        int unit = 1;
        int firstLinkedListAsInt = 0;

        while (first.hasNext()) {
            firstLinkedListAsInt += unit * first.next();
            unit *= 10;
        }

        unit = 1;
        int secondLinkedListAsInt = 0;

        while (second.hasNext()) {
            secondLinkedListAsInt += unit * second.next();
            unit *= 10;
        }

        int sum = firstLinkedListAsInt + secondLinkedListAsInt;
        String str = String.valueOf(sum);

        LinkedList<Integer> linkedListSum = new LinkedList<Integer>();
        for (int i = 0; i < str.length(); i+=1) {
            linkedListSum.add(Character.getNumericValue(str.charAt(i)));
        }
        return linkedListSum;
    }
}
