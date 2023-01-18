@Delivery
  @Tests
Feature: Book Delivery by Providing Pick Up & Delivery Location

  @Valid
    @Smoke
  Scenario Outline:  Valid Scenario - Book Delivery
    Given User is on the Login Page
    When  User Enters Valid Login Credentials "<mobileNo>", "<password>" and clicks on the Login Button
    And Enters the delivery Details "<pickUpLocation>", "<deliveryLocation>", "<vehicle>" and "<deliveryDescription>"

    Examples:
      | mobileNo   | password     | pickUpLocation | deliveryLocation | vehicle | deliveryDescription |
      | 0727662019 | Tanzania@210 | Nairobi, Kenya | Nairobi, Kenya   | Boda    | 50                  |