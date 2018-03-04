package tests2;

import ast2.Expression;
import ast2.Operator;
import ast2.Statement;
import ast2.Variable;
import ast2.NodeFactory;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * This class tests the various nodes,
 * (expressions and statements) and also checks 
 * if factory methods returns desired objects.
 * @author ashuk
 *
 */

public class AST2Tests {

	/**
	 * Standard given Test
	 */
	@Test 
	public void standardTest(){
		NodeFactory n = new NodeFactory();
		Variable x = new Variable("x");
		Expression one = n.createNumberExpression(1);
		Expression two = n.createNumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp = n.createInfixExpression(plus, one, two);
		Statement decl = n.createDeclaration(x);
		Statement assign = n.createAssignment(x, exp);
		Statement seq = n.createSequence(decl, assign);
		assertEquals("var x; x = 1 + 2;", seq.textRepresentation());	
	}
	
	/**
	 * To test Object of NumberExpression class
	 */
	@Test
	public void testObjectOfNumberExpression(){
		NodeFactory n = new NodeFactory();
		Expression two = n.createNumberExpression(2);
		assertEquals("ast2.NumberExpression", two.getClass().getName());	
	}
	
	/**
	 * To test Object of VariableExpression class
	 */
	@Test
	public void testObjectOfVariableExpression(){
		NodeFactory n = new NodeFactory();
		Variable x = new Variable("x");
		Expression varx = n.createVariableExpression(x);
		assertEquals("ast2.VariableExpression", varx.getClass().getName());	
	}
	
	/**
	 * To test Object of StringExpression class
	 */
	@Test
	public void testObjectOfStringExpression(){
		NodeFactory n = new NodeFactory();
		Expression str = n.createStringExpression("Hello");
		assertEquals("ast2.StringExpression", str.getClass().getName());	
	}
	
	/** 
	 * To test object of InfixExpression class
	 */
	@Test
	public void testObjectOfInfixExpression(){
		NodeFactory n = new NodeFactory();
		Expression one = n.createNumberExpression(1);
		Expression two = n.createNumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp = n.createInfixExpression(plus, one, two);
		assertEquals("ast2.InfixExpression", exp.getClass().getName());	
	}
	
	/**
	 * To test Object of PrefixExpression class
	 */
	@Test
	public void testObjectOfPrefixExpression(){
		NodeFactory n = new NodeFactory();
		Expression one = n.createNumberExpression(1);
		Expression two = n.createNumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp = n.createPrefixExpression(plus, one, two);
		assertEquals("ast2.PrefixExpression", exp.getClass().getName());	
	}
	
	/**
	 * To test object of Assignment class
	 */
	@Test
	public void testObjectOfAssignment(){
		NodeFactory n = new NodeFactory();
		Variable x = new Variable("x");
		Operator plus = new Operator("+");
		Expression one = n.createNumberExpression(1);
		Expression two = n.createNumberExpression(2);
		Expression exp = n.createPrefixExpression(plus, one, two);
		Statement assign = n.createAssignment(x, exp);
		assertEquals("ast2.Assignment", assign.getClass().getName());	
	}
	
	/**
	 * To test object of Declaration class
	 */
	@Test
	public void testObjectOfDeclaration(){
		NodeFactory n = new NodeFactory();
		Variable x = new Variable("x");
		Statement decl = n.createDeclaration(x);
		assertEquals("ast2.Declaration", decl.getClass().getName());	
	}
	
	/**
	 * To test object of sequence class
	 */
	@Test
	public void testObjectOfSequence(){
		NodeFactory n = new NodeFactory();
		Variable x = new Variable("x");
		Expression one = n.createNumberExpression(1);
		Expression two = n.createNumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp = n.createInfixExpression(plus, one, two);
		Statement decl = n.createDeclaration(x);
		Statement assign = n.createAssignment(x, exp);
		Statement seq = n.createSequence(decl, assign);
		assertEquals("ast2.Sequence", seq.getClass().getName());	
	}
	
	/**
	 * Test for Prefix Expressions
	 */
	@Test
	public void testPrefix() {
		NodeFactory n2 = new NodeFactory();
		Variable x1 = new Variable("x");
		Variable x2 = new Variable("y");
		Expression one = n2.createNumberExpression(1);
		Expression two = n2.createNumberExpression(2);
		Expression varx = n2.createVariableExpression(x1);
		Operator plus = new Operator("+");
		Expression e = n2.createPrefixExpression(plus,varx,two);
		Statement decl1 = n2.createDeclaration(x1);
		Statement decl2 = n2.createDeclaration(x2);
		Statement assign1 = n2.createAssignment(x1, one);
		Statement assign2 = n2.createAssignment(x2, e);
		Statement seq = n2.createSequence(decl1, decl2, assign1, assign2);
		assertEquals("var x; var y; x = 1; y = + x 2;", seq.textRepresentation());
	}
	
	/**
	 * Test for changed order of sequence
	 */
	@Test
	public void testOrderOfSequence() {
		NodeFactory n3 = new NodeFactory();
		Variable x1 = new Variable("x");
		Variable x2 = new Variable("y");
		Variable x3 = new Variable("z");
		Expression one = n3.createNumberExpression(1);
		Expression two = n3.createNumberExpression(2);
		Expression varx = n3.createVariableExpression(x1);
		Operator plus = new Operator("+");
		Expression e = n3.createInfixExpression(plus,varx,two);
		Statement decl1 = n3.createDeclaration(x1);
		Statement decl2 = n3.createDeclaration(x2);
		Statement decl3 = n3.createDeclaration(x3);
		Statement assign1 = n3.createAssignment(x1, one);
		Statement assign2 = n3.createAssignment(x2, e);
		Statement seq = n3.createSequence(decl1, decl2, assign1, assign2, decl3);
		assertEquals("var x; var y; x = 1; y = x + 2; var z;", seq.textRepresentation());
	}
	
	/**
	 * Test for expressions within expressions
	 */
	@Test
	public void testNestedExpression() {
		NodeFactory n4 = new NodeFactory();
		Variable x1 = new Variable("x");
		Variable x2 = new Variable("y");
		Variable x3 = new Variable("z");
		Expression one = n4.createNumberExpression(1);
		Expression two = n4.createNumberExpression(2);
		Expression varx = n4.createVariableExpression(x1);
		Expression vary = n4.createVariableExpression(x2);
		Operator plus = new Operator("+");
		Operator minus = new Operator("-");
		Expression e = n4.createPrefixExpression(plus,varx,vary);
		Expression e1 = n4.createInfixExpression(minus, varx, vary);
		Expression e2 = n4.createPrefixExpression(minus, one, two);
		Expression e3 = n4.createInfixExpression(plus, e1, e2);
		Statement decl1 = n4.createDeclaration(x1);
		Statement decl2 = n4.createDeclaration(x2);
		Statement decl3 = n4.createDeclaration(x3);
		Statement assign1 = n4.createAssignment(x1, one);
		Statement assign2 = n4.createAssignment(x2, e);
		Statement assign3 = n4.createAssignment(x3, e3);
		Statement seq = n4.createSequence(decl1, decl2, decl3, assign1, assign2, assign3);
		assertEquals("var x; var y; var z; x = 1; y = + x y; z = x - y + - 1 2;", seq.textRepresentation());
	}

	/**
	 * Test for expression within prefix expressions
	 */
	@Test
	public void testExpressionWithinPrefix() {
		NodeFactory n5 = new NodeFactory();
		Variable x1 = new Variable("x");
		Variable x2 = new Variable("y");
		Variable x3 = new Variable("z");
		Expression one = n5.createNumberExpression(1);
		Expression varx = n5.createVariableExpression(x1);
		Expression vary = n5.createVariableExpression(x2);
		Operator plus = new Operator("+");
		Expression e = n5.createPrefixExpression(plus,varx,vary);
		Statement decl1 = n5.createDeclaration(x1);
		Statement decl2 = n5.createDeclaration(x2);
		Statement decl3 = n5.createDeclaration(x3);
		Statement assign1 = n5.createAssignment(x1, one);
		Statement assign2 = n5.createAssignment(x2, e);
		Statement seq = n5.createSequence(decl1, decl2, decl3, assign1, assign2);
		assertEquals("var x; var y; var z; x = 1; y = + x y;", seq.textRepresentation());
	}
	
	/**
	 * Test for String expression
	 */
	@Test
	public void testString() {
		NodeFactory n6 = new NodeFactory();
		Variable x1 = new Variable("x");
		Variable x2 = new Variable("y");
		Variable x3 = new Variable("z");
		Expression one = n6.createNumberExpression(1);
		Expression two = n6.createNumberExpression(2);
		Expression abc = n6.createStringExpression("abc");
		Expression varx = n6.createVariableExpression(x1);
		Expression vary = n6.createVariableExpression(x2);
		Operator plus = new Operator("+");
		Operator minus = new Operator("-");
		Expression e = n6.createPrefixExpression(plus,varx,vary);
		Expression e1 = n6.createInfixExpression(minus, varx, vary);
		Expression e2 = n6.createPrefixExpression(minus, one, two);
		Expression e3 = n6.createInfixExpression(plus, e1, e2);
		Statement decl1 = n6.createDeclaration(x1);
		Statement decl2 = n6.createDeclaration(x2);
		Statement decl3 = n6.createDeclaration(x3);
		Statement assign1 = n6.createAssignment(x1, one);
		Statement assign2 = n6.createAssignment(x2, e);
		Statement assign3 = n6.createAssignment(x3, e3);
		Statement assign4 = n6.createAssignment(x3, abc);
		Statement seq = n6.createSequence(decl1, decl2, decl3, assign1, assign2, assign3, assign4);
		assertEquals("var x; var y; var z; x = 1; y = + x y; z = x - y + - 1 2; z = abc;", seq.textRepresentation());
	}
	
	/**
	 * Test for consecutive prefix expressions
	 */
	@Test
	public void testConsecutivePrefix() {
		NodeFactory n7 = new NodeFactory();
		Variable x = new Variable("x");
		Expression twentyFour = n7.createNumberExpression(24);
		Expression two = n7.createNumberExpression(2);
		Expression twelve = n7.createNumberExpression(12);
		Operator multiply = new Operator("*");
		Operator divide = new Operator("/");
		Expression exp1 = n7.createPrefixExpression(multiply, twentyFour, two);
		Expression exp2 = n7.createPrefixExpression(divide, exp1, twelve);
		Statement decl = n7.createDeclaration(x);
		Statement assign = n7.createAssignment(x, exp2);
		Statement seq = n7.createSequence(decl, assign);
		assertEquals("var x; x = / * 24 2 12;", seq.textRepresentation());
	}
	
	/**
	 * Test for all the nodes
	 */
	@Test
	public void testallNodes() {
		NodeFactory n8 = new NodeFactory();
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Variable z = new Variable("z");
		Expression ten = n8.createNumberExpression(10);
		Expression five = n8.createNumberExpression(5);
		Expression hundered = n8.createNumberExpression(100);
		Expression vary = n8.createVariableExpression(y);
		Expression varz = n8.createVariableExpression(z);
		Operator plus = new Operator("+");
		Operator minus = new Operator("-");
		Operator multiply = new Operator("*");
		Operator modulus = new Operator("%");
		Expression theta = n8.createStringExpression("theta");
		Expression exp1 = n8.createInfixExpression(modulus, hundered, ten);
		Expression exp2 = n8.createPrefixExpression(minus, vary, varz);
		Expression exp3 = n8.createPrefixExpression(multiply, five, ten);
		Expression exp4 = n8.createInfixExpression(plus, exp1, exp2);
		Expression exp5 = n8.createPrefixExpression(plus, exp3, exp4);
		Expression exp6 = n8.createInfixExpression(plus, exp5, theta);
		Statement decl = n8.createDeclaration(x);
		Statement assign = n8.createAssignment(x, exp6);
		Statement seq = n8.createSequence(decl, assign);
		assertEquals("var x; x = + * 5 10 100 % 10 + - y z + theta;", seq.textRepresentation());
	}
	
	/**
     * Test for textRepresentation()
     */
    @Test
    public void testTextRepresentation() {
    	NodeFactory n9 = new NodeFactory();
    	Variable x = new Variable("x");
		Expression one = n9.createNumberExpression(1);
		Expression two = n9.createNumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp1 = n9.createInfixExpression(plus, one, two);
		Expression varx = n9.createVariableExpression(x);
		Expression str = n9.createStringExpression("str");
		Expression e = n9.createPrefixExpression(plus, varx, str); 
		Statement decl = n9.createDeclaration(x);
		Statement assign1 = n9.createAssignment(x, exp1);
		assertEquals("1", one.textRepresentation());
		assertEquals("x", varx.textRepresentation());
		assertEquals("str", str.textRepresentation());
		assertEquals("1 + 2", exp1.textRepresentation());
		assertEquals("+ x str", e.textRepresentation());
		assertEquals("x = 1 + 2;", assign1.textRepresentation());
		assertEquals("var x;", decl.textRepresentation());
    }
}
