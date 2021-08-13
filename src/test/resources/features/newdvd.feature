Feature: DVD store accepts new dvds
  As a user, when I add a new DVD to my store, then the DVD should be saved to the stores item list.

  Scenario: Adding a DVD
    Given a dvd store
    And the following new DVDs
      | Title  | Year | Actor  |
      | Film 1 | 2001 | Actor  |
      | Film 2 | 2000 | Bactor |
    And the expected outputs
      | Film 1 - 2001 - Actor  |
      | Film 2 - 2000 - Bactor |
    When the new DVDs are added to the store
    Then the get dvd list request should return the expected outputs
