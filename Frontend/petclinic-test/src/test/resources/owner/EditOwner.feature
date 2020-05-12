Feature: Edit Owner
  As a employee
  I want to Edit owner information
  So that it remains up to date


  Scenario: Successfully owner data retrieved to be updated
    Given I am on the edit owner information form
    Then  The current owner data are pre-set in the fields

  Scenario: Successfully update owner information
    Given I am on the edit owner information form
    And  I clear all fields
    And I Enter updated valid data
    When  I submit the edit form
    Then  The updated owner will be displayed in the Owner page with updated information


  Scenario: Unsuccessfully edit an owner
    Given I am on the edit owner information form
    When  I clear all fields
    And I Enter updated valid data
    And  I enter non numeric telephone data
    Then  The edit submit button is disabled

  Scenario: Unsuccessfully edit an owner
    Given I am on the edit owner information form
    When  I clear all fields
    Then  The edit submit button is disabled