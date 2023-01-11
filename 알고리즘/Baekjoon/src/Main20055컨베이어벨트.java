

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main20055컨베이어벨트 {

	static class Node {
		boolean robot;
		int energy;
		Node(boolean robot, int energy){
			this.robot = robot;
			this.energy = energy;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int len = 2*N;
		List<Node> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < len; i++) {
			list.add(new Node(false, Integer.parseInt(st.nextToken())));
		}

		int cnt = 0;
		int zero = 0;
		loop : while(true) {
			cnt++;

			//회전시키기
			Node n = list.remove(len-1);
			list.add(0, n);

			//끝에 있는거 내리기
			list.get(N-1).robot = false;

			//앞에 비어있으면 로봇 이동
			for(int i = N-2; i >= 0; i--){
				Node cur = list.get(i);
				Node next = list.get(i+1);
				if(cur.robot == true && next.robot == false && next.energy > 0){
					cur.robot = false;
					next.robot = true;
					next.energy--;
					if(next.energy == 0){
						zero++;
					}
				}
			}

			list.get(N-1).robot = false;

			//올리기
			if(list.get(0).energy > 0) {
				list.get(0).robot = true;
				list.get(0).energy--;
				if(list.get(0).energy==0){
					zero++;
				}
			}
			if(zero >= K) break;
		}
		System.out.println(cnt);
	}
}
