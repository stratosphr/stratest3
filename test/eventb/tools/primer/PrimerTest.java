package eventb.tools.primer;

import eventb.expressions.FunctionDefinition;
import eventb.expressions.arith.*;
import eventb.expressions.bool.*;
import eventb.expressions.sets.CustomSet;
import eventb.expressions.sets.RangeSet;
import graphs.AbstractState;
import graphs.ConcreteState;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gvoiron on 14/08/16.
 * Time : 11:11
 */
public class PrimerTest {

    @Test
    public void test_visitArithmeticITE() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        ArithmeticITE arithmeticITE = new ArithmeticITE(new Equals(new Variable("v1"), new Variable("v2")), new Subtraction(v1, new Int(3), v2), new Subtraction(v2, functionCall));
        ArithmeticITE arithmeticITEPrimedFalse = new ArithmeticITE(new Equals(v1Primed, v2Primed), new Subtraction(v1Primed, new Int(3), v2Primed), new Subtraction(v2Primed, functionCallPrimedFalse));
        ArithmeticITE arithmeticITEPrimedTrue = new ArithmeticITE(new Equals(v1Primed, v2Primed), new Subtraction(v1Primed, new Int(3), v2Primed), new Subtraction(v2Primed, functionCallPrimedTrue));
        Assert.assertEquals(arithmeticITEPrimedFalse, arithmeticITE.prime());
        Assert.assertEquals(arithmeticITEPrimedTrue, arithmeticITE.prime(true));
    }

    @Test
    public void test_visitFunctionCall() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        Assert.assertEquals(functionCallPrimedFalse, functionCall.prime());
        Assert.assertEquals(functionCallPrimedTrue, functionCall.prime(true));
    }

    @Test
    public void test_visitGreaterOrEqual() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        GreaterOrEqual greaterOrEqual = new GreaterOrEqual(v1, functionCall);
        GreaterOrEqual greaterOrEqualPrimedFalse = new GreaterOrEqual(v1Primed, functionCallPrimedFalse);
        GreaterOrEqual greaterOrEqualPrimedTrue = new GreaterOrEqual(v1Primed, functionCallPrimedTrue);
        Assert.assertEquals(greaterOrEqualPrimedFalse, greaterOrEqual.prime());
        Assert.assertEquals(greaterOrEqualPrimedTrue, greaterOrEqual.prime(true));
    }

    @Test
    public void test_visitGreaterThan() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        GreaterThan greaterThan = new GreaterThan(v1, functionCall);
        GreaterThan greaterThanPrimedFalse = new GreaterThan(v1Primed, functionCallPrimedFalse);
        GreaterThan greaterThanPrimedTrue = new GreaterThan(v1Primed, functionCallPrimedTrue);
        Assert.assertEquals(greaterThanPrimedFalse, greaterThan.prime());
        Assert.assertEquals(greaterThanPrimedTrue, greaterThan.prime(true));
    }

    @Test
    public void test_visitInt() {
        Int fortyTwo = new Int(42);
        Assert.assertEquals(fortyTwo, fortyTwo.prime());
        Assert.assertEquals(fortyTwo, fortyTwo.prime(true));
    }

    @Test
    public void test_visitTrue() {
        True aTrue = new True();
        Assert.assertEquals(aTrue, aTrue.prime());
        Assert.assertEquals(aTrue, aTrue.prime(true));
    }

    @Test
    public void test_visitLowerOrEqual() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        LowerOrEqual lowerOrEqual = new LowerOrEqual(v1, functionCall);
        LowerOrEqual lowerOrEqualPrimedFalse = new LowerOrEqual(v1Primed, functionCallPrimedFalse);
        LowerOrEqual lowerOrEqualPrimedTrue = new LowerOrEqual(v1Primed, functionCallPrimedTrue);
        Assert.assertEquals(lowerOrEqualPrimedFalse, lowerOrEqual.prime());
        Assert.assertEquals(lowerOrEqualPrimedTrue, lowerOrEqual.prime(true));
    }

    @Test
    public void test_visitLowerThan() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        LowerThan lowerThan = new LowerThan(v1, functionCall);
        LowerThan lowerThanFalse = new LowerThan(v1Primed, functionCallPrimedFalse);
        LowerThan lowerThanTrue = new LowerThan(v1Primed, functionCallPrimedTrue);
        Assert.assertEquals(lowerThanFalse, lowerThan.prime());
        Assert.assertEquals(lowerThanTrue, lowerThan.prime(true));
    }

    @Test
    public void test_visitMultiplication() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v3 = new Variable("v3");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        Variable v3Primed = new Variable(v3.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        Multiplication multiplication = new Multiplication(v1, v2, v3, functionCall);
        Multiplication multiplicationPrimedFalse = new Multiplication(v1Primed, v2Primed, v3Primed, functionCallPrimedFalse);
        Multiplication multiplicationPrimedTrue = new Multiplication(v1Primed, v2Primed, v3Primed, functionCallPrimedTrue);
        Assert.assertEquals(multiplicationPrimedFalse, multiplication.prime());
        Assert.assertEquals(multiplicationPrimedTrue, multiplication.prime(true));
    }

    @Test
    public void test_visitSum() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v3 = new Variable("v3");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        Variable v3Primed = new Variable(v3.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        Sum sum = new Sum(v1, v2, v3, functionCall);
        Sum sumPrimedFalse = new Sum(v1Primed, v2Primed, v3Primed, functionCallPrimedFalse);
        Sum sumPrimedTrue = new Sum(v1Primed, v2Primed, v3Primed, functionCallPrimedTrue);
        Assert.assertEquals(sumPrimedFalse, sum.prime());
        Assert.assertEquals(sumPrimedTrue, sum.prime(true));
    }

    @Test
    public void test_visitSubtraction() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v3 = new Variable("v3");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        Variable v3Primed = new Variable(v3.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        Subtraction subtraction = new Subtraction(v1, v2, v3, functionCall);
        Subtraction subtractionPrimedFalse = new Subtraction(v1Primed, v2Primed, v3Primed, functionCallPrimedFalse);
        Subtraction subtractionPrimedTrue = new Subtraction(v1Primed, v2Primed, v3Primed, functionCallPrimedTrue);
        Assert.assertEquals(subtractionPrimedFalse, subtraction.prime());
        Assert.assertEquals(subtractionPrimedTrue, subtraction.prime(true));
    }

    @Test
    public void test_visitVariable() {
        Variable v1 = new Variable("v1");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Assert.assertEquals(v1Primed, v1.prime());
    }

    @Test
    public void test_visitAnd() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v3 = new Variable("v3");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        Variable v3Primed = new Variable(v3.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        And and = new And(new Equals(v1, v2), new Equals(v3, functionCall));
        And andPrimedFalse = new And(new Equals(v1Primed, v2Primed), new Equals(v3Primed, functionCallPrimedFalse));
        And andPrimedTrue = new And(new Equals(v1Primed, v2Primed), new Equals(v3Primed, functionCallPrimedTrue));
        Assert.assertEquals(andPrimedFalse, and.prime());
        Assert.assertEquals(andPrimedTrue, and.prime(true));
    }

    @Test
    public void test_visitOr() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v3 = new Variable("v3");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        Variable v3Primed = new Variable(v3.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        Or or = new Or(new Equals(v1, v2), new Equals(v3, functionCall));
        Or orPrimedFalse = new Or(new Equals(v1Primed, v2Primed), new Equals(v3Primed, functionCallPrimedFalse));
        Or orPrimedTrue = new Or(new Equals(v1Primed, v2Primed), new Equals(v3Primed, functionCallPrimedTrue));
        Assert.assertEquals(orPrimedFalse, or.prime());
        Assert.assertEquals(orPrimedTrue, or.prime(true));
    }

    @Test
    public void test_visitNot() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v3 = new Variable("v3");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        Variable v3Primed = new Variable(v3.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        Not not = new Not(new Equals(v1, new Subtraction(v2, v3, functionCall)));
        Not notPrimedFalse = new Not(new Equals(v1Primed, new Subtraction(v2Primed, v3Primed, functionCallPrimedFalse)));
        Not notPrimedTrue = new Not(new Equals(v1Primed, new Subtraction(v2Primed, v3Primed, functionCallPrimedTrue)));
        Assert.assertEquals(notPrimedFalse, not.prime());
        Assert.assertEquals(notPrimedTrue, not.prime(true));
    }

    @Test
    public void test_visitImplication() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v3 = new Variable("v3");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        Variable v3Primed = new Variable(v3.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        Implication implication = new Implication(new Equals(v1, v2), new Equals(v3, functionCall));
        Implication implicationPrimedFalse = new Implication(new Equals(v1Primed, v2Primed), new Equals(v3Primed, functionCallPrimedFalse));
        Implication implicationPrimedTrue = new Implication(new Equals(v1Primed, v2Primed), new Equals(v3Primed, functionCallPrimedTrue));
        Assert.assertEquals(implicationPrimedFalse, implication.prime());
        Assert.assertEquals(implicationPrimedTrue, implication.prime(true));
    }

    @Test
    public void test_visitEquals() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v3 = new Variable("v3");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        Variable v3Primed = new Variable(v3.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        Equals equals = new Equals(new Subtraction(v1, v2), new Subtraction(functionCall, v3));
        Equals equalsPrimedFalse = new Equals(new Subtraction(v1Primed, v2Primed), new Subtraction(functionCallPrimedFalse, v3Primed));
        Equals equalsPrimedTrue = new Equals(new Subtraction(v1Primed, v2Primed), new Subtraction(functionCallPrimedTrue, v3Primed));
        Assert.assertEquals(equalsPrimedFalse, equals.prime());
        Assert.assertEquals(equalsPrimedTrue, equals.prime(true));
    }

    @Test
    public void test_visitPredicate() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v3 = new Variable("v3");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        Variable v3Primed = new Variable(v3.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        Equals equals = new Equals(new Subtraction(v1, v2), new Subtraction(functionCall, v3));
        Equals equalsPrimedFalse = new Equals(new Subtraction(v1Primed, v2Primed), new Subtraction(functionCallPrimedFalse, v3Primed));
        Equals equalsPrimedTrue = new Equals(new Subtraction(v1Primed, v2Primed), new Subtraction(functionCallPrimedTrue, v3Primed));
        Predicate predicate = new Predicate("p0", equals);
        Predicate predicatePrimedFalse = new Predicate("p0", equalsPrimedFalse);
        Predicate predicatePrimedTrue = new Predicate("p0", equalsPrimedTrue);
        Assert.assertEquals(predicatePrimedFalse, predicate.prime());
        Assert.assertEquals(predicatePrimedTrue, predicate.prime(true));
    }

    @Test
    public void test_visitAbstractState() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v3 = new Variable("v3");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        Variable v3Primed = new Variable(v3.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        Equals equals = new Equals(new Subtraction(v1, v2), new Subtraction(functionCall, v3));
        Equals equalsPrimedFalse = new Equals(new Subtraction(v1Primed, v2Primed), new Subtraction(functionCallPrimedFalse, v3Primed));
        Equals equalsPrimedTrue = new Equals(new Subtraction(v1Primed, v2Primed), new Subtraction(functionCallPrimedTrue, v3Primed));
        AbstractState abstractState = new AbstractState("q0", equals);
        AbstractState abstractStatePrimedFalse = new AbstractState("q0", equalsPrimedFalse);
        AbstractState abstractStatePrimedTrue = new AbstractState("q0", equalsPrimedTrue);
        Assert.assertEquals(abstractStatePrimedFalse, abstractState.prime());
        Assert.assertEquals(abstractStatePrimedTrue, abstractState.prime(true));
    }

    @Test
    public void test_visitConcreteState() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v3 = new Variable("v3");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        Variable v3Primed = new Variable(v3.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        Equals equals = new Equals(new Subtraction(v1, v2), new Subtraction(functionCall, v3));
        Equals equalsPrimedFalse = new Equals(new Subtraction(v1Primed, v2Primed), new Subtraction(functionCallPrimedFalse, v3Primed));
        Equals equalsPrimedTrue = new Equals(new Subtraction(v1Primed, v2Primed), new Subtraction(functionCallPrimedTrue, v3Primed));
        ConcreteState concreteState = new ConcreteState("c0", equals);
        ConcreteState concreteStateFalse = new ConcreteState("c0", equalsPrimedFalse);
        ConcreteState concreteStateTrue = new ConcreteState("c0", equalsPrimedTrue);
        Assert.assertEquals(concreteStateFalse, concreteState.prime());
        Assert.assertEquals(concreteStateTrue, concreteState.prime(true));
    }

    @Test
    public void test_visitForAll() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v3 = new Variable("v3");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        Variable v3Primed = new Variable(v3.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        Equals equals = new Equals(new Subtraction(v1, v2), new Subtraction(functionCall, v3));
        Equals equalsPrimedFalse = new Equals(new Subtraction(v1Primed, v2Primed), new Subtraction(functionCallPrimedFalse, v3Primed));
        Equals equalsPrimedTrue = new Equals(new Subtraction(v1Primed, v2Primed), new Subtraction(functionCallPrimedTrue, v3Primed));
        ForAll forAll = new ForAll(equals, v1, v2, v3);
        ForAll forAllPrimedFalse = new ForAll(equalsPrimedFalse, v1, v2, v3);
        ForAll forAllPrimedTrue = new ForAll(equalsPrimedTrue, v1, v2, v3);
        Assert.assertEquals(forAllPrimedFalse, forAll.prime());
        Assert.assertEquals(forAllPrimedTrue, forAll.prime(true));
    }

    @Test
    public void test_visitExists() {
        Variable v1 = new Variable("v1");
        Variable v2 = new Variable("v2");
        Variable v3 = new Variable("v3");
        Variable v1Primed = new Variable(v1.getName() + Primer.getPrimeSuffix());
        Variable v2Primed = new Variable(v2.getName() + Primer.getPrimeSuffix());
        Variable v3Primed = new Variable(v3.getName() + Primer.getPrimeSuffix());
        FunctionDefinition functionDefinition = new FunctionDefinition("fun", new CustomSet(new Int(0), new Int(3), new Int(4)), new RangeSet(new Int(1), new Int(3)));
        FunctionDefinition functionDefinitionPrimed = new FunctionDefinition(functionDefinition.getName() + Primer.getPrimeSuffix(), functionDefinition.getDomain(), functionDefinition.getCoDomain());
        FunctionCall functionCall = new FunctionCall(functionDefinition, v2, v1);
        FunctionCall functionCallPrimedFalse = new FunctionCall(functionDefinitionPrimed, v2, v1);
        FunctionCall functionCallPrimedTrue = new FunctionCall(functionDefinitionPrimed, v2Primed, v1Primed);
        Equals equals = new Equals(new Subtraction(v1, v2), new Subtraction(functionCall, v3));
        Equals equalsPrimedFalse = new Equals(new Subtraction(v1Primed, v2Primed), new Subtraction(functionCallPrimedFalse, v3Primed));
        Equals equalsPrimedTrue = new Equals(new Subtraction(v1Primed, v2Primed), new Subtraction(functionCallPrimedTrue, v3Primed));
        Exists exists = new Exists(equals, v1, v2, v3);
        Exists existsPrimedFalse = new Exists(equalsPrimedFalse, v1, v2, v3);
        Exists existsPrimedTrue = new Exists(equalsPrimedTrue, v1, v2, v3);
        Assert.assertEquals(existsPrimedFalse, exists.prime());
        Assert.assertEquals(existsPrimedTrue, exists.prime(true));
    }

}