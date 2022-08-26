
public class Food {
	private String name;
	private int kcal;
	private double carbo;
	private double protein;
	private double fat;
	private int price;
	private String maker;
	private double rate;
	
	public Food(String name, int kcal, double carbo, double protein, double fat, int price, String maker, double rate) {
		super();
		this.name = name;
		this.kcal = kcal;
		this.carbo = carbo;
		this.protein = protein;
		this.fat = fat;
		this.price = price;
		this.maker = maker;
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public double getCarbo() {
		return carbo;
	}

	public void setCarbo(double carbo) {
		this.carbo = carbo;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return "이름 : " + this.getName() + "|칼로리 : " + this.getKcal() + "|탄수화물 : " + this.getCarbo()
		+ "%|단백질 : " + this.getProtein() + "%|지방" + this.getFat() + "%|가격 : " + this.getPrice() + "|제조사 : "
		+ this.getMaker() + "|평점 : " + this.getRate();
	}
	
}
