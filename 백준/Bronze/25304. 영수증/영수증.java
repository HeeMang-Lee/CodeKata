import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPrice = scanner.nextInt();
        int testCount = scanner.nextInt();
        int testPrice = 0;

        for (int i = 1; i <= testCount; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            testPrice += a*b;
        }
        System.out.println(totalPrice == testPrice ? "Yes" : "No");
    }
}
