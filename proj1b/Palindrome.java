public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return isPalindrome(d);
    }


    //a helper method
    public boolean isPalindrome(Deque d) {
        if (d.size() == 1 || d.size() == 0) {
            return true;
        } else if (d.removeLast() == d.removeFirst()) {
            return isPalindrome(d);
        } else {
            return false;
        }
    }


    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        return isPalindrome(d, cc);
    }

    public boolean isPalindrome(Deque<Character> d, CharacterComparator cc) {       //So wonderful that you write down "<Character>" after Deque.
        if (d.size() == 1 || d.size() == 0) {
            return true;
        } else if (cc.equalChars(d.removeLast(), d.removeFirst())) {         //If you haven't written "Deque<Character>", you have to cast d here to Character. To make generic a specific type only has something to with initializing other than using.
            return isPalindrome(d, cc);
        } else {
            return false;
        }
    }
}
