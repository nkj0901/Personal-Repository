import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class profileimpl {

	Scanner sc = new Scanner(System.in);
	private static profileimpl instance = new profileimpl();
	static List<Profile> plist = new ArrayList<>();

	public void inputData() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("profileinfo.dat"))) {
			plist = (List<Profile>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
		}
	}

	public static profileimpl getinstance() {
		return instance;
	}

	// 회원정보를 볼 수 있는 기능구현
	public void getlist() {
		int i = 1;
		for (Profile P : plist) {
			System.out.print(i++);
			System.out.println(P);
		}
	}

	public void add() {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("profileinfo.dat"));) {
			System.out.print("id를 입력하세요. : ");
			String id = sc.next();
			System.out.print("pw를 입력하세요. : ");
			String pw = sc.next();
			System.out.print("이름을 입력하세요. : ");
			String name = sc.next();
			System.out.print("e-mail을 입력하세요. : ");
			String email = sc.next();
			Profile p = new Profile(id, pw, name, email);
			plist.add(p);
			os.writeObject(plist);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
