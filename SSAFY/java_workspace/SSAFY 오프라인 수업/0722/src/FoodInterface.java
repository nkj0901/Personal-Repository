import java.util.Scanner;

public class FoodInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FoodManager fm = FoodManager.getInstance();
		int sel;
		do {
			System.out.println("1. 다이어트 식품을 목록에 추가하세요.\n2. 다이어트 식품을 목록에서 삭제하세요.\n3. 다이어트 식품을 다양한 방식으로 조회하세요.\n0. 다이어트 식품 목록 관리 시스템을 종료합니다.");
			sel = sc.nextInt();
			if( sel == 1) {
				System.out.println("다이어트 식품을 추가합니다..");
				System.out.print("제품명 : ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("칼로리 : ");
				int kcal = sc.nextInt();
				System.out.print("탄수화물 : ");
				double carbo = sc.nextDouble();
				System.out.print("단백질 : ");
				double protein = sc.nextDouble();
				System.out.print("지방 : ");
				double fat = sc.nextDouble();
				System.out.print("가격 : ");
				int price = sc.nextInt();
				System.out.print("제조사 : ");
				String maker  = sc.next();
				System.out.print("평점 : ");
				double rate = sc.nextDouble();
				Food food = new Food(name, kcal, carbo, protein, fat, price, maker, rate);
//				movies[size++] = movie;
				fm.add(food);
			} 
			else if (sel == 2){
				System.out.println("다이어트 식품을 삭제합니다.");
				System.out.print("삭제할 다이어트 제품명을 입력하세요 : ");
				sc.nextLine();
				String name = sc.nextLine();
				fm.removeFood(name);
			} 
			else if (sel == 3) {
				System.out.println("다이어트 식품을 조회합니다.");
				System.out.println("1. 칼로리가 낮은순으로 조회합니다. \n2. 가격이 낮은순으로 조회합니다.\n3. 담백질 함량이 높은순으로 조회합니다. \n4. 평점이 높은순으로 조회합니다.");
				int number = sc.nextInt();
				
				if (number == 1) {
					System.out.println("칼로리가 낮은순으로 조회합니다.");
					Food[] fd = fm.sortKcal();
					for (Food f : fd) {
						System.out.println(f.toString());
						}
					}
				else if (number == 2) {
					System.out.println("가격이 낮은순으로 조회합니다.");
					Food[] fd = fm.sortPrice();
					for (Food f : fd) {
						System.out.println(f.toString());
						}
					}
				else if (number == 3) {
					System.out.println("단백질 함량이 높은순으로 조회합니다.");
					Food[] fd = fm.sortProtein();
					for (Food f : fd) {
						System.out.println(f.toString());
						}
					}
				else if (number == 4) {
					System.out.println("평점이 높은순으로 조회합니다.");
					Food[] fd = fm.sortRate();
					for (Food f : fd) {
						System.out.println(f.toString());
						}
					}
				else {
					System.out.println("잘못된 입력입니다.");
					break;
					}
				}
		
	}while(sel!=0);
}}
