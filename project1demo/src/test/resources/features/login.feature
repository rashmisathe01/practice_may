Feature: Login Functionality

  Background:
    Given user opens the browser
    And user navigates to "https://practice.expandtesting.com/login"

  Scenario Outline: Validate login with multiple credentials
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on login button
    Then user should see message "<expected_message>"

    Examples:
      | username   | password               | expected_message                    |
      | practice   | SuperSecretPassword!   | You logged into a secure area!      |
      | Practice   | SuperSecretPassword!   | You logged into a secure area!      |
      | PRACTICE   | SuperSecretPassword!   | You logged into a secure area!      |
      |practice1   | SuperSecretPassword!   |You logged into a secure area!      |
      | practice   | supersecretpassword!   | Your password is invalid!           |
      | wronguser  | SuperSecretPassword!   | Your password is invalid!           |
      | wronguser  | wrongpass              | Your password is invalid!           |
      |            |                        | Your username is invalid!           |
      | practice   |                        | Your username is invalid!           |
      |            | SuperSecretPassword!   | Your username is invalid!           |
     