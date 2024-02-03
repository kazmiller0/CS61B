public class OffByN implements CharacterComparator {
    public int offset = 0;

    public OffByN(int N) {
        offset = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == offset;
    }
}
