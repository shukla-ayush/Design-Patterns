package ast2;

/**
 * Variable is the class
 * to represent the variable
 * used in expression.
 * @author ashuk
 *
 */

public class Variable {

    String var;
	
    // Constructor for variable
	public Variable(String v) {
		var = v;
	}
	
	// Returns string representation
	// of the variable
	// Example:
	// Variable("x").textRepresentation() => "x" 
	public String textRepresentation() {
		return var;
	}
	
}
