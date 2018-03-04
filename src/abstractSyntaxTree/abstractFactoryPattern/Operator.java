package ast2;

/**
 * Operator is the class
 * to represent the operator
 * used in expression.
 * @author ashuk
 *
 */

public class Operator {

	String op;
	
	// Constructor for Operator
	public Operator(String s) {
		op = s;
	}
	
	// Returns string representation
	// of the operator
	// Example:
	// Operator("+").textRepresentation() => "+" 
	public String textRepresentation() {
		return op;
	}
	
}
