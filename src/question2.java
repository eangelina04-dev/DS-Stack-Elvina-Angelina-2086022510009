import java.util.Scanner;
import java.util.Stack;

// Question 2: write a function, that takes a list of strings tokens representinf an arithemtic expression in Reverse Polish Notation, and returns the value of the expression. 
// Valid operators are +, -, *, and /. Each operand may be an integer and division should truncare toward zero.

public class question2 {
    public static int evaluate_rpn(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of tokens: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        String[] tokens = new String[n];
        System.out.println("Enter the tokens:");
        for (int i = 0; i < n; i++) {
            tokens[i] = scanner.nextLine();
        }
        System.out.println("The value of the expression is: " + evaluate_rpn(tokens));
    }
}
