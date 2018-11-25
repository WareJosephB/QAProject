package cucumberTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserTestSteps {

	FrontPage page;
	ArrayList<String> names;
	ArrayList<String> allNames;
	WebDriver driver = userTestRunner.driver;
	ExtentReports report = userTestRunner.report;
	ExtentTest test;

	@Given("^the website$")
	public void the_website() throws Throwable {
		driver.get("http://35.205.54.81:3000");
		FrontPage page = PageFactory.initElements(driver, FrontPage.class);
	}

	@Given("^that there are no users$")
	public void that_there_are_no_users() throws Throwable {
        test = userTestRunner.report.startTest("Add 1st user");
	}

	@When("^I make a user$")
	public void i_make_a_user() throws Throwable {
		page.newPlayerName.click();
		page.newPlayerName.clear();
		page.newPlayerName.sendKeys("A Good Name");
		page.newPlayerButton.click();
	}

	@Then("^there is one user, me$")
	public void there_is_one_user_me() throws Throwable {
		if(page.topPlayerName.getText().equals("A Good Name") && page.secondPlayerName.equals(null)) {
	        test.log(LogStatus.PASS, "Found one user, and it was you");
		} else {
			test.log(LogStatus.FAIL, "Error");
		}
		report.endTest(test);
		assertEquals(page.topPlayerName.getText(), "A Good Name");
		assertNull(page.secondPlayerName);
	}

	@Given("^a non-zero number of users$")
	public void a_non_zero_number_of_users() throws Throwable {
		if (page.noPlayers(userTestRunner.driver) == 0) {
			page.newPlayerName.sendKeys("A Bad Name");
			page.newPlayerButton.click();
		}
		int i = 0;
		boolean endOfList = false;
		while (!endOfList) {
			if (page.getPlayerXName(userTestRunner.driver, i).equals(null)) {
				endOfList = true;
			} else {
				names.add(page.getPlayerXName(userTestRunner.driver, i).toString());
				i += 1;
			}
		}
	}

	@Then("^there are all the previous users and me$")
	public void there_are_all_the_previous_users_and_me() throws Throwable {
		int i = 0;
		boolean endOfList = false;
		while (!endOfList) {

			while (!endOfList) {
				if (page.getPlayerXName(userTestRunner.driver, i).equals(null)) {
					endOfList = true;
				} else {
					names.add(page.getPlayerXName(userTestRunner.driver, i).toString());
					i += 1;
				}
			}
		}
		assertEquals(names.add("A Good Name"), allNames);
	}

	@Given("^a non-zero number of users including me$")
	public void a_non_zero_number_of_users_including_me() throws Throwable {
		int i = 0;
		boolean endOfList = false;
		while (!endOfList) {
			if (page.getPlayerXName(userTestRunner.driver, i).equals(null)) {
				endOfList = true;
			} else {
				names.add(page.getPlayerXName(userTestRunner.driver, i).toString());
				i += 1;
			}
		}
		assertEquals(names.add("A Good Name"), allNames);
		assertTrue(names.size() != 1);
	}

	@When("^I delete myself$")
	public void i_delete_myself() throws Throwable {
		names = new ArrayList<String>();
		allNames = new ArrayList<String>();
		int numBefore = page.noPlayers(driver);
		page.deletePlayerX(userTestRunner.driver, page.findMyNumber(userTestRunner.driver, "A Good Name"));
		int i = 0;
		boolean endOfList = false;
		while (!endOfList) {
			if (page.getPlayerXName(userTestRunner.driver, i).equals(null)) {
				endOfList = true;
			} else {
				allNames.add(page.getPlayerXName(userTestRunner.driver, i).toString());
				i += 1;
			}
		}
	}

	@Then("^I am no longer in the table but everyone else is$")
	public void i_am_no_longer_in_the_table_but_everyone_else_is() throws Throwable {
		assertTrue(!allNames.contains("A Good Name"));
		assertTrue(!(allNames.size() == 0));
	}

	@Given("^a single registered user$")
	public void a_single_registered_user() throws Throwable {
		names = new ArrayList<String>();
		int i = 0;
		boolean endOfList = false;
		while (!endOfList) {
			if (true) {
				endOfList = true;
			} else {
				names.add(page.getPlayerXName(userTestRunner.driver, i).toString());
				i += 1;
			}
		}
		while (names.size() > 1) {
			page.topDelete.click();
			names.remove(0);
		}
	}

	@Then("^there are no users left$")
	public void there_are_no_users_left() throws Throwable {
		assertEquals(null, page.topPlayerName);
	}

}
