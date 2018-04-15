package ast4;
/**
 * InfixExpression is the class that 
 * represents an in-order Expression.
 * Here we are considering binary operations
 * So we have one operator, and two
 * expressions in an InfixExression
 * @author ashuk
 *
 */

public class InfixExpression implements Expression{

	String infixExp;
	
	// Constructor for InfixExpression
	public InfixExpression(Operator o, Expression e1, Expression e2) {
		infixExp = e1.textRepresentation() + " " +  o.textRepresentation() + " " + e2.textRepresentation(); 
	}
	
	// Returns string that is associated with 
	// InfixExpression, where the operator
	// is present in between the two expressions.
	// Example: 
	// InfixExpression(plus, one, two).textRepresentation() => "1+2"
	// where plus is "+", and one, two are 1 and 2.
	public String textRepresentation() {
		return infixExp;
	}

	
}
