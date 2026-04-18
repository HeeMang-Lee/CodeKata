import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Map<Character, char[]> tree = new HashMap<>();
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i =  0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            tree.put(a,new char[]{b,c});
        }
        preorder('A');
        sb.append('\n');
        inorder('A');
        sb.append('\n');
        postorder('A');
        sb.append('\n');
        
        System.out.print(sb);
    }
    
    public static void preorder(char node) {
        if (node == '.') return;
        sb.append(node);
        preorder(tree.get(node)[0]);
        preorder(tree.get(node)[1]);
    }
    
    public static void inorder(char node) {
        if (node == '.') return;
        inorder(tree.get(node)[0]);
        sb.append(node);
        inorder(tree.get(node)[1]);
    }
    
    public static void postorder(char node) {
        if (node == '.') return;
        postorder(tree.get(node)[0]);
        postorder(tree.get(node)[1]);
        sb.append(node);
    }
}