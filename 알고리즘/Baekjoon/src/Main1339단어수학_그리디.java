import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1339단어수학_그리디 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new String[N];
        list = new ArrayList<>();
        charCheck = new Boolean[26];
        Arrays.fill(charCheck, false);

        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
            makeList(arr[i]);
        }
        L = list.size();

        check = new Boolean[L];
        Arrays.fill(check, false);
        result = new char[L];
        num = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        ans = 0;
        permutation(0);

        System.out.println(ans);
    }

    static List<Character> list;
    static Boolean[] charCheck;
    static Boolean[] check;
    static char[] result;
    static int L, N;
    static String[] arr;
    static int[] num;
    static int ans;

    private static void permutation(int idx) {
        if(idx == L) {
            ans = Math.max(sum(),ans);
            return;
        }

        for(int i = 0; i < L; i++){
            if(check[i]) continue;
            check[i] = true;
            result[idx] = list.get(i);
            permutation(idx+1);
            check[i] = false;
        }
    }

    private static int sum() {
        int sum = 0;
        for(int i  = 0; i < N; i++){
            String str = arr[i];
            int strSum = 0;
            int multiple = 1;
            for(int j = str.length()-1; j >= 0; j--){
                char c = str.charAt(j);
                for(int z = 0; z < L; z++){
                    if(result[z] == c){
                        strSum+=num[z]*multiple;
                        multiple*=10;
                    }
                }
            }
            sum+=strSum;
        }
        return sum;
    }

    private static void makeList(String a) {
        for(int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            if(charCheck[c-65]) continue;
            charCheck[c-65] = true;
            list.add(c);
        }
    }
}
