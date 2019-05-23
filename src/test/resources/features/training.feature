Feature: training

  Scenario: a test without a purpose
    Given something is done
    When "sample work" is printed
    And 22 is printed correctly
    But we can use a list as well
      | cat  |
      | dog  |
      | lion |

  Scenario Outline: singing   // dwa zestawy parametrów
    Given people trying singing
    When now <person> trying
    Then sings <how>
    Examples:
      | how       | person |
      | ugly      | me     |
      | beautiful | you    |
      | good      | Damian |
      | tia       | Albert |
