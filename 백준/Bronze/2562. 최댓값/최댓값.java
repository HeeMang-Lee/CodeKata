import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = Integer.MIN_VALUE; 
        int index = 0;              

        for (int i = 1; i <= 9; i++) {
            int num = scanner.nextInt();
            if (num > max) {
                max = num;
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index);

        scanner.close();
    }
}
