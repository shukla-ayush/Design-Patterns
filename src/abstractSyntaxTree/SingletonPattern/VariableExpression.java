package ast4;

/**
 * VariableExpression is the class that 
 * represents Variable in an Expression.
 * @author ashuk
 *
 */

public class VariableExpression implements Expression{

	String varExp;
	
	// Constructor for VariableExpression
	public VariableExpression(Variable v) {
		varExp = v.textRepresentation();
	}

	// Returns a String which represents
	// the string associated to the 
	// variable, that has been passed to 
	// VariableExpression function.
	// Example : VariableExpression("x").textRepresentation => "x"
	@Override
	public String textRepresentation() {
		return varExp;
	}
	
}
