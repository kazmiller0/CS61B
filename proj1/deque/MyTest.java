package deque;

import org.junit.Assert;
import org.junit.Test;

public class MyTest {
    @Test
    public void equalsTest() {
        Deque<Integer> dq1 = new LinkedListDeque<>();
        Deque<Integer> dq2 = new LinkedListDeque<>();
        Deque<Integer> dq3 = new LinkedListDeque<>();

        dq1.addLast(1);
        dq1.addLast(2);
        dq1.addLast(3);

        dq2.addLast(1);
        dq2.addLast(2);
        dq2.addLast(3);

        dq3.addLast(3);
        dq3.addLast(3);
        dq3.addLast(3);

        Assert.assertTrue(dq1.equals(dq2));
        Assert.assertFalse(dq2.equals(dq3));
        Assert.assertFalse(dq1.equals(dq3));
    }
}
