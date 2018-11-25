Feature: Adding users
  As a user
  I want to be able to add myself
  So that I can track my ELO

  Scenario: Add a user when there are no users
    Given the website
    And that there are no users
    When I make a user
    Then there is one user, me

  Scenario: Add a user where there are users
    Given the website
    And a non-zero number of users
    When I make a user
	Then there are all the previous users and me
	
  Scenario: Delete a user when there are other users
    Given the website
    And a non-zero number of users including me
    When I delete myself
    Then I am no longer in the table but everyone else is
    
  Scenario: Delete a user when you are the only one
    Given the website
    And a single registered user
    When I delete myself
	Then there are no users left