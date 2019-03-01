Feature: PostProfile
  Test POST operation using REST-assured library

  Scenario: Verify Post operation for Streams
    Given I Perform POST operation for "http://localhost:3000/streams" with body
     | id | title             | description           |
     |    | whatever          | idk what im doing     |
    Then I should see the body has title as "whatever"

  Scenario: Get a status code of 500
    Given I Perform POST operation for "http://localhost:3000/streams" with body
      | id | title             | description            |
      |  1 | idk               | listening to a podcast |
    Then I should see the status code "500" Intertal server error