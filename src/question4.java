import java.util.Scanner;
import java.util.Stack;

// Question 4: buat mesin yang bisa mengurutkan angka-angka di stack dengan memasukkan di array.
public class question4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input: ");
        String input = scanner.nextLine();
        
        int[] ordered =  orderSyncProtocol(input);

        Stack<Integer> stack = stackingFormatInjection(ordered);

        displaySecretCode(stack);

        scanner.close();
    }

       static int[] orderSyncProtocol(String input) {
        String[] tokens = input.trim().split("\\s+");
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        return numbers;

       }

       static void insertSorted(Stack<Integer> sortedstack, Stack<Integer> tempBuffer, int value) {
            while (!sortedstack.isEmpty() && sortedstack.peek() > value) {
                tempBuffer.push(sortedstack.pop());
            }
            
            sortedstack.push(value);
            
            while (!tempBuffer.isEmpty()) {
                sortedstack.push(tempBuffer.pop());
            }
       }

       static Stack<Integer> stackingFormatInjection(int[] numbers) {
            Stack<Integer> stack = new Stack<>();
            for (int number : numbers)stack.push(number);
            int n = numbers.length;
            int takeCount = 1;
            while (takeCount <= n) {
                int actualTake = Math.min(takeCount, stack.size());
                Stack<Integer> tempPop = new Stack<>();
                for (int i = 0; i < actualTake; i++) {
                    tempPop.push(stack.pop());
                }

               Stack<Integer> sortedStack = new Stack<>();
               Stack<Integer> tempBuffer = new Stack<>();
               while (!tempPop.isEmpty()) {
                    insertSorted(sortedStack, tempBuffer, tempPop.pop());
                }

                Stack<Integer> flipBuffer = new Stack<>();
                while (!sortedStack.isEmpty()) {
                    flipBuffer.push(sortedStack.pop());
                }
                while (!flipBuffer.isEmpty()) {
                    stack.push(flipBuffer.pop());
                }

                takeCount++;
            }
            return stack;
        }
    
    static void displaySecretCode(Stack<Integer> stack) {
        Stack<Integer> tempBuffer = new Stack<>();
        int total = stack.size();

        while(!stack.isEmpty()) {
            tempBuffer.push(stack.pop());
        }

        System.out.println("Output: ");

        for(int i = 0; i < total; i++) {
            int angka = tempBuffer.pop();
            System.out.print(angka);

            if (i == total - 1) {
                System.out.print("");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}