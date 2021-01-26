package stepDefinations;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javaFunctionality.Merchante_User_Functionality;

import java.io.IOException;

public class Merchante_User_StepDef {
	Merchante_User_Functionality MerchteUser;

	public Merchante_User_StepDef(TestContext context) {
		MerchteUser = new Merchante_User_Functionality(context);
	}

	@Given("user Lauch the application url {string} and verfiy page title")
	public void user_lauch_the_application_url_and_verfiy_page_title(String url) throws IOException {
		MerchteUser.lauchURl(url);
		MerchteUser.landingpage();
	}

	@And("user click on user button")
	public void user_click_on_user_button() {
		MerchteUser.User_Menu_click();
	}

	@And("user click on new user button")
	public void user_click_on_new_user_button() {
		MerchteUser.New_User_Menu_click();
	}

	@When("user enter the details and click on create user button {string} {string} {string}")
	public void user_enter_the_details_and_click_on_create_user_button(String username, String password, String email) {
		MerchteUser.UserCreation(username, password, email);
	}

	@Then("user see the success message and details on the page")
	public void user_see_the_success_message_and_details_on_the_page() {
		MerchteUser.UserSuccess_check();
	}

	@When("user enter email id in the filter box {string} and click on filter button")
	public void user_enter_email_id_in_the_filter_box_and_click_on_filter_button(String email) {
		MerchteUser.Emailfilter_result(email);
	}

	@Then("user see the created user details in the table  {string}  {string}")
	public void user_see_the_created_user_details_in_the_table(String user, String email) {
		MerchteUser.Filter_tableResult(user, email);
	}


}
