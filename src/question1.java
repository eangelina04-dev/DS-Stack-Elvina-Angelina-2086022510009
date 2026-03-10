import java.util.Scanner;
import java.util.Stack;

// Question 1: Implement a function to check if an input  string of brackets is balanced. A string of brackets is considered balanced if every opening bracket has a corresponding closing bracket of the same type and the brackets are closed in the correct order.
// For example, the string "{[()]}" is balanced, while the string "{[(])}" is not. An empty string is also considered balanced.

public class question1 {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            System.out.println("Current character: " + c);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string of brackets: ");
        String input = scanner.nextLine();
        if (isBalanced(input)) {
            System.out.println("The string is balanced.");
        } else {
            System.out.println("The string is not balanced.");
        }
        scanner.close();
    }
}