package q4b;

/**
 * Variable is the class
 * to represent the variable
 * used in expression.
 * @author ashuk
 *
 */

public class Variable {

	// To store the Variable representation
    String var;
	
    
    /**
	 * @author ashuk
	 * Constructor for Variable, that assigns 
	 * Variable's representation to a string 
	 * 
	 * @param v represents the variable name.
	 */
	public Variable(String v) {
		var = v;
	}
	
	
	/**
	 * @author ashuk
	 * 
	 * @return Returns string representation
	 * of the variable.
	 * 
	 * Example:
	 * Variable("x").textRepresentation() => "x"
	 */
	public String textRepresentation() {
		return var;
	}
	
}
