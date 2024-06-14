Feature: EMS Sanity Automation

## EMS Fully Received Flow ##

@EMS-Fully-1
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for EMS
And User enters the SCM Team Member "<username>" and "<password>" for EMS
When User create the PO Request for PO ORDER for EMS
When User click on the save button for EMS
When User click on the Edit button for EMS
When User verify the PO and providing Pre-Approval for EMS
When User click on the Save button for EMS
Then User verifies the PO Status has been changed and Signout for EMS

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@EMS-Fully-1
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for EMS
And User enters the Operations Head "<username>" and "<password>" for EMS
And User click on the Edit button for EMS
And User verify the PO and providing Final-Approval for EMS
When User click on the Save button for EMS
Then User verifies the PO Status has been changed and Signout for EMS

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@EMS-Fully-1
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for EMS
And User enters the SCM Team Member "<username>" and "<password>" for EMS
And User click on the Issue icon for EMS
When User click on the Issue button for EMS
Then User verifies the PO Status has been changed to Issued and Signout for EMS

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@EMS-Fully-1
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for EMS
And User enters the Store Team Member "<username>" and "<password>" for EMS
When User create the GRN Request for Fully Received for EMS
When User click on the save button for EMS
When User select the Fully Received status from the filter for EMS
When User click on the edit button for EMS
When User move the stock to the Store for EMS
When User click on the Save button for EMS
Then User click on the signout button for EMS

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@EMS-Fully
Scenario Outline: TC_05 Login with PM Team and Create the EMS Request
Given User on the login page for EMS
And User enters the PM Team Member "<username>" and "<password>" for EMS
When User create the EMS Request
When User click on the Save button for EMS
Then User click on the signout button for EMS

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@EMS-Fully
Scenario Outline: PO_06 Login with Store Team Member and Issue the EMS
Given User on the login page for EMS
And User enters the Store Team Member "<username>" and "<password>" for EMS
When User select the EMS Requested status from the filter
When User click on the Issue icon for Issue Module for EMS
When User click on the Save button for EMS
When User select the EMS Issued status from the filter for EMS
Then User verifies the EMS Status has been changed to Issued and Signout for EMS

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## EMS Partially Received Flow ##

@EMS-Partially
Scenario Outline: TC_01 Login with PM Team and Create the EMS Request
Given User on the login page for EMS
And User enters the PM Team Member "<username>" and "<password>" for EMS
When User create the EMS Request
When User click on the Save button for EMS
Then User click on the signout button for EMS

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@EMS-Partially
Scenario Outline: PO_02 Login with Store Team Member and Issue the EMS
Given User on the login page for EMS
And User enters the Store Team Member "<username>" and "<password>" for EMS
When User select the EMS Requested status from the filter
When User click on the Issue icon for Issue Module for EMS
When User enter the Partially Issued Qty for EMS
When User click on the Save button for EMS
When User select the Partialy Issued status from the filter for EMS
When User click on the Issue icon for Issue Module for EMS
When User click on the Save button for EMS
When User select the EMS Issued status from the filter for EMS
Then User verifies the EMS Status has been changed to Issued and Signout for EMS

Examples: 
|username|password|
|store@e-consystems.com|Store123|
