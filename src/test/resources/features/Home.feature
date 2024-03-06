Feature: User navigates to OrangeHRM Management System

  @home
  Scenario: User should be able to navigate to home page
    Given User accesses the OrangeHRM Management Login page
    When the User enters Admin Credentials and clicks Login btn
    Then the User should be successfully logged in and directed to the Dashboard, where the Dashboard header text is verified.