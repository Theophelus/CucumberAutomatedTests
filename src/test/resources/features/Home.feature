Feature: User navigates to OrangeHRM Management System

  @home
  Scenario: User should be able to navigate to home page
    Given User accesses the OrangeHRM Management Login page
    When the User enters Admin Credentials and clicks Login btn
    And the User should be successfully logged in and directed to the Dashboard, where the Dashboard header text is verified.
    Then the user validates all the sidebar navigation links on OrangeHRM Management page site:
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Claim       |
      | Buzz        |

  @home
  Scenario: On landing from OrangeHRM Management system, Dashboard link should be pre-selected
    Given User accesses the OrangeHRM Management Login page
    When the User enters Admin Credentials and clicks Login btn
    And the User should be successfully logged in and directed to the Dashboard, where the Dashboard header text is verified.
    Then dashboard on the sidebar navigation should be pre-selected Dashboard