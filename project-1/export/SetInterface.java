public interface SetInterface<T> {
    /**
     * Gets the current number of entries in the set.
     * 
     * @return The number of entries in the set.
     */
    public int getCurrentSize();

    /**
     * Determine whether a set is empty or not.
     * 
     * @return True if empty, false if not
     */
    public boolean isEmpty();

    /***
     * Add an entry to the set.
     * 
     * @param newEntry the object to be added to the set
     * @return True if added successfully, false if capacity is reached.
     */
    public boolean addEntry(T newEntry);

    /**
     * Removes the last entry from the set and returns it.
     * 
     * @return The item removed from the set.
     */
    public T remove();

    /**
     * Removes a specific entry from a set.
     * 
     * @param anEntry
     * @return True if successful, false if not
     */
    public boolean remove(T anEntry);

    /**
     * Removes all entries from a set.
     */
    public void clear();

    /***
     * Determine whether a set contains a certain item.
     * 
     * @param anEntry the item to search for
     * @return True if found, false if not
     */
    public boolean contains(T anEntry);

    /**
     * Converts the set to an array
     * 
     * @return the set as an array.
     */
    public T[] toArray();

    /**
     * Performs a union operation on two sets
     * 
     * @param otherSet the set to execute the operation with
     * @return the union of the two sets
     */
    public SetInterface<T> union(SetInterface<T> otherSet);

    /**
     * Performs the intersection operation on two sets.
     * 
     * @param otherSet the set to execute the operation with
     * @return the intersection of two sets.
     */
    public SetInterface<T> intersection(SetInterface<T> otherSet);

    /**
     * Performs the difference operation on two sets.
     * 
     * @param otherSet the set to execute the operation with
     * @return the difference between two sets
     */
    public SetInterface<T> difference(SetInterface<T> otherSet);
}