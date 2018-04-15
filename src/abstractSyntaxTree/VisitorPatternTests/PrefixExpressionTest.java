package q4bTests;

import static org.junit.Assert.*;

import org.junit.Test;

import q3.Expression;
import q3.NumberExpression;
import q3.Operator;
import q3.PrefixExpression;
import q3.Variable;
import q3.VariableExpression;
import q3.Assignment;
import q3.Declaration;
import q3.InfixExpression;
import q3.Sequence;
import q3.Statement;

/**
 * PrefixExpressionTest tests the functioning of
 * PrefixExpression class 
 * 
 * @author ashuk
 */
public class PrefixExpressionTest {

	/**
	 * prefixExpressionClassTest tests the functioning of
	 * PrefixExpression class' textRepresentation
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void prefixExpressionClassTest() {
		Variable x1 = new Variable("x");
		Expression two = new NumberExpression(2);
		Expression varx = new VariableExpression(x1);
		Operator plus = new Operator("+");
		Expression e = new PrefixExpression(plus,varx,two);
		assertEquals("+ x 2", e.textRepresentation());
	}
	
	/**
	 * Test for expressions within expressions
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void testNestedExpression() {
		Variable x1 = new Variable("x");
		Variable x2 = new Variable("y");
		Variable x3 = new Variable("z");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Expression varx = new VariableExpression(x1);
		Expression vary = new VariableExpression(x2);
		Operator plus = new Operator("+");
		Operator minus = new Operator("-");
		Expression e = new PrefixExpression(plus,varx,vary);
		Expression e1 = new InfixExpression(minus, varx, vary);
		Expression e2 = new PrefixExpression(minus, one, two);
		Expression e3 = new InfixExpression(plus, e1, e2);
		Statement decl1 = new Declaration(x1);
		Statement decl2 = new Declaration(x2);
		Statement decl3 = new Declaration(x3);
		Statement assign1 = new Assignment(x1, one);
		Statement assign2 = new Assignment(x2, e);
		Statement assign3 = new Assignment(x3, e3);
		Statement seq = new Sequence(decl1, decl2, decl3, assign1, assign2, assign3);
		assertEquals("var x; var y; var z; x = 1; y = + x y; z = x - y + - 1 2;", seq.textRepresentation());
	}
	
	
	/**
	 * Test for expression within prefix expressions
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void testExpressionWithinPrefix() {
		Variable x1 = new Variable("x");
		Variable x2 = new Variable("y");
		Variable x3 = new Variable("z");
		Expression one = new NumberExpression(1);
		Expression varx = new VariableExpression(x1);
		Expression vary = new VariableExpression(x2);
		Operator plus = new Operator("+");
		Expression e = new PrefixExpression(plus,varx,vary);
		Statement decl1 = new Declaration(x1);
		Statement decl2 = new Declaration(x2);
		Statement decl3 = new Declaration(x3);
		Statement assign1 = new Assignment(x1, one);
		Statement assign2 = new Assignment(x2, e);
		Statement seq = new Sequence(decl1, decl2, decl3, assign1, assign2);
		assertEquals("var x;" ,decl1.textRepresentation());
		assertEquals("var x; var y; var z; x = 1; y = + x y;", seq.textRepresentation());
	}

}
