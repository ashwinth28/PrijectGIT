Feature: Asset Management Testing

@Asset-Management-Admin
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER
When User click on the save button
When User click on the Edit button
When User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@Asset-Management-Admin
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@Asset-Management-Admin
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@Asset-Management-Admin
Scenario Outline: PO_04 Login with Admin Team Member and Create the GRN
Given User on the login page
And User enters the Admin Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received
When User click on the save button
When User select the Fully Received status from the filter
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@Asset-Management-IT
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER for IT
When User click on the save button
When User click on the Edit button
When User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@Asset-Management-IT
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@Asset-Management-IT
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@Asset-Management-IT
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received
When User click on the save button
When User select the Fully Received status from the filter
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|