Feature: Sorting

  Scenario: Sorting items low to high price
    Given user login with valid username and password
    And user click on filter button
    When user click on low to high button
    Then items are lined up in order of low price to high price

  Scenario: Sorting items high to low price
    Given user login with valid username and password
    And user click on filter button
    When user click on high to low button
    Then items are lined up in order of high price to low price

  Scenario: Sorting items by name A to Z
    Given user login with valid username and password
    And user click on filter button
    When user click on name A to Z button
    Then items are lined up in order of name A to Z

  Scenario: Sorting items by name Z to A
    Given user login with valid username and password
    And user click on filter button
    When user click on name Z to A button
    Then items are lined up in order of name Z to A

