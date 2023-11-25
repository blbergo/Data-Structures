/**
 * An interface for a stack data structure.
 * 
 * @param <T> the type of elements in the stack
 */
public interface StackInterface<T> {
    
    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty();
    
    
    /**
     * Adds an element to the top of the stack.
     * 
     * @param element the element to be added to the stack
     */
    public void push(T element);
    
    /**
     * Removes and returns the top element from the stack.
     * 
     * @return the top element from the stack
     */
    public T pop();
    
    /**
     * Retrieves the top element of the stack without removing it.
     * 
     * @return the top element of the stack
     */
    public T peek();
}
