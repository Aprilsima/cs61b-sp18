import static org.junit.Assert.*;
public class HorribleSteve {
    public static void main(String [] args) {
        Integer i = 0;
        for (Integer j = 0; i < 500; i++, j++) {
            if (!Flik.isSameNumber(i, j)) {
                assertTrue("Integer i 不等于j", i == j);     //find the mistake but i can't fix it.
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }
}
