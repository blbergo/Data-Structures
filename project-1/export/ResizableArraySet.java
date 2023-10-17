import java.util.Arrays;

public class ResizableArraySet<T> implements SetInterface<T> {
    private int size;
    private int capacity;

    public static final int DEFAULT_CAPACITY = 25;
    public static final int MAX_CAPACITY = 10000;
    private boolean integrityOK = false;

    private T[] array;

    public ResizableArraySet(int capacity) {
        size = 0;

        checkCapacity();

        integrityOK = true;
        this.capacity = capacity;

        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity];
        array = temp;
    }

    public ResizableArraySet() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Checks the integrity of a set.
     * 
     * @return True if integrity is ok, throws exception if not
     */
    public boolean checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("Set object is corrupt");
        }

        return true;
    }

    /*
     * Checks that the capacity does not exceed the max capacity for a set.
     */
    public void checkCapacity() {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempted to create a set whose capacity exceeds the maximum.");
        }
    }

    /**
     * Determine if a set is full or not.
     * 
     * @return True if full, false if not
     */
    public boolean isArrayFull() {
        if (size == capacity) {
            return true;
        }

        return false;
    }

    /**
     * Doubles the capacity of a set.
     */
    public void doubleCapacity() {
        int newCap = capacity * 2;
        checkCapacity();
        array = Arrays.copyOf(array, newCap);

    }

    /**
     * Get the index of a specific entry
     * 
     * @param anEntry the entry to search for
     * @return -1 if not found, any other int if found
     */
    public int getIndexOf(T anEntry) {
        for (int i = 0; i < size; i++) {
            if (anEntry.equals(array[i])) {
                return i;
            }
        }

        return -1;
    }

    public int getCurrentSize() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }

        return false;
    }

    public boolean addEntry(T newEntry) {
        checkIntegrity();

        // resize the array if necessary
        if (isArrayFull()) {
            doubleCapacity();
        }

        if (getIndexOf(newEntry) != -1) {
            return false;
        }

        array[size] = newEntry;
        size += 1;
        return true;
    }

    /**
     * Removes an entry at the given index.
     * 
     * @param givenIndex the index of the element to remove
     * @return the element to be removed, null if it doesn't exist
     */
    private T removeEntry(int givenIndex) {
        T result = null;

        if (!isEmpty() && (givenIndex >= 0)) {
            result = array[givenIndex];
            array[givenIndex] = array[size - 1];
            array[size - 1] = null;
            size--;
        }

        return result;
    }

    public boolean remove(T anEntry) {
        checkIntegrity();

        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    public T remove() {
        checkIntegrity();

        // just have to remove from the end
        T result = removeEntry(size - 1);
        return result;
    }

    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    public boolean contains(T anEntry) {
        checkIntegrity();

        if (getIndexOf(anEntry) > -1) {
            return true;
        }

        return false;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[size];

        // iterate through the array and add each element to the result
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }

        return result;
    }

    public SetInterface<T> union(SetInterface<T> otherSet) {
        // create a new set to store the result
        SetInterface<T> result = new ResizableArraySet<T>();
        T[] otherArray = otherSet.toArray();
        T[] leftOverArray;
        SetInterface<T> leftOverSet = new ResizableArraySet<T>();

        int length = 0;

        // determine how long to iterate for
        if (size > otherSet.getCurrentSize()) {
            length = otherSet.getCurrentSize();
            leftOverArray = array;
            leftOverSet = this;
        } else {
            length = size;
            leftOverArray = otherArray;
            leftOverSet = otherSet;
        }

        // add entries from both sets
        int i = 0;
        while (i < length) {
            result.addEntry(array[i]);
            result.addEntry(otherArray[i]);
            i++;
        }

        // add the remaining entries from the longer array;
        for (int j = length; j < leftOverSet.getCurrentSize(); j++) {
            result.addEntry(leftOverArray[j]);
        }

        return result;
    }

    public SetInterface<T> intersection(SetInterface<T> otherSet) {
        // create a new set to store the result
        SetInterface<T> result = new ResizableArraySet<T>();
        T[] otherArray = otherSet.toArray();

        SetInterface<T> largerSet, smallerSet;
        T[] largerArray;

        // determine how long to iterate for
        if (size > otherSet.getCurrentSize()) {

            largerSet = this;
            largerArray = array;

            smallerSet = otherSet;
        } else {

            largerSet = otherSet;
            largerArray = otherArray;

            smallerSet = this;
        }

        // loop for the larger set, and add its items if the smaller set contains them
        for (int i = 0; i < largerSet.getCurrentSize(); i++) {
            if (smallerSet.contains(largerArray[i])) {
                result.addEntry(largerArray[i]);
            }
        }

        return result;
    }

    public SetInterface<T> difference(SetInterface<T> otherSet) {
        SetInterface<T> result = this;

        for (int i = 0; i < size; i++) {
            if (otherSet.contains(array[i])) {
                result.remove(array[i]);
            }
        }

        return result;
    }

}
