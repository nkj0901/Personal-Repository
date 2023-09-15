import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4179불_bfs {
    static int R, C;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Queue<Node> jq = new LinkedList<>();
        Queue<Node> fq = new LinkedList<>();
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                //지훈, 불 위치 저장
                if (map[i][j] == 'J') jq.add(new Node(i, j));
                else if(map[i][j] == 'F') fq.add(new Node(i, j));
            }
        }


        int curTime = 0;
        while (true) {
            curTime++;

            //불 이동
            int size = fq.size();
            while(size > 0) {
                size--;

                Node n = fq.poll();

                for(int d = 0; d < 4; d++) {
                    int nr = n.r + dr[d];
                    int nc = n.c + dc[d];

                    if(nr >= R || nc >= C || nr < 0 || nc < 0) continue;
                    if(map[nr][nc] != '.') continue;
                    map[nr][nc] = 'F';
                    fq.add(new Node(nr, nc));
                }
            }


            //지훈이 이동
            size = jq.size();
            while(size > 0){
                size--;
                Node n = jq.poll();

                for(int d = 0; d < 4; d++) {
                    int nr = n.r+dr[d];
                    int nc = n.c+dc[d];


                    if(nr >= R || nc >= C || nr < 0 || nc < 0) {
                        System.out.println(curTime);
                        return;
                    }
                    if(map[nr][nc] != '.') continue;
                    map[nr][nc] = 'J';
                    jq.add(new Node(nr, nc));
                }
            }

            if(jq.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }


    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

/*

4 4
####
#JF#
#..#
#..#


// 3

4 4
###F
#J.#
#..#
#..#

//3


4 5
#####
#F#J#
###.#
###.#

// 3


*/


