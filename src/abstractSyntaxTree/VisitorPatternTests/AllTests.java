package q4bTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AssignmentTest.class, ASTNodeCountVisitorTests.class, DeclarationTest.class, InfixExpressionTest.class,
		NodeSetTests.class, NodeTest.class, NumberExpressionTest.class, OperatorTest.class, PrefixExpressionTest.class,
		SequenceTest.class, StringExpressionTest.class, VariableExpressionTest.class, VariableTest.class })
public class AllTests {

}
