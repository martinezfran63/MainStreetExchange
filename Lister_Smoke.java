package smoke;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Reporter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import regression.EmailReport;
import regression.Screenshot;


public class Lister_Smoke extends EmailReport  {
	 WebDriver driver;
	 public static ExtentReports report;
	 public static ExtentTest logger;
	 Screenshot shot;
	 String ClassName = "Lister_Smoke";
	    
	 @BeforeSuite
	 public void BeforeSuite() throws IOException {
	  
	  //change to change report name
	  report = new ExtentReports("/Users/franciscomartinez/Documents/workspace/MainStreetExchange/test-output/MSE Test Report.html");
		
	 }
	 
	 // Configure for multi browser drivers
	 @Parameters({ "URL", "Email", "Password", "Browser"})
	 @BeforeMethod
	 public void beforeTest(String URL, String Email, String Password, String Browser) {
		  System.out.println("\nBrowser: " + Browser+  "\nURL: " + URL + "\nEmail: " + Email + "\nPassword: " + Password);
		  
	           if (Browser.equalsIgnoreCase("firefox")) {
	        	   driver = new FirefoxDriver();
	           } else if (Browser.equalsIgnoreCase("chrome")) {
	                  // Set Path for the executable file

	                  driver = new ChromeDriver();
	           } else if (Browser.equalsIgnoreCase("Internet Explorer")) {
		        	// Set Path to find the browser driver
	                  System.setProperty("webdriver.ie.driver", "C:/Selenium/IE/IEDriverServer.exe");
	                //creates an instance of the ie driver to do testing on the browser
	                  DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	                  caps.setCapability("ignoreZoomSetting", true);
	                  caps.setCapability("nativeEvents",false);
	                  driver = new InternetExplorerDriver(caps);
	           } else {
	                  throw new IllegalArgumentException("The Browser Type is Undefined");
	           }
	           
	    }
  
	@Parameters({ "URL", "Email", "Password"})
	@Test
	public void MyCompany(String URL, String Email, String Password) throws IOException {
		System.out.println("MyCompany");
		logger=report.startTest("MyCompany");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
		
	    //Click My Company
		driver.findElement(By.linkText("My Company")).click();
		logger.log(LogStatus.INFO, "Click 'My Company' ");
		
	    // Assert Text Present
		String TexttoVerify= "Setup Checklist";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Entities Index: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
	}

	@Parameters({ "URL", "Email", "Password"})
	@Test
	public void Compliance(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("Compliance");
		System.out.println("Compliance");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
		
	    //Click Compliance
		driver.findElement(By.linkText("Compliance")).click();
		logger.log(LogStatus.INFO, "Click 'Compliance' ");
		
	    // Assert Text Present
		String TexttoVerify= "Compliance";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Compliance: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
		}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	public void Knowledge(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("Knowledge");
		System.out.println("Knowledge");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
		
	    //Click Knowledge
		driver.findElement(By.linkText("Knowledge")).click();
		logger.log(LogStatus.INFO, "Click 'Knowledge' ");
		
	    // Assert Text Present
		String TexttoVerify= "Knowledge";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Knowledge: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
		}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	public void Contact(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("Contact");
		System.out.println("Contact");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
		
	    //Click Contact
		driver.findElement(By.linkText("Contact")).click();
		logger.log(LogStatus.INFO, "Click 'Contact' ");
		
	    // Assert Text Present
		String TexttoVerify= "Contact";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Contact: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
		}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	public void AccountInformation(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("AccountInformation");
		System.out.println("Account Information");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
		
	    //Click Company Icon in corner
	    driver.findElement(By.cssSelector(".dropdown-toggle")).click();
	    logger.log(LogStatus.INFO, "Click Company Icon in corner");
	    	
	    //Click Account Information
		driver.findElement(By.linkText("Account Information")).click();
		logger.log(LogStatus.INFO, "Click 'Account Information' ");
		
	    // Assert Text Present
		String TexttoVerify= "Account Information";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Account Information: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
		}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	public void UserSettings(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("UserSettings");
		System.out.println("User Settings");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
		
	    //Click Company Icon in corner
	    driver.findElement(By.cssSelector(".dropdown-toggle")).click();
	    logger.log(LogStatus.INFO, "Click Company Icon in corner");
	    	
	    //Click User Settings
		driver.findElement(By.linkText("User Settings")).click();
		logger.log(LogStatus.INFO, "Click 'User Settings' ");
		
	    // Assert Text Present
		String TexttoVerify= "Settings";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "User Settings: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
		}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	public void Subscription(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("Subscription");
		System.out.println("Subscription");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
		
	    //Click Company Icon in corner
	    driver.findElement(By.cssSelector(".dropdown-toggle")).click();
	    logger.log(LogStatus.INFO, "Click Company Icon in corner");
	    
	    //Click User Settings
		driver.findElement(By.linkText("Subscriptions")).click();
		logger.log(LogStatus.INFO, "Click 'Subscriptions' ");
		
	    // Assert Text Present
		String TexttoVerify= "Subscription Management";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Subscription: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
		}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	public void CapitalizationTable(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("CapitalizationTable");
		System.out.println("Capitalization Table");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click User Settings
		driver.findElement(By.linkText("Capitalization Table")).click();
		logger.log(LogStatus.INFO, "Click 'Capitalization Table' ");
		
	    // Assert Text Present
		String TexttoVerify= "Capitalization Table";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Capitalization Table: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
		}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	void ViewListing(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("ViewListing");
		System.out.println("View Listing");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click View Listing
		driver.findElement(By.linkText("View Listing")).click();
		logger.log(LogStatus.INFO, "Click 'View Listing' ");
		
	    // Assert Text Present
		String TexttoVerify= "Summary";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Summary: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
		}
	
	@Parameters({ "URL", "Email", "Password"})	
	@Test
	void EditListing(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("EditListing");
		System.out.println("Edit Listing");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click Edit Listing
		driver.findElement(By.linkText("Edit Listing")).click();
		logger.log(LogStatus.INFO, "Click 'Edit Listing' ");
		
	    // Assert Text Present
		String TexttoVerify= "Save Changes";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Edit Listing: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
	}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	void FinancingRounds(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("FinancingRounds");
		System.out.println("Financing Rounds");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click Financing Rounds
		driver.findElement(By.linkText("Financing Rounds")).click();
		logger.log(LogStatus.INFO, "Click 'FinancingRounds' ");
		
	    // Assert Text Present
		String TexttoVerify= "Create Financing Round";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Financing Round: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
	}

	@Parameters({ "URL", "Email", "Password"})
	@Test
	void CapitalizationTable2(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("CapitalizationTable2");
		System.out.println("Capitalization Table 2");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click Capitalization Table 
		driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[7]/a")).click();
		logger.log(LogStatus.INFO, "Click 'Capitalization Table ' ");
		
	    // Assert Text Present
		String TexttoVerify= "Capitalization Table";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Capitalization Table2: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
	}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	void Documents(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("Documents");
		System.out.println("Documents");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click Documents
		driver.findElement(By.linkText("Documents")).click();
		logger.log(LogStatus.INFO, "Click 'Documents'");
		
	    // Assert Text Present
		String TexttoVerify= "Documents";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Documents: Text Verified");	
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
	}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	void UploadNewDocument(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("UploadNewDocument");
		System.out.println("Upload New Document");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click Upload New Document
		driver.findElement(By.linkText("Upload New Document")).click();
		logger.log(LogStatus.INFO, "Click 'Document'");
		
	    // Assert Text Present
		String TexttoVerify= "File Upload";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Upload New Document: Text Verified");	
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
	}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	void Reporting(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("Reporting");
		System.out.println("Reporting");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click Reporting
		driver.findElement(By.linkText("Reporting")).click();
		logger.log(LogStatus.INFO, "Click 'Reporting'");
		
	    // Assert Text Present
		String TexttoVerify= "Reports Shared with Users";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Reporting: Text Verified");		
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
	}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	void Compliance2(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("Compliance2");
		System.out.println("Compliance2");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click Compliance2 
		driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[13]/a")).click();
		logger.log(LogStatus.INFO, "Click 'Compliance2'");
		
	    // Assert Text Present
		String TexttoVerify= "Welcome to the compliance center. ";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Compliance2: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
	}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	void AddEditUsers(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("AddEditUsers");
		System.out.println("Add/Edit Users");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click Add/Edit Users 
		driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[15]/a")).click();
		logger.log(LogStatus.INFO, "Click 'Add/Edit Users'");
		
	    // Assert Text Present
		String TexttoVerify= "Linked Users";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Add/Edit Users: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
	}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	void KeyPeople(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("KeyPeople");
		System.out.println("Key People");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click Key People 
		driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[16]/a")).click();
		logger.log(LogStatus.INFO, "Click 'Key People'");
		
	    // Assert Key People
		String TexttoVerify= "Create Key Person";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Key People: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");

	}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	void UserGroups(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("UserGroups");
		System.out.println("User Groups");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click User Groups
		driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[17]/a")).click();
		logger.log(LogStatus.INFO, "Click 'User Groups'");
		
	    // Assert User Groups
		String TexttoVerify= "User Groups Index";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Key People: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
		
	}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	void UserRoles(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("UserRoles");
		System.out.println("User Roles");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click User Roles
		driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[18]/a")).click();
		logger.log(LogStatus.INFO, "Click 'User Roles'");
		
	    // Assert User Roles
		String TexttoVerify= "User Roles";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "User Roles: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
	
	}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	void Subscriptions2(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("Subscriptions2");
		System.out.println("Subscriptions2");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
	
	    //Click Subscriptions
		driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[20]/a")).click();
		logger.log(LogStatus.INFO, "Click 'Subscriptions'");
		
	    // Assert Subscriptions
		String TexttoVerify= "Subscription Management";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "Subscriptions2: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");

	}
	
	@Parameters({ "URL", "Email", "Password"})
	@Test
	void CreateNewCompany(String URL, String Email, String Password) throws IOException {
		logger=report.startTest("CreateNewCompany");
		System.out.println("CreateNewCompany");
		
   		// Navigate to MainStreetExchange
   	    driver.get(URL);
   	    logger.log(LogStatus.INFO, "Navigate to Main Street Exchange");
   	   
   		// Maximize window
   	    driver.manage().window().maximize(); 
   	    logger.log(LogStatus.INFO, "Browser Window Maximized");

   		//Click 'Sign In' link
   	    driver.findElement(By.linkText("Sign In")).click();
   	    logger.log(LogStatus.INFO, "Click 'Sign In' link");

   		//Type in UserName
   	    driver.findElement(By.id("email")).sendKeys(Email);
   	    logger.log(LogStatus.INFO, "Type in UserName");

   		//Type in Password
   	    driver.findElement(By.name("password")).sendKeys(Password);
   	    logger.log(LogStatus.INFO, "Type in Password");
   	    
   		//Click 'Login' Button
   	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click(); 
   	    logger.log(LogStatus.INFO, "Click 'Login' Button");
		
	    //Click Create New Company
		driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[22]/a")).click();
		logger.log(LogStatus.INFO, "Click 'Create New Company'");
		
	    // Assert Create New Company
		String TexttoVerify= "New Company";
		Assert.assertTrue(driver.findElement(By.tagName("html")).getText().contains(TexttoVerify));	
		logger.log(LogStatus.PASS, "CreateNewCompany: Text Verified");
		
	    //Click Company Icon in corner
	    driver.findElement(By.xpath("//*[@id='app-navbar-collapse']/ul[2]/li/a")).click();
	    
		//Click 'Logout' link
	    driver.findElement(By.linkText("Logout")).click();
		logger.log(LogStatus.INFO, "Logout of Main Street Exchange");
		
	}
	
  
  @AfterMethod
  public void afterTest() {
         try {
      	   	  driver.close();
                driver.quit();
         } catch (Exception e) {
                driver = null;
         }
  }
   
	 @AfterMethod
		public void AfterMethod(ITestResult testResult) throws IOException {
			if (testResult.getStatus() == ITestResult.FAILURE) {
				
				String screenshot_path=Screenshot.captureScreenshot(driver, testResult.getName(), ClassName);
				String image = logger.addScreenCapture(screenshot_path);
				//logger.log(LogStatus.FAIL, "Test Fail", image);
				//logger.log(LogStatus.FAIL, "Test Fail");
				logger.log(LogStatus.FAIL, testResult.getThrowable());
				
				
			}	
		   }     
	 
	 @AfterSuite(alwaysRun=true)
	 public void After()
	 {
		 driver.quit(); 
	     report.endTest(logger);
	     report.flush();  
	     emailReport(ClassName);
	 }
	 
	 
}

