package setup;

public class OrderedPair<T> implements Pairable<T> {
	
	private T first, second;
	
	public OrderedPair(T firstItem, T secondItem) {
		first = firstItem;
		second = secondItem;
	} // end constructor

	/* Returns the first object in this pair. */
	public T getFirst() {
		return first;
	} // end getFirst

	/* Returns the second object in this pair. */
	public T getSecond() {
		return second;
	} // end getSecond

	public void changeOrder() {
		T temp = first;
		first = second;
		second = temp;
	} // end changeOrder
	
	public String toString() {
		return "(" + first + ", " + second + ")";
	} // end toString
	

} // end OrderedPair
