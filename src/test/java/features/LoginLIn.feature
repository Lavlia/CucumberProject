Feature: This feature deals with the login functionality of the application
  As an account holder
  I want to login into an account
  So that i can use the application


  Scenario: Login to site with correct username and password
    Given I navigate to LinkedIn Website
    And I enter the following for Login
      | username           | password |
      | ********@gmail.com | ******** |
    And I click login button
    Then I should see the user home page


