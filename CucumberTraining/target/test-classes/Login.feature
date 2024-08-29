#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Verify Login Page Scenario 
	Scenario Outline: Verify Successful login
		Given Launch Browser and navigate to URL
		When Enter Username <username>
		And Enter Password <password>
		And Click on LoginButton
		Then Verify Home Page is displayed
		Then Close the browser

Examples:
 |username|password|
 |"standard_user"|"secret_sauce"|
 |"error_user"|"secret_sauce"|
 |"visual_user"|"secret_sauce"|