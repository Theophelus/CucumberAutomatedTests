Feature: Employee List on Orange HRM Management System

  @PIM
  Scenario: Admin User lands on Employee List Page after clicking PIM
    Given User accesses the OrangeHRM Management Login page
    When the User enters Admin Credentials and clicks Login btn
    And the User navigates to PIM page
    Then the Employee List Tab should be pre selected