Feature: Testing www.goibibo.com website

  Scenario: User wanted to go for Oneway Trip
    Given user on goibibo page
    When user select Oneway trip on goibibo page
    And user select the start and end point of travelling location for Onewaytrip
      | Pune | Mysore |
    And user select Departure date and future returning date
    	| October | 2022 | 20 | November | 2022 | 15 |
    And user select the travelling details as Student and travel class from page
    And user search and select cheapest price
    And user click on Book now button
    Then user should get details regarding booking

  Scenario: User wanted to go for RoundTrip
    Given user on goibibo page
    When user select Round trip on goibibo page
    And user select the start and end point of travelling location for Roundtrip
      | Kolhapur | Puducherry |
    And user select Departure date and future returning date
    	| October | 2022 | 20 | November | 2022 | 15 |
    And user select the travelling details as Regular and travel class from page
    And user search and select cheapest price
    And user should get the Not Flight Available Message
    Then user should go back to original Page
