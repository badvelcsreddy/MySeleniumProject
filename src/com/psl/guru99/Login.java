package com.psl.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	
	// my first program
	
	@Test
	public void login()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.findElement(By.name("uid")).sendKeys("mngr38718");
		driver.findElement(By.name("password")).sendKeys("yhuhurE");
		driver.findElement(By.name("btnLogin")).click();
		String LoginStatus = driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
		System.out.println(LoginStatus);
		String Title = driver.getTitle();
		System.out.println(Title);
		
		//String ActualStatus = "Manager Id : mngr38718";
				
		Assert.assertEquals("Manger Id : mngr38718", LoginStatus, "Login is not Successfull");
		driver.quit();
		
	}

}
