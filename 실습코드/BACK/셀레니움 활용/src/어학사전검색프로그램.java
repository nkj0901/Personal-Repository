import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class 어학사전검색 {
	public static void main(String[] args) {
		// 입력값 받기
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("입력하세요 : ");
			String word = sc.nextLine();
			
			// 네이버 열기
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.naver.com/");
			
			// 사전으로 들어가기
			WebElement btnDic = driver.findElement(By.cssSelector("#NM_FAVORITE > div.group_nav > ul.list_nav.NM_FAVORITE_LIST > li:nth-child(1) > a"));
			btnDic.click();
			
			// 사전에서 입력창 선택
			WebElement inputSearch = driver.findElement(By.cssSelector("#ac_input"));
			
			// 조건에 따라 사전, 파파고 실행
			
			int wordCnt = word.split(" ").length;
			System.out.println(word + "에 대한 검색중");
			
			if (wordCnt > 1) {
				driver.get("https://papago.naver.com/");
				WebElement textareaSearch = driver.findElement(By.cssSelector("#txtSource"));
				textareaSearch.sendKeys(word);
				textareaSearch.sendKeys(Keys.ENTER);
				try {
		            Thread.sleep(3000);  // 1초 대기한다.
		        } catch (Exception e) {
		        	
		        }
				WebElement txt = driver.findElement(By.cssSelector("#txtTarget > span"));
				System.out.println(txt.getText());
				
			} else {
				inputSearch.sendKeys(word);
				inputSearch.sendKeys(Keys.ENTER);
				List<WebElement> means = driver.findElements(By.cssSelector("#content > div.en_dic_section.search_result.dic_en_entry > dl > dd:nth-child(2)"));
				System.out.println("==============의미===============");
				for (WebElement el : means) {
					System.out.println(el.getText());
				}
				if(means.isEmpty()) {
					System.out.println("결과가 존재하지 않습니다");
						}
				System.out.println("================================");
				}
			driver.close();
			System.out.println("계속하시려면 Y, 그만두시려면  N을 눌러주세요");
			String YN = sc.nextLine().toLowerCase();
			if(YN.equals("n")) {
				System.out.println("종료합니다.");
				break;
			}
			else if(YN.equals("y")) {
				System.out.println("다음 단어를 입력해주세요 :");
				continue;
			}
			else {
				System.out.println("잘못된 입력입니다. 종료합니다");
				break;
			}
		}	
	}
}