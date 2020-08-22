Feature: Enter Details 

Background:
    Given user is in the form page

  Scenario: User inputs valid data and Submits form
    When user enters correct employeeID 
    And user selects Supervisor dropdown, slp dropdown, multiselect dropdown
    And user click on Submit button
    Then form is submitted and confirmation page opens

  Scenario: User enters invalid data
    When user enter invalid employeeID
    And user selects correct Supervisor, slp dropdown, multiselect dropdown
    Then error message "Please enter correct employeeID" is shown
    
    Scenario: Form Display valid Supervisor Data 
     When user enters employee id
     And user click on Supervisor dropdown
     Then all Supervisor Name will shown

   Scenario: User enters incomplete data
		When user enter correct Employee id,
		And user click on submit button
		Then show all fields are mandatory
 
	Scenario: Form displays correct dropdown
		When user enter correct employee id
		And user selects Supervisor dropdown,SLP Trackdown
		Then Multiselect dropdown according to SLP  
	
	Scenario: Dropdown Validation
		When user enter correct employee id
		And user selects Supervisor dropdown,
		And user selects the Multiselect dropdown 
		Then Multiselect dropdown is empty	