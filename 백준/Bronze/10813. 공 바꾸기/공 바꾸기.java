import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] ball = new int[N];

        for (int i = 0; i < N; i++) {
            ball[i] = i + 1;
        }

        for(int num=0; num<M; num++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int temp = ball[i - 1];
            ball[i - 1] = ball[j - 1];
            ball[j - 1] = temp;
        }
        for(int b : ball) {
            System.out.print(b + " ");
        }
        scanner.close();
    }
}
