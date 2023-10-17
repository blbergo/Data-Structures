public class LinkedSetTest<T> {
    private LinkedSet<T> set1;
    private LinkedSet<T> set2;

    public static void main(String[] args) {
        LinkedSetTest<String> test = new LinkedSetTest<String>();

        test.getCurrentSize(); // 0
        test.isEmpty(); // true
        test.spacer();

        test.addEntry("Testing 123"); // `Testing 123` ? true
        test.addEntry("Testing 123"); // `Testing 123` ? false
        test.addEntry("Testing 345"); // `Testing 345` ? true
        test.getCurrentSize(); // 2
        test.spacer();

        test.remove(); // true
        test.getCurrentSize(); // 1
        test.spacer();

        test.remove("Testing 123");
        test.getCurrentSize(); // 0
        test.spacer();

        test.clear();
        test.spacer();

        test.contains("Testing 123"); // false
        test.addEntry("This is a test!"); // `This is a test!` ? true
        test.contains("This is a test!"); // true
        test.spacer();

        test.addEntry("This is, yet another test");
        test.toArray();
        test.clear();
        test.spacer();

        test.addEntry("a");
        test.addEntry("b");
        test.addEntry("c");
        test.set2.addEntry("a");
        test.set2.addEntry("d");
        test.union(test.set2);
        test.clear();
        test.set2.clear();
        test.spacer();
        
        test.addEntry("a");
        test.addEntry("b");
        test.addEntry("c");
        test.set2.addEntry("a");
        test.set2.addEntry("d");
        test.intersection(test.set2);
        test.clear();
        test.set2.clear();
        test.spacer();

        test.addEntry("a");
        test.addEntry("b");
        test.addEntry("c");
        test.set2.addEntry("a");
        test.set2.addEntry("d");
        test.difference(test.set2);
        test.clear();
        test.set2.clear();
        test.spacer();

        test.addEntry("a");
        test.addEntry("b");
        test.addEntry("c");
        test.set2.addEntry("a");
        test.set2.addEntry("d");
        test.difference2(test.set1);
        test.clear();
        test.set2.clear();
        test.spacer();
    
    }

    public LinkedSetTest() {
        set1 = new LinkedSet<T>();
        set2 = new LinkedSet<T>();
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

    public void getCurrentSize() {
        System.out.println(String.format("Current size of set1: %s", set1.getCurrentSize()));
    }

    public void isEmpty() {
        System.out.println(String.format("Is set1 empty? %s", set1.isEmpty()));
        spacer();
    }

    public void addEntry(T anEntry) {
        System.out.println(String.format("Successfully added `%s` to set1? %s", anEntry, set1.addEntry(anEntry)));
    }

    public void remove() {
        System.out.println(String.format("Successfully removed %s from the end of set1", set1.remove()));
    }

    public void remove(T anEntry) {
        System.out.println(String.format("Successfully removed %s from set1? %s", anEntry, set1.remove(anEntry)));
    }

    public void clear() {
        set1.clear();
        System.out.println("Successfully cleared set1");
    }

    public void contains(T anEntry) {
        System.out.println(String.format("Does set 1 contain `%s`? %s", anEntry, set1.contains(anEntry)));
    }

    public void toArray() {
        T[] array = set1.toArray();
        System.out.println(String.format("Successfully converted set1 to %s with a length of %s", array, array.length));
    }

    /**
     * Test that union is working properly.
     * 
     * @param otherSet
     */
    public void union(LinkedSet<T> otherSet) {
        set1 = (LinkedSet<T>) set1.union(otherSet);
        System.out.println(String.format("New length: %s", set1.getCurrentSize()));
        printArray(set1.toArray());
    }

    /**
     * Test that intersection is working properly.
     * 
     * @param otherSet
     */
    public void intersection(LinkedSet<T> otherSet) {
        set1 = (LinkedSet<T>) set1.intersection(otherSet);
        System.out.println(String.format("New length: %s", set1.getCurrentSize()));
        T[] array = set1.toArray();
        printArray(array);
    }

    /*
     * Test that difference is working properly.
     */
    public void difference(LinkedSet<T> otherSet) {
        set1 = (LinkedSet<T>) set1.difference(otherSet);
        System.out.println(String.format("New length of set1: %s", set1.getCurrentSize()));

        T[] array = set1.toArray();
        printArray(array);
    }

    public void difference2(LinkedSet<T> otherSet) {
        set2 = (LinkedSet<T>) set2.difference(otherSet);
        System.out.println(String.format("New length of set2: %s", set2.getCurrentSize()));

        T[] array = set2.toArray();
        printArray(array);
    }

}
