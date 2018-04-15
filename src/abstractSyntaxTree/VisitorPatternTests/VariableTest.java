package q4bTests;

import static org.junit.Assert.*;

import org.junit.Test;

import q3.Variable;

/**
 * VariableTest tests the functioning of
 * Variable class 
 * 
 * @author ashuk
 * 
 */
public class VariableTest {

	/**
	 * variableClassTest tests the functioning of
	 * Variable class' textRepresentation
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void variableClassTest() {
		Variable x = new Variable("x");
		assertEquals("x", x.textRepresentation());
	}

}
