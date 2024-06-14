package com.roc.utils;

import java.util.Random;

public class ArrayUtils {
    public static void disorderArrayInPlace(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = r.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }
}
