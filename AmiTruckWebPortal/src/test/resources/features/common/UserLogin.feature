@Login
@Personal
@Tests
Feature: As a User I should be Able to Login using Valid Credentials and
  Error Messages should be displayed When Using Invalid credentials.

  @Smoke
    @Valid
  Scenario Outline: User Login - Valid Credentials
    Given User is on the Login Page
    When User Enters Valid Login Credentials "<mobileNo>", "<password>" and clicks on the Login Button
    Then User should be Logged In and Navigated to the Landing Page

    Examples:
      | mobileNo   | password     |
      | 0727662019 | Tanzania@210 |

  @Invalid
  Scenario Outline:  User Login - Blank Credentials
    Given User is on the Login Page
    When User Enters Valid Login Credentials "<mobileNo>", "<password>" and clicks on the Login Button
    Then An Error Message Should be Displayed

    Examples:
      | mobileNo | password |
      |          |          |

  @Invalid
  Scenario Outline:  User Login - Invalid Credentials
    Given User is on the Login Page
    When User Enters Valid Login Credentials "<mobileNo>", "<password>" and clicks on the Login Button
    Then An Account Does not Exist Error Message Should be Displayed

    Examples:
      | mobileNo  | password |
      | 072727939 | 0191823  |