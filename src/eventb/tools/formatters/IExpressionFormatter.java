package eventb.tools.formatters;

import eventb.expressions.arith.*;
import eventb.expressions.bool.*;
import graphs.AState;

/**
 * Created by gvoiron on 04/08/16.
 * Time : 13:05
 */
public interface IExpressionFormatter {

    String visit(True aTrue);

    String visit(Not not);

    String visit(And and);

    String visit(Or or);

    String visit(Equals equals);

    String visit(LowerThan lowerThan);

    String visit(LowerOrEqual lowerOrEqual);

    String visit(GreaterThan greaterThan);

    String visit(GreaterOrEqual greaterOrEqual);

    String visit(Implication implication);

    String visit(AState aState);

    String visit(Variable variable);

    String visit(FunctionCall functionCall);

    String visit(Int anInt);

    String visit(Sum sum);

    String visit(Subtraction subtraction);

    String visit(Multiplication multiplication);

    String visit(ArithmeticITE arithmeticITE);

    String visit(ForAll forAll);

    String visit(Exists exists);

    String visit(Predicate predicate);

}
