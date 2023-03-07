package synthesizer;
import org.junit.Test;
import java.lang.reflect.InvocationTargetException;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
    }

    @Test
    public void testIteration() {
        int[] someInts = new int[]{1, 2, 3};
        for (int x : someInts) {
            for (int y: someInts) {
                System.out.println("x: " + x +  ", y:" + y);
            }
        }
        ArrayRingBuffer<Integer> some = new ArrayRingBuffer<>(10);
        some.enqueue(4);
        some.enqueue(5);
        some.enqueue(6);
        for (int x : some) {
            for (int y: some) {
                System.out.println("x: " + x +  ", y:" + y);
            }
        }

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }

} 
