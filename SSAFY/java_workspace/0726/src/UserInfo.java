
public class UserInfo {
	String name = "홍길동";
	
	@Override
	public String toString() {
		return "이름 : " + this.name;
	}
}

	class MemberInfo extends UserInfo {
	String grade = "정회원";
	
	@Override
	public String toString() {
		return super.toString() + ", 등급: " + grade; 
	}	
}
	