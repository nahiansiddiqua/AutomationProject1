package automationProject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing1 {

	
    WebDriver driver;	
	
	@BeforeTest
	public void init(){
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
     
	}
	
	@Test(priority=2)
	
	public void TestTittle(){
	  String ExpectedTitle = "Swag Labs";
      String ActualTitle = driver.getTitle();
      System.out.println(ActualTitle);
      Assert.assertEquals(ActualTitle, ExpectedTitle, "Title Matched");
		
	}
	
	@Test(priority=1)
	
	public void TestURL(){
		  String ExpectedUrl ="https://www.saucedemo.com/";
	      String ActualUrl = driver.getCurrentUrl();
	      System.out.println(ActualUrl);
	      Assert.assertEquals(ActualUrl, ExpectedUrl, "URL Matched");
			
	}
	
}