import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1954 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			int k = N; // �ݺ�Ƚ��
			int first = 0; //�ε������� ���� ��
			int last = N - 1; //�ε������� ���� ��
			int num = 1;
			
			for (int i = 0; i < N; i++) {

				// ��
				for (int j = first; j < k+first; j++) {
					arr[first][j] = num++;
				}
				k--; 
				first++;// last 4; first = 1; k = 4;
				// last = 3; first = 2; k = 2;
				// last = 2; first =3; k=0;
				
				if (k == 0) {
					break;
				}

				// ������
				for (int j =  first; j < k+first; j++) {
					arr[j][last] = num++;
				}
				// last = 4; first = 1; k = 4; 
				// last = 3; first = 2; k = 2;

				// �Ʒ���
				for (int j = last-1; j >= last-k; j--) {
					arr[last][j] = num++;
				}
				k--;// first = 1; last = 4; k = 3
				// last = 3; first = 2; k = 1;

				// ����
				for (int j = last-1; j >= last-k; j--) {
					arr[j][first-1] = num++;
				}
				last--;// first = 1; last = 3; k = 3
				//first = 2; last = 2; k = 1

			}
			bw.write("#" + t);
			bw.newLine();
			for (int j = 0; j < N; j++) {
				for (int x = 0; x < N; x++) {
					bw.write(arr[j][x] + " ");
				}
				bw.newLine();
			}
		}
			bw.flush();
			bw.close();
			br.close();
	}
}
