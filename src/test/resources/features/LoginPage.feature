Feature: Login functionality for Orange HRM Website Open Source HR Management

  As a user of Orange HRM Website Open Source HR Management
    I want to be able to login into my account,
    So I can access my account and manage all related functionality e.g my orders

  @login
  Scenario: User should be able to login into Orange HRM Website Open Source HR Management using correct Credentials
    Given user landing to Orange HRM login Page
    When the user enter username email "Admin" and password "admin123"
    And the user clicks on the "Login" button on Landing page.
    Then the user validate landing page text "Dashboard"