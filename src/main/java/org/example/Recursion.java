package org.example;

public class Recursion {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println(recursive(numbers, 13));
    }

    public static int recursiveIndex(int[] array, int num, int index) {
        if (index == array.length) {
            return -1;
        } else if (num == array[index]) {
            return index;
        }
        return recursiveIndex(array, num, index + 1);
    }

    public static int recursive(int[] array, int num) {
        return recursiveIndex(array, num, 0);
    }

}
