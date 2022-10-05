package 템플릿메소드패턴;

public class Persontest {
	 public static void main(String[] args) {
		
		 Person p1 = new Student();
		 Person p2 = new Employee();
		 
		 System.out.println("학생---");
		 p1. daily();
		 System.out.println("직장인---");
		 p2. daily();
	}

}
