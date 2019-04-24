Feature: This feature verify different GET operation on people from SW
  As a user
  I want to see details on the people
  So that i can learn about SW universe

  Scenario: This scenario query on people from SW universe
    Given I perform GET operation on all the people
    And I perform GET for people descriptions
    Then I store them in another list