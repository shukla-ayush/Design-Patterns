package q4bTests;

import static org.junit.Assert.*;

import org.junit.Test;

import q4b.StringExpression;
import q4b.VariableExpression;
import q4b.PrefixExpression;
import q4b.ASTNodeCountVisitor;
import q4b.Assignment;
import q4b.Declaration;
import q4b.InfixExpression;
import q4b.NumberExpression;
import q4b.Operator;
import q4b.Sequence;
import q4b.Variable;

/**
 * @author ashuk
 * This class tests the functions of ASTNodeCountVisitor
 * class which finds number of times each type of node occurs
 * in an AST.
 */
public class ASTNodeCountVisitorTests {

	/**
	 * 
	 * assignmentCountTest function tests the number of times
	 * assignment occurs.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void assignmentCountTest() {
		Variable x = new Variable("x");
		NumberExpression one = new NumberExpression(1);
		NumberExpression three = new NumberExpression(3);
		Operator plus = new Operator("+");
		InfixExpression exp = new InfixExpression(plus, one, three);
		Declaration decl = new Declaration(x);
		Assignment assign = new Assignment(x, exp);
		Sequence seq = new Sequence(decl, assign);
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		seq.accept(v);
		assertEquals(1, v.getAssignmentCount());
	}
	
	
	/**
	 * 
	 * declarationCountTest function tests the number of times
	 * declaration occurs.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void declarationCountTest() {
		Variable x1 = new Variable("x");
		Variable x2 = new Variable("y");
		NumberExpression one = new NumberExpression(1);
		NumberExpression two = new NumberExpression(2);
		VariableExpression varx = new VariableExpression(x1);
		Operator plus = new Operator("+");
		PrefixExpression e = new PrefixExpression(plus,varx,two);
		Declaration decl1 = new Declaration(x1);
		Declaration decl2 = new Declaration(x2);
		Assignment assign1 = new Assignment(x1, one);
		Assignment assign2 = new Assignment(x2, e);
		Sequence seq = new Sequence(decl1, decl2, assign1, assign2);
		assertEquals("x = 1;", assign1.textRepresentation());
		assertEquals("var x; var y; x = 1; y = + x 2;", seq.textRepresentation());
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		seq.accept(v);
		assertEquals(2, v.getDeclarationCount());
	}
	
	
	/**
	 * 
	 * sequenceCountTest function tests the number of times
	 * sequence occurs.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void sequenceCountTest() {
		Variable x1 = new Variable("x");
		Variable x2 = new Variable("y");
		Variable x3 = new Variable("z");
		NumberExpression one = new NumberExpression(1);
		NumberExpression two = new NumberExpression(2);
		VariableExpression varx = new VariableExpression(x1);
		Operator plus = new Operator("+");
		InfixExpression e = new InfixExpression(plus,varx,two);
		Declaration decl1 = new Declaration(x1);
		Declaration decl2 = new Declaration(x2);
		Declaration decl3 = new Declaration(x3);
		Assignment assign1 = new Assignment(x1, one);
		Assignment assign2 = new Assignment(x2, e);
		Sequence seq1 = new Sequence(decl1, decl2, assign1, assign2, decl3);
		Sequence seq2 = new Sequence(decl1, assign1, seq1);
		assertEquals("var x; var y; x = 1; y = x + 2; var z;", seq1.textRepresentation());
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		seq2.accept(v);
		assertEquals(2, v.getSequenceCount());
	}
	
	
	/**
	 * 
	 * numberCountTest function tests the number of times
	 * NumberExpression occurs.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void numberCountTest() {
		Variable x = new Variable("x");
		NumberExpression one = new NumberExpression(1);
		NumberExpression three = new NumberExpression(3);
		Operator plus = new Operator("+");
		InfixExpression exp = new InfixExpression(plus, one, three);
		Declaration decl = new Declaration(x);
		Assignment assign = new Assignment(x, exp);
		Sequence seq = new Sequence(decl, assign);
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		seq.accept(v);
		assertEquals(2, v.getNumberExpressionCount());
	}
	
	
	/**
	 * 
	 * variableCountTest function tests the number of times
	 * VariableExpression occurs.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void variableCountTest() {
		Variable x = new Variable("x");
		NumberExpression one = new NumberExpression(1);
		Operator plus = new Operator("+");
		VariableExpression var = new VariableExpression(x);
		InfixExpression exp = new InfixExpression(plus, one, var);
		Declaration decl = new Declaration(x);
		Assignment assign = new Assignment(x, exp);
		Sequence seq = new Sequence(decl, assign);
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		seq.accept(v);
		assertEquals(1, v.getVariableExpressionCount());
	}
	
	/**
	 * 
	 * stringCountTest function tests the number of times
	 * StringExpression occurs.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void stringCountTest() {
		Variable x1 = new Variable("x");
		Variable x2 = new Variable("y");
		Variable x3 = new Variable("z");
		NumberExpression one = new NumberExpression(1);
		NumberExpression two = new NumberExpression(2);
		StringExpression abc = new StringExpression("abc");
		VariableExpression varx = new VariableExpression(x1);
		VariableExpression vary = new VariableExpression(x2);
		Operator plus = new Operator("+");
		Operator minus = new Operator("-");
		PrefixExpression e = new PrefixExpression(plus,varx,vary);
		InfixExpression e1 = new InfixExpression(minus, varx, vary);
		PrefixExpression e2 = new PrefixExpression(minus, one, two);
		InfixExpression e3 = new InfixExpression(plus, e1, e2);
		Declaration decl1 = new Declaration(x1);
		Declaration decl2 = new Declaration(x2);
		Declaration decl3 = new Declaration(x3);
		Assignment assign1 = new Assignment(x1, one);
		Assignment assign2 = new Assignment(x2, e);
		Assignment assign3 = new Assignment(x3, e3);
		Assignment assign4 = new Assignment(x3, abc);
		Sequence seq = new Sequence(decl1, decl2, decl3, assign1, assign2, assign3, assign4);
		assertEquals("var x; var y; var z; x = 1; y = + x y; z = x - y + - 1 2; z = abc;", seq.textRepresentation());
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		seq.accept(v);
		assertEquals(1, v.getStringExpressionCount());
	}
	
	
	/**
	 * 
	 * infixCountTest function tests the number of times
	 * InfixExpression occurs.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void infixCountTest() {
		Variable x = new Variable("x");
		NumberExpression one = new NumberExpression(1);
		NumberExpression three = new NumberExpression(3);
		Operator plus = new Operator("+");
		InfixExpression exp = new InfixExpression(plus, one, three);
		Declaration decl = new Declaration(x);
		Assignment assign = new Assignment(x, exp);
		Sequence seq = new Sequence(decl, assign);
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		seq.accept(v);
		assertEquals(1, v.getInfixExpressionCount());
	}
	
	
	 /** 
	 * 
	 * prefixCountTest function tests the number of times
	 * PrefixExpression occurs.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void prefixCountTest() {
		Variable x1 = new Variable("x");
		Variable x2 = new Variable("y");
		Variable x3 = new Variable("z");
		NumberExpression one = new NumberExpression(1);
		VariableExpression varx = new VariableExpression(x1);
		VariableExpression vary = new VariableExpression(x2);
		Operator plus = new Operator("+");
		PrefixExpression e = new PrefixExpression(plus,varx,vary);
		Declaration decl1 = new Declaration(x1);
		Declaration decl2 = new Declaration(x2);
		Declaration decl3 = new Declaration(x3);
		Assignment assign1 = new Assignment(x1, one);
		Assignment assign2 = new Assignment(x2, e);
		Sequence seq = new Sequence(decl1, decl2, decl3, assign1, assign2);
		assertEquals("var x;" ,decl1.textRepresentation());
		assertEquals("var x; var y; var z; x = 1; y = + x y;", seq.textRepresentation());
		ASTNodeCountVisitor v = new ASTNodeCountVisitor();
		seq.accept(v);
		assertEquals(1, v.getPrefixExpressionCount());
	}
	
	

}
