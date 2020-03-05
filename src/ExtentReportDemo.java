//import java.io.File;
//import java.lang.reflect.Method;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//
//public class ExtentReportDemo {
//
//	public static WebDriver driver;
//	public static ExtentReports extent;
//	public static ExtentTest test;
//
//	@BeforeClass
//	public void beforeClass() {
//
//		extent = new ExtentReports("D://MyExtentReport.html", true);
//		extent.loadConfig(new File("E:\\kp workspace selenium\\Test Project\\extent-config.xml"));
//	}
//
//	@BeforeMethod
//	public void beforeMethod(Method method) {
//		test = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()), method.getName());
//		test.assignAuthor("kiran Pirangute");
//		test.assignCategory("Smoke Test");
//		System.setProperty("webdriver.chrome.driver","D:\\kiran Software\\selenium software\\chrome driver 77\\chromedriver.exe");
//		driver = new ChromeDriver();
//		test.log(LogStatus.PASS, "Browser Launch successfully");
//
//	}
//
//	@Test
//	public void testDemo() {
//		driver.get("https://beta.wrapportal.com/login.aspx");
//		String currentURL = driver.getCurrentUrl();
//		test.log(LogStatus.PASS, "The current urlof the web page" + currentURL);
//		driver.findElement(By.id("txtUserName")).sendKeys("demotest2");
//		driver.findElement(By.id("txtPassword")).sendKeys("Dk5zihFV97");
//		driver.findElement(By.xpath("//a[text()='Login']")).click();
//
//		String actualResult = driver.getTitle();
//		String expectedResult = "Home - Wrap-Portal";
//		if (actualResult.equalsIgnoreCase(expectedResult)) {
//			test.log(LogStatus.PASS, "Actual Result :: " + actualResult);
//		} else {
//			test.log(LogStatus.FAIL, "Actual Result :: " + actualResult + "Expected Result :: " + expectedResult);
//		}
//	}
//
//	@AfterMethod
//	public void afterMethods() {
//
//		driver.close();
//		driver.quit();
//		test.log(LogStatus.PASS, "Browser Closed successfully");
//		extent.endTest(test);
//	}
//
//	@AfterClass
//	public void afterClass() {
//		extent.flush();
//		extent.close();
//	}
//}
