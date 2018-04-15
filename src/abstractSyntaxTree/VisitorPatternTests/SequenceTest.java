package q4bTests;

import static org.junit.Assert.*;

import org.junit.Test;

import q3.Assignment;
import q3.Declaration;
import q3.Expression;
import q3.InfixExpression;
import q3.NumberExpression;
import q3.Operator;
import q3.Sequence;
import q3.Variable;
import q3.Statement;
import q3.VariableExpression;
import q3.PrefixExpression;

/**
 * SequenceTest tests the functioning of
 * Sequence class 
 * 
 * @author ashuk
 * 
 */
public class SequenceTest {

	/**
	 * sequenceClassTest tests the functioning of
	 * Sequence class' textRepresentation
 	 * 
 	 * @return void
 	 * 
     * @author ashuk
	 */
	@Test
	public void sequenceClassTest() {
		Variable x = new Variable("x");
		Expression one = new NumberExpression(1);
		Expression three = new NumberExpression(3);
		Operator plus = new Operator("+");
		InfixExpression exp = new InfixExpression(plus, one, three);
		Declaration decl = new Declaration(x);
		Assignment assign = new Assignment(x, exp);
		Sequence seq = new Sequence(decl, assign);
		assertEquals("var x; x = 1 + 3;", seq.textRepresentation());
	}
	
	
	/**
	 * Test for changed order of sequence
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void testOrderOfSequence() {
		Variable x1 = new Variable("x");
		Variable x2 = new Variable("y");
		Variable x3 = new Variable("z");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Expression varx = new VariableExpression(x1);
		Operator plus = new Operator("+");
		Expression e = new InfixExpression(plus,varx,two);
		Statement decl1 = new Declaration(x1);
		Statement decl2 = new Declaration(x2);
		Statement decl3 = new Declaration(x3);
		Statement assign1 = new Assignment(x1, one);
		Statement assign2 = new Assignment(x2, e);
		Statement seq = new Sequence(decl1, decl2, assign1, assign2, decl3);
		assertEquals("var x; var y; x = 1; y = x + 2; var z;", seq.textRepresentation());
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

}
