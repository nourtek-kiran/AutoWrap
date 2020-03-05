import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class New_CP_ReportGeneration_TestScript
{

	String btnFilterBy = "//a[@class='filter-btn']";
	String linkReport = "//*[contains(text(),'Report')]";
	String selectProgramField="//div[@class='select-wrapper mdb-select md-form colorful-select dropdown-primary ddl-report-project']";
	String selectProgramDropDown="//input[@class='select-dropdown active']/../ul/li[*]";
	String selectCategoryField="//input[@class='select-dropdown active']";
	String selectCategoryDropdown="//input[@class='select-dropdown active']/../ul/li[*]";
	String selectYourReporFrmList="//div[@class='row report-item']/div//a/div[2]/span";
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testReportGeneration() throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "D:\\kiran Software\\selenium software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// Website URL
		driver.get("http://cp5.getenrolled.us/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// login Details
		driver.findElement(By.id("UserName")).sendKeys("michaelschumacher");
		driver.findElement(By.id("Password")).sendKeys("V49324");
		driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		System.out.println(driver.getCurrentUrl());
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(linkReport))));
		driver.findElement(By.xpath(linkReport)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(selectProgramField))));
		driver.findElement(By.xpath(selectProgramField)).click();
		
		selectSingleValueFromList(driver.findElements(By.xpath(selectProgramDropDown)), "Sony Tower One Prog");
		selectSingleValueFromList(driver.findElements(By.xpath(selectYourReporFrmList)), "Claims Report");
		
		Thread.sleep(5000);
		Set<String> set= driver.getWindowHandles();
		Iterator<String> it=set.iterator();
			String PID=it.next();
			String CID=it.next();
	
		driver.switchTo().window(CID);
		Thread.sleep(6000);
		driver.close();
		
		driver.switchTo().window(PID);
		Thread.sleep(2000);
		driver.close();
		
		//can't open the report because of the 404 	not found error 12-02-2020
		
		// driver.close();

	}
	
	public void selectSingleValueFromList(List<WebElement> selectElement, String data) {

		List<WebElement> str = selectElement;
		System.out.println("size of list" + str.size());
		for (WebElement option : str) {
			if (option.getText().contains(data)) {
				System.out.println("Trying to select" + data);
				option.click();
				break;
			}
		}
	}

}
