Feature: User lands on Massimo Dutti Landing page

  User should be able to click on world market button and
  a side bar navigate should be displayed.
  So that the user can be able to select a Region, country and the language of their choice

  Background:
    Given User landing on Massimo Dutti landing page and accept cookies

    @landingPage
  Scenario Outline: User select location of preference
    Given the user clicks on the Select Location button
    When the user selects a "<Region>", then clicks on the "<Country>" and selects a "<Language>"
    Then the select Location button should display "<SelectedLocation>".

    Examples:
      | Region | Country      | Language | SelectedLocation       |
      | África | South Africa | English  | South Africa (English) |
      | África | Uganda       | English  | Uganda (English)       |

#@login
  Scenario: User select location of preference and click on Shop by Man button
    Given the user clicks on the Select Location button
    When the user selects a "África", then clicks on the "South Africa" and selects a "English"
    And the select Location button should display "South Africa (English)".
    And the user clicks on the "MEN" button.
    Then the home page partial link is validated.