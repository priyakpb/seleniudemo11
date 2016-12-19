package demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DDFdemo {

	// WebDriver driver;

	 
	 public static void main(String[] args) throws IOException {
		
		 WebDriver driver;
		 driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.facebook.com/");
			String [][] data1= GetData.readExcel("TestData", "Data");
			
			for(int i=1 ;i<data1.length;i++){
				
				String username =data1[i][0];
				String password =data1[i][1];
				
				driver.findElement(By.name("email")).sendKeys(username);
				
				driver.findElement(By.name("pass")).sendKeys(password);
				
				driver.findElement(By.id("u_0_l")).click();
				
				System.out.println(driver.findElement(By.xpath("//*[@id='login_form']/div[1]/div[1]")).getText());
				
				driver.navigate().back();
			}
		 
		 
	}
	
	}

