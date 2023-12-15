package org.example;

public class Sorting {

    public static void sort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        sort(input, start, mid);
        sort(input, mid, end);
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int middle, int end) {

        if (input[middle - 1] <= input[middle]) {
            return;
        }

        int i = start;
        int j = middle;
        int tempIndex = 0;
        int[] temp = new int[end - start];
        while (i < middle && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, middle - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}


