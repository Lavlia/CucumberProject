Feature:Verify different GET operations using REST-assured


  Scenario: Verify city weather with query on json
    When I perform GET operations for city weather
    And I perform GET for Great Britain
    And I perform GET for city London
    And I perform GET for city London temperature