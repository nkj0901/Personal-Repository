import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VideoReviewUI {

	Scanner sc = new Scanner(System.in);

	private static VideoReviewUI instance = new VideoReviewUI();

	public static VideoReviewUI getInstance() {
		return instance;
	}

	void detail() {
		int cnt = 0;
		MainUI mu = MainUI.getInstance();
		VideoUI vu = VideoUI.getInstance();
		VideoDaoImpl manager = VideoDaoImpl.getInstance();
		System.out.print("영상 번호를 입력하세요 : ");
		int sel = sc.nextInt();
		System.out.println("-----------------------------");
		manager.detailVideo(sel);
		System.out.println("-----------------------------");
		if (manager.reviewIndex[sel - 1] == null) {
			System.out.println("-----------------------------");
			System.out.println("영상 리뷰");
			System.out.println("-----------------------------");
			System.out.println("리뷰가 없습니다.");
		} else {
			cnt = manager.reviewIndex[sel - 1].size();
			System.out.println("-----------------------------");
			System.out.println("영상 리뷰 : " + cnt + "개");
			System.out.println("-----------------------------");
			int k = 0;
			while (cnt-- > 0) {
				System.out.print(manager.reviewIndex[sel - 1].size() - cnt);
				System.out.print(" ");
				System.out.println(manager.reviewIndex[sel - 1].get(k++));
			}
		}
		System.out.println("-----------------------------");
		System.out.println("1. 리뷰등록");
		System.out.println("2. 영상보기");
		System.out.println("0. 이전으로 ");
		System.out.println("-----------------------------");
		System.out.print("메뉴를 선택하세요 : ");
		int sel2 = sc.nextInt();
		if (sel2 == 1) {
			System.out.print("닉네임을 입력하세요 : ");
			String nickname = sc.next();
			sc.nextLine();
			System.out.print("내용을 입력하세요 : ");
			String text = sc.nextLine();

			String sum = nickname + " " + text;
			if (manager.reviewIndex[sel - 1] == null) {
				List<String> list = new ArrayList<>();
				list.add(sum);
				manager.reviewIndex[sel - 1] = list;
				vu.service();
			} else {
				List<String> list = new ArrayList<>();
				list = manager.reviewIndex[sel - 1];
				list.add(sum);
				manager.reviewIndex[sel - 1] = list;
				vu.service();
			}
		}

		else if (sel2 == 2) {
			Browser browser = Browser.getinstance();
			browser.browser(manager.vlist.get(sel - 1).getUrl());
			vu.detailVideo();
		}

		else {
			vu.detailVideo();
		}
	}
}
