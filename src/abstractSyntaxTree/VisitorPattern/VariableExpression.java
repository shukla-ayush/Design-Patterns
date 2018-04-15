package q4b;

/**
 * VariableExpression is the class that 
 * represents Variable in an Expression.
 * 
 * @author ashuk
 *
 */

public class VariableExpression extends Expression{

	// To store the VariableExpression representation
	String varExp;
		
	/**
	 * Constructor for VariableExpression, that assigns 
	 * VariableExpression's variable's string representation 
	 * to a string.
	 * 
	 * @param s represents the variable of VariableExpression.
	 * 
	 * @author ashuk
	 */
	public VariableExpression(Variable v) {
		super();
		varExp = v.textRepresentation();
	}

	/**
	 * 
	 * @return Returns a String which represents
	 * the string associated to the 
	 * variable, that has been passed to 
	 * VariableExpression function.
	 * 
	 * Example : VariableExpression("x").textRepresentation => "x".
	 * 
	 * @author ashuk
	 */
	@Override
	public String textRepresentation() {
		return varExp;
	}

	
	
	/**
	 * accept function accepts the visitor v 
	 * 
	 * @param v is the object of ASTVisitor.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	public void accept(ASTVisitor v) {
		v.visit(this);
	}
}
