package com.ssafy.mvc;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {
	
	@Autowired
	private ServletContext servletContext;
	
	
	@GetMapping("/")
	public String showIndex() {
		return "index";
	}
	
	
	//여러개의 파일을 저장하고 싶다면 여기부터 손을 봐야한다.
	@PostMapping("upload")
	public String upload(MultipartFile upload_file, Model model) {
		
		String uploadPath = servletContext.getRealPath("/file");
		String fileName = upload_file.getOriginalFilename();
		
		File target = new File(uploadPath, fileName);
		
		//만약 file 이라고 하는 경로가 없다면... 만들어주는게 먼저
		if(!new File(uploadPath).exists())
			new File(uploadPath).mkdir();
		
		try {
			FileCopyUtils.copy(upload_file.getBytes(), target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("fileName", fileName);
		
		return "result";
	}
	
	//ModelAndView를 반환하는 형태로도 한번 끄적여 보자!
	
	
	@GetMapping("download")
	public String download(Model model, String fileName) {
		Map<String, Object> fileInfo = new HashMap<>();
		fileInfo.put("fileName", fileName);
		model.addAttribute("downloadFile", fileInfo);
		
		return "fileDownLoadView";
	}
	
	
}
