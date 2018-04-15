package ast4;

/**
* Sequence is the class
* that is used for describing 
* the declarations and assignments
* to represent the AST.
* It implements Statement.
* @author ashuk
*
*/

public class Sequence implements Statement{

	// Used so that the first statement can be
	// appended to sequence without blank space 
	// initially.
	int flag = 1; 
	StringBuilder seq = new StringBuilder("");
	
	// Constructor for Sequence
	public Sequence(Statement...statements) {
		for (Statement s: statements) {
			if(flag == 1) {
				seq.append(s.textRepresentation());
				flag = 0;
			}
			else {
				seq.append(" " + s.textRepresentation());
			}
		}
	 
	}
	
	// Returns a String
	// which includes all the declarations and
	// assignments that have been passed to 
	// Sequence to represent the Abstract Syntax
	// Tree.
	// Example:
	// Sequence(decl, assign).textRepresentation() => "var x; x = 1 + 2;"
	// where decl (declaration) is var x,
	// and assign (assignment) is x = 1 + 2
	public String textRepresentation() {
		return seq.toString();
	}
	
}
