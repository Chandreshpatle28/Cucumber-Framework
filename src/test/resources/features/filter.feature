
@tag
Feature: Filter feature
  
  @filtertag1
  Scenario: Verify filter functionality is displayed on the dashboard
    Given user is on login page
		And user enters valid credentials
		Then user is navigated to the home page
		And Filter section should be displayed on the dashboard

  @filtertag2
  Scenario: Verify the display of by default filter option
    Given user is on login page
		And user enters valid credentials
		Then user is navigated to the home page
		And Filter section should be displayed on the dashboard
		And default option in the Filter dropdown should be visible


  @filtertag3
  Scenario: Verify the display of filter functionality and selecting the first option
  	Given user is on login page
		And user enters valid credentials
		Then user is navigated to the home page
		And Filter section should be displayed on the dashboard
		And Filter dropdown should be visible
		When user clicks on the Filter dropdown
		Then dropdown should display a list of options
		And user selects the first option from the dropdown
  	