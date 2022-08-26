import java.io.BufferedReader;
import java.io.InputStreamReader;

public class main2751허 {
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	  
	    //가능 범위 만큼 count 배열 생성(중복이 없으므로 boolean)
	    boolean[] cntArr = new boolean[2000001];    
	   
	    //입력 받을 숫자 개수
	    int N = Integer.parseInt(br.readLine());
	    
	    //cntArr의 (입력 받은 숫자 + 최소 가능 수) index를 true로
	    for(int i = 0; i < N; i++) {
	        cntArr[Integer.parseInt(br.readLine()) + 1000000] = true;
	    }
	 
	    //cntArr이 true인 것만 뽑아서
	    for(int i = 0; i < cntArr.length; i++) {
	        if(cntArr[i]) {
	            //index - 최소 가능 수 = 입력받은 수(원래 숫자)
	            //입력받은 수 문자열 append
	            sb.append((i - 1000000)).append('\n');
	        }
	    }
	    //문자열  출력
	    System.out.print(sb);
	}
	
}
