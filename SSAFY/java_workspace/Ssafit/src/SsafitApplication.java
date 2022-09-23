public class SsafitApplication {
	public static void main(String[] args) {

		MainUI mu = MainUI.getInstance();
		profileimpl ip = profileimpl.getinstance();

		ip.inputData();
		mu.service();

	}

}