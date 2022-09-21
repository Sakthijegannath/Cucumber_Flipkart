#Author: sakthi.email@your.domain.com
Feature: Mobile validation


  Scenario: Mobile Validation
  	Given Launching flipkart application for purchase
    When Searching mobile "Redmi"
    And Taking Mobile list
    And Selecting Mobile
    And Windows Handling
    And Taking Screenshot
    And User doing Validation
    And Buying the mobile
    And Radio button check
    And Delivery Details
    And Price Details
    Then User close the application
