Feature: This feature deals with functionality of the UI from Left Main Menu for Softvision Site
  As an user
  I want to navigate through Left Main Menu
  So that check what information it provides


  Scenario Outline: Test About Home Page of the Softvision Site
    Given I am on the Softvision Site
    And I click on <LinkElement> on Left Main Menu
    Then I check if Element have the correct <elementTitle>

    Examples:
      | LinkElement | elementTitle |
      | What        | What's new   |
      | Solutions   | Solutions    |
      | Talent      | Talent       |
      | Studios     | Studios      |



