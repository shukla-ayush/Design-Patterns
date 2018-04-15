package q4b;

import q4b.Iterator;


/**
* Sequence is the class
* that is used for describing 
* the declarations and assignments
* to represent the AST.
* It implements Statement.
* 
* @author ashuk
*
*/

public class Sequence extends Statement{

	// Used so that the first statement can be
	// appended to sequence without blank space 
	// initially.
	int flag = 1; 
	StringBuilder seq = new StringBuilder("");
	Sequence se;
	Assignment as;
	Declaration de;
	
	// To store Nodes passed to Sequence
	Set<Node> st = new NodeSet();
	
	
	/**
	 * Constructor for Sequence, that assigns 
	 * all the statements' representation 
	 * to a string.
	 * 
	 * @param statements reprents the various statements
	 * passed
	 * 
	 * @author ashuk
	 */
	public Sequence(Statement...statements) {
		super();
		for (Statement s: statements) {
		
			st.add(s);
			
			if(flag == 1) {
				seq.append(s.textRepresentation());
				flag = 0;
			}
			else {
				seq.append(" " + s.textRepresentation());
			}
		}
		
	}
	
	
	/**
	 * @return Returns a String
	 * which includes all the declarations and
	 * assignments that have been passed to 
	 * Sequence to represent the Abstract Syntax
	 * Tree.
	 * 
	 * Example:
	 * Sequence(decl, assign).textRepresentation() => "var x; x = 1 + 2;"
	 * where decl (declaration) is var x,
	 * and assign (assignment) is x = 1 + 2
	 * 
	 * @author ashuk
	 */
	@Override
	public String textRepresentation() {
		return seq.toString();
	}
	
	
	/**
	 * accept function accepts the visitor v, and
	 * further calls accept function for children 
	 * functions.
	 * 
	 * @param v is the object of ASTVisitor.
	 * 
	 * @return void
	 * 
	 * @author ashuk
	 */
	public void accept(ASTVisitor v) {
		v.visit(this);
		Iterator<Node> itr = st.iterator();
		while(itr.hasAnotherElement()) {
			Node n = itr.nextElement();
			if(n instanceof Sequence) {
				((Sequence) n).accept(v);
			}
			if(n instanceof Declaration) {
				((Declaration) n).accept(v);
			}
			if(n instanceof Assignment) {
				((Assignment) n).accept(v);
			}
		}
	}
	
}
