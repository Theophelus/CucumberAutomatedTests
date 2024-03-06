Feature: User must be able to login with Admin Credentials on OrangeHRM Management

  User should be able to login into the OrangeHRM Management as an admin

  @login
  Scenario: Login into OrangeHRM Management Successfully as Admin
    Given User accesses the OrangeHRM Management Login page
    When the User enters Admin Credentials and clicks Login btn
    Then the User should be successfully logged in and directed to the Dashboard, where the Dashboard header text is verified.