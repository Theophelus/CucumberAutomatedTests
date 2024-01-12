Feature: User should be able to validate social networks links under footer page

  @footer
  Scenario Outline: A user validates social links
    Given User landing on Massimo Dutti home page and accept cookies
    When the user check of "Massimo Dutti" header is visible
    And the user smooth scroll to the social network footer container
    Then the user validate all the social networks on Massimo dutti site "<social>"

    Examples:
      | social    |
      | INSTAGRAM |
      | x         |
      | TIKTOK    |
      | FACEBOOK  |
      | PINTEREST |
      | YOUTUBE   |