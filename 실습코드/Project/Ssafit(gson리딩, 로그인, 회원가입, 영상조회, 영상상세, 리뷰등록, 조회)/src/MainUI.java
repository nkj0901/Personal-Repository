import java.util.Scanner;

public class MainUI {

	Scanner sc = new Scanner(System.in);
	profileUI pu = profileUI.getinstance();
	VideoUI vu = VideoUI.getInstance();

	private MainUI() {
	}

	private static MainUI instance = new MainUI();

	public static MainUI getInstance() {
		return instance;
	}

	public void service() {
		System.out.println("-----------------------------");
		System.out.println("자바로 구현하는 SSAFIT");
		System.out.println("-----------------------------");
		System.out.println("회원가입을 먼저하고 영상정보를 조회해주세요.");
		System.out.println("-----------------------------");
		System.out.println("1. 영상정보\n2. 회원가입\n0. 종료");
		System.out.println("-----------------------------");
		System.out.print("메뉴를 선택하세요 :  ");
		int sel = sc.nextInt();
		if (sel == 1) {
			vu.loginUI();
		} else if (sel == 2) {
			pu.addUI();
		} else {
			System.out.println("종료");
		}
	}
}
