package ast4;

/**
 * NumberExpression is the class that 
 * represents Numbers in an Expression.
 * Here we are considering integer
 * values for numbers.
 * @author ashuk
 *
 */

public class NumberExpression implements Expression{

	String num;
	
	// Constructor for NumberExpression
	public NumberExpression(int d) {
		num = Integer.toString(d) ;
	}

	
	// Returns a String which represents
	// the string associated to the 
	// number, that has been passed to 
	// NumberExpression function.
	// Example : NumberExpression(1).textRepresentation => "1"
	public String textRepresentation() {
	    return num;
	}
	
	
	
}

