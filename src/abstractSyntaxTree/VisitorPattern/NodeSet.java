package q4b;

/**
 * NodeSet class provides object that is a data
 * structure for storing Nodes present in an 
 * AST. It provides features like add, remove,
 * contains, etc on a Node.
 * 
 * @author ashuk
 */
public class NodeSet implements Set<Node>{
	
	/**
	 * Constructor for NodeSet, creates adapter to 
	 * BitVector class' object.
	 * 
     * @author ashuk
	 */
	public NodeSet() {
		adaptee = new BitVector();
	}
	
	
	/**
	 * add a new Node to the NodeSet
	 * 
	 * @param Node n
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Override 
	public void add(Node n){
		int id = n.getId();
		adaptee.set(id);
	}
	
	
	/**
	 * addAll adds all node present in passed
	 * NodeSet to calling NodeSet.
	 * 
	 * @param a set of Node, or NodeSet that
	 * needs to be copied to calling Node.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Override 
	public void addAll(Set<Node> n){
		BitVector b = new BitVector();
		Iterator<Node> nItr = n.iterator();
		while(nItr.hasAnotherElement()) {
			b.set(nItr.nextElement().getId());	
		}
		adaptee.copy(b);
	}
	
	
	/**
	 * remove function removes the
	 * passed Node from NodeSet.
	 * 
	 * @param Node n 
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	@Override 
	public void remove(Node n){
		int id = n.getId();
		adaptee.clear(id);
	}
	
	
	/**
	 * contains check presence of given Node
	 * in NodeSet.
	 * 
	 * @param Node n
	 * 
	 * @return true if Node is found, otherwise
	 * false.
	 * 
	 * @author ashuk
	 */
	@Override 
	public boolean contains(Node n) {
		int id = n.getId();
		return adaptee.get(id);
	}
	
	
	/**
	 * size gives the size of the NodeSet.
	 * 
	 * @return Returns the number of
	 * Nodes present in NodeSet.
	 * 
	 * @author ashuk
	 */
	@Override public int size(){
		return adaptee.size();
	}
	
	
	/**
	 * iterator gives object of NodeSetIterator
	 * class that implements the Iterator.
	 * 
	 * @return returns an object of NodeIterator.
	 *
	 * @author ashuk
	 */
	@Override
	public Iterator<Node> iterator() {
		return new NodeSetIterator();
	}
	
	
	/**
	 * NodeIterator provides object of Iterator type
	 * and implements functions like hasAnotherElement
	 * and nextElement
	 * 
	 * @author ashuk
	 *
	 */
	public class NodeSetIterator implements Iterator<Node>{

		// Adapter to Biterator's iterator
		Iterator<Integer> itr = adaptee.iterator();
		
		
		/**
		 * 
		 * @return boolean value corresponding to 
		 * if there is another Node present in 
		 * NodeSet.
		 * 
		 * @author ashuk
		 */
		@Override
		public boolean hasAnotherElement() {
			return itr.hasAnotherElement();
		}

		
		/**
		 * 
		 * @return Node that occurs next in 
		 * the traversal of the NodeSet.
		 *
		 * @author ashuk
		 */
		@Override
		public Node nextElement() {
			return Node.getNode(itr.nextElement());
		}
		
	}
	
	
	/**
	 * String associated with Object of NodeSet
	 * 
	 * @return Returns a string for object of
	 * NodeSet describing number of objects in
	 * NodeSet.
	 * 
	 * @author ashuk
	 */
	@Override 
	public String toString(){
		return "The NodeSet has: " + this.size() + " number of nodes";
	}
	
	
	// Adapter object for the IBitVector type.
	private IBitVector adaptee;

	
}
