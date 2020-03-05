import java.util.concurrent.TimeUnit;

import org.apache.jmeter.protocol.java.sampler.JUnitSampler;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class New_CP_Login_TestScript {
	
	String btnFilterBy = "//a[@class='filter-btn']";
	
	@Test
	public void testLogin() throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "D:\\kiran Software\\selenium software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// Website URL
		driver.get("http://cp5.getenrolled.us/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		// login Details
		/*JUnitSampler junitSampler = new JUnitSampler();
		String UserName = junitSampler.getThreadContext().getVariables().get("username");
		String Password = junitSampler.getThreadContext().getVariables().get("pass");
		String Reportname = junitSampler.getThreadContext().getVariables().get("ReportName");
		String programName = junitSampler.getThreadContext().getVariables().get("ProgramName");
		String projectName = junitSampler.getThreadContext().getVariables().get("projectName");
		//username,pass,ReportName,ProgramName,projectName
		
		driver.findElement(By.id("UserName")).sendKeys(UserName);
		driver.findElement(By.id("Password")).sendKeys(Password);*/
		
		driver.findElement(By.id("UserName")).sendKeys("KaneDom");
		driver.findElement(By.id("Password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
		System.out.println(driver.getCurrentUrl());
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(btnFilterBy))));

		 driver.close();

	}
}
