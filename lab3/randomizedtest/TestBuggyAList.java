package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        correct.addLast(4);
        correct.addLast(5);
        correct.addLast(6);

        buggy.addLast(4);
        buggy.addLast(5);
        buggy.addLast(6);

        assertEquals(correct.size(), buggy.size());

        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                buggy.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int correctSize = correct.size();
                int buggySize = buggy.size();
                assertEquals(correctSize, buggySize);
                System.out.println("correct size: " + correctSize + " buggy size: " + buggySize);
            } else if (operationNumber == 2) {
                // getLast
                if (correct.size() > 0 && buggy.size() > 0) {
                    int correctLast = correct.getLast();
                    int buggyLast = correct.getLast();
                    buggy.getLast();
                    assertEquals(correctLast, buggyLast);
                    System.out.println("correct last: " + correctLast + " buggy last: " + buggyLast);
                }
            } else if (operationNumber == 3) {
                // removeLast
                if (correct.size() > 0 && buggy.size() > 0) {
                    int correctLast = correct.getLast();
                    int buggyLast = correct.getLast();
                    buggy.removeLast();
                    assertEquals(correctLast, buggyLast);
                    System.out.println("correct removeLast: " + correct.removeLast() + " buggy removeLast: " + buggyLast);
                }
            }
        }
    }
}
