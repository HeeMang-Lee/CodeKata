import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] ball = new int[N];

        for(int num=0; num<M; num++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int k = scanner.nextInt();
            for(int num2=i-1; num2<j; num2++) {
                ball[num2] = k;
            }
        }
        for(int b : ball) {
            System.out.print(b + " ");
        }
        scanner.close();
    }
}
