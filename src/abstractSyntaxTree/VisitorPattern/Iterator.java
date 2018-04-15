package q4b;

/**
 * Iterator is an object that provides
 * features of traversing a data structure
 * of any data type (generic).
 *
 * The type T can be any data type like
 * Integer, String and so on. 
 * @param <T>
 * 
 * @author ashuk
 */
public interface Iterator<T> {

	/**
	 * Check if there are more elements
	 */
	boolean hasAnotherElement();
	
	/**
	 * Return the next element
	 */
	T nextElement();
	
}
