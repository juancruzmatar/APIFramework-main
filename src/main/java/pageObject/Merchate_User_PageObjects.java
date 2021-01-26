package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



//import io.cucumber.core.api.Scenario;

public class Merchate_User_PageObjects {

	WebDriver driver;

	public Merchate_User_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "users")
	public WebElement User_Menu_Button;

	@FindBy(xpath = "//*[@class='action_item']/a")
	public WebElement New_User_Button;

	@FindBy(id = "user_username")
	public WebElement Create_UserName;
	
	@FindBy(id = "user_password")
	public WebElement Create_Password;
	
	@FindBy(id = "user_email")
	public WebElement Create_Email;
	
	@FindBy(id = "user_submit_action")
	public WebElement Create_User_Button;
	
	@FindBy(xpath = "//*[@class='flash flash_notice']")
	public WebElement Create_Success_message;
	
	@FindBy(xpath = "//*[@class='row row-email']/td")
	public WebElement Created_email_id;
	
	@FindBy(id = "q_email")
	public WebElement Filter_email_Search;
	
	@FindBy(xpath = "//*[@value='Filter']")
	public WebElement Filter_button;
	
	@FindBy(xpath = "//*[@id='index_table_users']//tbody//td[@class='col col-username']")
	public WebElement Filter_Search_table_User;
	
	@FindBy(xpath = "//*[@id='index_table_users']//tbody//td[@class='col col-email']")
	public WebElement Filter_Search_table_Email;
	
	


}
