package ast4;

import java.util.logging.Logger;

import ast4.Assignment;
import ast4.Declaration;
import ast4.Expression;
import ast4.InfixExpression;
import ast4.NumberExpression;
import ast4.Operator;
import ast4.PrefixExpression;
import ast4.Sequence;
import ast4.Statement;
import ast4.StringExpression;
import ast4.Variable;
import ast4.VariableExpression;

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
	
	int countInfix = 0;  // Count of InfixExpression Nodes
	int countNumber = 0; // Count of NumberExpression Nodes
	int countString = 0; // Count of StingExpression Nodes
	int countPrefix = 0; // Count of PrefixExpression Nodes
	int countVariable = 0; // Count of VariableExpression Nodes
	int countStatement = 0; // Count of Statement Nodes
	int countDeclaration = 0; // Count of Declaration Nodes
	int countSequence = 0;   // Count of Sequence Nodes
	int countAssignment = 0; // Count of Assignment Nodes
	
	// to facilitate creating single object of NodeFactory.
	private static NodeFactory nodeFactory = null;
	
	// Constructor should not be accessible outside the class.
	private NodeFactory() {}
	
	// This method creates instance of NodeFactory, and ensures
	// only one instance is created (Singleton Pattern)
	public static NodeFactory instance() {
		if(nodeFactory == null) {
			nodeFactory =  new NodeFactory();
		}
		return nodeFactory;
	}
	
	// Returns an InfixExpression Object
	public Expression createInfixExpression(Operator o, Expression e1, Expression e2) {
		countInfix = countInfix + 1;
		return new InfixExpression(o, e1, e2);
	}
		
	// Returns a PrefixExpression Object
	public Expression createPrefixExpression(Operator o, Expression e1, Expression e2) {
		countPrefix = countPrefix + 1;
		return new PrefixExpression(o, e1, e2);
	}
		
    // Returns a VariableExpression Object
	public Expression createVariableExpression(Variable v) {
		countVariable = countVariable + 1;
		return new VariableExpression(v);
	}
		
	// Returns a StringExpression Object
	public Expression createStringExpression(String s) {
		countString = countString + 1;
		return new StringExpression(s);
	}
		
	// Returns a NumberExpression Object
	public Expression createNumberExpression(int num) {
		countNumber = countNumber + 1;
		return new NumberExpression(num);
	}
		
	// Returns an Assignment Object
	public Statement createAssignment(Variable v, Expression e) {
		countAssignment = countAssignment + 1;
		return new Assignment(v, e);
	}
		
	// Returns a Declaration Object
	public Statement createDeclaration(Variable v) {
		countDeclaration = countDeclaration + 1;
		return new Declaration(v);
	}
		
	// Returns a Sequence Object
	public Statement createSequence(Statement...statements ) {
		countSequence = countSequence + 1;
		return new Sequence(statements);
	}
		
	// This method is to print the number of instances of each node 
	// to the standard output, and also returns a string for testing 
	// purpose.
	public String report() {
	// String that holds what needs to displayed
	// on standard output, and also returned 
	// for purpose of testing
		String reportInst = "Count of Variables: " + " " + countVariable + "\n" +
				"Count of Numbers: " + " " + countNumber + "\n" +
				"Count of Strings: " + " " + countString + "\n" +
				"Count of Infix: " + " " + countInfix + "\n" +
				"Count of Prefix: " + " " + countPrefix + "\n" +
				"Count of Assignment: " + " " + countAssignment + "\n" +
				"Count of Declaration: " + " " + countDeclaration + "\n" +
				"Count of Sequences: " + " " + countSequence;
		Logger logger = Logger.getLogger("Information of Node Instances");
		logger.info(reportInst);
		return reportInst;
	}
	
}
