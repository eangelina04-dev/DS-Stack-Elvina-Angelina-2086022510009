import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class question4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input: ");
        String inputLine = scanner.nextLine();
        
        String[] tokens = inputLine.trim().split("\\s+");
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (!token.isEmpty()) {
                stack.push(Integer.parseInt(token));
            }
        }

        int totalElemen = stack.size();

        for (int k = 1; k <= totalElemen; k++) {
            ArrayList<Integer> tempList = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                tempList.add(stack.pop());
            }

            Collections.sort(tempList);

            for (int angka : tempList) {
                stack.push(angka);
            }
        }

        System.out.println("Output: ");
        for (int i = 0; i < totalElemen; i++) {
            System.out.print(stack.get(i) + (i == totalElemen - 1 ? "" : " "));
        }
        System.out.println();

        scanner.close();
    }
}