package com.nishtahir;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Kata {

    public static int[] invert(int[] array) {
        return Arrays.stream(array).map(it -> -it).toArray();
    }

    static int findShort(String s) {
        return Arrays.stream(s.split(" ")).min(Comparator.comparing(String::length)).get().length();
    }

    static String crackSha256(String hash, String chars) {
        return permutation(chars).stream().filter(string ->
                hash.equals(hashSha256(string))
        ).findFirst().orElse(null);
    }

    static String hashSha256(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(value.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte piece : md.digest()) {
                sb.append(Integer.toString((piece & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static String shift(String value) {
        return value.charAt(value.length() - 1) + value.substring(0, value.length() - 1);
    }

    static List<String> permutation(String input) {
        return permutation("", input);
    }

    private static List<String> permutation(String perm, String word) {
        List<String> permutations = new ArrayList<>();
        if (word.isEmpty()) {
            permutations.add(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutations.addAll(permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length())));
            }
        }
        return permutations;
    }
}