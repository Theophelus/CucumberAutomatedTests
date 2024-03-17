Feature: Employee List on Orange HRM Management System

  @PIM
  Scenario: Admin User lands on Employee List Page after clicking PIM
    Given User accesses the OrangeHRM Management Login page
    When the User enters Admin Credentials and clicks Login btn
    And the User navigates to PIM page
    Then the Employee List Tab should be pre selected

  @PIM
  Scenario: Validate Number of Employee Records
    Given User accesses the OrangeHRM Management Login page
    When  the User enters Admin Credentials and clicks Login btn
    And the User navigates to PIM page
    And the Employee List Tab should be pre selected
    And the Records Found text is visible
    And click on the 0273 record from the list
    Then the User validates "Personal Details" header text