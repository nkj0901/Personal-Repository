import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TEST {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://finance.naver.com/");
		
		List<WebElement> news = driver.findElements(By.cssSelector("#content > div.article > div.section > div.news_area > div > ul > li"));
		for( WebElement el : news ) {
			System.out.println(el.getText());
		}
//		WebElement newsBtn = driver.findElement(By.cssSelector("#ac_input"));
//		newsBtn.click();
//		
//		WebElement inputSearch = driver.findElement(By.cssSelector("div._gnb_header_shop_Xd6Hq > div > div._gnbSearch_search_area_3LAyd > form > fieldset > div > input"));
//				System.out.println("검색할 상품: ");
//				inputSearch.sendKeys("갤럭시");
//				inputSearch.sendKeys(Keys.ENTER);
	}
}
