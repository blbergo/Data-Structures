// helper class for using linked lists
class Node<T> {
    public T value;
    public Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value) {
        this(value, null);
    }
}

public class LinkedSet<T> implements SetInterface<T> {
    private int size;
    private Node<T> head;

    public LinkedSet(Node<T> head) {
        size = 1;
        this.head = head;
    }

    public LinkedSet() {
        size = 0;
        this.head = null;
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
        Node<T> current = head;
        Node<T> previous = head;

        if (size == 0) {
            head = new Node<T>(newEntry);
            size = 1;
            return true;
        }

        while (current != null) {
            if (current.value == newEntry) {
                return false;
            }

            previous = current;
            current = current.next;
        }

        // reassign the last node's next to the new node
        Node<T> newNode = new Node<T>(newEntry);
        previous.next = newNode;

        size += 1;
        return true;
    }

    public T remove() {
        Node<T> current = head;
        Node<T> previous = head;
        T value = head.value;

        while (current != null) {
            previous = current;
            value = current.value;
            current = current.next;

        }

        previous.next = null;
        size -= 1;

        return value;
    }

    public boolean remove(T anEntry) {
        Node<T> current = head;
        Node<T> previous = head;

        while (current != null) {
            // check if entry already exists
            if (current.value == anEntry) {
                if (size == 1) {
                    head = null;
                    size = 0;
                } else {
                    previous.next = current.next;
                    size -= 1;
                }
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean contains(T anEntry) {
        Node<T> current = head;

        while (current != null) {
            if (current.value == anEntry) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public T[] toArray() {
        // required to cast to T[]
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[size];

        Node<T> current = head;
        int index = 0;

        while (current != null) {
            array[index] = current.value;
            current = current.next;
            index += 1;
        }

        return array;
    }

    public SetInterface<T> union(SetInterface<T> otherSet) {
        // create a return set and cast the other set to a linked set
        LinkedSet<T> result = new LinkedSet<T>();
        LinkedSet<T> set2 = (LinkedSet<T>) otherSet;

        Node<T> current = head;
        while (current != null) {
            result.addEntry(current.value);
            current = current.next;
        }

        // add entries from the second set
        current = set2.head;

        while (current != null) {
            result.addEntry(current.value);
            current = current.next;
        }

        return result;
    }

    public SetInterface<T> intersection(SetInterface<T> otherSet) {
        // same thing as union here
        Node<T> current;
        LinkedSet<T> result = new LinkedSet<T>();
        current = head;

        while (current != null) {
            if(otherSet.contains(current.value)) {
                result.addEntry(current.value);
            }
            current = current.next;
        }

        return result;

    }

    public SetInterface<T> difference(SetInterface<T> otherSet) {
        // here as well
        Node<T> current;
        LinkedSet<T> result = new LinkedSet<T>();
        current = head;

        while (current != null) {
            if(!otherSet.contains(current.value)) {
                result.addEntry(current.value);
            }
            current = current.next;
        }

        return result;
    }

}
