import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();  
        int b = scanner.nextInt();  
        int c = scanner.nextInt();  

        int totalMinutes = a * 60 + b + c; 
        int hour = (totalMinutes / 60) % 24;  
        int minute = totalMinutes % 60;

        System.out.println(hour + " " + minute);
    }
}
