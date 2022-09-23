import java.util.Scanner;

public class VideoUI {
	Scanner sc = new Scanner(System.in);

	VideoDaoImpl manager = VideoDaoImpl.getInstance();
	MainUI mu = MainUI.getInstance();
	VideoReviewUI ru = VideoReviewUI.getInstance();
	loginimpl li = loginimpl.getinstance();

	private static VideoUI instance = new VideoUI();

	public static VideoUI getInstance() {
		return instance;
	}

	void loginUI() {
		System.out.println("-----------------------------");
		System.out.println("로그인을 해야 영상 목록을 조회할 수 있습니다.");
		System.out.println("-----------------------------");
		li.login();
	}

	void service() {
		MainUI mu = MainUI.getInstance();
		System.out.println("1. 영상목록");
		System.out.println("0. 이전으로");
		System.out.println("-----------------------------");
		System.out.print("메뉴를 선택하세요 : ");
		int sel = sc.nextInt();
		if (sel == 1) {
			listVideo();
		} else {
			mu.service();
		}

	}

	void listVideo() {
		System.out.println("-----------------------------");
		System.out.println("전체 : 8");
		System.out.println("-----------------------------");
		manager.allVideos();
		detailVideo();

	}

	void detailVideo() {
		System.out.println("-----------------------------");
		System.out.println("1. 영상상세");
		System.out.println("0. 이전으로 ");
		System.out.println("-----------------------------");
		System.out.print("메뉴를 선택하세요 : ");
		int sel = sc.nextInt();
		if (sel == 1) {
			ru.detail();
		} else {
			service();
		}
	}
}
