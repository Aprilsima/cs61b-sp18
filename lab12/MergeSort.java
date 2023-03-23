import edu.princeton.cs.algs4.Queue;
import org.junit.Test;

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     *
     * The method assumes that both q1 and q2 are in sorted order, with the smallest item first. At
     * most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      The smallest item that is in q1 or q2.
     */
    private static <Item extends Comparable> Item getMin(
            Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /** Returns a queue of queues that each contain one item from items. */
    private static <Item extends Comparable> Queue<Queue<Item>>
            makeSingleItemQueues(Queue<Item> items) {
        Queue<Queue<Item>> result = new Queue<>();
        for (Item x : items) {
            Queue<Item> single = new Queue<>();
            single.enqueue(x);
            result.enqueue(single);
        }
        return result;
    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     *
     * This method should take time linear in the total number of items in q1 and q2.  After
     * running this method, q1 and q2 will be empty, and all of their items will be in the
     * returned queue.
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      A Queue containing all of the q1 and q2 in sorted order, from least to
     *              greatest.
     *
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(
            Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> result = new Queue<>();
        while (!q1.isEmpty() || !q2.isEmpty()) {
            Item min = getMin(q1, q2);
            result.enqueue(min);
        }
        return result;
    }

    /** Returns a Queue that contains the given items sorted from least to greatest. */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
        Queue<Item> result = new Queue<>();
        if (items.isEmpty()) {
            return result;
        } else if(items.size() == 1) {
            result.enqueue(items.peek());
            return result;
        }
        //I need to get two sorted queues first;
        Queue<Queue<Item>> copyOfOriginal = makeSingleItemQueues(items);
        int size = copyOfOriginal.size();
        Queue<Item> front = new Queue<>();
        Queue<Item> back = new Queue<>();
        int i = 0;
        for (; i < (size / 2); i++) {
            front.enqueue(copyOfOriginal.dequeue().dequeue());
        }
        for (; i < size; i++) {
            back.enqueue(copyOfOriginal.dequeue().dequeue());
        }
        Queue<Item> sortedfront = mergeSort(front);
        Queue<Item> sortedback = mergeSort(back);
        result = mergeSortedQueues(sortedfront, sortedback);
        return result;
    }

    public static void main(String[] args) {
        Queue<String> students = new Queue<String>();
        students.enqueue("Alice");
        students.enqueue("Vanessa");
        students.enqueue("Ethan");
        students.enqueue("Bob");
        students.enqueue("April");
        System.out.println("Queue is: " + students.toString());
        Queue<String> students_change = MergeSort.mergeSort(students);
        System.out.println("After changing, the original queue is: " + students.toString());      //which should be unchanged;
        System.out.println("After changing, the returned queue is: " + students_change.toString());

    }

}
