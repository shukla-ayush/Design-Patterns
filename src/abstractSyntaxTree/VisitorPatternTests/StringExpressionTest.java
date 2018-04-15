package q4bTests;

import static org.junit.Assert.*;

import org.junit.Test;

import q3.Assignment;
import q3.Expression;
import q3.Statement;
import q3.StringExpression;
import q3.Variable;

/**
 * StringExpressionTest tests the functioning of
 * StringExpression class 
 * 
 * 
 * @author ashuk
 * 
 */
public class StringExpressionTest {


	/**
	 * stringExpressionClassTest tests the functioning of
	 * StringExpression class' textRepresentation
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void stringExpressionClassTest() {
		Variable z = new Variable("z");
		Expression abc = new StringExpression("abc");
		Statement assign = new Assignment(z, abc);
		assertEquals("z = abc;",assign.textRepresentation());
	}

}
