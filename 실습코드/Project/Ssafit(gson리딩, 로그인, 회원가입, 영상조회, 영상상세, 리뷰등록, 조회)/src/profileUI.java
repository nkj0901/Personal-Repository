import java.util.Scanner;

public class profileUI {
	Scanner sc = new Scanner(System.in);
	profileimpl ip = profileimpl.getinstance();

	private profileUI() {
	}

	private static profileUI instance = new profileUI();

	public static profileUI getinstance() {
		return instance;
	}

	public void addUI() {
		MainUI mu = MainUI.getInstance();
		System.out.println("-----------------------------");
		System.out.println("회원가입을 진행합니다."); // ui에 넣을 것
		System.out.println("-----------------------------");
		ip.add();
		System.out.println("회원가입이 완료되었습니다."); // ui에 넣을 것
		System.out.println("-----------------------------");
		System.out.println("1. 회원정보 조회\n0. 이전으로 돌아가기");
		System.out.println("-----------------------------");
		System.out.print("메뉴를 선택하세요 :  ");
		int sel = sc.nextInt();
		if (sel == 1) {
			getlistUI();
		} else {
			mu.service();
		}
	}

	public void getlistUI() {
		MainUI mu = MainUI.getInstance();
		System.out.println("-----------------------------");
		System.out.println("회원정보를 조회합니다."); // ui에 넣을 것
		System.out.println("-----------------------------");
		ip.getlist();
		System.out.println("-----------------------------");
		System.out.println("1. 메인화면으로 돌아가기 \n0. 종료");
		System.out.println("-----------------------------");
		int sel = sc.nextInt();
		if (sel == 1) {
			mu.service();
		} else {
			System.out.println("종료");
		}
	}
}
