Feature: Free CRM Login Feature

Scenario Outline: Free CRM Login Test Scenario

Given user open browser and comes to crm login page
When title of login page is Free CRM
Then user enters "<un>" and "<pwd>"
Then user clicks on login button
Then user comes to Home Page
Then close the Browser

Examples:
  |  un       | pwd      |
  | shashankk | test123  |
