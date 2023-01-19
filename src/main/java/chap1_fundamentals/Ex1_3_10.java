package chap1_fundamentals;

import utils.StdOut;

public class Ex1_3_10 {

    public static String infixToPostfix(String s) {
        String[] expr = s.split("\\s");
        StackLinkedList<String> operands = new StackLinkedList<>();
        StackLinkedList<String> operators = new StackLinkedList<>();
        for (int i = 0; i < expr.length; i++) {
            if (expr[i].equals(")")) {
                String y = operands.pop();
                String x = operands.pop();
                String op = operators.pop();
                operands.push(x + " " + y + " " + op);
            } else if (expr[i].equals("+") || expr[i].equals("-") || expr[i].equals("*") || expr[i].equals("/")) {
                operators.push(expr[i]);
            } else if (expr[i].equals("(")) {
                // do nothing
            } else {
                operands.push(expr[i]);
            }
        }

        return operands.pop();
    }

    public static void main(String[] args) {
        String s = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";
        StdOut.println(infixToPostfix(s)); // 1 2 + 3 4 - 5 6 - * *
    }
}
