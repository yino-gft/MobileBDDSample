@login
Feature: User Login
  User login casuistics

  @validCredentialAndroid
  Scenario: Testing login with valid credential on Android device
    Given Open login page
    When Enter user name as "Hanna" and password as "111111"
    And Submit login page
    Then Rediret to user dashboard home page

  @invalidCredential
  Scenario: Testing login with invalid credential on Android device
    Given Open login page
    When Enter user name as "invalid" and password as "demoxxx"
    And Submit login page
    Then Return to login page
    
  @validCredentialIOS
  Scenario: Testing login with valid credential on iOS device
    Given Open login page
    When Enter user name as "Hanna" and password as "111111"
    And Submit login page
    Then Rediret to user dashboard home page