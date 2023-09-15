import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1935후위표기식2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        double[] arr = new double[26];

        for(int i = 0; i < N; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char c= str.charAt(i);
            if(c == '+') {
                stack.add(stack.pop()+stack.pop());
            } else if(c == '-') {
                double a = stack.pop();
                double b = stack.pop();
                stack.add(b-a);
            } else if(c == '*') {
                stack.add(stack.pop()*stack.pop());
            } else if(c == '/') {
                double a = stack.pop();
                double b = stack.pop();
                stack.add(b/a);
            } else {
                stack.add(arr[c-65]);
            }
        }
        System.out.printf("%.2f",stack.pop());
    }
}
