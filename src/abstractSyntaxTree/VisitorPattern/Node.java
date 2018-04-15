package q4b;

import java.util.NoSuchElementException;

/**
 * A Node represents the entities that are
 * used to model the Abstract Syntax trees.
 * A Node can be an Expression or Statement.
 * All Nodes have a function of 
 * textRepresentation(), which returns the
 * subtree rooted at that Node.
 * 
 * @author ashuk
 *
 */

public abstract class Node {

	// count that acts as ID counter for each Node.
	private static int count = 0;
	
	// Static NodeArray to store Nodes as index's of Id's
	private static Node[] nodeArray;
	
	// index integer
	int c;
	
	
	/**
	 * Returns string representation for each node.
	 */
	public abstract String textRepresentation();
	
	
	/**
	 * Constructor for Node
	 * that increments the counter and assign
	 * values to the Node Array.
	 */
	public Node() {
		count++;
		this.c = count;
		Node[] tempNodeArray = new Node[c];
		for(int i = 0; i < c - 1; i++) {
			tempNodeArray[i] = nodeArray[i];
		}
		
		tempNodeArray[c-1] = this;
		
		nodeArray = new Node[c];
		for(int i = 0; i < c; i++) {
			nodeArray[i] = tempNodeArray[i];
		}
	}
	
	
	/**
	 * Returns unique identifier for each node.
	 * 
	 * @author ashuk
	 */
	public int getId() {
		return c;
	}
	
	
	/**
	 * Reverse mapping from Nodes to their unique identifiers.
	 * 
	 * @param int id, which is Id of a node
	 * 
	 * @return returns Node corresponding to the Id.
	 * 
	 * @author ashuk
	 */
	public static Node getNode(int id) throws NoSuchElementException {
		if(id <= nodeArray.length) {
			return nodeArray[id-1];
		}
        else {
        	throw new NoSuchElementException("No such Node Id exists!");
        }
	}
	
}

