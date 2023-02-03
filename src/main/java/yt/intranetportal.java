package yt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class intranetportal {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions OP = new ChromeOptions();
		OP.addArguments("headless");

		WebDriver driver = new ChromeDriver(OP);
		driver.manage().window().maximize();
//		driver.get("https://intranet.valuemomentum.biz/Pages/Default.aspx");
		String password = "Passw1rd";
		driver.get("https://hemanthvee:" + password + "@intranet.valuemomentum.biz/");
		driver.findElement(By.xpath("(//*[contains(@class,'additional-background ms-navedit-flyoutArrow')]/span)[8]"))
				.click();

		driver.findElement(By.xpath("(//*[contains(@class,'link-item')]/a)[46]")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath(
				"//*[contains(@id,'ctl00_ctl41_g_e591b96a_b123_43c8_a116_aa6392953194_ctl00_grdReport')]/tbody/tr[1]"))
				.getText());

	}

}
