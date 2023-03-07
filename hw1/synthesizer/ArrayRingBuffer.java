
package synthesizer;
import java.util.Iterator;


public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last] = x;
        last++;
        if (last == capacity) {
            last = 0;
        }
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T result = rb[first];
        rb[first] = null;
        first++;
        if (first == capacity) {
            first = 0;
        }
        fillCount--;
        return result;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T result = rb[first];
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return  new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T> {
        private int ptr;
        ArrayRingBufferIterator() {
            ptr = 0;
        }
        public boolean hasNext() {
            return ptr != fillCount();
        }

        public  T next() {
            T result = rb[ptr];
            ptr++;
            return result;
        }

    }
}
