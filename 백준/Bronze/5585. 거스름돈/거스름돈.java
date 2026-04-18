import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int payMoney = Integer.parseInt(br.readLine());
        int change = 1000 - payMoney;
        int result = 0;
        int[] coins = {500, 100, 50, 10, 5, 1};
        for (int coin : coins) {
            result += change / coin;
            change %= coin;
        }
        
        System.out.print(result);
    }
}