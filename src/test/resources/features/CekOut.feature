Feature: Checkout Process

  Scenario: User checks out successfully
    Given user login with valid username and password
    When user adds the first two items to the cart
    And user proceeds to checkout
    And user enters checkout information
    And user clicks continue
    And user clicks finish
    Then checkout is complete with success messages
    And user verifies the order confirmation details
    And user returns to home page
    And user verifies products are still displayed
