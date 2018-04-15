package q4bTests;

import static org.junit.Assert.*;

import org.junit.Test;

import q3.Assignment;
import q3.Expression;
import q3.NumberExpression;
import q3.Operator;
import q3.PrefixExpression;
import q3.Sequence;
import q3.Statement;
import q3.VariableExpression;
import q3.Declaration;
import q3.Variable;

/**
 * @author ashuk
 * AssignmentTest tests the functioning of
 * Assignment class 
 * 
 */
public class DeclarationTest {

	/**
	 * declarationClassTest tests the functioning of
	 * Assignment class' textRepresentation
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void declarationClassTest() {
		Variable x = new Variable("x");
		Declaration decl = new Declaration(x);
		assertEquals("var x;", decl.textRepresentation());
	}

	
	/**
	 * declarationSecondaryTest tests the functioning of
	 * Assignment class' textRepresentation
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void declarationSecondaryTest() {
		Variable x1 = new Variable("x");
		Variable x2 = new Variable("y");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Expression varx = new VariableExpression(x1);
		Operator plus = new Operator("+");
		Expression e = new PrefixExpression(plus,varx,two);
		Statement decl1 = new Declaration(x1);
		Statement decl2 = new Declaration(x2);
		Statement assign1 = new Assignment(x1, one);
		Statement assign2 = new Assignment(x2, e);
		Statement seq = new Sequence(decl1, decl2, assign1, assign2);
		assertEquals("var y;", decl2.textRepresentation());
		assertEquals("x = 1;", assign1.textRepresentation());
		assertEquals("var x; var y; x = 1; y = + x 2;", seq.textRepresentation());
	}
}
