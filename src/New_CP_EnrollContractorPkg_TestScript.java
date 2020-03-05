import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class New_CP_EnrollContractorPkg_TestScript 
{
	String CompanyLogo="//img[@id='imgLogo']";
	String ProfilePictureicon="//img[@id='imgAvtar']";
	String MyProfileIcon="//a[@class='dropdown-item waves-effect waves-light']";
	String SignOutIcon="//a[@id='aLogout']";
	String MyMessagesIcon="//span[contains(text(),'My Messages')]";
	
	String myProjectListing = "//span[contains(text(),'My Projects')]";
	String mySubContractorListing = "//span[contains(text(),'My Sub Contractors')]";
	// div[@class='treeview-colorful custom-treeview']/ul/li[* and
	// @id!='liOSHAEMRSummary']/*[contains(text(),'OSHA & EMR')]
	// div[@class='treeview-colorful custom-treeview']/ul/li[* and
	// @id!='liOSHAEMRSummary' and
	// @id!='liSubContractorSummary']/*[contains(text(),' Contract Cost
	// Worksheet ')]
	String MyCompanyInformation = "//div[@class='treeview-colorful custom-treeview']/ul/li[*]/a[contains(text(),'My Company Information')]";
	String MyPolicyInformation = "//div[@class='treeview-colorful custom-treeview']/ul/li[*]/a[contains(text(),'My Policy Information')]";
	String ContractorCostWorksheet = "//div[@class='treeview-colorful custom-treeview']/ul/li[*]/a[contains(text(),'Contract Cost Worksheet')]";
	String SubContracotrs = "//div[@class='treeview-colorful custom-treeview']/ul/li[@id!='liSubContractorSummary']/*[contains(text(),'Sub Contractors')]";
	String OSHA_EMR = "//div[@class='treeview-colorful custom-treeview']/ul/li[* and @id!='liOSHAEMRSummary']/*[contains(text(),'OSHA & EMR')]";
	String ReviewEnrollment = "//div[@class='treeview-colorful custom-treeview']/ul/li[*]/*[contains(text(),'Review Enrollment')]";
	//div[@id='accordionEx']/div[*]//i[@class='fas fa-angle-down rotate-icon']
	String selectPreviewPanelProjectDropdown="//div[@id='accordionEx']/div[*]//h5[contains(text(),'Sony Project Five')]/../..//i[@class='fas fa-angle-down rotate-icon']";
	String btnRefresh="//i[@class='mdi mdi-refresh']";
	String linkViewAllNotifications="//*[contains(text(),'View All Notifications')]";
	String notificationAssignContractorPkg="//div[@class='col-md-12 mb-2 mt-2']//div[@class='row']//div[1]//span[@class='icon-group right-thick']";
	String notificationMissingPayrollPkg="//div[@class='col-md-12 mb-2 mt-2']//div[@class='row']/div[2]//*[@class='defult-status missing-payroll-status']";
	String notificationIncompletePaperWork="//div[@class='col-md-12 mb-2 mt-2']//div[@class='row']/div[3]//a";
	String notificationExpiredOffSiteCoverage="//div[@class='col-md-12 mb-2 mt-2']//div[@class='row']/div[4]//a";
	
	
	String btnFilterBy = "//a[@class='filter-btn']";
	String selectProgramField = "//div[@class='advance-search']/div/div[1]//input[@type='text']";
	String selectProgram = "//div[@class='advance-search']/div/div[1]//ul/li[*]";
	String selectProjectField = "//div[@class='advance-search']/div/div[2]/div[1]/div/input";
	String selectProjectDropdown = "//div[@class='advance-search']/div/div[2]/div[1]//ul/li[*]";
	String selectTradeField = "//div[@class='advance-search']/div/div[3]/div//input";
	String selectTradeDropdown = "//div[@class='advance-search']/div/div[3]/div/div/ul/li[*]/span";
	String selectEnrollmentTypeField = "//div[@class='advance-search']/div/div[4]/div/div/input";
	String selectEnrollmentDropdown = "//div[@class='advance-search']/div/div[4]//ul/li[*]";
	String selectContractValue = "//input[@id='txtContractValue']";
	String selectContractNumber = "//input[@id='txtContractNumber']";
	String btnSearch = "//a[contains(text(),'Search')]";
	public String selectEnrollmentTab(String tabname)// 'Enrollment'
	{
		String selectTabName = "//ul[@class='list-enrolled']//*[contains(text(),'" + tabname + "')]/..//a";
		return selectTabName;
	}
	String contractorNameField="//label[contains(text(),'Contractor Name*')]";
	String EMR_Field="wp.companysection.NCCIExperienceModifierRate";
	String selectOfficeContactField="//*[@class='col-md-12 maindiv' and @style!='display: none;']//div[@class='form-group custom-form-group']/label[contains(text(),'Contact')]/span[contains(text(),'1')]/../..//input[@type='text']";
	String selectOfficeContactDropDown="//*[@class='col-md-12 maindiv' and @style!='display: none;']//div[@class='form-group custom-form-group']/label[contains(text(),'Contact')]/span[contains(text(),'1')]/../..//ul/li[*]";
	
	String selectPayrollContactField="//div[@id='bodyEnrollment']//div[@class='card']/div//div[@class='col-md-12 maindiv'][position()=2]//input";
	String selectpayrollContactDropDown="//div[@id='bodyEnrollment']//div[@class='card']/div//div[@class='col-md-12 maindiv'][position()=2]//ul/li[*]";
	//div[@class='select-wrapper mdb-select md-form colorful-select dropdown-primary ddlContactType'][position()=1]
	//div[@class='card-body p-5']/div[1]//div[@class='col-md-12 maindiv']/div[1]/div[1]//div[@class='select-wrapper mdb-select md-form colorful-select dropdown-primary ddlContactType']//ul
	//div[@class='card-body p-5']/div[1]//div[@class='col-md-12 maindiv']/div[1]/div[1]//div[2]
	//div[@id='bodyEnrollment']//div[@class='card']
	//div[@id='modal-contractor-package-data']//div[6]
	//body[@class='modal-open']/div[@class='container mt-4']/div[@class='row']/div[@id='modal-contractor-package-data']/div[@class='modal-dialog modal-details-view modal-right']/div[@class='modal-content modal-background']/div[@class='p-4']/div[@class='row']/div[@class='col-md-12 mt-4']/div[@class='row']/div[@class='col-lg-9 div-body-content']/div[@id='bodyEnrollment']/div[@class='card']/div[@class='card-body p-5']/div[@class='row']/div[11]/div[1]/div[1]/div[1]
	
	String contractPriceField="//input[@id='wp.contractorcost.contrprice']";
	String selefPerformContractValue="//input[@id='wp.contractorcost.contrselfvalue']";
	String estimatedManhours="//input[@id='wp.contractorcost.contrhours']";
	String estimatedPayroll="//input[@id='wp.contractorcost.contrpayroll']";
	String startDate="//label[contains(text(),'Contract Start Date*')]";
	String endDate="//label[contains(text(),'Contract End Date')]";
	String checkBoxFixedCost="//div[@class='row mt-5']//div[@class='btn-group custom-btn-group']/label[1]";
	String checkBoxUnitPrice="//div[@class='row mt-5']//div[@class='btn-group custom-btn-group']/label[2]";
	String ScopeOfWorkTestArea="//textarea[@id='wp.contractorcost.brieflydescribework']";
	String btnContinue="//a[contains(text(),'Continue')]";
	String btnExit="//a[contains(text(),'Exit')]";
	String calenderStartDateClick="//input[@id='wp.contractorcost.contrstartdate']";
	String calenderSelectStartYear="//div[@id='wp.contractorcost.contrstartdate_root']//div[@class='picker__wrap']//select[1]";
	String calenderSelectStartMonth="//div[@id='wp.contractorcost.contrstartdate_root']//div[@class='picker__wrap']//select[2]";
	String calenderSelectStartDay="//div[@id='wp.contractorcost.contrstartdate_root']//div[@class='picker__wrap']//table/tbody//tr//td/div[contains(text(),'10')]";
	
	String calenderEndaDateClick="//input[@id='wp.contractorcost.contrenddate']";
	String calenderSelectEndYear="//div[@id='wp.contractorcost.contrenddate_root']//select[@class='picker__select--year']";
	String calenderSelectEndMonth="//div[@id='wp.contractorcost.contrenddate_root']//select[@class='picker__select--month']";
	String calenderSelectEndDay="//div[@id='wp.contractorcost.contrenddate_root']//div[@class='picker__wrap']//table/tbody//tr//td/div[contains(text(),'13')]";
	
	String btnAddWorkClass="//a[contains(text(),'Add a Work Class')]";
	String WCClassCodeField="//div[@class='select-wrapper mdb-select md-form colorful-select dropdown-primary form-control-dynamic ddlWorkClass']//input";
	String WCClassCodeDropDown="//div[@class='select-wrapper mdb-select md-form colorful-select dropdown-primary form-control-dynamic ddlWorkClass']//ul/li[*]";
	String identityBillMethodField="//div[@class='select-wrapper mdb-select md-form colorful-select dropdown-primary form-control-dynamic ddlBillingMethod']//input";
	String identityBillMethodDropDown="//div[@class='select-wrapper mdb-select md-form colorful-select dropdown-primary form-control-dynamic ddlBillingMethod']//ul/li[*]";
	String WCgrossBillingRateField="//div[@class='col-md-12 div-work-class']/div[1]/div[3]/div/div[1]//input[@type='text']";
	String WCbaseWagerateField="//div[@class='col-md-12 div-work-class']/div[1]/div[3]/div/div[2]//input[@type='text']";
	String WCHoursField="//div[@class='col-md-12 div-work-class']/div[1]/div[4]/div/div[1]//input[@type='text']";
	String WCPayrollField="//div[@class='col-md-12 div-work-class']/div[1]/div[4]/div/div[2]//input[@type='text']";
	String WCRateField="//div[@class='col-md-12 div-work-class']/div[1]/div[4]/div/div[3]//input[@type='text']";
	String WCPremiumField="//div[@class='col-md-12 div-work-class']/div[1]/div[4]/div/div[4]//input[@type='text']";
	String WCAlertCancelBtn="//div[@class='sa-button-container']//*[contains(text(),'Cancel')]";
	String WCAlertOkBtn="//div[@class='sa-button-container']//*[contains(text(),'Ok')]";
	
	//All inputs for enrolling the contractor 
	/*String username="michaelschumacher";
	String password="V49324";
	String programName="Sony Tower One Prog";
	String projectName="Sony Project4051";
	String tradeName="3535";
	String enrollmentType="WC & GL Enrollment";
	String payrollContactName="michael";*/
	
	String username="KaneDom";
	String password="Admin@1234";
	String programName="Sony Tower Test";
	String projectName="Sony Project Five";
	String tradeName="481";
	String enrollmentType="WC & GL Enrollment";
	String payrollContactName="Kane";
	
	
	@Test
	public void testEnrollCP() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\kiran Software\\selenium software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// Website URL
		driver.get("http://cp5.getenrolled.us/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// login Details
		driver.findElement(By.id("UserName")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
		System.out.println(driver.getCurrentUrl());
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(btnFilterBy))));
		driver.findElement(By.xpath(btnFilterBy)).click();
		driver.findElement(By.xpath(selectProgramField)).click();

		selectSingleValueFromList(driver.findElements(By.xpath(selectProgram)), programName);
		driver.findElement(By.xpath(selectProjectField)).click();
		selectSingleValueFromList(driver.findElements(By.xpath(selectProjectDropdown)),projectName );
		driver.findElement(By.xpath(selectTradeField)).click();
		selectSingleValueFromList(driver.findElements(By.xpath(selectTradeDropdown)),tradeName );
		driver.findElement(By.xpath(selectEnrollmentTypeField)).click();
		selectSingleValueFromList(driver.findElements(By.xpath(selectEnrollmentDropdown)),enrollmentType );
		driver.findElement(By.xpath(btnSearch)).click();
		driver.findElement(By.xpath(selectEnrollmentTab("Enrollment"))).click();
//		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(contractorNameField))));
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id(EMR_Field)).click();
		driver.findElement(By.xpath(btnContinue)).click();
//		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(selectPayrollContactField))));
		js.executeScript("window.scrollBy(0,250)", "");
//		driver.findElement(By.xpath(selectOfficeContactField)).click();
//		selectSingleValueFromList(driver.findElements(By.xpath(selectOfficeContactDropDown)), "jonhy");
		
		driver.findElement(By.xpath(selectPayrollContactField)).click();
		selectSingleValueFromList(driver.findElements(By.xpath(selectpayrollContactDropDown)),payrollContactName );
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath(btnContinue)).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(btnContinue))));
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath(btnContinue)).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(contractPriceField))));
		driver.findElement(By.xpath(contractPriceField)).clear();
		driver.findElement(By.xpath(contractPriceField)).sendKeys("5100000");
		
		driver.findElement(By.xpath(selefPerformContractValue)).clear();
		driver.findElement(By.xpath(selefPerformContractValue)).sendKeys("510000");
		
		driver.findElement(By.xpath(estimatedManhours)).clear();
		driver.findElement(By.xpath(estimatedManhours)).sendKeys("5100");
		
		driver.findElement(By.xpath(estimatedPayroll)).clear();
		driver.findElement(By.xpath(estimatedPayroll)).sendKeys("5100");
		Thread.sleep(1500);
		
		js.executeScript("window.scrollBy(0,50)", "");
		//js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath(calenderStartDateClick)));
		driver.findElement(By.xpath(calenderStartDateClick)).click();
		
		Select yearSelect=new Select(driver.findElement(By.xpath(calenderSelectStartYear)));
		yearSelect.selectByVisibleText("2019");
		Select monthSelect=new Select(driver.findElement(By.xpath(calenderSelectStartMonth)));
		Thread.sleep(500);
		monthSelect.selectByVisibleText("November");
		driver.findElement(By.xpath(calenderSelectStartDay)).click();
		
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath(calenderEndaDateClick)));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(calenderSelectEndYear))));
		Select yearSelect1=new Select(driver.findElement(By.xpath(calenderSelectEndYear)));
		yearSelect1.selectByValue("2020");
		Select monthSelect1=new Select(driver.findElement(By.xpath(calenderSelectEndMonth)));
		Thread.sleep(500);
		monthSelect1.selectByVisibleText("November");
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath(calenderSelectEndDay)));
//		driver.findElement(By.xpath(calenderSelectEndDay)).sendKeys(Keys.TAB);
		js.executeScript("window.scrollBy(0,100)", "");
		
		driver.findElement(By.xpath(ScopeOfWorkTestArea)).sendKeys("Testign of scope of the work");
		js.executeScript("window.scrollBy(0,250)", "");
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath(btnContinue)));
		
		//page is not working fine because of that not able to automate but i have find the Xpath 12-02-2020 
	/*	driver.findElement(By.xpath(btnAddWorkClass)).click();
		driver.findElement(By.xpath(WCClassCodeField)).click();
		selectSingleValueFromList(driver.findElements(By.xpath(WCClassCodeDropDown)), "4036");*/
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(btnAddWorkClass))));
		driver.findElement(By.xpath(btnAddWorkClass)).click();
		driver.findElement(By.xpath(WCClassCodeField)).click();
		selectSingleValueFromList(driver.findElements(By.xpath(WCClassCodeDropDown)), "Analytical Testing");
		driver.findElement(By.xpath(WCHoursField)).sendKeys("100");
		driver.findElement(By.xpath(WCPayrollField)).sendKeys("1500");
		driver.findElement(By.xpath(WCRateField)).sendKeys("16");
		
		driver.findElement(By.xpath(btnContinue)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(btnExit))));
		
		js.executeScript("window.scrollBy(0,250)", "");
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath(btnExit)));
		
		
		// driver.close();
	}

	public void selectSingleValueFromList(List<WebElement> selectElement, String data) 
	{
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
