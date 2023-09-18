package setup;

public class Test {

	public static void main(String[] args) {
		OrderedPair<String> fruit = new OrderedPair<String>("apple","banana");
		
		System.out.println(fruit);
		fruit.changeOrder();
		System.out.println(fruit);
		
		String firstFruit = fruit.getFirst();
		System.out.println(firstFruit + " has length " + firstFruit.length());
	}

}