@Registration
Feature: Registration Form Validation

  Background: 
    Given user is in the Registration form
    
    Scenario: User inputs valid data and Registers
    When user enters correct employee Id
    And user selects Supervisor dropdown, SLP Track dropdown
    And user click on register button
    Then user is registered and confirmation page opens saying "Thank You"
    
    Scenario: User registers with existing Employee ID
    When user enters an existing employeeID
    And user selects Supervisor dropdown, SLP Track dropdown
    And user click on register button
    Then Error message showing "This employee is already registered !"

  Scenario: User only enters Employee ID
    When user enter correct Employee id
    And user click on register button
    Then alert message shows "Please select Supervisor"

  Scenario: User only selects Supervisor
    When user selects supervisor
    And user click on register button
    Then alert message popup "Please enter valid Employee ID"

  Scenario: User only selects SLP Track
    When user selects SLP Track
    And user click on register button
    Then alert message popup "Please enter valid Employee ID"
    
    Scenario: User enters invalid EmployeeID
    When user enter invalid employee id
    And user selects Supervisor dropdown, SLP Track dropdown
    And user click on register button
    Then error message "Invalid Employee Id"
    

  Scenario: User registers with empty form
    When user click on register button
    Then alert message popup "Please enter valid Employee ID"

  Scenario: User enters characters in Employee ID field
    When user enters characters as employeeID
    And user selects Supervisor dropdown, SLP Track dropdown
    And user click on register button
    Then alert message popup "Please enter valid Employee ID"

  Scenario: user registers with empty employee Id
    When user selects Supervisor dropdown, SLP Track dropdown
    And user click on register button
    Then alert message popup "Please enter valid Employee ID"

  Scenario: user registers without choosing supervisior
    When user enters correct employee Id
    And user selects SLP Track
    And user click on register button
    Then alert message shows "Please select Supervisor"

  Scenario: user registers without choosing slp Track
    When user enters correct employee Id
    When user selects supervisor
    And user click on register button
    Then alert box message display "Please select track !"
