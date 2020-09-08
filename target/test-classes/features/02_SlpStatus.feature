@SLp
Feature: SLP Status

Background:
    Given user is on the SLP status tracking page
  
  Scenario: user enters invalid employee id and checks status
     When user enter incorrect employee Id
      And user click check status button
     Then Pop up box appears, Invalid Employee id
   
   Scenario: user checks Supervisor
     When user enters valid employee id 
     And user click check status button   
     Then user check corrrect supervisor is populated
     
  Scenario: user cannot change Supervisor and SLP Track
     When user enters valid employee id    
     And user click check status button
     Then Check User cannot change Supervisor or SLP Track
            
  Scenario: All DropDown are based on SLP Track
     When user enters valid employee id
     And user click check status button    
     Then Courses Dropdown are based on SLP Track   
         
  Scenario: user checks status
     When user enters valid employee id 
     And user click check status button
     Then user will be displayed with employee id,supervisor,slp track,selenium dropdown,java dropdown,cucumber dropdown
   
  Scenario: user enters valid employee id and checks status
     When user enters valid employee id
     And user click check status button
     And user selects course dropdown
     And user click updates button
     Then message will be shown Thank you for the update    
    
  Scenario: user check course updated successfully
    When user enters valid employee id
    And user click check status button
    Then user check priviously updated courses are checked
    
   Scenario: user select only one course to update 
     When user enters valid employee id
     And user click check status button
     And user update one course
     And user click updates button
     Then message will be shown Thank you for the update 
       