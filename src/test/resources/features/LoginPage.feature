Feature: Login functionality for Orange HRM Website Open Source HR Management

  As a user of Orange HRM Website Open Source HR Management
    I want to be able to login into my account,
    So I can access my account and manage all related functionality e.g my orders

  @wip
  Scenario: User should be able to login into Orange HRM Website Open Source HR Management using correct Credentials
    Given user landing to Orange HRM login Page
    When the user enter username email "Admin" and password "admin123"
    And the user clicks on the "Login" button on Landing page.
    Then the user validate landing page text "Dashboard"

  @wip
  Scenario Outline: User should not be able to login into Orange HRM Website Open Source HR Management using incorrect Credentials
    Given user landing to Orange HRM login Page
    When the user enter username email "<email>" and password "<password>"
    And the user clicks on the "Login" button on Landing page.
    Then the user should validate error message text "<requiredFields>"

    Examples:
      | email  | password | requiredFields      |
#      |        | admin123 | Required            |
#      | Admin  |          | Required            |
      | frinir | rrikvnr  | Invalid credentials |
