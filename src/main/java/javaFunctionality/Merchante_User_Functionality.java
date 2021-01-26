package javaFunctionality;

import cucumber.TestContext;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.Merchate_User_PageObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Merchante_User_Functionality {
	public Properties properties;
	public String propertyFilePath = "src/test/java/resources/global.properties";

	WebDriver driver;
	Merchate_User_PageObjects Merchate_User_PageObjects;
//	Hooks Hooks;

	public Merchante_User_Functionality(TestContext context) {

		this.driver = context.getDriver();
		Merchate_User_PageObjects = new Merchate_User_PageObjects(driver);

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}

	}

	public void lauchURl(String URl) throws IOException {
		URl = properties.getProperty(URl);
		driver.get(URl);
		driver.manage().window().maximize();

	}

	public void landingpage() {

		String actualTitle = "";
		String ExpectedTitle = "Dashboard | Active Admin Depot";

		try {
			actualTitle = driver.getTitle();
			Assert.assertEquals(ExpectedTitle, actualTitle);
			System.out.println("The actual title is " + actualTitle);
			System.out.println("The Expected title is " + ExpectedTitle);

		} catch (AssertionError e) {
			e.printStackTrace();

			System.out.println("The actual title is " + actualTitle);
			System.out.println("The Expected title is " + ExpectedTitle);
			throw e;

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		
	}

	public void User_Menu_click() {

		try {
			Merchate_User_PageObjects.User_Menu_Button.click();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void New_User_Menu_click() {

		try {
			Merchate_User_PageObjects.New_User_Button.click();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void UserCreation(String user, String password, String email) {
		user = properties.getProperty("sample_username_1");
		password = properties.getProperty("sample_password_1");
		email = properties.getProperty("sample_email_1");

		try {
			Merchate_User_PageObjects.Create_UserName.sendKeys(user);
			Merchate_User_PageObjects.Create_Password.sendKeys(password);
			Merchate_User_PageObjects.Create_Email.sendKeys(email);
			Merchate_User_PageObjects.Create_User_Button.click();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void UserSuccess_check() {

		String Expectedemail = properties.getProperty("sample_email_1");
		String actualemail = "";
		String actualSuccessMessage = "";
		String ExpectedSuccessMessage = "User was successfully created.";

		try {

			actualSuccessMessage = Merchate_User_PageObjects.Create_Success_message.getText().toString();
			Assert.assertEquals(ExpectedSuccessMessage, actualSuccessMessage);
			actualemail = Merchate_User_PageObjects.Created_email_id.getText().toString();
			Assert.assertEquals(Expectedemail, actualemail);
			System.out.println("The actual title is " + actualSuccessMessage);
			System.out.println("The Expected title is " + ExpectedSuccessMessage);

		} catch (AssertionError e) {
			System.out.println("The actual title is " + actualSuccessMessage);
			System.out.println("The Expected title is " + ExpectedSuccessMessage);
			Assert.fail("problem while creating the data");
			throw e;

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("problem while creating the data");

		}
	}

	public void Emailfilter_result(String Expectedemail) {

		Expectedemail = properties.getProperty("sample_email_1");

		try {
			Merchate_User_PageObjects.Filter_email_Search.sendKeys(Expectedemail);
			Merchate_User_PageObjects.Filter_button.click();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void Filter_tableResult(String ExpectedUser, String Expectedemail) {
		ExpectedUser = properties.getProperty("sample_username_1");
		Expectedemail = properties.getProperty("sample_email_1");
		String ActualEmail = "";
		String ActualUser = "";

		try {
			ActualEmail = Merchate_User_PageObjects.Filter_Search_table_Email.getText().toString();
			ActualUser = Merchate_User_PageObjects.Filter_Search_table_User.getText().toString();
			Assert.assertEquals(ExpectedUser, ActualUser);
			Assert.assertEquals(Expectedemail, ActualEmail);
			System.out.println("The actual title is " + ActualUser);
			System.out.println("The Expected title is " + ExpectedUser);
			System.out.println("The actual title is " + ActualEmail);
			System.out.println("The Expected title is " + Expectedemail);

		} catch (AssertionError e) {
			System.out.println("The actual title is " + ActualUser);
			System.out.println("The Expected title is " + ExpectedUser);
			System.out.println("The actual title is " + ActualEmail);
			System.out.println("The Expected title is " + Expectedemail);

			throw e;

		} catch (Exception e) {
			e.printStackTrace();

		}

	}


}


