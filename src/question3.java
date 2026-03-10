import java.util.Scanner;
import java.util.Stack;

// Question 3: 
public class question3 {
    public static String buildSequence(int v) {
        if (v == 1) return "1";
        if (v % 2 == 0) return buildSequence(v / 2) + "d+";
        return buildSequence(v - 1) + "1+";
    }

    public static int countPluses(String seq) {
        int count = 0;
        for (char c : seq.toCharArray()) {
            if (c == '+') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan input (baris 1: jumlah N, baris 2: target angka):");
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = scanner.nextInt();
        }

        String[] instructions = new String[n];
        int totalPlusesAfter = 0; 

        for (int i = n - 1; i >= 0; i--) {
            int valueToBuild = target[i] + totalPlusesAfter;
            
            String seq = buildSequence(valueToBuild);
            instructions[i] = seq;
            
            totalPlusesAfter += countPluses(seq);
        }

        StringBuilder finalOutput = new StringBuilder();
        for (int i = 0; i < n; i++) {
            finalOutput.append(instructions[i]);
        }

        String answer = finalOutput.toString();
        System.out.println("\nOutput Instruksi:\n" + answer);
        verifyWithStack(answer);
        
        scanner.close();
    }

    public static void verifyWithStack(String instructions) {
        Stack<Integer> stack = new Stack<>();
        
        for (char c : instructions.toCharArray()) {
            if (c == '1') {
                stack.push(1);
            } else if (c == 'd') {
                stack.push(stack.peek());
            } else if (c == '+') {
                int b = stack.pop();
                int a = stack.pop();
                
                Stack<Integer> tempStack = new Stack<>();
                while (!stack.isEmpty()) {
                    int val = stack.pop() - 1;
                    if (val > 0) {
                        tempStack.push(val); 
                    }
                }
                
                while (!tempStack.isEmpty()) {
                    stack.push(tempStack.pop());
                }
                stack.push(a + b);
            }
        }
    }
}