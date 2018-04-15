package q4b;


/**
 * StringExpression is the class that 
 * represents String in an Expression.
 * 
 * @author ashuk
 *
 */

public class StringExpression extends Expression{

	// To store the StringExpression representation
		String str;
		
	/**
	 * Constructor for StringExpression, that assigns 
	 * StringExpression's string representation 
	 * to a string.
	 * 
	 * @param s represents the string of StringExpression
	 * 
	 * @author ashuk
	 */
	public StringExpression(String s) {
		super();
		str = s;
		
	}
	
	/**
	 * 
	 * @return a String that has been passed to 
	 * StringExpression function.
	 * 
	 * Example :
	 * StringExpression("abc").textRepresentation => "abc"
	 * 
	 * @author ashuk
	 */
	@Override	
	public String textRepresentation() {
		return str;
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
