import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    @Test
    public void teststudent() {
        ArrayDequeSolution<Integer> a = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> b = new StudentArrayDeque<>();
        String message = "";
        //testaddFirst()
        for (int i = 2; i < 10; i++) {
            int number = StdRandom.uniform(100);
            a.addFirst(number);
            b.addFirst(number);
            message += "AddLast(" + number + ")\n";
            int index = StdRandom.uniform(i - 1);
            assertEquals(a.get(index), b.get(index));
        }
        //testaddLast() {
        for (int i = 2; i < 10; i++) {
            int number = StdRandom.uniform(100);
            a.addLast(number);
            b.addLast(number);
            message += "AddLast(" + number + ")\n";
            int index = StdRandom.uniform(i - 1);
            assertEquals(a.get(index), b.get(index));
        }

        //testremoveFirst() {
        for (int i = 1; i < 10; i++) {
            Integer x = a.removeFirst();
            Integer y = b.removeFirst();
            message += "removeFirst()\n";
            assertEquals(message, x, y);
            //int index = StdRandom.uniform(a.size());
            //assertEquals(a.get(index), b.get(index));
        }

        //testremoveLast() {
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
