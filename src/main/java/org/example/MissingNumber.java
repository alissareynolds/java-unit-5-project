package org.example;

import java.util.Arrays;
import java.util.List;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println("missingNumber: " + missingNumber(new int[]{2, 5, 4, 1, 6, 8, 7, 10, 9}, 10));
        System.out.println("missingNumber2: " + missingNumber2(new int[]{2, 5, 4, 1, 6, 8, 7, 10, 9}, 10));
        System.out.println("reducedMemory: " + reducedMemory(new int[]{2, 5, 4, 1, 6, 8, 7, 10, 9}, 10));
    }

    // I used a list for the first problem to try and make it as simple as possible where in the example there is a set
    public static int missingNumber(int[] numArray, int maxNum) {
        List<Integer> arr = Arrays.stream(numArray).boxed().toList();
        for (int i = 1; i <= maxNum; i++) {
            if (arr.indexOf(i) == -1) {
                return i;
            }
        }
        return 0;
    }

    public static int missingNumber2(int[] numArray, int maxNum) {
        Arrays.sort(numArray);
        int missingNum = 1;

        for (int num : numArray) {
            if (num == missingNum) {
                missingNum++;
            } else if (num > missingNum) {
                return missingNum;
            }
        }
        return missingNum <= maxNum ? missingNum : 0;
    }

    public static int reducedMemory(int[] numArray, int maxNum) {
        Arrays.sort(numArray);

        for (int i = 1; i < maxNum; i += 1) {
            if (numArray[i - 1] != i) {
                return i;
            }
        }
        if (numArray.length == maxNum && numArray[maxNum - 1] == maxNum) {
            return 0;
        }
        return maxNum;
    }

}
