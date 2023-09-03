Feature:Login to opencart

  Background:
    Given I am on opencart login page

  @test
  Scenario: Successful login with valid creds
    When I have entered a valid username and password
    And I click on the login button
    Then I should be logged in successfully

  @test
  Scenario Outline: Unsuccessful login with invalid or empty Creds
    When I have entered invalid "<username>" and "<password>"
    And I click on the login button
    Then i should see an error message indicating "<error_message>"

    Examples:
      | username          | password    | error_message                                                                                    |
      | invalid@email.com | invalidPass | Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour. |
      | anccc             | valid       | Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour. |
#      | anccc             | valid       | Warning: No match for E-Mail Address and/or Password. |

#  @test
  Scenario: navigate to forgotten password page
#    When I click on the "Forgotten Password" link
#    Then i should be redirecting to password reset page
