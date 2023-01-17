package chap1_fundamentals;

import utils.StdOut;

// Determine whether given parentheses are balanced.
public class Ex1_3_4 {

    public static boolean isBalanced(String parentheses) {
        StackLinkedList<Character> st = new StackLinkedList<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);
            if (c == '(' || c == '{' || c == '[') st.push(c);
            else {
                if (st.isEmpty()) {
                    return false;
                }
                char last = st.peek();
                if (last == '(' && c == ')' || last == '{' && c == '}' || last == '[' && c == ']') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        StdOut.println(isBalanced("[()]{}{[()()]()}"));
        StdOut.println(isBalanced("[(])"));
        StdOut.println(isBalanced("[(])))"));
        StdOut.println(isBalanced("[(]((()))"));
    }

}
