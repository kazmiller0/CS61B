public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindrome(deque);
    }

    private boolean isPalindrome(Deque<Character> deque) {
        if (deque.size() == 1 || deque.size() == 0) {
            return true;
        }
        if (deque.removeFirst() != deque.removeLast()) {
            return false;
        } else {
            return isPalindrome(deque);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() <= 1 || word == null) {
            return true;
        }

        for (int i = 0; i < word.length() / 2; i++) {
            if (cc.equalChars(word.charAt(i), word.charAt(word.length() - i - 1))) {
                return true;
            }
        }
        return false;
    }
}
