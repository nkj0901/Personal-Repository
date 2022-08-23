import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main17478 {
	static BufferedWriter bw;
	static int n;
	
	static void under(int N) throws IOException {
		for (int i = 0; i < Math.abs(N-(n+1)); i++) {
			bw.write("____");
		}
	}
	
	static void write(int N) throws IOException {
		if (N == 1) {
			under(N); bw.write("\"재귀함수가 뭔가요?\"");
			bw.newLine();
			under(N); bw.write("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			bw.newLine();
			under(N); bw.write("라고 답변하였지.");
			bw.newLine();
			return;
		}
		under(N);bw.write("\"재귀함수가 뭔가요?\"");
		bw.newLine();
		under(N);bw.write("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		bw.newLine();
		under(N);bw.write("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		bw.newLine();
		under(N); bw.write("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		bw.newLine();
		write(N-1);
		under(N);bw.write("라고 답변하였지.");
		bw.newLine();
		}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		bw.newLine();
		bw.write("\"재귀함수가 뭔가요?\"");
		bw.newLine();
		bw.write("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		bw.newLine();
		bw.write("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		bw.newLine();
		bw.write("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		bw.newLine();
		
		write(n);
		
		bw.write("라고 답변하였지.");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
