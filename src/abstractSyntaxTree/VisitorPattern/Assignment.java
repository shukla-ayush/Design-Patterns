package q4b;


/**
 * Assignment is the class
 * that is used for assigning 
 * expression to variable.
 * It implements Statement.
 * 
 * @author ashuk
 *
 */

public class Assignment extends Statement{

	String assgn;
	InfixExpression i;
	PrefixExpression p;
	NumberExpression n;
	VariableExpression ve;
	StringExpression str;
	int flag;
	
	/**
	 * Constructor for Assignment, that assigns 
	 * variable and expression's representation 
	 * to a string.
	 * 
	 * @param v represents the passed Variable
	 * @param e represents the passed expression
	 * 
	 * @author ashuk
	 */
	public Assignment(Variable v, Expression e) {
		super();
		assgn = v.textRepresentation() + " = " + e.textRepresentation() + ";";
		
		if(e instanceof InfixExpression) {
			flag = 1;
			i = (InfixExpression) e;
		}
		
		if(e instanceof PrefixExpression) {
			flag = 2;
			p = (PrefixExpression) e;
		}
		
		if(e instanceof NumberExpression) {
			flag = 3;
			n = (NumberExpression) e;
		}
		
		if(e instanceof VariableExpression) {
			flag = 4;
			ve = (VariableExpression) e;
		}
		
		if(e instanceof StringExpression) {
			flag = 5;
			str = (StringExpression) e;
		}
		
		
	}
	
	/**
	 * 
	 * @return Returns a string that represents the
	 * expression being assigned to the
	 * variable.
	 * 
	 * Example:
	 * Assignment(x, exp).textRepresentation() => "x = 1+2"
	 * where x is variable and exp is 1+2 
	 * 
	 * @author ashuk
	 */
	@Override
	public String textRepresentation() {
		return assgn;
	}

	/**
	 * accept function accepts the visitor v, and
	 * further calls accept function for children 
	 * functions.
	 * 
	 * @param v is the object of ASTVisitor.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	public void accept(ASTVisitor v) {
		v.visit(this);
		switch(flag) {
		case 1: i.accept(v);
				break;
		case 2: p.accept(v);
				break;
		case 3: n.accept(v);
				break;
		case 4: ve.accept(v);
				break;
		case 5: str.accept(v);
				break;
		default: break;
		}
		
	}
	
}
