//package Preparation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ApparelDesignSoftwareLoginTest {
	
	public static void main(String[]args) throws InterruptedException {
		
		String URL = "https://ecmv3.robo2mation.com/";
		System.setProperty("webdriver.chrome.driver", "D:\\OneDrive - Expo Group, Bangladesh\\Project\\Software\\chromedriver-win64\\chromedriver.exe");
		
		//Handled "Unable to establish websocket connection to http://localhost:64153/devtools/browser/0d3e614d-f9d0-4a22-bb1f-e367f4362b9b" issues
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		//Maximize the browser  
		driver.manage().window().maximize();
		//Redirect browser to the URL
		driver.navigate().to(URL);
		
		//Login Section
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("login_test_user");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("12345678");
		
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		
		// Wait for the login process to complete
		Thread.sleep(2000);
		
		// Verify if the login is successful (checking for the presence of the "Initiated vs My Participated" on the Dashboard page)
		try {
			driver.findElement(By.xpath("//div[@id='workflow-init-vs-com']//h2[1]")).isDisplayed();
			System.out.println("Login Successful!");
		}catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Login Failed!");
		}
	}
}
