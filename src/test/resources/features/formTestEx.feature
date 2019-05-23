Feature: Form Test

  Scenario: user can register on the page https://aavtrain.com/
    Given browser opened with "page"
    When user clicks on registration button
    Then user is on registration page
    When user fills all mandatory fields
      | Karol         |
      | Kowalski      |
      | karol@dupa.hu |
      | karolek1      |

