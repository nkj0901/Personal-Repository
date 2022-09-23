package gson;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class gsontest {
	

	Gson gson = new Gson();
		
	class video{
		int no;
		String title;
		String part; 
		String url;
	}
	List<video> videoList = new ArrayList<>();
	FileReader fr = new FileReader("video.json")
	videoList = gson.fromJson(fr, videoList.class);
}
