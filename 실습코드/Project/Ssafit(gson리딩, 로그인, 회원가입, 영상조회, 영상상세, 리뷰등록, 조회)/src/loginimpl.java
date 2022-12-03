import java.util.Scanner;

public class loginimpl {
	Scanner sc = new Scanner(System.in);
	profileimpl ip = profileimpl.getinstance();

	static loginimpl instance = new loginimpl();

	static loginimpl getinstance() {
		return instance;
	}

	public void login() {
		VideoUI vu = VideoUI.getInstance();
		MainUI mu = MainUI.getInstance();
		System.out.print("id를 입력하세요 : ");
		String id = sc.next();
		System.out.print("pw를 입력하세요 : ");
		String pw = sc.next();
		int a=0;
		for (int i = 0; i < ip.plist.size(); i++) {
			if (id.equals(ip.plist.get(i).getId()) && pw.equals(ip.plist.get(i).getPw())) {
				System.out.println("로그인이 되었습니다.");
				a = 1;
				vu.service();
			}
		}
		if (a==0) {
			System.out.println("가입을 하지 않은 회원이거나, id와 pw를 잘못 입력했습니다.");
			mu.service();
		}
	}
}
