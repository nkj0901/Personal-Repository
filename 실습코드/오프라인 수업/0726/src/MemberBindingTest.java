
public class MemberBindingTest {
	public static void main(String[] args) {
		SubClass subClass = new SubClass();
//		System.out.println(subClass.x);//sub
//		subClass.method();//프린트하는 거 였음 오버라이딩한 내용
//		
//		SuperClass superClass = subClass;
//		System.out.println(superClass.x);//super
//		superClass.method();//오버라이딩한 내용
		
		SuperClass superClass = new SubClass();
		System.out.println(superClass);
		
		
		
	}
}
