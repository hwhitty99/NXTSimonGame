public class ArrayQueue1 implements BoundedQueueInterface {
    private Object[] queue;
    private int size, head, tail;
    public static final int DEFAULTMAX = 100;
    
    public ArrayQueue1() {
        queue = new Object[DEFAULTMAX];
        size = 0;
        head = 0;
        tail = -1;
    }
    
    public ArrayQueue1(int maxSize) {
        queue = new Object[maxSize];
        size = 0;
        head = 0;
        tail = -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == queue.length;
    }
    
    public void enqueue(Object item) throws QueueOverflowException {
        int cur;
        if (isFull())
            throw new QueueOverflowException("enqueue a full queue");
        else {
            if (tail != queue.length - 1) {
                tail++;
                queue[tail]=item;
                size++;
            } else { // move everyong down to bottom
                cur = 0;
                for (int i=head; i<= tail; i++) {
                    queue[cur] = queue[i];
                    cur++;
                }
                tail = cur - 1;
                tail++;
                queue[tail]=item;
                head = 0;
                size++;
            }
        }
    }
    
    public Object dequeue() throws QueueUnderflowException {
        Object saved;
        if (isEmpty())
            throw new QueueUnderflowException("dequeue an empty queue");
        else {
            saved = queue[head];
            head++;
            size--;
            return saved;
        }
    }
}