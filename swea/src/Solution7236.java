import java.util.Scanner;

public class Solution7236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            String[][] arr = new String[n][n];

            for (int i =0; i <n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.next();
                }
            }

            int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
            int[] dc = {-1, 0, 1, 1, 1, 0, -1,-1};

            int max = 0;
            for (int i =0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = 0;
                    for (int z = 0; z<dr.length; z++) {
                        //인덱스니까 n-1까지만 같아야해
                        if(i+dc[z] > -1 && i+dc[z] < n && j+dr[z] > -1 && j+dr[z] < n && arr[i+dc[z]][j+dr[z]].equals("W")) {
                            sum+=1;
                        }
                    }
                    if (max < sum) {
                        max = sum;
                    }
                }
            }
            if (max == 0) {
                max = 1;
            }
            System.out.println("#" + tc + " " + max);
        }
    }// main
}