import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class byteinputstream {
	public static void main(String[] args) {
		private String data1 = "hi java world";
		private void read1() {
			try(InputStream input = new ByteArrayInputStream(data1.getBytes())){
				int read = -1;
				while((read = input.read()) != -1) {
					System.out.printf("읽은 값: %d, 문자로: %c%n",read , read);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
