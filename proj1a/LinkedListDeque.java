public class LinkedListDeque<T> {
    private LinkedList sentinel;
    private int size;
    public class LinkedList<T> {
        private LinkedList prev;
        private T item;
        private LinkedList next;

        public LinkedList(LinkedList p, T i, LinkedList n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    /* Create an empty linked list deque. */
    public LinkedListDeque() {
        size = 0;
        sentinel = new LinkedList(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;

    } //I don't know what should be put in the position of i.


    public void addFirst(T item) {
        size++;
        LinkedList temp = sentinel.next;
        sentinel.next = new LinkedList(sentinel, item, sentinel.next);
        temp.prev = sentinel.next;
    }


    public void addLast(T item) {
        size++;
        LinkedList temp = sentinel.prev;
        sentinel.prev = new LinkedList(temp, item, sentinel);
        temp.next = sentinel.prev;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < this.size; i++) {
            T item = this.get(i);
            System.out.print(item + " ");
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = (T) sentinel.next.item;
        LinkedList temp = sentinel.next.next;
        sentinel.next = temp;
        temp.prev = sentinel;
        size--;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item = (T) sentinel.prev.item;
        LinkedList temp = sentinel.prev.prev;
        sentinel.prev = temp;
        temp.next = sentinel;
        size--;
        return item;
    }

    /* use the iteration */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        LinkedList p = sentinel;
        for (int i = 0; i < (index + 1); i++) {
            p = p.next;
        }
        return (T) p.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        } else {
            LinkedList p = sentinel.next;
            if (index == 0) {
                return (T) p.item;
            }
            return getRecursive(index - 1);
        }
    }
}
