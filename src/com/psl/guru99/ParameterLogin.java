package com.psl.guru99;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterLogin {
	
	private static final String ActualStatus = "Manger Id : mngr38718";
	public WebDriver driver;
	public WebDriverWait wait;
	String URL = "http://www.demo.guru99.com/V4/";
	
	ReadTestData rtd = new ReadTestData();
	// Locators
	
	private By userid = By.name("uid");
	private By password = By.name("password");
	private By loginBtn = By.name("btnLogin");
	//private By logoutLnk = By.xpath("html/body/div[2]/div/ul/li[15]/a");
	
	
	@BeforeClass
	public void testSetup(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 15);
	}

	
	@Test(dataProvider="Login")
	public void VerifyLogin(String userName, String passWord){
		driver.get(URL);
		driver.findElement(userid).sendKeys(userName);
		driver.findElement(password).sendKeys(passWord);
		driver.findElement(loginBtn).click();
		
		if (driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).isDisplayed())
		{
			String LogingStatus = driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
			Assert.assertEquals(ActualStatus, LogingStatus);
		}
		else
		{
			Alert alert = driver.switchTo().alert();
			String alertTXT = alert.getText();
			Assert.assertEquals(ActualStatus, alertTXT);
		}
			
	}
	
	@DataProvider(name="Login")
		public Object[][] loginData(){
		
		Object[][] arrayObject = rtd.ReadData("D:\\MyJavaWorkspace\\MyGuru99\\TestData\\LoginData.xls", "Sheet1");
		return arrayObject;
		
	}
	
	
	@Test
	
	public void tearDown(){
		driver.quit();
	}
}
