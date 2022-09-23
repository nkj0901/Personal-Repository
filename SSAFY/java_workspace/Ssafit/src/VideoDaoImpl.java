import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class VideoDaoImpl {

	Scanner sc = new Scanner(System.in);
	List<Video> vlist = new ArrayList<>();

	List[] reviewIndex = new List[8]; // 리뷰인덱스리스트
	// List<String> reviewList = new ArrayList<>(); // 리뷰내용리스트
	VideoReviewUI ru = VideoReviewUI.getInstance();

	// json 파일 가져오기
	private VideoDaoImpl() {

		Reader reader;
		try {
			reader = new FileReader("video.json");

			Gson gson = new Gson();
			Type listType = new TypeToken<List<Video>>() {
			}.getType();

			vlist = gson.fromJson(reader, listType);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static VideoDaoImpl getInstance() {
		return instance;
	}

	private static VideoDaoImpl instance = new VideoDaoImpl();

	public void allVideos() {
		for (Video m : vlist) {
			System.out.println(m.getNo() + " " + m.getTitle());
		}
	}

	public void detailVideo(int sel) {
		for (int i = 0; i < vlist.size(); i++) {
			if (sel == (vlist.get(i).getNo())) {
				System.out.println(vlist.get(i));
			}
		}

	}

}
