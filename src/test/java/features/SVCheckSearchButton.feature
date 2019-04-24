Feature: This feature deals with functionality of the UI for Search Button in Softvision Site
  As an user
  I want to navigate to Search field
  So that I search information about Softvision in articles from 2019

  Scenario: Test About Search Button of the Softvision Site
    Given I am on the Softvision Home Page
    When I click on Search Button on Softvision Home Page
    And I search the year 2019
    Then I check if search engine sends the search
