Feature: Form Test
  Scenario: user can register on the web side
    Given there is a browser opened with home page
    When user clicks on registration button
    Then user is on registration page
    When user fills all mandatory fields with values
      | first_name | Adrian          |
      | last_name  | Lachowski       |
      | email      | adian@gmail.com |
      | user_name  | adrian1988      |
      | address1   | krakow          |
      | city       | krakow          |
      | prov       | CA              |
      | zip        | 90210           |
      | password   | PASSWORD_123    |
  Scenario Outline: many users can register
    Given there is a browser opened with home page
    When user clicks register button
    Then user is on reogstration page
    When input field firstname is filled with <firstnameparameter>
    And input field lastname is filled with <lastnameparameter>
    And input field email is filled with <emailparameter>
    And input field uername is filled with <usernameparameter>
    And input field city is filled with <cityparameter>
    And input field state is filled with <stateparameter>
    And input field zip is filled with <zipparameter>
    Examples:
      | firstnameparameter | lastnameparameter | emailparameter | usernameparameter | cityparameter | stateparameter | zipparameter |
      | Adrian             | Lachowski         | dsfghjdsfg@com | lkdsjfdj          | kdjsfhsd      | CA             | 90210        |
      | Adam               | Malysz            | salkdjd.com    | dskfhsjkdf        | sdfhsdkfjh    | FL             | 12345        |
      | Lionel             | Messi             | sdfjhdssd.     | sddsfnkds         | dvmfklv       | NY             | 67898        |




