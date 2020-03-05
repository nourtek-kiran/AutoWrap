import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.jmeter.protocol.java.sampler.JUnitSampler;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddContractorPackage 
{
	public String programName="Sony Tower Test";
	public String ProjectName="Sony Project Five";
	public String ContractorName="Sony 1";
	public String ContactName="jonty rod";
	public String EnrollmentType="WC & GL";
	public String tradeNm="541310";
	
	
/*	public String programName="ABC Project";
	public String ProjectName="Test";
	public String ContractorName="abc contracting";
	public String ContactName="Bobby Builder";
	public String EnrollmentType="WC & GL";
	public String TradeName="541310";
*/	
	
	@Test
	public void addContractorPkg() throws InterruptedException 
	{
			
			System.setProperty("webdriver.gecko.driver", "D:\\kiran Software\\selenium software\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://beta.wrapportal.com/");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			/*JUnitSampler junitSampler = new JUnitSampler();
			String UserName = junitSampler.getThreadContext().getVariables().get("username");// pass
			String Password = junitSampler.getThreadContext().getVariables().get("pass");
			String tradeNm= junitSampler.getThreadContext().getVariables().get("trade");
			driver.findElement(By.id("txtUserName")).sendKeys(UserName);
			driver.findElement(By.id("txtPassword")).sendKeys(Password);*/

			driver.findElement(By.id("txtUserName")).sendKeys("demotest2");
			driver.findElement(By.id("txtPassword")).sendKeys("NOUR5uccess#1");

			driver.findElement(By.xpath("//a[text()='Login']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@src='images/map/contractor_package.png']")).click();
			//addContractorPckageButton
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,-250)", "");
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//i[@class='fa fa-plus']")));
			
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			String pID = it.next();
			String cID = it.next();
			driver.switchTo().window(cID);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			try {
				// select program
				//js.executeScript("arguments[0].click();",);
			WebElement element = driver.findElement(By.xpath("//div[@id='s2id_cntrlAddUpdateContractor_ddlProject']"));
			 wait.until(ExpectedConditions.visibilityOf(element));
			 wait.until(ExpectedConditions.elementToBeClickable(element));
			 element.click();
			
			// selectProgramSearchBox
			driver.findElement(By.xpath("//input[@id='s2id_autogen4_search']")).sendKeys(programName);
			Thread.sleep(1500);
			// selectProgramDropdownAutocomplete
			List<WebElement>  selectProgram = driver.findElements(By.xpath("//div[@id='select2-drop']//div[@class='select2-search']/../ul/li[*]"));
			List<WebElement> str = selectProgram;
			System.out.println("size of list"+str.size());
			for(WebElement option: str)
			{
				if(option.getText().contains(programName))
				{
					System.out.println("Trying to select"+programName);
					option.click();
					break;
				}
			}
			// selectProject
			driver.findElement(By.xpath("//div[@id='s2id_cntrlAddUpdateContractor_ddlWorkSite']")).click();
			// selectProjectSearchBox
			driver.findElement(By.xpath("//input[@id='s2id_autogen5_search']")).sendKeys(ProjectName);
			Thread.sleep(1500);
			// selectProjectDropdownAutocomplete
			List<WebElement> selectProject = driver.findElements(By.xpath("//div[@id='select2-drop']//div[@class='select2-search']/../ul/li[*]"));
			List<WebElement> str1 = selectProject;
			System.out.println("size of list"+str1.size());
			for(WebElement option: str1)
			{
				if(option.getText().contains(ProjectName))
				{
					System.out.println("Trying to select"+ProjectName);
					option.click();
					break;
				}
			}
			Thread.sleep(1500);
			// selectEnrollmentType
			driver.findElement(By.xpath("//div[@id='s2id_cntrlAddUpdateContractor_ddlContractorType']")).click();
			// selectEnrollmentType
			driver.findElement(By.xpath("//input[@id='s2id_autogen7_search']")).sendKeys("WC & GL");
			Thread.sleep(1500);
			// selectEnrollmentTypeDropdownAutocomplete
			List<WebElement> selectEnrollement = driver.findElements(By.xpath("//div[@id='select2-drop']//div[@class='select2-search']/../ul/li[*]"));
			List<WebElement> str2 = selectEnrollement;
			System.out.println("size of list"+str2.size());
			for(WebElement option: str2)
			{
				if(option.getText().contains(EnrollmentType))
				{
					System.out.println("Trying to select"+EnrollmentType);
					option.click();
					break;
				}
			}
			
			// selectContractor
			driver.findElement(By.xpath("//input[@id='token-input-cntrlAddUpdateContractor_txtGeneralContractor']")).click();
			driver.findElement(By.xpath("//input[@id='token-input-cntrlAddUpdateContractor_txtGeneralContractor']")).sendKeys(ContractorName);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='token-input-cntrlAddUpdateContractor_txtGeneralContractor']")).sendKeys(Keys.ENTER);
			// SelectContact
			driver.findElement(By.xpath("//div[@id='s2id_cntrlAddUpdateContractor_ddlContacts']")).click();
			// SelectContactSearchBox
			driver.findElement(By.xpath("//input[@id='s2id_autogen6_search']")).sendKeys(ContactName);
			Thread.sleep(2500);
			// SelectContactAutoCompllete
			List<WebElement> selectContact =driver.findElements(By.xpath("//input[@id='s2id_autogen6_search']/../../ul/li[*]"));
			List<WebElement> str3 = selectContact;
			System.out.println("size of list"+str3.size());
			for(WebElement option: str3)
			{
				if(option.getText().contains(ContactName))
				{
					System.out.println("Trying to select"+ContactName);
					option.click();
					break;
				}
			}
			// selectTrade
			driver.findElement(By.xpath("//div[@id='s2id_cntrlAddUpdateContractor_ddlTrade']")).click();;
			// selectTradeSearchBox
			driver.findElement(By.xpath("//input[@id='s2id_autogen8_search']")).sendKeys(tradeNm);
			Thread.sleep(1500);
			//selectTradeDropdown
			List<WebElement> selectTrade =driver.findElements(By.xpath("//div[@id='select2-drop']//div[@class='select2-search']/../ul/li[*]"));
			List<WebElement> str4 = selectTrade;
			System.out.println("size of list"+str4.size());
			for(WebElement option: str4)
			{
				if(option.getText().contains(tradeNm))
				{
					System.out.println("Trying to select"+tradeNm);
					option.click();
					break;
				}
			}
		} catch (Throwable e) 
		{
			System.out.println(e);
		}
			
			//buttonNext
			driver.findElement(By.xpath("//input[@id='cntrlAddUpdateContractor_btnNext']")).click();
			Thread.sleep(1000);
			
			
			try {
				//alertConfirmComplianceContinueBtn
				driver.findElement(By.xpath("//button[@id='btnSaveModal']")).click();
			} catch (Throwable e) {
				System.out.println(e);
			}
			
			//sendEmailCloseBtn
			driver.findElement(By.xpath("//button[@id='btnCloseWindow']")).click();
			
			driver.switchTo().window(pID);
			driver.close();
			
			//sendEmailSendAndCloseBtn
//			driver.findElement(By.xpath("//input[@id='btnSend']"));
		

	}
}
