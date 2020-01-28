//----------------------------------------------------------------------------
// QueueInterface.java           by Dale/Joyce/Weems                 Chapter 3
//
// Interface for a class that implements a queue of Object.
// A queue is a first-in, first-out structure.
//----------------------------------------------------------------------------

public interface QueueInterface {
    Object dequeue() throws QueueUnderflowException;
    // Throws QueueUnderflowException if this queue is empty,
    // otherwise removes top element from this queue.
  
  
    boolean isEmpty();
    // Returns true if this queuea is empty, otherwise returns false.

}
