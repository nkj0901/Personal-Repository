import java.io.*;

public class Main10974모든순열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sel = new int[N];
        visited = new boolean[N+1];

        permutation(0);

    }
    static int N;
    static int[] sel;
    static boolean[] visited;

    static void permutation(int idx){

        if(idx == N){
            for(int i = 0; i < N; i++){
                System.out.print(sel[i] + " ");
            }
            System.out.println();
        }

        for(int i = 1; i <= N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            sel[idx] = i;
            permutation(idx+1);
            visited[i] = false;
        }
    }
}
