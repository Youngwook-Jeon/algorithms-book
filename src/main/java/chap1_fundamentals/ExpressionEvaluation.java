package chap1_fundamentals;

import utils.StdIn;
import utils.StdOut;

import java.util.Stack;

// Find the solution of an arithmetic expression
public class ExpressionEvaluation {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    ops.push(s);
                    break;
                case ")":
                    double val = vals.pop();
                    String op = ops.pop();
                    switch (op) {
                        case "+" -> val = vals.pop() + val;
                        case "-" -> val = vals.pop() - val;
                        case "*" -> val = vals.pop() * val;
                        case "/" -> val = vals.pop() / val;
                    }
                    vals.push(val);
                    break;
                default:
                    vals.push(Double.parseDouble(s));
                    break;
            }
        }
        StdOut.println(vals.pop());
    }
}
