package ast4;

/**
 * A Node represents the entities that are
 * used to model the Abstract Syntax trees.
 * A Node can be an Expression or Statement.
 * All Nodes have a function of 
 * textRepresentation(), which returns the
 * subtree rooted at that Node.
 * @author ashuk
 *
 */

public interface Node {

	// Returns the String representation
	// associated with the given Node
	public String textRepresentation();
	
}
