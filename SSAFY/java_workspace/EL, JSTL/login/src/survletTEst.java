import com.ssafy.person.dto.Person;
import com.ssafy.person.manager.PersonManager;

public class survletTEst {
	public static void main(String[] args) {
		PersonManager pm = PersonManager.getManager();
		int no = 1;
		String name = "nam"; 
		int age = 18;
		String msg = "안녕";		
		Person p = new Person(no, name, age, msg);
		
		pm.addPerson(p);	
		p = new Person(2, "ki", 20, "hi");
		
		pm.addPerson(p);
		
		System.out.println(pm.getList());
		
	}
}
