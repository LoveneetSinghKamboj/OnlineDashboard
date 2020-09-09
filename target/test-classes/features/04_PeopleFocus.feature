@PeopleFocusUI
Feature: People Focus Week Form Validation

  Background: 
    Given user is in the People Focus Week form
    
    Scenario: User inputs valid data and Registers
    When user enters a correct employee id
    And user selects designation dropdown,supervisor dropdown,f2fdone dropdown,f2f date
    And user enters issues,appreciation,escalation,remarks
    And user clicks on the register button
    Then user is registered and confirmation page opens displaying message "Thank You"
    
    Scenario: User inputs valid data and Registers
    When user enters another correct employee id
    And user selects designation dropdown,supervisor dropdown
    And user selects f2fdone as No
    And user enters issues,appreciation,escalation,remarks
    And user clicks on the register button
    Then user is registered and confirmation page opens displaying message "Thank You"
    
    Scenario: User registers with existing Employee ID
    When user enters a correct employee id
    And user selects designation dropdown,supervisor dropdown,f2fdone dropdown,f2f date
    And user enters issues,appreciation,escalation,remarks
    And user clicks on the register button
    Then Alert popups message shows "Please try to create your profile after 6 months from your registration date as this employee Id is already registered !"

  Scenario: User only enters Employee ID
    When user enters a correct employee id[1]
    And user clicks on the register button
    Then alert message showing "Please select designation !"

Scenario: User only enters Designation
    When user selects only designation
    And user clicks on the register button
    Then alert message popups "Please enter valid employee Id !"

  Scenario: User only selects Supervisor
    When user selects only supervisor
    And user clicks on the register button
    Then alert message popups "Please enter valid employee Id !"

  Scenario: User only selects F2F Done
    When user selects only F2F done
    And user clicks on the register button
    Then alert message popups "Please enter valid employee Id !"
    
    Scenario: User enters invalid EmployeeID
    When user entering invalid employeeid
    And user selects designation dropdown,supervisor dropdown,f2fdone dropdown,f2f date
    And user enters issues,appreciation,escalation,remarks
    And user clicks on the register button
    Then error message showing "Invalid employee Id !"
    
  Scenario: User registers with empty form
    When user clicks on the register button
    Then alert message popups "Please enter valid employee Id !"
    
  Scenario: User enters characters in Employee ID field
    When user enters characters as employeeID_char
    And user selects designation dropdown,supervisor dropdown,f2fdone dropdown,f2f date
    And user enters issues,appreciation,escalation,remarks
    And user clicks on the register button
    Then alert message popups "Please enter valid employee Id !"

  Scenario: user registers with empty employee Id
    When user selects designation dropdown,supervisor dropdown,f2fdone dropdown,f2f date
    And user enters issues,appreciation,escalation,remarks
    And user clicks on the register button
    Then alert message popups "Please enter valid employee Id !"

  Scenario: user registers without choosing designation
    When user enters a correct employee id
    And user selects supervisor dropdown,f2fdone dropdown,f2f date
    And user enters issues,appreciation,escalation,remarks
    And user clicks on the register button
    Then alert message showing "Please select designation !"

  Scenario: user registers without choosing supervisor
    When user enters a correct employee id
    And user selects designation dropdown,f2fdone dropdown,f2f date
    And user enters issues,appreciation,escalation,remarks
    And user clicks on the register button
    Then alert popup message displaying "Please select supervisor !"
    
  Scenario: user registers without choosing f2fdone
    When user enters a correct employee id
    And user selects desigantion dropdwon,supervisor dropdown
    And user enters issues,appreciation,escalation,remarks
    And user clicks on the register button
    Then alert message box displaying "Please select f2f Done !"
    
  Scenario: user registers without choosing f2fdate
    When user enters a correct employee id
    And user selects only desigantion dropdwon,supervisor dropdown,f2f done
    And user enters issues,appreciation,escalation,remarks
    And user clicks on the register button
    Then alert popup message box displaying message as Please select f2f Date!