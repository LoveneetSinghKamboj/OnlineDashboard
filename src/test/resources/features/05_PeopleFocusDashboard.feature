@PeopleFocusDashboard
Feature: PeopleFocusDashboard

Scenario: Admin verify correct data is displayed in table
    Given Admin in Dashboard Login Page 
	When Admin enters valid login id password 
	And submits a login button 
    And Admin clicks on People Focus week
	And clicks on Report Link under people focus week
    Then Checks Same set of data should be displayed in the people focus table
	
Scenario: Admin verify correct data is displayed when search in search box  
    Given Admin in Dashboard Login Page 
	When Admin enters valid login id password 
	And submits a login button 
    And Admin clicks on People Focus week
	And clicks on Report Link under people focus week
	And Send a Value in Search Box
    Then Checks Same set of data should be displayed in the people focus table
