#Author: your.email@your.domain.com
#Keywords Summary : La la la

@globalposition
Feature: Global position
  Access to global position and validate that it working correctly

  Scenario: Validate global position on Android
    Given Log on santander mobile application with user "Hanna" and password "111111"
    When Access to global position
    Then Validate global position page