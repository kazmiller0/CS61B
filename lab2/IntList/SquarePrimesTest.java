package IntList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(37, 84, 12, 59, 73);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1369 -> 84 -> 12 -> 3481 -> 5329", lst.toString());
        assertTrue(changed);
    }
}
