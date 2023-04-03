Feature: CalculateFeature
  Scenario: Sum of two integers
    Given the first number is 10
    And the second number is 20
    When I add the two numbers
    Then the result should be 30