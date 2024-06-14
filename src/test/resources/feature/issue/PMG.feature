Feature: PMG Sanity Automation

## PMG Fully Received Flow ##

@PMG-Fully
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for PMG
And User enters the SCM Team Member "<username>" and "<password>" for PMG
When User create the PO Request for PO ORDER for PMG
When User click on the save button for PMG
When User click on the Edit button for PMG
When User verify the PO and providing Pre-Approval for PMG
When User click on the Save button for PMG
Then User verifies the PO Status has been changed and Signout for PMG

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@PMG-Fully
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for PMG
And User enters the Operations Head "<username>" and "<password>" for PMG
And User click on the Edit button for PMG
And User verify the PO and providing Final-Approval for PMG
When User click on the Save button for PMG
Then User verifies the PO Status has been changed and Signout for PMG

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@PMG-Fully
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for PMG
And User enters the SCM Team Member "<username>" and "<password>" for PMG
And User click on the Issue icon for PMG
When User click on the Issue button for PMG
Then User verifies the PO Status has been changed to Issued and Signout for PMG

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@PMG-Fully
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for PMG
And User enters the Store Team Member "<username>" and "<password>" for PMG
When User create the GRN Request for Fully Received for PMG
When User click on the save button for PMG
When User select the Fully Received status from the filter for PMG
When User click on the edit button for PMG
When User move the stock to the Store for PMG
When User click on the Save button for PMG
Then User click on the signout button for PMG

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@PMG-Fully
Scenario Outline: TC_05 Login with PM Team and Create the PMG Request and Approval
Given User on the login page for PMG
And User enters the PM Team Member "<username>" and "<password>" for PMG
When User create the PMG Request
When User click on the Save button for PMG
When User select the PMG Requested status from the filter
When User click on the PMG edit button
When User Approve the PMG Request
When User click on the Save button for PMG
Then User click on the signout button for PMG

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@PMG-Fully
Scenario Outline: PO_06 Login with Store Team Member and Issue the PMG
Given User on the login page for PMG
And User enters the Store Team Member "<username>" and "<password>" for PMG
When User select the PMG Approved status from the filter for PMG
When User click on the Issue icon for Issue Module for PMG
When User click on the Save button for PMG
When User select the PMG Issued status from the filter for PMG
Then User verifies the PMG Status has been changed to Issued and Signout for PMG

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PMG Partially Received Flow ##

@PMG-Partially
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for PMG
And User enters the SCM Team Member "<username>" and "<password>" for PMG
When User create the PO Request for PO ORDER for PMG
When User click on the save button for PMG
When User click on the Edit button for PMG
When User verify the PO and providing Pre-Approval for PMG
When User click on the Save button for PMG
Then User verifies the PO Status has been changed and Signout for PMG

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@PMG-Partially
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for PMG
And User enters the Operations Head "<username>" and "<password>" for PMG
And User click on the Edit button for PMG
And User verify the PO and providing Final-Approval for PMG
When User click on the Save button for PMG
Then User verifies the PO Status has been changed and Signout for PMG

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@PMG-Partially
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for PMG
And User enters the SCM Team Member "<username>" and "<password>" for PMG
And User click on the Issue icon for PMG
When User click on the Issue button for PMG
Then User verifies the PO Status has been changed to Issued and Signout for PMG

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@PMG-Partially
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for PMG
And User enters the Store Team Member "<username>" and "<password>" for PMG
When User create the GRN Request for Fully Received for PMG
When User click on the save button for PMG
When User select the Fully Received status from the filter for PMG
When User click on the edit button for PMG
When User move the stock to the Store for PMG
When User click on the Save button for PMG
Then User click on the signout button for PMG

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@PMG-Partially
Scenario Outline: TC_05 Login with PM Team and Create the PMG Request
Given User on the login page for PMG
And User enters the PM Team Member "<username>" and "<password>" for PMG
When User create the PMG Request
When User click on the Save button for PMG
When User select the PMG Requested status from the filter
When User click on the PMG edit button
When User Approve the PMG Request
When User click on the Save button for PMG
Then User click on the signout button for PMG

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@PMG-Partially
Scenario Outline: PO_06 Login with Store Team Member and Issue the PMG
Given User on the login page for PMG
And User enters the Store Team Member "<username>" and "<password>" for PMG
When User select the PMG Approved status from the filter for PMG
When User click on the Issue icon for Issue Module for PMG
When User enter the Partially Issued Qty for PMG
When User click on the Save button for PMG
When User select the Partialy Issued status from the filter for PMG
When User click on the Issue icon for Issue Module for PMG
When User click on the Save button for PMG
When User select the PMG Issued status from the filter for PMG
Then User verifies the PMG Status has been changed to Issued and Signout for PMG

Examples: 
|username|password|
|store@e-consystems.com|Store123|
