Feature: Google Search

  Scenario: user can search any keyword in google
    Given an open browser with google
    When "Selenium" word has been written into input field and submitted
    Then the first should contain "selenium" result
    And close browser
