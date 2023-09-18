package setup;

/*
 * An interface for pairs of objects
 */
public interface Pairable<T> {
	public T getFirst();
	public T getSecond();
	public void changeOrder();
} //end pairable