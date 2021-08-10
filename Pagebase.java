package com.spicejet.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Pagebase {
	public static WebDriver driver;
	public static Properties pro;
	
	public Pagebase() throws IOException {	
 pro=new Properties();
FileInputStream file=new FileInputStream("/Users/sumankalyanisahu/eclipse-workspace/SpiceJetTestPOM/src/main/java/com/spicejet/qa/configuration/config.properties");
pro.load(file);
	}
	public void initialization(String browsername, String URL) {
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
			 driver=new ChromeDriver();
		}
		else if (browsername.equals("IE")) {
			System.out.println("we are not supporting IE browser");
			
		}
		else {
			System.out.println("we rae not supporting this browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get(URL);
		
	}
	public void teatDown() {
		driver.quit();
	}
}
