class Node<T> {
    public Node<T> next;
    public T value;

}

public class LinkedStack<T> implements StackInterface<T> {
    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    /**
     * Returns true if the stack is empty, false otherwise.
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds the specified element to the top of this stack.
     *
     * @param element the element to be pushed onto this stack
     */
    public void push(T element) {
        Node<T> newNode = new Node<T>();
        newNode.value = element;
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Removes and returns the top element of this stack.
     *
     * @return the top element of this stack
     * @throws RuntimeException if this stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        T element = top.value;
        top = top.next;
        size--;
        return element;
    }

    /**
     * Returns the element at the top of this stack without removing it.
     * 
     * @return the element at the top of this stack
     * @throws RuntimeException if this stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return top.value;
    }

    void printStack() {
        System.out.println("Stack:");
        Node<T> current = top;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
