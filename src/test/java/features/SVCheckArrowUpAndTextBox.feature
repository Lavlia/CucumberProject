Feature: This feature deals with functionality of the UI from Insights Page for Softvision Site
  As an user
  I want navigate to Insights Page
  So that check Arrow Up Button and Text Box for subscribe


  Background: I go to Softvision Site then i go to Insights Page
    Given I navigate to Softvision Site
    When I click on Insights Page


  Scenario: I check the Arrow Up button
    When I scroll down the page
    And I click on Arrow Up Button
    Then I check the button title


  Scenario: I check the Text Box for subscribe
    When I click on Text Box
    And I try to write something to the Text Box
    Then I should see the text i wrote
