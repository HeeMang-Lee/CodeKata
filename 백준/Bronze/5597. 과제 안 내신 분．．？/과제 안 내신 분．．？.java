import java.util.*;

public class Main {
    public static void main(String[] args) {
    Set<Integer> allNumbers = new LinkedHashSet<>();
        for (int i = 1; i <= 30; i++) {
            allNumbers.add(i);
        }

        Scanner scanner = new Scanner(System.in);

        // 28명 입력받아서 제거
        for (int i = 0; i < 28; i++) {
            int num = scanner.nextInt();
            allNumbers.remove(num);
        }

        scanner.close();

        for (int num : allNumbers) {
            System.out.println(num);
        }
    }
}
