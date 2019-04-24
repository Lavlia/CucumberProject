Feature: This feature adds books to a library website
  As an librarian
  I want to add books in the application
  So that i can keep track of books in my library


  Scenario Outline: Test about adding books to a library website
    Given I am on the library site
    And I add different books <name> with unique <isbn> and store then on their <aisle>
    Then I check if books have the correct <status>

    Examples:
      | name                                    | isbn | aisle | status  |
      | Learn Selenium Automation with Java     | aaa  | 01    | Created |
      | Learn TestNG Automation with Java       | bbb  | 02    | Created |
      | Learn Cucumber Automation with Java     | ccc  | 03    | Created |
      | Learn Rest-assured Automation with Java | ddd  | 04    | Created |

