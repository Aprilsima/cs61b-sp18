package hw3.hash;

import org.junit.Test;


import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class TestSimpleOomage {

    @Test
    public void testHashCodeDeterministic() {
        SimpleOomage so = SimpleOomage.randomSimpleOomage();
        int hashCode = so.hashCode();
        for (int i = 0; i < 100; i += 1) {
            assertEquals(hashCode, so.hashCode());
        }
    }

    @Test
    public void testHashCodePerfect() {
        SimpleOomage ooA = new SimpleOomage(5, 10, 20);
        SimpleOomage ooA2 = new SimpleOomage(5, 20, 10);
        SimpleOomage ooA3 = new SimpleOomage(5, 10, 20);
        SimpleOomage oob = new SimpleOomage(0, 0, 0);
        SimpleOomage oob1 = new SimpleOomage(0, 0, 5);
        assertEquals(ooA.hashCode(), ooA3.hashCode());
        assertNotEquals(ooA.hashCode(), ooA2.hashCode());
        assertNotEquals(oob.hashCode(), oob1.hashCode());
    }

    @Test
    public void testEquals() {
        SimpleOomage ooA = new SimpleOomage(5, 10, 20);
        SimpleOomage ooA2 = new SimpleOomage(5, 10, 20);
        SimpleOomage ooB = new SimpleOomage(50, 50, 50);
        assertEquals(ooA, ooA2);
        assertNotEquals(ooA, ooB);
        assertNotEquals(ooA2, ooB);
        assertNotEquals(ooA, "ketchup");
    }


    @Test
    public void testHashCodeAndEqualsConsistency() {
        SimpleOomage ooA = new SimpleOomage(5, 10, 20);
        SimpleOomage ooA2 = new SimpleOomage(5, 10, 20);
        HashSet<SimpleOomage> hashSet = new HashSet<>();
        hashSet.add(ooA);
        assertTrue(hashSet.contains(ooA2));
    }

    @Test
    public void testRandomOomagesHashCodeSpread() {
        List<Oomage> oomages = new ArrayList<>();
        int N = 10000;

        for (int i = 0; i < N; i += 1) {
            oomages.add(SimpleOomage.randomSimpleOomage());
        }

        assertTrue(OomageTestUtility.haveNiceHashCodeSpread(oomages, 10));
    }

    /** Calls tests for SimpleOomage. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestSimpleOomage.class);
    }
}
