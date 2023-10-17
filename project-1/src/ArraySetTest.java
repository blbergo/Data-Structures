public class ArraySetTest<T> {
    private ResizableArraySet<T> set1;
    private ResizableArraySet<T> set2;

    public static void main(String[] args) {
        // Initialize test object subsequently set1
        ArraySetTest<String> test = new ArraySetTest<String>();

        test.getCurrentSize(); // 0
        test.isEmpty(); // true
        test.spacer();

        test.addEntry("This is a test"); // true
        test.getCurrentSize(); // 1
        test.spacer();

        test.remove(); // This is a test
        test.getCurrentSize(); // 0
        test.spacer();

        test.addEntry("This is yet another test"); // true
        test.getCurrentSize(); // 1

        test.remove("This is yet another test");
        test.getCurrentSize(); // 0
        test.spacer();

        test.addEntry("Test 1"); // true
        test.addEntry("Test 2"); // true
        test.addEntry("Test 3"); // true
        test.getCurrentSize(); // 3
        test.clear();
        test.getCurrentSize(); // 0
        test.spacer();

        test.addEntry("This is a test of the national alert system");
        test.contains("This is a test of the national alert system"); // true
        test.contains("Missiles inbound!"); // false
        test.clear();
        test.spacer();

        test.addEntry("Test 1"); // true
        test.addEntry("Test 2"); // true
        test.addEntry("Test 3"); // true
        test.toArray();
        test.clear();
        test.spacer();

        test.addEntry("a"); // true
        test.addEntry("b"); // true
        test.addEntry("c"); // true
        test.set2.addEntry("a");
        test.union(test.set2); // 3
        test.clear();
        test.set2.clear();
        test.spacer();

        test.addEntry("a"); // true
        test.addEntry("b"); // true
        test.addEntry("c"); // true
        test.set2.addEntry("a");
        test.set2.addEntry("d");
        test.intersection(test.set2); // 3
        test.clear();
        test.set2.clear();
        test.spacer();

        test.addEntry("a"); // true
        test.addEntry("b"); // true
        test.addEntry("c"); // true
        test.set2.addEntry("a");
        test.set2.addEntry("d");

        test.difference(test.set2); // 1, [c, b]
        test.clear();
        test.spacer();

        test.addEntry("a"); // true
        test.addEntry("b"); // true
        test.addEntry("c"); // true
        test.difference2(test.set1); // 1, [d]
    }

    public ArraySetTest() {
        set1 = new ResizableArraySet<T>();
        set2 = new ResizableArraySet<T>(30);
    }

    public void spacer() {
        System.out.print('\n');
    }

    public void printArray(T[] array) {
        String output = "[";
        for (int i = 0; i < array.length - 1; i++) {
            output += array[i].toString() + ", ";
        }

        output += array[array.length - 1].toString() + ']';
        System.out.println(output);
    }

    /*
     * Test that getCurrentSize is working properly.
     */
    public void getCurrentSize() {
        System.out.println(String.format("Current size of set1: %s", set1.getCurrentSize()));
    }

    /**
     * Test that isEmpty is working properly.
     */
    public void isEmpty() {
        System.out.println(String.format("Is set1 empty? %s", set1.isEmpty()));
    }

    /**
     * Test that addEntry is working properly.
     * 
     * @param entry
     */
    public void addEntry(T entry) {
        System.out.println(String.format("Successfully added `%s` to set1? %s", entry, set1.addEntry(entry)));
    }

    /**
     * Test that remove is working properly.
     */
    public void remove() {
        System.out.println(String.format("Item removed from set1: %s", set1.remove()));
    }

    /**
     * Test that remove(T anEntry) is working properly.
     * 
     * @param anEntry - the string to remove
     */
    public void remove(T anEntry) {
        System.out.println(String.format("`%s` removed from set1? %s", anEntry, set1.remove(anEntry)));
    }

    /**
     * Test that clear is working properly.
     */
    public void clear() {
        set1.clear();
        System.out.println("Successfully cleared set1");
    }

    /**
     * Test that contains is working properly.
     * 
     * @param anEntry
     */
    public void contains(T anEntry) {
        System.out.println(String.format("Does set1 contain `%s`? %s", anEntry, set1.contains(anEntry)));
    }

    /**
     * Test that toArray is working properly.
     */
    public void toArray() {
        T[] array = set1.toArray();
        System.out.println(String.format("Converted set1 to array object %s with length: %s", array, array.length));
    }

    /**
     * Test that union is working properly.
     * 
     * @param otherSet
     */
    public void union(ResizableArraySet<T> otherSet) {
        set1 = (ResizableArraySet<T>) set1.union(otherSet);
        System.out.println(String.format("New length: %s", set1.getCurrentSize()));
        printArray(set1.toArray());
    }

    /**
     * Test that intersection is working properly.
     * 
     * @param otherSet
     */
    public void intersection(ResizableArraySet<T> otherSet) {
        set1 = (ResizableArraySet<T>) set1.intersection(otherSet);
        System.out.println(String.format("New length: %s", set1.getCurrentSize()));
        T[] array = set1.toArray();
        printArray(array);
    }

    /*
     * Test that difference is working properly.
     */
    public void difference(ResizableArraySet<T> otherSet) {
        set1 = (ResizableArraySet<T>) set1.difference(otherSet);
        System.out.println(String.format("New length of set1: %s", set1.getCurrentSize()));

        T[] array = set1.toArray();
        printArray(array);
    }

    public void difference2(ResizableArraySet<T> otherSet) {
        set2 = (ResizableArraySet<T>) set2.difference(otherSet);
        System.out.println(String.format("New length of set2: %s", set2.getCurrentSize()));

        T[] array = set2.toArray();
        printArray(array);
    }
}