package q4bTests;

import static org.junit.Assert.*;

import org.junit.Test;

import q3.Expression;
import q3.Variable;
import q3.VariableExpression;

/**
 * VariableExpressionTest tests the functioning of
 * VariableExpression class 
 * 
 * @author ashuk
 */
public class VariableExpressionTest {

	/**
	 * variableExpressionClassTest tests the functioning of
	 * VariableExpression class' textRepresentation
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void variableExpressionClassTest() {
		Variable x1 = new Variable("x");
		Expression varx = new VariableExpression(x1);
		assertEquals("x", varx.textRepresentation());
	}

}
