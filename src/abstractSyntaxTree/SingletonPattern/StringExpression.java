package ast4;

/**
 * StringExpression is the class that 
 * represents String in an Expression.
 * @author ashuk
 *
 */

public class StringExpression implements Expression{

	String str;
	
	// Constructor for StringExpression
	public StringExpression(String s) {
		str = s;
	}
	
	// Returns a String that has been passed to 
	// StringExpression function.
	// Example : StringExpression("abc").textRepresentation => "abc"
	public String textRepresentation() {
		return str;
	}
	
}
