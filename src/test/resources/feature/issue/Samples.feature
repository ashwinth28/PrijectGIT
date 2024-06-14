Feature: Samples Sanity Automation

## Samples Fully Received Flow ##

## GRN CREATION - Fully Received

@Samples-Fully
Scenario Outline: PO_01 Login with Store Team Member and Create the GRN
Given User on the login page for Samples
And User enters the Store Team Member "<username>" and "<password>" for Samples
When User create the GRN Request for Fully Received for Samples
When User click on the save button for Samples
When User select the Fully Received status from the filter for Samples
When User click on the edit button for Samples
When User move the stock to the Store for Samples
When User click on the Save button for Samples
Then User click on the signout button for Samples

Examples: 
|username|password|
|r.sureshkumar@e-consystems.com|Suresh123|

@Samples-Fully
Scenario Outline: TC_02 Login with PM Team and Create the Samples Request
Given User on the login page for Samples
And User enters the PM Team Member "<username>" and "<password>" for Samples
When User create the Samples Request
When User click on the Save button for Samples
Then User click on the signout button for Samples

Examples: 
|username|password|
|s.prabhakar@e-consystems.com|Prabhakar123|

@Samples-Fully
Scenario Outline: PO_03 Login with Store Team Member and Issue the Samples
Given User on the login page for Samples
And User enters the Store Team Member "<username>" and "<password>" for Samples
When User select the Samples Requested status from the filter for Samples
When User click on the Issue icon for Issue Module for Samples
When User enters the Issue Qty Fully for Samples
When User click on the Save button for Samples
When User select the Samples Issued status from the filter for Samples
Then User verifies the Samples Status has been changed to Issued and Signout for Samples

Examples: 
|username|password|
|r.sureshkumar@e-consystems.com|Suresh123|
