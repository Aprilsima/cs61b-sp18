public class ArrayDeque<T> {

    private T[] items;
    private int size;
    //private int factor;   I got messed up, so I don't want to consider the resizing.
    private int nextfirst;
    private int nextlast;

    /* Creates an empty array deque. And the starting size is 8.*/
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextfirst = 7;     //always the end of the array
        nextlast = 1;      //maybe i should change it to items.length-1
    }


    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (nextfirst == (items.length - 1)) {
            System.arraycopy(items, 0, a, 0, size);
        } else if (nextfirst < nextlast) {
            System.arraycopy(items, nextfirst + 1, a, 0, size);
        } else if (nextlast == 0) {
            System.arraycopy(items, nextfirst + 1, a, 0, size);
        } else {
            int n1 = items.length - nextfirst - 1;
            int n2 = size - n1;
            System.arraycopy(items, nextfirst + 1, a, 0, n1);
            System.arraycopy(items, 0, a, n1 - 1, n2);
        }
        items = a;
        nextfirst = a.length - 1;
        nextlast = size;
    }


    public void addFirst(T item) {
        efficient();
        size++;
        items[nextfirst] = item;
        if (nextfirst == 0) {
            nextfirst = items.length - 1;
        } else {
            nextfirst--;
        }
    }

    public void addLast(T item) {
        efficient();
        size++;
        items[nextlast] = item;
        nextlast++;
        if (nextlast == items.length) {
            nextlast = 0;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
     /* make our ArrayDeque have a better usage ration(>25% and <50%). */
    private void efficient() {
        if (items.length > 16 && items.length / size > 4) {
            resize(items.length / 2);
        } else if (items.length / size < 2) {
            resize(items.length * 2);
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
    }

    public T removeFirst() {
        efficient();
        size--;
        if (nextfirst == (items.length - 1)) {
            nextfirst = 0;
        } else {
            nextfirst++;
        }
        T item = items[nextfirst];
        return item;
    }

    public T removeLast() {
        efficient();
        size--;
        if (nextlast == 0) {
            nextlast = items.length - 1;
        } else {
            nextlast--;
        }
        T item = items[nextlast];
        return item;
    }

    /* must take constant time. 0 is the front and 1 is the next. */
    public T get(int index) {
        int a = nextfirst + index + 1;
        if (a >= items.length) {
            a -= items.length;
        }
        return items[a];
    }


}
