package q4b;

/**
 * 
 * @author ashuk
 * ASTVisitor is an object that provides Visitor
 * to various types of Nodes, like Assignment,
 * Declaration etc.
 * 
 * It also provides function to return count of number
 * of times each node occurs in AST, which is found by
 * the number of times visit functions are called inside the
 * accept functions of various nodes.
 *
 */
public interface ASTVisitor {

	/**
	 * visit function performs the required action
	 * like increasing count of number of occurences
	 * of given parameter.
	 * 
	 * @param assign Object of Assignment class
	 * 
	 * @author ashuk
	 */
	public void visit(Assignment assign);
	
	
	/**
	 * visit function performs the required action
	 * like increasing count of number of occurences
	 * of given parameter.
	 * 
	 * @param decl Object of Declaration class
	 * 
	 * @author ashuk
	 */
	public void visit(Declaration decl);
	
	
	/**
	 * visit function performs the required action
	 * like increasing count of number of occurences
	 * of given parameter.
	 * 
	 * @param seq Object of Sequence class
	 * 
	 * @author ashuk
	 */
	public void visit(Sequence seq);
	
	
	/**
	 * visit function performs the required action
	 * like increasing count of number of occurences
	 * of given parameter.
	 * 
	 * @param infix Object of InfixExpression class
	 * 
	 * @author ashuk
	 */
	public void visit(InfixExpression infix);
	
	
	/**
	 * visit function performs the required action
	 * like increasing count of number of occurences
	 * of given parameter.
	 * 
	 * @param prefix Object of PrefixExpression class
	 * 
	 * @author ashuk
	 */
	public void visit(PrefixExpression prefix);
	
	
	/**
	 * visit function performs the required action
	 * like increasing count of number of occurences
	 * of given parameter.
	 * 
	 * @param num Object of NumberExpression class
	 * 
	 * @author ashuk
	 */
	public void visit(NumberExpression num);
	
	
	/**
	 * visit function performs the required action
	 * like increasing count of number of occurences
	 * of given parameter.
	 * 
	 * @param var Object of VariableExpression class
	 * 
	 * @author ashuk
	 */
	public void visit(VariableExpression var);
	
	
	/**
	 * visit function performs the required action
	 * like increasing count of number of occurrences
	 * of given parameter.
	 * 
	 * @param str Object of StringExpression class
	 * 
	 * @author ashuk
	 */
	public void visit(StringExpression str);
	
	
	/**
	 * 
	 * @return number of times Assignment object appears 
	 * each time in AST
	 * 
	 * @author ashuk
	 */
	public int getAssignmentCount();

	/**
	 * @author ashuk
	 * 
	 * @return number of times Declaration object appears 
	 * each time in AST
	 */
	public int getDeclarationCount();

	/**
	 * 
	 * @return number of times Sequence object appears 
	 * each time in AST
	 * 
	 * @author ashuk
	 */
	public int getSequenceCount();

	/**
	 * 
	 * @return number of times InfixExpression object appears 
	 * each time in AST
	 * 
	 * @author ashuk
	 */
	public int getInfixExpressionCount();

	/**
	 * 
	 * @return number of times PrefixExpression object appears 
	 * each time in AST
	 * 
	 * @author ashuk
	 */
	public int getPrefixExpressionCount();

	/**
	 * 
	 * @return number of times NumberExpression object appears 
	 * each time in AST
	 * 
	 * @author ashuk
	 */
	public int getNumberExpressionCount();

	/**
	 * 
	 * @return number of times VariableExpression object appears 
	 * each time in AST
	 * 
	 * @author ashuk
	 */
	public int getVariableExpressionCount();

	/**
	 * 
	 * @return number of times StringExpression object appears 
	 * each time in AST
	 * 
	 * @author ashuk
	 */
	public int getStringExpressionCount();
}
