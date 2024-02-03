public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        if (word.length() <= 1 || word == null) {
            return true;
        }

        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
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
