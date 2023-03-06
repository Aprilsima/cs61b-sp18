import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    static ArrayDequeSolution<Integer> a = new ArrayDequeSolution<>();
    static StudentArrayDeque<Integer> b = new StudentArrayDeque<>();
    @Test
    public void testaddFirst() {
        for (int i = 2; i < 10000; i++) {
            int number = StdRandom.uniform(100);
            a.addFirst(number);
            b.addFirst(number);
            int index = StdRandom.uniform(i - 1);
            assertEquals(a.get(index), b.get(index));
        }
    }

    @Test
    public void testaddLast() {
        String message = "";
        for (int i = 2; i < 10000; i++) {
            int number = StdRandom.uniform(100);
            a.addLast(number);
            b.addLast(number);
            int index = StdRandom.uniform(i - 1);
            assertEquals(a.get(index), b.get(index));
        }
    }

    @Test
    public void testremoveFirst() {
        String message = "";
        for (int i = 0; i < 20; i++) {
            int number = StdRandom.uniform(10);
            a.addLast(number);
            b.addLast(number);
            message += "AddLast(" + number + ")\n";
        }
        for (int i = 1; i < 20; i++) {
            Integer x = a.removeFirst();
            Integer y = b.removeFirst();
            message += "removeFirst()\n";
            assertEquals(message, x, y);
            //int index = StdRandom.uniform(a.size());
            //assertEquals(a.get(index), b.get(index));
        }
    }

    @Test
    public void testremoveLast() {
        String message = "";
        for (int i = 0; i < 10; i++) {
            int number = StdRandom.uniform(10);
            a.addLast(number);
            b.addLast(number);
            message += "AddLast(" + number + ")\n";
        }
        for (int i = 1; i < 10; i++) {
            Integer x = a.removeLast();
            Integer y = b.removeLast();
            message += "removeLast()\n";
            assertEquals(message, x, y);
            //int index = StdRandom.uniform(a.size());
            //assertEquals(a.get(index), b.get(index));
        }

    }
}
