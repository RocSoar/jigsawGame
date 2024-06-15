package com.roc.utils;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtils {
    public static String generateCheckCode(int len) {
        Random r = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            int case_ = r.nextInt(2);
            char letter = case_ == 0 ? (char) r.nextInt(97, 123) : (char) r.nextInt(65, 91);
            code.append(letter);
        }
        int randomIndex = r.nextInt(len);
        return code.substring(0, randomIndex) + r.nextInt(10) + code.substring(randomIndex);
    }

    public static String generateCheckCode2(int len) {
        ArrayList<Character> letters = new ArrayList<>();
        Random r = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            letters.add((char) ('a' + i));
            letters.add((char) ('A' + i));
        }
        for (int i = 0; i < len - 1; i++)
            code.append(letters.get(r.nextInt(letters.size())));

        code.insert(r.nextInt(code.length() + 1), r.nextInt(10));
        return code.toString();
    }
}

