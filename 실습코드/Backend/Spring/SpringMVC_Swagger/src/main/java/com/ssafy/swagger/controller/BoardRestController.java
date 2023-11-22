package com.ssafy.swagger.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.swagger.model.dto.Board;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "게시글")
@RestController
@RequestMapping("/api")
public class BoardRestController {
	
	@ApiOperation(value = "게시글 조회", notes = "전체글을 가져온다.")
	@GetMapping("/board")
	public ResponseEntity<List<Board>> getBoards(String key, String word) {
		return new ResponseEntity<List<Board>>(Arrays.asList(new Board(1, "ssafy", "swagger", "swagger 연습"),
				new Board(2, "ssafy", "swagger", "swagger 연습")), HttpStatus.OK);
	}
}
