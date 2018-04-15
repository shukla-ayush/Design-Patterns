package ast4;

/**
 * Declaration is the class
 * that is used for declaring 
 * a variable.
 * It implements Statement.
 * @author ashuk
 *
 */

public class Declaration implements Statement{

	String dec;
	
	// Constructor for Declaration
	public Declaration(Variable v) {
		dec = "var " + v.textRepresentation() + ";";
	}
	
	// Returns a string that represents the
	// declared variable
	// Example:
	// Declaration(x).textRepresentation() => "var x"
	// where x is variable
	public String textRepresentation() {
		return dec;
	}
	
}
