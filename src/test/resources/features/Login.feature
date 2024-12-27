Feature: Login Feature
  The feature verifies various aspects of the login functionality to ensure compliance with specifications.

  @logintag01
  Scenario: Successful login with valid credentials
    Given user is on login page
    And user enters valid credentials
    Then user is navigated to the home page

  @logintag02
  Scenario: To verify that login fails with an invalid username
    Given user is on login page
    And user enters invalid credentials
    Then error message should be displayed

  @logintag03
  Scenario: To verify that the logo is as per the client specification
    Given user is on login page
    Then the logo should be displayed
   # And the logo dimensions and alt text should match the specification
		And screenshot of the logo should be captured
		
  @logintag04
  Scenario: To verify that title is as per the specification
    Given user is on login page
    Then To verify Login page title

  @logintag05
  Scenario: To verify the username text is correct
    Given user is on login page
    Then username text should be Username

  @logintag06
  Scenario: To verify that username text field is clickable
    Given user is on login page
    Then the username text field should be clickable

  @logintag07
  Scenario: To verify that username is accepting the text
    Given user is on login page
    When user enters text in the username field
    Then username field should accept the text

  @logintag08
  Scenario: To verify that password text field is clickable
    Given user is on login page
    Then password text field should be clickable

  @logintag09
  Scenario: To verify that password is accepting the text
    Given user is on login page
    When user enters text in the password field
    Then password field should accept the text

  @logintag10
  Scenario: To verify that login fails with an invalid password
    Given user is on login page
    And user enters valid username and invalid password
    Then error message should be displayed

  #@logintag11
  #Scenario: To verify that a user can reset the password using "Forget Your Password"
    #Given user is on login page
    #When user clicks on Forget Your Password
    #Then user should be navigated to the reset password page

  @logintag12
  Scenario: To verify login button is visible
    Given user is on login page
    Then login button should be visible

  @logintag13
  Scenario: To verify that login button is clickable
    Given user is on login page
    Then login button should be clickable
