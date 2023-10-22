import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test {
    public static void main(String[] args) {
        int N = 2;
        int[][] simulation_data = {{0,3},{2,5},{4,2},{5,3}};

        int[] arr = new int[N];
        int next = 0;
        int time = -1;
        int answer = 0;
        loop : while(true){
            time++;
            //상담진행
            for(int i = 0; i < N; i++) {
                arr[i]--;
                if(arr[i] <= 0) {
                System.out.println(Arrays.toString(arr) + " " + time + " " + next + " " + simulation_data[next][0]);
                    //창구가 0이거나 0보다 작으면 넣을 수 있는 사람 넣기
                    if(simulation_data[next][0] <= time) {
                        arr[i] = simulation_data[next][1];
                        if(simulation_data[next][0] < time) answer+=time-simulation_data[next][0];
                        next++;
                    }

                }
            }

                if(next == simulation_data.length) {
                    for(int i = 0; i < N; i++) {
                        if(arr[i] > 0) continue loop;
                    }
                    break;
                }


        }
        System.out.println(answer);
    }
}
