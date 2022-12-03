import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main22864 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); //피로도
		int B = Integer.parseInt(st.nextToken()); //작업량
		int C = Integer.parseInt(st.nextToken()); //-피로도
		int D = Integer.parseInt(st.nextToken()); //Max 피로도
		
		int fatigue = 0;
		int workload = 0;
		for (int i = 0; i < 24; i++) {
			if (fatigue+A <= D){
				fatigue+=A;
				workload+=B;
			} else {
				fatigue-=C;
				if (fatigue < 0) fatigue = 0;
			}
		}
		bw.write(workload+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
