package com.ssafy.person.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ssafy.person.dto.Person;

public class PersonManager {
	private List<Person> personList;

	private PersonManager() {
		personList = new ArrayList<Person>();
	}

	private static PersonManager instance = new PersonManager();

	public static PersonManager getManager() {
		return instance;
	}

	// 목록을 조회
	public List<Person> getList() {
		return personList;
	}

	// 번호에 해당하는 사람을 조회
	public Person getPerson(int no) {
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getNo() == no) {
				return personList.get(i);
			}
		}
		return null; // 사용자 정의 오류 넣어도 된다.
	}

	// 사람을 추가
	public void addPerson(Person p) {
		personList.add(p);
		// 중복된 번호가 있거나 나이가 음수이거나 이럴 때 오류 던질 수 있음
	}

	// 사람을 수정
	public void updatePerson(Person p) {
		for (Person person : personList) {
			if (person.getNo() == p.getNo()) {
				person.setAge(p.getAge());
				person.setMsg(p.getMsg());
				person.setName(p.getName());
			}
		}
	}

	// 사람을 삭제
	public void deletePerson(int no) {
		Person p = this.getPerson(no);
		personList.remove(p);
	}
}
