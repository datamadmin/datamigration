package com.dataeconomy.framework.util;

import java.util.Random;

public class PasswordGenerator {
	private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUM = "0123456789";

    //Generate a new password based on the Password policy values passed in
    public static char[] generatePassword() {
        int minLen = 6;
        int maxLen = 8;
        int numOfCAPSAlpha = 1;
        int numOfDigits = 1;
        int numOfAlpha = 4;

        if (minLen > maxLen)
            throw new IllegalArgumentException("Min. Length > Max. Length!");
        if ((numOfCAPSAlpha + numOfDigits + numOfAlpha) > minLen)
            throw new IllegalArgumentException(
                    "Min. Length should be at least the sum of (CAPS, DIGITS, SPL CHARS) Length!");

        Random rnd = new Random();
        int len = rnd.nextInt(maxLen - minLen + 1) + minLen;
        char[] password = new char[len];
        int index = 0;

        for (int i = 0; i < numOfCAPSAlpha; i++) {
            index = getNextIndex(rnd, len, password);
            password[index] = ALPHA_CAPS.charAt(rnd.nextInt(ALPHA_CAPS.length()));
        }

        for (int i = 0; i < numOfDigits; i++) {
            index = getNextIndex(rnd, len, password);
            password[index] = NUM.charAt(rnd.nextInt(NUM.length()));
        }
        for (int i = 0; i < numOfAlpha; i++) {
            index = getNextIndex(rnd, len, password);
            password[index] = ALPHA.charAt(rnd.nextInt(ALPHA.length()));
        }

        for (int i = 0; i < len; i++) {
            if (password[i] == 0) {
                password[i] = ALPHA.charAt(rnd.nextInt(ALPHA.length()));
            }
        }

        return password;
    }

    private static int getNextIndex(Random rnd, int length, char[] password) {
        int index = rnd.nextInt(length);
        while (password[index = rnd.nextInt(length)] != 0);
        return index;
    }
}
