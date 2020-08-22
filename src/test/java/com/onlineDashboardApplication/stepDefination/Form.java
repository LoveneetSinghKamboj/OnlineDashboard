package com.onlineDashboardApplication.stepDefination;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Form {

    @Given("^user is in the form page$")
    public void user_is_in_the_form_page() throws Throwable 
    {
    
    	System.out.println("Hello");
    }

    @When("^user enters correct employeeID $")
    public void user_enters_correct_employeeid() throws Throwable {
       
    }

    @When("^user enter invalid employeeID$")
    public void user_enter_invalid_employeeid() throws Throwable {
        
    }

    @When("^user enters employee id$")
    public void user_enters_employee_id() throws Throwable {

    }

    @When("^user enter correct Employee id,$")
    public void user_enter_correct_employee_id() throws Throwable {
    
    }

    @Then("^form is submitted and confirmation page opens$")
    public void form_is_submitted_and_confirmation_page_opens() throws Throwable {
       
    }

    @Then("^error message \"([^\"]*)\" is shown$")
    public void error_message_something_is_shown(String strArg1) throws Throwable {
       
    }

    @Then("^all Supervisor Name will shown$")
    public void all_supervisor_name_will_shown() throws Throwable {
     
    }

    @Then("^show all fields are mandatory$")
    public void show_all_fields_are_mandatory() throws Throwable {
      
    }

    @Then("^Multiselect dropdown according to SLP$")
    public void multiselect_dropdown_according_to_slp() throws Throwable {
       
    }

    @Then("^Multiselect dropdown is empty$")
    public void multiselect_dropdown_is_empty() throws Throwable {
    
    }

    @And("^user selects Supervisor dropdown, slp dropdown, multiselect dropdown$")
    public void user_selects_supervisor_dropdown_slp_dropdown_multiselect_dropdown() throws Throwable {
      
    }

    @And("^user click on Submit button$")
    public void user_click_on_submit_button() throws Throwable {
       
    }

    @And("^user selects correct Supervisor, slp dropdown, multiselect dropdown$")
    public void user_selects_correct_supervisor_slp_dropdown_multiselect_dropdown() throws Throwable {
        
    }

    @And("^user click on Supervisor dropdown$")
    public void user_click_on_supervisor_dropdown() throws Throwable {
        
    }

    @And("^user selects Supervisor dropdown,SLP Trackdown$")
    public void user_selects_supervisor_dropdownslp_trackdown() throws Throwable {
  
    }

    @And("^user selects the Multiselect dropdown $")
    public void user_selects_the_multiselect_dropdown() throws Throwable {

    }

}
