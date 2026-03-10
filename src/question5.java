import java.util.Scanner;
import java.util.Stack;

// Question 5: buat mesin yang bisa menghitung kapan bom akan dijatuhkan.
public class question5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input: "); 
        if (!scanner.hasNextInt()) {
            System.out.println("Input harus berupa angka!");
            return;
        }
        int n = scanner.nextInt();

        Stack<Integer> momentumStack = new Stack<>();

        int currentMomentum = n;
        
        while (currentMomentum > 0) {
            momentumStack.push(currentMomentum); 
            currentMomentum = currentMomentum / 2; 
        } 

        System.out.println("Output: "); 
        while (!momentumStack.isEmpty()) {
            System.out.print(momentumStack.pop());
            
            if (!momentumStack.isEmpty()) {
                System.out.print(" ");
            }
        }
        System.out.println(); 
        scanner.close();
    }
}