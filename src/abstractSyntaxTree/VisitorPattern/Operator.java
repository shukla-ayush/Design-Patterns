package q4b;

/**
 * Operator is the class
 * to represent the operator
 * used in expression.
 * 
 * @author ashuk
 *
 */

public class Operator {

	// To store the Operator representation
	String op;
	
	/**
	 * Constructor for Operator, that assigns 
	 * Operator's representation to a string 
	 * 
	 * @param s represents the operator.
	 * 
	 * @author ashuk
	 */
	public Operator(String s) {
		op = s;
	}
	
	
	/**
	 * 
	 * @return Returns string representation
	 * of the operator.
	 * 
	 * Example:
	 * Operator("+").textRepresentation() => "+" 
	 * 
	 * @author ashuk
	 */
	public String textRepresentation() {
		return op;
	}
	
}
