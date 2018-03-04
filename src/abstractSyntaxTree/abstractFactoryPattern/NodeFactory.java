package ast2;

/**
 * The NodeFactory class has various functions
 * to create the nodes of different types
 * like Numbers, InfixExpressions etc
 * The NodeFactory is useful in the sense that, if there
 * is a need to create specialized types of nodes
 * then they can inherit this NodeFactory and it can 
 * have its own methods apart from the ability to
 * override the method of NodeFactory.
 * @author ashuk
 *
 */

public class NodeFactory {
    
	// Returns an InfixExpression Object
	public Expression createInfixExpression(Operator o, Expression e1, Expression e2) {
		return new InfixExpression(o, e1, e2);
	}
	
	// Returns a PrefixExpression Object
	public Expression createPrefixExpression(Operator o, Expression e1, Expression e2) {
		return new PrefixExpression(o, e1, e2);
	}
	
	// Returns a VariableExpression Object
	public Expression createVariableExpression(Variable v) {
		return new VariableExpression(v);
	}
	
	// Returns a StringExpression Object
	public Expression createStringExpression(String s) {
		return new StringExpression(s);
	}
	
	// Returns a NumberExpression Object
	public Expression createNumberExpression(int num) {
		return new NumberExpression(num);
	}
	
	// Returns an Assignment Object
	public Statement createAssignment(Variable v, Expression e) {
		return new Assignment(v, e);
	}
	
	// Returns a Declaration Object
	public Statement createDeclaration(Variable v) {
		return new Declaration(v);
	}
	
	// Returns a Sequence Object
	public Statement createSequence(Statement...statements ) {
		return new Sequence(statements);
	}
	
}
