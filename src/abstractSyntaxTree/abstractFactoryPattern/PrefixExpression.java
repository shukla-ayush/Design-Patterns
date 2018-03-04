package ast2;

/**
 * PrefixExpression is the class that 
 * represents an pre-order Expression.
 * Here we are considering binary operations
 * So we have one operator, and two
 * expressions in an PrefixExpression
 * @author ashuk
 *
 */

public class PrefixExpression implements Expression {

	String prefixExp;
	
	// Constructor for PrefixExpression
	public PrefixExpression(Operator o, Expression e1, Expression e2){
		prefixExp = o.textRepresentation() + " " + e1.textRepresentation() + " " + e2.textRepresentation();
	}
	
	// Returns string that is associated with 
	// PrefixExpression, where the operator
	// is present before the two expressions.
	// Example: 
	// PrefixExpression(plus, one, two).textRepresentation() => "+ 1 2"
    // where plus is "+", and one, two are 1 and 2.
	public String textRepresentation() {
		return prefixExp;
	}

}
