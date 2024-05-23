package automationProject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	@Test(priority=3)
	public void testUserNameAndPassword() {
	    // Entering username and password
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    driver.findElement(By.id("login-button")).click();
	    
	    String ExpectedUrl ="https://www.saucedemo.com/inventory.html";
	    String ActualUrl = driver.getCurrentUrl();
	    System.out.println(ActualUrl);
	    Assert.assertEquals(ActualUrl, ExpectedUrl, "Login Successful");
	}
	
	@Test(priority=4)
	public void clickOnInventoryItem() {
		
	    driver.findElement(By.id("item_4_title_link")).click();
	    
	    String ExpectedTittle ="https://www.saucedemo.com/inventory-item.html?id=4";
	    String ActualUrl = driver.getCurrentUrl();
	    System.out.println(ActualUrl);
	    Assert.assertEquals(ActualUrl, ExpectedTittle, "Valid");
	}
	
	@Test(priority = 4)
	public void addItemToCart() {
		
		driver.findElement(By.className("btn")).click();
	    
	    WebElement element = driver.findElement(By.className("btn"));
	    String actualText = element.getText();
	    
	    String expectedText = "Remove";
	
	    Assert.assertEquals(actualText, expectedText, "Button text match expected value.");
	}


}
	
	 

