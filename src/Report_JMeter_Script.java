import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.jmeter.protocol.java.sampler.JUnitSampler;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Report_JMeter_Script {
	@Test
	public void testReport() throws InterruptedException {

		/*String Reportname = "Submitted Payroll Report";
		String projectName = "UCB Tolman Hall";
		String programName = "University Controlled Insurance Program (UCIP) III";
		*/
		// Non-Compliance Report
		System.setProperty("webdriver.gecko.driver", "D:\\kiran Software\\selenium software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://beta.wrapportal.com/");
		WebDriverWait webwait = new WebDriverWait(driver, 50);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		
		  JUnitSampler junitSampler = new JUnitSampler(); 
		  String UserName =junitSampler.getThreadContext().getVariables().get("username");
		  String Password =junitSampler.getThreadContext().getVariables().get("pass"); 
		  String Reportname =junitSampler.getThreadContext().getVariables().get("ReportName");
		  String programName =junitSampler.getThreadContext().getVariables().get("ProgramName");
		  String projectName  =junitSampler.getThreadContext().getVariables().get("projectName");
		 

		// username,pass,ReportName,ProgramName,projectName
		// University Controlled Insurance Program (UCIP) III Carrier Payroll
		// Report Payroll Summary Report UCB Tolman Hall

		
		  driver.findElement(By.id("txtUserName")).sendKeys(UserName);
		  driver.findElement(By.id("txtPassword")).sendKeys(Password);
		 

		/*driver.findElement(By.id("txtUserName")).sendKeys("LoadTest107936");// ("demotest2");
		driver.findElement(By.id("txtPassword")).sendKeys("jN7O3u4G2BdO");// ("NOUR5uccess#1");
*/		driver.findElement(By.xpath("//a[text()='Login']")).click();

		Thread.sleep(5000);
//		webwait.until(ExpectedConditions
//				.elementToBeClickable(driver.findElement(By.xpath("//li[@id='ctl00_ctrlMenu_liReports']"))));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50)", "");//Scroll down
		driver.findElement(By.xpath("//li[@id='ctl00_ctrlMenu_liReports']")).click();
		
		
		// select program from the list
		WebElement element = driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_ddlProject']"));
		Select sel = new Select(element);
		// sel.selectByVisibleText(programName);
		sel.selectByVisibleText(programName);
		// sel.deselectByVisibleText(Reportname);
		// select report from the list of report
		WebElement openReport = driver.findElement(By.xpath("//span[contains(text(),'" + Reportname + "')]"));

		webwait.until(ExpectedConditions.visibilityOf(openReport));
		openReport.click();
		// change the window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String pID = it.next();
		String cID = it.next();
		driver.switchTo().window(cID);
		webwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//td[@class='mainTitle txt-center']"))));
		try {
			// select project from drop-down
			driver.findElement(By
					.xpath("//div[@id='ctrlBuildReport_divWorksite']//div[@class='non-selected-wrapper']//a[contains(text(),'"
							+ projectName + "')]"))
					.click();

			driver.findElement(By.xpath("//input[@id='ctrlBuildReport_btnBuildReport']")).click();

			WebElement reportHeader = driver.findElement(By.xpath("//td[@class='mainTitle txt-center']"));
			webwait.until(ExpectedConditions.visibilityOf(reportHeader));
			System.out.println("Report Name= \t" + reportHeader.getText());
			driver.close();// close the child window
			driver.switchTo().window(pID);
			driver.close();
			
		} catch (Throwable e) {
			System.out.println("Exception \n" + e);
		}
		
	}
}
