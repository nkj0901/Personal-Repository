import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main1043거짓말_그래프 {
    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    list = new List[M];
    check = new boolean[N+1];

    for(int i = 0; i < M; i++){
        list[i] = new ArrayList<>();
    }

    st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());

    for(int i = 0; i < t; i++){
        check[Integer.parseInt(st.nextToken())] = true;
    }

    for(int i = 0; i < M; i++){
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for(int j = 0; j < num; j++){
            list[i].add(Integer.parseInt(st.nextToken()));
        }
    }

    for(int i = 0; i < M; i++){
        for(int j = 0; j < list[i].size(); j++){
            if(check[list[i].get(j)] == true){
                checkTrue(i);
                break;
            }
        }
    }

    int ans = 0;
    loop: for(int i = 0; i < M ;i++){
        for(int j = 0; j < list[i].size(); j++){
            if(check[list[i].get(j)] == true) continue loop;
        }
        ans++;
    }
        System.out.println(ans);
    }

    static boolean[] check;
    static List<Integer>[] list;

    private static void checkTrue(int n) {
        for(int i = 0; i < list[n].size(); i++){
            check[list[n].get(i)] = true;
        }
    }
}
