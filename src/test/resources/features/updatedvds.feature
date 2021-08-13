Feature: DVD store can update DVDs
  As a user, when I update the details of a film, the changes should be reflected in the stores item list.

  Scenario: Updating DVDs
    Given a dvd store
    And the following DVDs in the store
      | Title  | Year | Actor  |
      | Film 1 | 2000 | Actor  |
      | Film 2 | 2021 | Bactor |
    And the expected outputs
      | Film 1 - 2000 - Sactor |
      | Film 2 - 2021 - Bactor |
    When I change the actor of the film with the id 1 to "Sactor"
    Then the get dvd list request should return the expected outputs
