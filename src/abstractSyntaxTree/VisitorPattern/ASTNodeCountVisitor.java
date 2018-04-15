package q4b;

/**
 * 
 * ASTNodeCountVisitor provides an object of ASTVisitor
 * and provides features of visit for various types of 
 * nodes, that identifies how many times each node
 * occurs in AST.
 * 
 * 
 * @author ashuk
 */
public class ASTNodeCountVisitor implements ASTVisitor{

	int assignCount = 0;
	int declCount = 0;
	int seqCount = 0;
	int infixCount = 0;
	int prefixCount = 0;
	int numCount = 0;
	int varCount = 0;
	int stringCount = 0;
	
	/**
	 * assignCount increases when this visit
	 * function is called.
	 * 
	 * @author ashuk
	 * 
	 * @param assign Object of Assignment class
	 * 
	 * @return void
	 */
	@Override
	public void visit(Assignment assign) {
		assignCount++;
	}

	
	/**
	 * declCount increases when this visit
	 * function is called.
	 * 
	 * @param decl Object of Declaration class
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Override
	public void visit(Declaration decl) {
		declCount++;
	}

	
	/**
	 * seqCount increases when this visit
	 * function is called.
	 * 
	 * @return void
	 * 
	 * @param seq Object of Sequence class
	 * 
	 * @author ashuk
	 */
	@Override
	public void visit(Sequence seq) {
		seqCount++;
	}

	
	/**
	 * @author ashuk
	 * infixCount increases when this visit
	 * function is called.
	 * 
	 * @param infix Object of InfixExpression class
	 * 
	 * @return void
	 */
	@Override
	public void visit(InfixExpression infix) {
		infixCount++;
	}

	
	/**
	 * prefixCount increases when this visit
	 * function is called.
	 * 
	 * @param prefix Object of PrefixExpression class
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Override
	public void visit(PrefixExpression prefix) {
		prefixCount++;
	}

	
	/**
	 * numCount increases when this visit
	 * function is called.
	 * 
	 * @param prefix Object of NumberExpression class
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Override
	public void visit(NumberExpression num) {
		numCount++;
	}

	
	/**
	 * varCount increases when this visit
	 * function is called.
	 * 
	 * @param var Object of VariableExpression class
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Override
	public void visit(VariableExpression var) {
		varCount++;
	}

	
	/**
	 * stringCount increases when this visit
	 * function is called.
	 * 
	 * @param str Object of StringExpression class
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Override
	public void visit(StringExpression str) {
		stringCount++;
	}
	
	
	/**
	 * 
	 * @return assignCount, Count of Assignment node in AST.
	 * 
	 * @author ashuk
	 */
	@Override
	public int getAssignmentCount() {
		return assignCount;
	}

	
	/**
	 * 
	 * @return declCount, Count of Declaration node in AST.
	 * 
	 * @author ashuk
	 */
	@Override
	public int getDeclarationCount() {
		return declCount;
	}

	
	/**
	 * 
	 * @return seqCount, Count of Sequence node in AST.
	 * 
	 * @author ashuk
	 */
	@Override
	public int getSequenceCount() {
		return seqCount;
	}

	
	/**
	 * 
	 * @return infixCount, Count of InfixExpression node in AST.
	 * 
	 * @author ashuk
	 */
	@Override
	public int getInfixExpressionCount() {
		return infixCount;
	}

	
	/**
	 * 
	 * @return prefixCount, Count of PrefixExpression node in AST.
	 * 
	 * @author ashuk
	 */
	@Override
	public int getPrefixExpressionCount() {
		return prefixCount;
	}

	
	/**
	 * 
	 * @return numCount, Count of NumberExpression node in AST.
	 * 
	 * @author ashuk
	 */
	@Override
	public int getNumberExpressionCount() {
		return numCount;
	}

	
	/**
	 * 
	 * @return varCount, Count of VariableExpression node in AST.
	 * 
	 * @author ashuk
	 */
	@Override
	public int getVariableExpressionCount() {
		return varCount;
	}

	
	/**
	 * 
	 * @return strCount, Count of StringExpression node in AST.
	 * 
	 * @author ashuk
	 */
	@Override
	public int getStringExpressionCount() {
		return stringCount;
	}

}
