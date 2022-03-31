Feature: Login to webapp

  Background:
    Given User open webapp


  Scenario: Login with valid credentials
    When User input his email "info.director@mailinator.com"
    And User input his password "password"
    And User press Login button
    And User press Agree button on Privacy modal
    Then User go into Home page successfully






