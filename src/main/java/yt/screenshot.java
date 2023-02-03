package yt;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions OP = new ChromeOptions();
	   OP.addArguments("headless");
	   WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple iPhone 14 512GB Purple");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		List<WebElement> list = driver.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal"));
	for (WebElement list1 : list) {
	System.out.println(list1.getText());
		if(list1.getText().equals("Apple iPhone 14 Pro 512GB Deep Purple")) {
			System.out.println("hello");
			list1.click();
			break;
		}
		
	}
		
		Set<String> handles = driver.getWindowHandles();
	int hanldnum=	handles.size();
		System.out.println(hanldnum);
		System.out.println(handles);
		
		Iterator<String> it = handles.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
		
		
//		
//		File input =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		
//		File output = new File("C:\\Users\\HemanthKumarVeeravat\\OneDrive - ValueMomentum, Inc\\Desktop\\notepad\\amazon1.png");
//		
//		Files.copy(input, output);
//		Thread.sleep(3000);
//		
		System.out.println("hello121");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span[2]/span[2]/span[2]")).getText());
		driver.findElement(By.id("buy-now-button")).click();
		

	}

}
