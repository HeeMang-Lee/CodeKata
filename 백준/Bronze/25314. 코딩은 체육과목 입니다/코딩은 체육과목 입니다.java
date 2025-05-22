import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        int test = testCount/4;

        for (int i = 1; i <= test; i++) {
            System.out.print("long ");            
        }
        System.out.println("int");
    }
}
