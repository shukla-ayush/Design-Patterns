package q4bTests;

import static org.junit.Assert.*;

import org.junit.Test;


import q3.Expression;
import q3.NumberExpression;

/**
 * StringExpressionTest tests the functioning of
 * StringExpression class 
 * 
 * @author ashuk
 */
public class NumberExpressionTest {

	/**
	 * numberExpressionClassTest tests the functioning of
	 * NumberExpression class' textRepresentation
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void numberExpressionClassTest() {
		Expression one = new NumberExpression(1);
		assertEquals("1", one.textRepresentation());
	}

	
}
