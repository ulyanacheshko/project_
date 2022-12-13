package com.src;
import java.util.Objects;
public class Counter {
    public String Calculate(String userArithmeticExpression) {
        String output;

        Finder algebraicFinder = new AlgebraicExpressionFinder(-1);


        String left = algebraicFinder.GroupFind(1,userArithmeticExpression);
        left = normaliseNumber(left);

        String right = algebraicFinder.GroupFind(3,userArithmeticExpression);
        right = normaliseNumber(right);
        if(Objects.equals(algebraicFinder.GroupFind(2,userArithmeticExpression), "^")) output = pow(left,right);
        else if(Objects.equals(algebraicFinder.GroupFind(2,userArithmeticExpression), "*")) output = multiplication(left,right);
        else if(Objects.equals(algebraicFinder.GroupFind(2,userArithmeticExpression), "/")) output = division(left,right);
        else if(Objects.equals(algebraicFinder.GroupFind(2,userArithmeticExpression), "-")) output = residual(left,right);
        else  output = addition(left,right);
        return output;
    }
    private String addition(String left, String right) {
        double result;
        result = Double.parseDouble(left) + Double.parseDouble(right);
        return String.valueOf(result);
    }
    private String residual(String left, String right) {
        double result;
        result = Double.parseDouble(left) - Double.parseDouble(right);
        return String.valueOf(result);
    }
    private String multiplication(String left, String right) {
        double result;
        result = Double.parseDouble(left) * Double.parseDouble(right);
        return String.valueOf(result);
    }
    private String division(String left, String right) {
        double result;
        result = Double.parseDouble(left) / Double.parseDouble(right);
        return String.valueOf(result);
    }
    private String pow(String left, String right) {
        double result;
        result = Math.pow(Double.parseDouble(left), Double.parseDouble(right));
        return String.valueOf(result);
    }
    private String normaliseNumber(String number) {
        boolean ind = false;
        String output = number;
        Finder finder = new SymbolFinder("-");
        while(finder.exists(output)) {
            output = finder.ReplaceFirst(output,"");
            ind = !ind;
        }
        if(ind) output = "-" + output;
        return output;
    }
}
class AlgebraicProcessor {
    private String ProcessAlgebraicExpression(String input) {
        int priority = 2;
        String output = input;
        String expression;
        Counter count = new Counter();
        while(priority >= 0) {
            Finder f = new AlgebraicExpressionFinder(priority);
            while (f.exists(output)) {
                expression = f.FindFirst(output);
                output = f.ReplaceFirst(output, count.Calculate(expression));
            }
            priority = priority - 1;
        }
        return output;
    }
    private String BracketsDelete(String input) {
        String output = input;
        output = output.substring(1,output.length() - 1);
        return output;
    }
    private String ProcessBracketsExpression(String input) {
        String output = input;
        String temp = input;
        String expression;
        Finder bracketsFinder = new BracketsFinder();
        while(bracketsFinder.exists(output)) {
            //temp = output;
            temp = bracketsFinder.FindFirst(output);
            temp = BracketsDelete(temp);
            expression = temp;
            expression = ProcessAlgebraicExpression(expression);
            output = output.replace("(" + temp + ")", expression);
            temp = "";
        }
        return output;
    }
    public String Process(String input) {
        String output = input;
        output = ProcessBracketsExpression(output);
        output = ProcessAlgebraicExpression(output);
        return output;
    }
}