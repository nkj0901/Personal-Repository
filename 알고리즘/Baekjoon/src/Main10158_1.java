import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10158_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

		x = (x+t)%(w*2);
		y = (y+t)%(h*2);
		
		if (x+t < w) {
			bw.write(x + " ");
		} else {
			bw.write((w*2)-x + " ");
		}
		
		if (y+t < h) {
			bw.write(y+ " ");
		} else {
			bw.write((h*2)-y + " ");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
