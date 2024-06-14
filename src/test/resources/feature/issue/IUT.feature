Feature: IUT Sanity Automation

## IUT Fully Received Flow ##

@IUT-Fully
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for IUT
And User enters the SCM Team Member "<username>" and "<password>" for IUT
When User create the PO Request for PO ORDER for IUT
When User click on the save button for IUT
When User click on the Edit button for IUT
When User verify the PO and providing Pre-Approval for IUT
When User click on the Save button for IUT
Then User verifies the PO Status has been changed and Signout for IUT

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@IUT-Fully
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for IUT
And User enters the Operations Head "<username>" and "<password>" for IUT
And User click on the Edit button for IUT
And User verify the PO and providing Final-Approval for IUT
When User click on the Save button for IUT
Then User verifies the PO Status has been changed and Signout for IUT

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@IUT-Fully
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for IUT
And User enters the SCM Team Member "<username>" and "<password>" for IUT
And User click on the Issue icon for IUT
When User click on the Issue button for IUT
Then User verifies the PO Status has been changed to Issued and Signout for IUT

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@IUT-Fully
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for IUT
And User enters the Store Team Member "<username>" and "<password>" for IUT
When User create the GRN Request for Fully Received for IUT
When User click on the save button for IUT
When User select the Fully Received status from the filter for IUT
When User click on the edit button for IUT
When User move the stock to the Store for IUT
When User click on the Save button for IUT
Then User click on the signout button for IUT

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@IUT-Fully
Scenario Outline: TC_05 Login with PM Team and Create the IUT Request and Approval
Given User on the login page for IUT
And User enters the PM Team Member "<username>" and "<password>" for IUT
When User create the IUT Request
When User click on the Save button for IUT
When User select the IUT Requested status from the filter
When User click on the IUT edit button
When User Approve the IUT Request
When User click on the Save button for IUT
Then User click on the signout button for IUT

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@IUT-Fully
Scenario Outline: PO_06 Login with Store Team Member and Issue the IUT
Given User on the login page for IUT
And User enters the Store Team Member "<username>" and "<password>" for IUT
When User select the IUT Approved status from the filter for IUT
When User click on the Issue icon for Issue Module for IUT
When User click on the Save button for IUT
When User select the IUT Issued status from the filter for IUT
Then User verifies the IUT Status has been changed to Issued and Signout for IUT

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## IUT Partially Received Flow ##

@IUT-Partially
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for IUT
And User enters the SCM Team Member "<username>" and "<password>" for IUT
When User create the PO Request for PO ORDER for IUT
When User click on the save button for IUT
When User click on the Edit button for IUT
When User verify the PO and providing Pre-Approval for IUT
When User click on the Save button for IUT
Then User verifies the PO Status has been changed and Signout for IUT

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@IUT-Partially
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for IUT
And User enters the Operations Head "<username>" and "<password>" for IUT
And User click on the Edit button for IUT
And User verify the PO and providing Final-Approval for IUT
When User click on the Save button for IUT
Then User verifies the PO Status has been changed and Signout for IUT

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@IUT-Partially
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for IUT
And User enters the SCM Team Member "<username>" and "<password>" for IUT
And User click on the Issue icon for IUT
When User click on the Issue button for IUT
Then User verifies the PO Status has been changed to Issued and Signout for IUT

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@IUT-Partially
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for IUT
And User enters the Store Team Member "<username>" and "<password>" for IUT
When User create the GRN Request for Fully Received for IUT
When User click on the save button for IUT
When User select the Fully Received status from the filter for IUT
When User click on the edit button for IUT
When User move the stock to the Store for IUT
When User click on the Save button for IUT
Then User click on the signout button for IUT

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@IUT-Partially
Scenario Outline: TC_05 Login with PM Team and Create the IUT Request
Given User on the login page for IUT
And User enters the PM Team Member "<username>" and "<password>" for IUT
When User create the IUT Request
When User click on the Save button for IUT
When User select the IUT Requested status from the filter
When User click on the IUT edit button
When User Approve the IUT Request
When User click on the Save button for IUT
Then User click on the signout button for IUT

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@IUT-Partially
Scenario Outline: PO_06 Login with Store Team Member and Issue the IUT
Given User on the login page for IUT
And User enters the Store Team Member "<username>" and "<password>" for IUT
When User select the IUT Approved status from the filter for IUT
When User click on the Issue icon for Issue Module for IUT
When User enter the Partially Issued Qty for IUT
When User click on the Save button for IUT
When User select the Partialy Issued status from the filter for IUT
When User click on the Issue icon for Issue Module for IUT
When User click on the Save button for IUT
When User select the IUT Issued status from the filter for IUT
Then User verifies the IUT Status has been changed to Issued and Signout for IUT

Examples: 
|username|password|
|store@e-consystems.com|Store123|