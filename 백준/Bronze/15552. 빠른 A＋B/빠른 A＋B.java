import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력하기 위한 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCount; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            bw.write((a + b) + "\n");
        }

        // 출력 스트림 비우기
        bw.flush();
        // 자원 닫기
        bw.close();
        br.close();
    }
}
