package stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.Merchate_User_PageObjects;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.Merchate_User_PageObjects;


public class Hooks {

	pageObject.Merchate_User_PageObjects Merchate_User_PageObjects;
	WebDriver driver;

	private final TestContext context;

	public Hooks(TestContext context) {
		this.context = context;
		Merchate_User_PageObjects = new Merchate_User_PageObjects(driver);
	}


	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{		//execute this code only when place id is null
		//write a code that will give you place id
		
		StepDefination m =new StepDefination();
		if(StepDefination.id==null)
		{
		
		m.add_Place_Payload_with("Shetty", "French", "Asia");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_Id_created_maps_to_using("Shetty", "getPlaceAPI");
		}
		
		

	}

//	@Before
//	public void beforeSteps(Scenario scenario) throws IOException {
////
////		 for driver version please the suitable and change it accordingly to run in
//		// your system
////
//		WebDriverManager.chromedriver().version("87.0.4280.20").setup();
//		driver = new ChromeDriver();
//		context.setDriver(driver);
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//	}
//
//	@AfterStep
//	public void afterStep(Scenario scenario) {
////
//		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//		scenario.attach(screenshot, "image/jpg", "jpg");
////
//	}
//
//	@After
//	public void tearDown(Scenario scenario) throws IOException {
////
//		context.getDriver().close();
////
//	}

}
