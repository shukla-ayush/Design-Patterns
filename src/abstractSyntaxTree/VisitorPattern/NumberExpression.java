package q4b;


/**
 * NumberExpression is the class that 
 * represents Numbers in an Expression.
 * Here we are considering integer
 * values for numbers.
 * @author ashuk
 *
 */

public class NumberExpression extends Expression{

	// To store the NumberExpression representation
	String num;
	
	/**
	 * Constructor for NumberExpression, that assigns 
	 * NumberExpression's number representation 
	 * to a string.
	 * 
	 * @param int d which is the integer in the 
	 * number expression
	 * 
	 * @author ashuk
	 */
	public NumberExpression(int d) {
		super();
		num = Integer.toString(d) ;
	}

	
	/**
	 * 
	 * @return Returns a string that represents the
	 * string associated to number that has been passed
	 * in constructor.
	 * 
	 * Example:
	 * NumberExpression(1).textRepresentation => "1"
	 * 
	 * @author ashuk
	 */
	@Override
	public String textRepresentation() {
	    return num;
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

