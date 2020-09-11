@Dashboard
Feature: Dashboard
      
Scenario: Admin logins into dashboard 
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	Then Admin should be logged in into the dashboard 
	
Scenario: Admin logins into dashboard with invalid credentials 
	Given Admin is in Dashboard Login Page 
	When Admin user enters invalid login id password 
	And submit login button 
	Then message will be displayed Invalid credentials 

Scenario: To check if registered and updated data show in slp report
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button     	 
	Then Check data are reflect on dashboard that have register on registration page	
		
Scenario: Admin searches by employee id 
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	When user searches for employee id  in search employee id bar 
	Then slp report shows all suitable search for that employee id 
	
Scenario: Admin searches by employee name 
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	When user searches for employee name  in search employee name bar 
	Then slp report shows all suitable search for that employee name 
	
Scenario: Admin searches by registration date 
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	When user searches for registration date  in search registration date bar 
	Then slp report shows all suitable search for that registration date 
	
Scenario: Admin searches by superviser name 
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	When user searches for superviser name in search supervisor name bar 
	Then slp report shows all suitable search for that superviser name 
	
	
Scenario: Admin searches by track name 
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	When user searches for track name in search track name bar 
	Then slp report shows all suitable search for that track name 
	
Scenario: Admin searches by course 
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	When user searches for course  in search course bar 
	Then slp report shows all suitable search for that course 
	
Scenario: Admin searches by topic completed 
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	When user searches for topic completed in search topic completed bar 
	Then slp report shows all suitable search for that topic completed 
	
Scenario: Admin searches data in search box 
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	When admin searches for topic completed in search topic completed bar 
	Then search box shows all suitable searched data 
	
Scenario: Admin Checks Slp Report Export to Excel Functionality 
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	And click on Export to Excel button 
	And Slp Report file is downloaded 
	Then Match data with excel file to table 
	
Scenario: Admin Checks Track Report Export to Excel Functionality 
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	And Admin click on Chart link 
	And click on Track Report 
	And click on Export to Excel button 
	And Track Report file is downloaded 
	Then Match data with excel file to table 

Scenario: Admin Checks People Focus Report Excel Functionality
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
    And Admin click on People Focus week
	And click on Report Link under people focus week 
	And click on Export to Excel button
	And Focus People Report File is downloaded
	Then Match data with excel file to table 	

Scenario: Admin uploads excel sheet successfully
    Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	Then verify Dashboard page for supervisor upload
    When admin clicks on supervisor Page for supervisor upload
    When chooses the excelfile from location for supervisor upload
    And admin clicks on upload button for supervisor upload
    Then file is successfully uploaded

Scenario: Verify uploaded file
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	When admin clicks on supervisor Page for supervisor upload
	Then Verify Data from excel file is imported in the table for supervisor upload

 Scenario: Admin searches data in the search box
    Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button
	When admin clicks on supervisor Page for supervisor upload
	When admin searches for particular data for supervisor upload
    Then search box shows all suitable searched result for supervisor upload
	
Scenario: Admin Checks Supervisor Data Report Excel Functionality
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	When admin clicks on supervisor Page for supervisor upload	
	And click on Export to Excel button
	And Supervisor Data Report File is downloaded
	Then Match data with excel file to table 

Scenario:  Admin uploads empList excel sheet successfully
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	Then verify Dashboard page
    When admin clicks on Employee Page
	When choose the excelfile from location for emp upload
    And admin clicks on upload button
     Then file is successfully uploaded

Scenario: Verify emplist uploaded file
    Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	Then verify Dashboard page
    When admin clicks on Employee Page
    Then Verifies the Data from excel file is imported in the table
    
Scenario: Admin searches emp data in the search box
    Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	Then verify Dashboard page
	When admin clicks on Employee Page
	When admin searches for particular data
    Then search box shows all suitable searched result
 
Scenario: Admin Checks Employee Data Report Excel Functionality
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button 
	When admin clicks on Employee Page
	And click on Export to Excel button
	And Employee Data Report File is downloaded
	Then Match data with excel file to table     
	
Scenario: Updated Courses percentage reflect in track report page
	Given Admin is in Dashboard Login Page 
	When Admin user enters valid login id password 
	And submit login button     
	Then Table track report matches couses values from slp report 
	

 
 
 
    