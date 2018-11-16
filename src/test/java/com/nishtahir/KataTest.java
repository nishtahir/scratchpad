package com.nishtahir;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

public class KataTest {

    @Test
    public void exampleTest() {
        assertEquals("odd", Kata.oddOrEven(new int[]{2, 5, 34, 6}));
    }

    @Test
    public void testPermutation() throws Exception {
        assertEquals(24, Kata.permutation("test").size());
    }

    @Test
    public void findShort() throws Exception {
        assertEquals(3, Kata.findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, Kata.findShort("turns out random test cases are easier than writing out basic ones"));
    }

    @Test
    public void testHashSha256() throws Exception {
        assertEquals("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08", Kata.hashSha256("test"));
    }

    @Test
    public void testShift() {
        assertEquals("!Hello World", Kata.shift("Hello World!"));
        assertEquals("d!Hello Worl", Kata.shift("!Hello World"));
        assertEquals("ld!Hello Wor", Kata.shift("d!Hello Worl"));
    }

    @Test
    public void testCrackSha256() throws Exception {
        assertEquals("GoOutside", Kata.crackSha256("b8c49d81cb795985c007d78379e98613a4dfc824381be472238dbd2f974e37ae", "deGioOstu"));
        assertEquals(null, Kata.crackSha256("f58262c8005bb64b8f99ec6083faf050c502d099d9929ae37ffed2fe1bb954fb", "abc"));
    }

    @Test
    public void abcdeReturnsZero() {
        assertEquals(0, Kata.duplicateCount("abcde"));
    }

    @Test
    public void abcdeaReturnsOne() {
        assertEquals(1, Kata.duplicateCount("abcdea"));
    }

    @Test
    public void indivisibilityReturnsOne() {
        assertEquals(1, Kata.duplicateCount("indivisibility"));
    }

    @Test
    public void testKeyHasher() throws Exception {
        String result = Kata.keyHasher("cnn");
        System.out.println(result);
        //098F6BCD4621D373CADE4E832627B4F6
        //098f6bcd4621d373cade4e832627b4f6
    }
}