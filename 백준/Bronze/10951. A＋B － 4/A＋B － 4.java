import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) { // 입력이 더 있을 동안 계속 반복
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + b);
        }

        scanner.close();
    }
}
