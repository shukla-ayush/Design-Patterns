package q4bTests;

import static org.junit.Assert.*;

import org.junit.Test;

import q3.Assignment;
import q3.Declaration;
import q3.InfixExpression;
import q3.Node;
import q3.NodeSet;
import q3.NodeSet.NodeSetIterator;
import q3.NumberExpression;
import q3.Operator;
import q3.Sequence;
import q3.Set;
import q3.Variable;
import q3.Iterator;
import q3.Statement;

/**
 * 
 * @author ashuk
 * NodeSetTests tests the various functions
 * of NodeSet class.
 */
public class NodeSetTests {

	/**
	 * addcontainsTest function tests the
	 * correctness of add method of NodeSet
	 * which adds a Node to NodeSet, and
	 * contains method of NodeSet which checks 
	 * if Node is present in NodeSet.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void addcontainsTest() {
		Set<Node> ns = new NodeSet();
		Variable x = new Variable("x");
		NumberExpression one = new NumberExpression(1);
		NumberExpression three = new NumberExpression(3);
		Operator plus = new Operator("+");
		InfixExpression exp = new InfixExpression(plus, one, three);
		Declaration decl = new Declaration(x);
		Assignment assign = new Assignment(x, exp);
		ns.add(exp);
		ns.add(decl);
		ns.add(assign);
		assertEquals(true, ns.contains(exp));
		assertEquals(false, ns.contains(one));
	}
	
	
	/**
	 * removeTest checks if Node is 
	 * correctly removed from the
	 * NodeSet
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void removeTest() {
		Set<Node> ns = new NodeSet();
		Variable x = new Variable("x");
		NumberExpression one = new NumberExpression(1);
		NumberExpression three = new NumberExpression(3);
		Operator plus = new Operator("+");
		InfixExpression exp = new InfixExpression(plus, one, three);
		Declaration decl = new Declaration(x);
		Assignment assign = new Assignment(x, exp);
		ns.add(exp);
		ns.add(decl);
		ns.add(assign);
		ns.remove(exp);
		assertEquals(false, ns.contains(exp));
		assertEquals(false, ns.contains(one));
	}
	
	
	/**
	 * addAllTest checks if all Nodes are 
	 * correctly added to NodeSet
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void addAllTest() {
		Set<Node> ns1 = new NodeSet();
		Set<Node> ns2 = new NodeSet();
		Variable x = new Variable("x");
		NumberExpression one = new NumberExpression(1);
		NumberExpression three = new NumberExpression(3);
		Operator plus = new Operator("+");
		InfixExpression exp = new InfixExpression(plus, one, three);
		Declaration decl = new Declaration(x);
		Assignment assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		ns1.add(one);
		ns1.add(three);
		ns2.add(exp);
		ns2.add(decl);
		ns2.add(assign);
		ns2.add(seq);
		assertEquals(false, ns2.contains(one));
		ns2.addAll(ns1);
		assertEquals(true, ns2.contains(one));
	}

	

	/**
	 * addAllSizeTest checks if new size
	 * of NodeSet is correct.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void addAllSizeTest() {
		Set<Node> ns1 = new NodeSet();
		Set<Node> ns2 = new NodeSet();
		Variable x = new Variable("x");
		NumberExpression one = new NumberExpression(1);
		NumberExpression three = new NumberExpression(3);
		Operator plus = new Operator("+");
		InfixExpression exp = new InfixExpression(plus, one, three);
		Declaration decl = new Declaration(x);
		Assignment assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		ns1.add(one);
		ns1.add(three);
		ns2.add(exp);
		ns2.add(decl);
		ns2.add(assign);
		ns2.add(seq);
		ns2.addAll(ns1);
		assertEquals(6, ns2.size());
	}
	
	/**
	 * @author ashuk
	 * sizeTest checks the size of the NodeSet
	 * and returns the count of number of nodes 
	 * in it.
	 * 
	 * @return void
	 * 
	 * 
	 * @author ashuk
	 */
	@Test
	public void sizeTest() {
		Set<Node> ns1 = new NodeSet();
		Set<Node> ns2 = new NodeSet();
		Variable x = new Variable("x");
		NumberExpression one = new NumberExpression(1);
		NumberExpression three = new NumberExpression(3);
		Operator plus = new Operator("+");
		InfixExpression exp = new InfixExpression(plus, one, three);
		Declaration decl = new Declaration(x);
		Assignment assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		ns1.add(one);
		ns1.add(three);
		ns2.add(exp);
		ns2.add(decl);
		ns2.add(assign);
		ns2.add(seq);
		assertEquals(2, ns1.size());
		assertEquals(4, ns2.size());
		ns2.addAll(ns1);
		assertEquals(6, ns2.size());
	}
	
	
	/**
	 * iteratorTest is to test if the iterator(), is 
	 * as per the interface requirements and return
	 * an object of NodeIterator class that implements
	 * Iterator interface.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void iteratorTest() {
		Set<Node> ns = new NodeSet();
		Iterator<Node> itr = ns.iterator();
		assertEquals(true, itr instanceof NodeSetIterator);
	}
	
	
	/**
	 * hasAnotherElementTest is to test if the iterator's
	 * hasAnotherElement function, is as 
	 * per the interface requirements and return boolean
	 * value true if NodeSet has more nodes remaining
	 * during traversing.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void hasAnotherElementTest() {
		Set<Node> ns = new NodeSet();
		NumberExpression one = new NumberExpression(1);
		ns.add(one);
		Iterator<Node> itr = ns.iterator();
		assertEquals(true, itr.hasAnotherElement());
		itr.nextElement();
		assertEquals(false, itr.hasAnotherElement());
	}
	
	
	/**
	 * nextElementTest is to test if the iterator's
	 * nextElement function, is as 
	 * per the interface requirements and returns the
	 * correct node while traversing node set.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Test
	public void nextElementTest() {
		Set<Node> ns = new NodeSet();
		NumberExpression one = new NumberExpression(1);
		NumberExpression three = new NumberExpression(3);
		Operator plus = new Operator("+");
		InfixExpression exp = new InfixExpression(plus, one, three);
		ns.add(one);
		ns.add(three);
		ns.add(exp);
		Iterator<Node> itr = ns.iterator();
		Node n1 = itr.nextElement();
		Node n2 = itr.nextElement();
		assertEquals(one, n1);
		assertEquals(three, n2);
	}
	
	
	/**
	 * getIdgetNodeTest function tests the correctness if correct Id
	 * is returned by getId function corresponding to the Node,
	 * and getNode returns correct Node when passed Id.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 * 
	 */
	@Test
	public void getIdgetNodeTest() {
		// As ID are stored as a counter. Their values
		// will be serial.
		NumberExpression one = new NumberExpression(1);
		NumberExpression three = new NumberExpression(3);
		Operator plus = new Operator("+");
		InfixExpression exp = new InfixExpression(plus, one, three);
		int i1 = one.getId();
		int i2 = three.getId();
		int i3 = exp.getId();
		assertEquals(one, Node.getNode(i1));
		assertEquals(three, Node.getNode(i2));
		assertEquals(exp, Node.getNode(i3));
	}
	
	
	
	
}
