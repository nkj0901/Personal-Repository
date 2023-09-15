package com.ssafy.manager;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Person;

public class PersonManager {
	
	private List<Person> list = new ArrayList<>();
	
	private static PersonManager manager = new PersonManager();
	
	private PersonManager() {
	}
	
	public static PersonManager getInstance() {
		return manager;
	}
	
	//등록
	public void regist(Person p) {
		list.add(p);
	}
	
	//리스트 몽땅
	public List<Person> getLIST(){
		return list;
	}
	
	
}
