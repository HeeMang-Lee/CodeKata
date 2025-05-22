import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 스트림
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 스트림
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCount; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            bw.write("Case #" + i + ": " + a + " + " + b + " = " + (a + b) + "\n");
        }

        // 출력 비우고 자원 닫기
        bw.flush();
        bw.close();
        br.close();
    }
}
