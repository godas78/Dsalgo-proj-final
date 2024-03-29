package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pages.Stackpage;
import com.qa.util.ConfigReader;
import com.qa.util.Loggerload;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StackSteps {
	Stackpage stackp = new Stackpage();
	
	String Excelpath = ConfigReader.getexcelfilepath();
	String expectedMsg;

	@When("The user selects Stack item from the drop down menu")
	public void the_user_selects_stack_item_from_the_drop_down_menu() throws InterruptedException {
		Loggerload.info("User click on Data Structure dropdown ");
		Loggerload.info("User select Stack from Data Structure dropdown ");
		stackp.dropdown_stack();
	}

	@Then("The user should be directed to {string} Page")
	public void the_user_should_be_directed_to_page(String string) {
		Loggerload.info("User redirected to Stack Data Structure Page ");
		String Title = stackp.getStackPageTitle();
		Loggerload.info("Title of current page is : " + Title);
		assertEquals(Title, "Stack", "Title do not match");
	}
	@When("The user clicks on the Operations in Stack link")
	public void the_user_clicks_on_the_operations_in_stack_link() {
		stackp.dropdown_stack();
		stackp.clickOnOperationsInstackpage();
	}

	@Then("The user should then be directed to {string} Page")
	public void the_user_should_then_be_directed_to_page(String string) {
		Loggerload.info("User redirected to Stack DataStructure Page ");
		String Title = stackp.getStackPageTitle();
		Loggerload.info("Title of current page is :" + Title);
		assertEquals(Title, "Operations in Stack", "Title do not match");
	}
	@When("The user clicks {string} button in {string} page")
	public void the_user_clicks_button_in_page(String bname, String dsname) throws InterruptedException {
		stackp.dropdown_stack();
		stackp.clickOnOperationsInstackpage();
		stackp.clickTryHereLink(bname, dsname);
	}
	@Given("The user is in stack page having an tryEditor with a Run button to test")
	public void the_user_is_in_stack_page_having_an_try_editor_with_a_run_button_to_test() {
		Loggerload.info("User redirected to a page having an tryEditor with a Run button to test");
		stackp.navigateTotryEditor();
		String Title = stackp.getStackPageTitle();
		Loggerload.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}

	@When("The user gets input from sheet {string} and {int}")
	public void the_user_gets_input_from_sheet_and(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		stackp.enterStackPythoncode(sheetName, rowNum);
		expectedMsg = stackp.getExpectedResult(sheetName, rowNum);
	}

	@When("The user clicks on Run button after Entering valid python code in stack tryEditor")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_stack_try_editor() {
		stackp.clickOnRun();
	}

	@Then("The user should be presented with Run output")
	public void the_user_should_be_presented_with_run_output() {
		Loggerload.info("Expected result - Excel Sheet :  " + expectedMsg);
		String actualMsg = stackp.getActualResult();
		Loggerload.info("Actual result  :" + actualMsg);
		assertEquals(actualMsg, expectedMsg);
	}

	@When("The user gets invalid input from sheet {string} and {int}")
	public void the_user_gets_invalid_input_from_sheet_and(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		Loggerload.info("The user enter python code with invalid syntax in tryEditor from sheetname :" + sheetName
				+ " and row number : " + rowNum);
		stackp.enterStackPythoncode(sheetName, rowNum);
	}

	@When("The user clicks on Run button after Entering invalid python code in stack tryEditor")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_stack_try_editor() {
		stackp.clickOnRun();
	}
	@Then("The user should be presented with error output")
	public void the_user_should_be_presented_with_error_output() {
		String actualMsg = stackp.getErrorText();
		Loggerload.info("Actual Error message is  :" + actualMsg);
		assertEquals(actualMsg,"NameError: name 'hello' is not defined on line 1", "Result do not match");
	}
	@When("The user clicks on the Implementation button")
	public void the_user_clicks_on_the_implementation_button() {
		stackp.dropdown_stack();
		stackp.clickOnimplementationlink();
	}

	@Then("The user should be directed to Implementation Page")
	public void the_user_should_be_directed_to_implementation_page() {
		Loggerload.info("User redirected to Stack Implementation Page ");
		String Title = stackp.getStackPageTitle();
		Loggerload.info("Title of current page is :" + Title);
		assertEquals(Title, "Implementation", "Title do not match");
	}
	@When("The user clicks on the Applications button")
	public void the_user_clicks_on_the_applications_button() {
		stackp.dropdown_stack();
		stackp.clickOnapplicationslink();
	}

	@Then("The user should be directed to Applications Page")
	public void the_user_should_be_directed_to_applications_page() {
		Loggerload.info("User redirected to Stack Implementation Page ");
		String Title = stackp.getStackPageTitle();
		Loggerload.info("Title of current page is :" + Title);
		assertEquals(Title, "Applications", "Title do not match");
	}
	@When("The user clicks on the Practice Questions button")
	public void the_user_clicks_on_the_practice_questions_button() {
		stackp.dropdown_stack();
		stackp.clickOnapplicationslink();
		stackp.clickOnPracticeQuestionspage();
	}

	@Then("The user should be directed to Practice Questions  Page")
	public void the_user_should_be_directed_to_practice_questions_page() {
		String Title = stackp.getStackPageTitle();
		Loggerload.info("Title of current page is :" + Title);
		assertEquals(Title, "Practice Questions", "Title do not match");
		Loggerload.info("NO questions found ");
	}

}
