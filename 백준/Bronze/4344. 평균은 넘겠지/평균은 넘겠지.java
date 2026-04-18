import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        double[] answer = new double[testCount];
        for(int i = 0; i < testCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentCount = Integer.parseInt(st.nextToken());
            int[] studentScore  = new int[studentCount];
            int sum = 0;
            for (int j = 0; j < studentCount; j++) {
                studentScore[j] = Integer.parseInt(st.nextToken());
                sum += studentScore[j];
            }
            double avg = (double) sum / studentCount;
            int avgOver = 0;
            for (int j = 0 ; j < studentCount; j++) {
                if(avg < studentScore[j]) avgOver++;
            }
            answer[i] = (double) avgOver / studentCount;
        }
        for (int i = 0 ; i < testCount ; i++) {
            System.out.println(String.format("%.3f%%", answer[i]*100));
        }
    }
}