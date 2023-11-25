public class ResizableArrayStack<T> implements StackInterface<T> {
    private T[] stack;
    private int size;
    private int capacity;

    public static int DEFAULT_CAPACITY = 25;

    public ResizableArrayStack(int capacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity];
        stack = temp;

        size = 0;
        this.capacity = capacity;
    }

    public ResizableArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Determine whether a stack is empty or not
     * 
     * @return True if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Determine whether a stack is full or not
     * 
     * @return True if full, false otherwise
     */
    public boolean isFull() {
        return size == capacity;
    }

    /*
     * Double the capacity of the stack
     */
    public void doubleCapacity() {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
        capacity *= 2;
    }

    /*
     * Push an element to the top of the stack, doubling capacity if necessary
     */
    public void push(T element) {
        if (isFull()) {
            doubleCapacity();
        }

        stack[size] = element;
        size += 1;
    }

    /**
     * Pop an element off the top of the stack
     * 
     * @return T - the element popped off of the stack
     */
    public T pop() {
        T result = stack[size - 1];

        size -= 1;
        return result;
    }

    /**
     * Get the element at the top of the stack
     * 
     * @return T - the element at the top of the stack
     */
    public T peek() {
        return stack[size-1];
    }

    public void printStack() {
        System.out.println("Stack:");
        for (int i = 0; i < size; i++) {
            System.out.println(stack[i]);
        }
    }

}