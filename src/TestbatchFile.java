
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.jmeter.protocol.java.sampler.JUnitSampler;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestbatchFile 
{

	@Test
	public void batchileLogin() throws InterruptedException
	{

		System.setProperty("webdriver.gecko.driver", "D:\\kiran Software\\selenium software\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://beta.wrapportal.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		JUnitSampler junitSampler=new JUnitSampler(); 
		String UserName=junitSampler.getThreadContext().getVariables().get("username");//pass this parameter into the JMeter CSV file for
		String Password=junitSampler.getThreadContext().getVariables().get("pass");//pass this parameter into the JMeter CSV file for
		driver.findElement(By.id("txtUserName")).sendKeys(UserName);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		
//		driver.findElement(By.id("txtUserName")).sendKeys("demotest2");
//		driver.findElement(By.id("txtPassword")).sendKeys("NOUR5uccess#1");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//img[@src='images/map/contractor_package.png']")).click();
		
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='See More']")).click();
		driver.findElement(By.xpath("//a[text()='See More']")).click();
		driver.findElement(By.xpath("//a[text()='See More']")).click();
		driver.findElement(By.xpath("//a[text()='See More']")).click();
		driver.findElement(By.xpath("//a[text()='See More']")).click();
		
		WebElement wb=driver.findElement(By.xpath("//div[@class='mailDetails']"));
		Thread.sleep(5000);
		
		Actions act=new Actions(driver);
		act.moveToElement(wb).perform();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,250)");
		
		String path="//div[@class='panel-body']/div[1]/ul[*]/li[*]/div[1]//div[@class='companytitle']";
		List<WebElement>lst=driver.findElements(By.xpath(path));
		
		int si= lst.size();
		System.out.println(si);
		
		
			for(int i=1;i<=lst.size()-1;i++)
			{
				System.out.println(lst.get(i).getText());
			}
			Thread.sleep(5000);
		//driver.close();
			
			driver.findElement(By.xpath("//a[@class='dropdown-toggle avatar']//span[@class='more']")).click();
			driver.quit();
	
	}
}
