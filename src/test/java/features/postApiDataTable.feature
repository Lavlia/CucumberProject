Feature: This feature adds books to a library website
  As an librarian
  I want to add books in the application
  So that i can keep track of books in my library


  Scenario: Test about adding books to a library website
    Given I am on the library website
    And I add different books
      | name                                    | isbn | aisle |
      | Learn Selenium Automation with Java     | aaa  | 01    |
      | Learn TestNG Automation with Java       | bbb  | 02    |
      | Learn Cucumber Automation with Java     | ccc  | 03    |
      | Learn Rest-assured Automation with Java | ddd  | 04    |
    Then I check if the status is correct
      | status  |
      | Created |
      | Created |
      | Created |
      | Created |
