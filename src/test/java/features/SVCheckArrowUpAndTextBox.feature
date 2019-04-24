Feature: This feature deals with functionality of the UI from Insights Page for Softvision Site
  As an user
  I want navigate to Insights Page
  So that check Arrow Up Button and Text Box for subscribe


  Background: I go to Softvision Site then i go to Insights Page
    Given I navigate to Softvision Site
    Then I click on Insights Page


  Scenario: I check the Arrow Up button
    Given I scroll down the page
    Then I click on Arrow Up Button


  Scenario: I check the Text Box for subscribe
    Given I click on Text Box
    Then I try to write something to the Text Box
