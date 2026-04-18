import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); 
        int b = scanner.nextInt();
        if (b >= 45) {
            System.out.println(a + " " + (b - 45));
        } else {
            a = (a == 0) ? 23 : a - 1;
            System.out.println(a + " " + (b + 15));
        }
    }
}

