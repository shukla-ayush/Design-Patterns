package q4b;


/**
 * PrefixExpression is the class that 
 * represents an pre-order Expression.
 * Here we are considering binary operations
 * So we have one operator, and two
 * expressions in an PrefixExpression.
 * 
 * @author ashuk
 *
 */

public class PrefixExpression extends Expression {

	String prefixExp;
	InfixExpression i1;
	InfixExpression i2;
	PrefixExpression p1;
	PrefixExpression p2;
	NumberExpression n1;
	NumberExpression n2;
	VariableExpression ve1;
	VariableExpression ve2;
	StringExpression str1;
	StringExpression str2;
	int flag1;
	int flag2;
	
		
	/**
	 * Constructor for PrefixExpression, that assigns 
	 * operator's and expressions' representation 
	 * to a string.
	 * 
	 * @param o operator of PrefixExpression
	 * @param e1 1st Expression of PrefixExpression
	 * @param e2 2nd Expression of PrefixExpression
	 * 
	 * @author ashuk
	 */
	public PrefixExpression(Operator o, Expression e1, Expression e2){
		super();
		prefixExp = o.textRepresentation() + " " + e1.textRepresentation() + " " + e2.textRepresentation();
	    
	    if(e1 instanceof InfixExpression) {
			flag1 = 1;
			i1 = (InfixExpression) e1;
		}
		
		if(e1 instanceof PrefixExpression) {
			flag1 = 2;
			p1 = (PrefixExpression) e1;
		}
		
		if(e1 instanceof NumberExpression) {
			flag1 = 3;
			n1 = (NumberExpression) e1;
		}
		
		if(e1 instanceof VariableExpression) {
			flag1 = 4;
			ve1 = (VariableExpression) e1;
		}
		
		if(e1 instanceof StringExpression) {
			flag1 = 5;
			str1 = (StringExpression) e1;
		}
		
		if(e2 instanceof InfixExpression) {
			flag2 = 1;
			i2 = (InfixExpression) e2;
		}
		
		if(e2 instanceof PrefixExpression) {
			flag2 = 2;
			p2 = (PrefixExpression) e2;
		}
		
		if(e2 instanceof NumberExpression) {
			flag2 = 3;
			n2 = (NumberExpression) e2;
		}
		
		if(e2 instanceof VariableExpression) {
			flag2 = 4;
			ve2 = (VariableExpression) e2;
		}
		
		if(e2 instanceof StringExpression) {
			flag2 = 5;
			str2 = (StringExpression) e2;
		}
		
	    
	}
	
	/**
	 * 
	 * @return Returns string that is associated with 
	 * PrefixExpression, where the operator
	 * is present in before the two expressions.
	 * 
	 * Example: 
	 * PrefixExpression(plus, one, two).textRepresentation() => "+ 1 2"
	 * where plus is "+", and one, two are 1 and 2.
	 * 
	 * @author ashuk
	 */
	@Override
	public String textRepresentation() {
		return prefixExp;
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
		switch(flag1) {
		case 1: i1.accept(v); 
				break;
		case 2: p1.accept(v);
				break;
		case 3: n1.accept(v);
				break;
		case 4: ve1.accept(v);
				break;
		case 5: str1.accept(v);
				break;
		default: break;
		}
		switch(flag2) {
		case 1: i2.accept(v);
				break;
		case 2: p2.accept(v);
				break;
		case 3: n2.accept(v);
				break;
		case 4: ve2.accept(v);
				break;
		case 5: str2.accept(v); 
				break;
		default: break;
		}
	}
	
}
