package q4bTests;

import static org.junit.Assert.*;

import org.junit.Test;

import q3.Operator;

/**
 * VariableTest tests the functioning of
 * Variable class 
 * 
 * @author ashuk
 */
public class OperatorTest {

	/**
	 * operatorClassTest tests the functioning of
	 * Operator class' textRepresentation
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 * 
	 */
	@Test
	public void operatorClassTest() {
		Operator x = new Operator("+");
		assertEquals("+",x.textRepresentation());
	}

}
