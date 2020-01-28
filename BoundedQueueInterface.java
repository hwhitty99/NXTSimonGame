//----------------------------------------------------------------------------
// BoundedQueueInterface.java        by Dale/Joyce/Weems             Chapter 3
//
// Interface for a class that implements a queue of Object with a bound
// on the size of the queue. A queue is a first-in, first-out structure.
//----------------------------------------------------------------------------


public interface BoundedQueueInterface extends QueueInterface {
    void enqueue(Object element) throws QueueOverflowException;
    // Throws QueueOverflowException if this queue is full,
    // otherwise places element at the top of this queue.

    boolean isFull();
    // Returns true if this Queue is full, otherwise returns false.
  
}
