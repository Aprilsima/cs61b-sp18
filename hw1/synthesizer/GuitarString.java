
package synthesizer;

//Make sure this class is public
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int capacity = (int) Math.round(SR / frequency);
        buffer = new ArrayRingBuffer<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buffer.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        double[] numarray = new double[buffer.capacity()];
        for (int i = 0; i < buffer.capacity(); i++) {
            double r = Math.random() - 0.5;
            int unique = 1;
            for (int j = 0; j < i; j++) {
                if (r == numarray[j]) {
                    i--;
                    unique = 0;
                    break;
                }
            }
            if (unique == 1) {
                numarray[i] = r;
            }
        }
        int k = buffer.fillCount();
        for (int i = 0; i < k; i++) {
            buffer.dequeue();
        }
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.enqueue(numarray[i]);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        double first = buffer.dequeue();
        double second = buffer.peek();
        double factor = 0.996;
        double result = factor * 0.5 * (first + second);
        buffer.enqueue(result);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        double result = buffer.peek();
        return result;
    }
}
