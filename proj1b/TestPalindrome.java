import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("acca"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));

        assertFalse(palindrome.isPalindrome("aab"));
        assertFalse(palindrome.isPalindrome("aabb"));
    }

    @Test
    public void testIsOffByOnePalindrome() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertFalse(palindrome.isPalindrome("aba", cc));
    }

    @Test
    public void testIsOffByNPalindrome() {
        for (int i = 0; i < 5; i++) {
            CharacterComparator cc = new OffByN(i);
            assertTrue(palindrome.isPalindrome("aba", cc));
            assertFalse(palindrome.isPalindrome("abb", cc));
            assertFalse(palindrome.isPalindrome("abc", cc));
            assertFalse(palindrome.isPalindrome("abd", cc));
            assertFalse(palindrome.isPalindrome("abe", cc));
        }
    }
}
