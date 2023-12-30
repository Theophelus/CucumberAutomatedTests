Feature: Login functionality for Massimo Dutti E-commerce Website

    As a user of Massimo Dutti e-commerce Website
    I want to be able to login into my account,
    So I can access my account and manage all related functionality e.g my orders

  Background:
    Given user landing on Massimo Dutti login Page and accept cookies
    When the user validate the "LOG IN" title

#  @login
  Scenario: User should be able to login into Massimo Dutti E-commerce using correct Credentials
      Given the user enter valid "aneletom10@gmail.com" and "Bonaventura!20"
      And the user clicks on the "LOG IN" buttons.
      Then the user verify "MY ACCOUNT" link from navigation bar

  @login
  Scenario Outline: User should not be able to login using incorrect password and email address
    Given the user enter username email "<email>" and password "<password>"
    When the user clicks on the "LOG IN" buttons.
    Then the user validate the "<fieldRequiredMessage>" error message

    Examples:
      | email                | password    | fieldRequiredMessage   |
      |                      |             | This field is required |
      | aneletom10@gmail.com |             | This field is required |
      |                      | ewinenefnwk | This field is required |