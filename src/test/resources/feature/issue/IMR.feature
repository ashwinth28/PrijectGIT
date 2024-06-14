Feature: IMR Sanity Automation

## IMR Fully Received Flow ##

@IMR-Fully-1
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for IMR
And User enters the SCM Team Member "<username>" and "<password>" for IMR
When User create the PO Request for PO ORDER for IMR
When User click on the save button for IMR
When User click on the Edit button for IMR
When User verify the PO and providing Pre-Approval for IMR
When User click on the Save button for IMR
Then User verifies the PO Status has been changed and Signout for IMR

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@IMR-Fully-1
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for IMR
And User enters the Operations Head "<username>" and "<password>" for IMR
And User click on the Edit button for IMR
And User verify the PO and providing Final-Approval for IMR
When User click on the Save button for IMR
Then User verifies the PO Status has been changed and Signout for IMR

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@IMR-Fully-1
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for IMR
And User enters the SCM Team Member "<username>" and "<password>" for IMR
And User click on the Issue icon for IMR
When User click on the Issue button for IMR
Then User verifies the PO Status has been changed to Issued and Signout for IMR

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@IMR-Fully-1
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for IMR
And User enters the Store Team Member "<username>" and "<password>" for IMR
When User create the GRN Request for Fully Received for IMR
When User click on the save button for IMR
When User select the Fully Received status from the filter for IMR
When User click on the edit button for IMR
When User move the stock to the Store for IMR
When User click on the Save button for IMR
Then User click on the signout button for IMR

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@IMR-Fully
Scenario Outline: TC_05 Login with Camera Products Team and Create the IMR Request
Given User on the login page for IMR
And User enters the Camera Products Team Member "<username>" and "<password>" for IMR
When User create the IMR Request
When User click on the Save button for IMR
Then User click on the signout button for IMR

Examples: 
|username|password|
|r.ramkumar@e-consystems.com|Ram12345|

@IMR-Fully
Scenario Outline: PO_06 Login with Store Team Member and Issue the IMR
Given User on the login page for IMR
And User enters the Store Team Member "<username>" and "<password>" for IMR
When User select the IMR Requested status from the filter
When User click on the Issue icon for Issue Module for IMR
When User click on the Save button for IMR
When User select the IMR Issued status from the filter for IMR
Then User verifies the IMR Status has been changed to Issued and Signout for IMR

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## IMR Partially Received Flow ##

@IMR-Partially
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for IMR
And User enters the SCM Team Member "<username>" and "<password>" for IMR
When User create the PO Request for PO ORDER for IMR
When User click on the save button for IMR
When User click on the Edit button for IMR
When User verify the PO and providing Pre-Approval for IMR
When User click on the Save button for IMR
Then User verifies the PO Status has been changed and Signout for IMR

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@IMR-Partially
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for IMR
And User enters the Operations Head "<username>" and "<password>" for IMR
And User click on the Edit button for IMR
And User verify the PO and providing Final-Approval for IMR
When User click on the Save button for IMR
Then User verifies the PO Status has been changed and Signout for IMR

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@IMR-Partially
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for IMR
And User enters the SCM Team Member "<username>" and "<password>" for IMR
And User click on the Issue icon for IMR
When User click on the Issue button for IMR
Then User verifies the PO Status has been changed to Issued and Signout for IMR

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@IMR-Partially
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for IMR
And User enters the Store Team Member "<username>" and "<password>" for IMR
When User create the GRN Request for Fully Received for IMR
When User click on the save button for IMR
When User select the Fully Received status from the filter for IMR
When User click on the edit button for IMR
When User move the stock to the Store for IMR
When User click on the Save button for IMR
Then User click on the signout button for IMR

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@IMR-Partially
Scenario Outline: TC_05 Login with Camera Products Team and Create the IMR Request
Given User on the login page for IMR
And User enters the Camera Products Team Member "<username>" and "<password>" for IMR
When User create the IMR Request
When User click on the Save button for IMR
Then User click on the signout button for IMR

Examples: 
|username|password|
|r.ramkumar@e-consystems.com|Ram12345|

@IMR-Partially
Scenario Outline: PO_06 Login with Store Team Member and Issue the IMR
Given User on the login page for IMR
And User enters the Store Team Member "<username>" and "<password>" for IMR
When User select the IMR Requested status from the filter
When User click on the Issue icon for Issue Module for IMR
When User enter the Partially Issued Qty for IMR
When User click on the Save button for IMR
When User select the Partialy Issued status from the filter for IMR
When User click on the Issue icon for Issue Module for IMR
When User click on the Save button for IMR
When User select the IMR Issued status from the filter for IMR
Then User verifies the IMR Status has been changed to Issued and Signout for IMR

Examples: 
|username|password|
|store@e-consystems.com|Store123|