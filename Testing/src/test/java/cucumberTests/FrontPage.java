package cucumberTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrontPage {

	@FindBy(xpath = "//*[@id=\"New Name\"]")
	public WebElement newPlayerName;

	@FindBy(id = "//*[@id=\"Add Player\"]")
	public WebElement newPlayerButton;

	@FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")
	public WebElement topPlayerName;

	@FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/button")
	public WebElement topDelete;

	@FindBy(xpath = "/html/body/div/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr[2]/td[2]")
	public WebElement secondPlayerName;

	public WebElement getPlayerXName(WebDriver driver, int X) {
		return driver.findElement(
				By.xpath("/html/body/div/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr[" + X + "]/td[2]"));
	}

	public void deletePlayerX(WebDriver driver, int X) {
		driver.findElement(
				By.xpath("/html/body/div/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr[" + X + "]/td[5]/button"))
				.click();
	}

	public int noPlayers(WebDriver driver) {
		return driver.findElements(By.xpath("/html/body/div/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody")).size();
	}
	
	public int findMyNumber(WebDriver driver, String name) {
		int i = 1;
		List<WebElement> everyone = driver.findElements(By.xpath("/html/body/div/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody"));
		for (WebElement row : everyone) {
			if (row.getText().contains(name)){
				return i;
			} else {
				i ++;
			}
		}
		return 0;
	}
}
