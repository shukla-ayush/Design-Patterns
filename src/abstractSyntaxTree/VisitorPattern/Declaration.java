package q4b;

/**
 * Declaration is the class
 * that is used for declaring 
 * a variable.
 * It implements Statement.
 * 
 * @author ashuk
 *
 */

public class Declaration extends Statement{

	String dec;
	
	/**
	 * Constructor for Declaration that assigns
	 * string representation of Variable to 
	 * dec string.
	 * 
	 * @param v Represents the variable V
	 * 
	 * @author ashuk
	 */
	public Declaration(Variable v) {
		super();
		dec = "var " + v.textRepresentation() + ";";
	}
	
	
	/**
	 * 
	 * @return Returns a string that represents the
	 * declared variable
	 * 
	 * Example: Example:
	 * Declaration(x).textRepresentation() => "var x"
	 * where x is variable
	 * 
	 * @author ashuk
	 */
	@Override
	public String textRepresentation() {
		return dec;
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
