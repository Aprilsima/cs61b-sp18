import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        String test1 = "a";
        String test2 = "noon";
        String test3 = "1";
        String test4 = "aA";
        String test5 = "horse";
        assertTrue(palindrome.isPalindrome(test1));
        assertTrue(palindrome.isPalindrome(test2));
        assertTrue(palindrome.isPalindrome(test3));
        assertFalse(palindrome.isPalindrome(test4));
        assertFalse(palindrome.isPalindrome(test5));
    }


    @Test
    public void testPalindrome() {
        String test1 = "flake";
        String test2 = "a";
        String test3 = "noon";
        String test4 = "ab";
        OffByOne cc = new OffByOne();
        assertTrue(test1, palindrome.isPalindrome(test1, cc));
        assertTrue(test2, palindrome.isPalindrome(test2, cc));
        assertFalse(test3, palindrome.isPalindrome(test3, cc));
        assertTrue(test4, palindrome.isPalindrome(test4, cc));

    }

}
