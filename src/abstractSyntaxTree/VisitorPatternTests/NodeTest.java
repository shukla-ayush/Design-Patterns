package q4bTests;

import static org.junit.Assert.*;

import org.junit.Test;

import q3.NumberExpression;
import q3.Operator;
import q3.Sequence;
import q3.Variable;
import q3.Assignment;
import q3.Declaration;
import q3.Expression;
import q3.InfixExpression;
import q3.Node;

/**
 * 
 * NodeTest class tests the functionality
 * of functions of Node Class
 * 
 * @author ashuk
 */
public class NodeTest {

	/**
	 * nodeTest is to test the getId and
	 * getNode functions of the Node class.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void nodeTest() {
		Variable x = new Variable("x");
		Expression one = new NumberExpression(1);
		Expression three = new NumberExpression(3);
		Operator plus = new Operator("+");
		InfixExpression exp = new InfixExpression(plus, one, three);
		Declaration decl = new Declaration(x);
		Assignment assign = new Assignment(x, exp);
		Sequence seq = new Sequence(decl, assign);
		int i1 = one.getId();
		int i2 = three.getId();
		int i3 = exp.getId();
		int i4 = decl.getId();
		int i5 = assign.getId();
		int i6 = seq.getId();
		assertEquals(Node.getNode(i1), one);
		assertEquals(Node.getNode(i2), three);
		assertEquals(Node.getNode(i3), exp);
		assertEquals(Node.getNode(i4), decl);
		assertEquals(Node.getNode(i5), assign);
		assertEquals(Node.getNode(i6), seq);
	}

}
