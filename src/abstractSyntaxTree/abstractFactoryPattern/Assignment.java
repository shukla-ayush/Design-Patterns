package ast2;

/**
 * Assignment is the class
 * that is used for assigning 
 * expression to variable.
 * It implements Statement.
 * @author ashuk
 *
 */

public class Assignment implements Statement{

	String assgn;
	
	// Constructor for Assignment
	public Assignment(Variable v, Expression e) {
		assgn = v.textRepresentation() + " = " + e.textRepresentation() + ";";
	}
	
	// Returns a string that represents the
	// expression being assigned to the
	// variable
	// Example:
	// Assignment(x, exp).textRepresentation() => "x = 1+2"
	// where x is variable
	// and exp is 1+2
	public String textRepresentation() {
		return assgn;
	}
	
}
