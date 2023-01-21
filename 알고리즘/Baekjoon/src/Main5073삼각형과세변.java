import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5073삼각형과세변 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){

            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(A == 0 && B == 0 && C == 0) break;

            //모든 변의 길이가 같을 때
            if( A == B && B == C){
                System.out.println("Equilateral");
            }
            //길이가 다를 때
            else {
                //제일 긴 변이 나머지 두변을 더한 것보다 큰지 계산
                int max = Math.max(C,Math.max(A, B));
                int sum = 0;
                if(A==max) sum = B+C;
                else if( B==max) sum = A+C;
                else sum = A+B;
                if( max >= sum ) System.out.println("Invalid");
                // 두변의 길이가 같인지 확인
                else if(A==B || B==C || C==A) System.out.println("Isosceles");
                // 남은 것들은 모두 길이가 다른 것
                else System.out.println("Scalene");
            }
        }
    }
}
