Feature: This feature verify different GET operation on planets from SW
  As a user
  I want to see details on the planets
  So that i can learn about SW universe

  Scenario: This scenario query on planets from SW universe
    Given I perform GET operation on all the planets
    And I perform GET for planets descriptions
    Then I store them in a list