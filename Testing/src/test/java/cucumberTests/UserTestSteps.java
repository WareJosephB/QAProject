package cucumberTests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserTestSteps {
	
	@Given("^the website$")
	public void the_website() throws Throwable {
	    userTestRunner.driver.get("http://35.205.54.81:3000");
	}

	@Given("^that there are no users$")
	public void that_there_are_no_users() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I make a user$")
	public void i_make_a_user() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^there is one user, me$")
	public void there_is_one_user_me() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^a non-zero number of users$")
	public void a_non_zero_number_of_users() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^there are all the previous users and me$")
	public void there_are_all_the_previous_users_and_me() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^a non-zero number of users including me$")
	public void a_non_zero_number_of_users_including_me() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I delete myself$")
	public void i_delete_myself() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I am no longer in the table but everyone else is$")
	public void i_am_no_longer_in_the_table_but_everyone_else_is() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^a single registered user$")
	public void a_single_registered_user() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^there are no users left$")
	public void there_are_no_users_left() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
