Feature: DVD store can remove old DVDs
  As a user, when I remove a DVD from the store, the DVD should longer be available in the stores item list.

  Scenario: Remove a DVD
    Given a dvd store
    And the following DVDs in the store
    | Title | Year | Actor |
    | Film 1 | 2000   | Actor  |
    | Film 2 | 2021 | Bactor |
    And the expected outputs
    | Film 1  - 2000 - Actor |
    And the dvd to remove with the id 2
    When the dvd is removed
    Then the get dvd list request should return the expected output
