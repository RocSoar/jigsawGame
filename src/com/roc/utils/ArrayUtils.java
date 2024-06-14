package com.roc.utils;

import java.util.Random;

public class ArrayUtils {
    public static <T> void disorderArrayInPlace(T[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = r.nextInt(arr.length);
            T temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }
}
