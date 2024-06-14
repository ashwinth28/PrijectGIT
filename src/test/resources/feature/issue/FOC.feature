Feature: FOC Sanity Automation

## FOC Fully Received Flow ##

@FOC-Fully-1
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for FOC
And User enters the SCM Team Member "<username>" and "<password>" for FOC
When User create the PO Request for PO ORDER for FOC
When User click on the save button for FOC
When User click on the Edit button for FOC
When User verify the PO and providing Pre-Approval for FOC
When User click on the Save button for FOC
Then User verifies the PO Status has been changed and Signout for FOC

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@FOC-Fully-1
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for FOC
And User enters the Operations Head "<username>" and "<password>" for FOC
And User click on the Edit button for FOC
And User verify the PO and providing Final-Approval for FOC
When User click on the Save button for FOC
Then User verifies the PO Status has been changed and Signout for FOC

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@FOC-Fully-1
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for FOC
And User enters the SCM Team Member "<username>" and "<password>" for FOC
And User click on the Issue icon for FOC
When User click on the Issue button for FOC
Then User verifies the PO Status has been changed to Issued and Signout for FOC

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@FOC-Fully
Scenario Outline: TC_04 Login with PM Team and Create the FOC Request
Given User on the login page for FOC
And User enters the PM Team Member "<username>" and "<password>" for FOC
When User create the FOC Request
When User click on the Save button for FOC
Then User click on the signout button for FOC

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@FOC-Fully
Scenario Outline: PO_05 Login with Store Team Member and Issue the FOC
Given User on the login page for FOC
And User enters the Store Team Member "<username>" and "<password>" for FOC
When User select the FOC Requested status from the filter
When User click on the Issue icon for Issue Module for FOC
When User click on the Save button for FOC
When User select the FOC Issued status from the filter for FOC
Then User verifies the FOC Status has been changed to Issued and Signout for FOC

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## FOC Partially Received Flow ##

@FOC-Partially
Scenario Outline: TC_01 Login with PM Team and Create the FOC Request
Given User on the login page for FOC
And User enters the PM Team Member "<username>" and "<password>" for FOC
When User create the FOC Request
When User click on the Save button for FOC
Then User click on the signout button for FOC

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@FOC-Partially
Scenario Outline: PO_02 Login with Store Team Member and Issue the FOC
Given User on the login page for FOC
And User enters the Store Team Member "<username>" and "<password>" for FOC
When User select the FOC Requested status from the filter
When User click on the Issue icon for Issue Module for FOC
When User enter the Partially Issued Qty for FOC
When User click on the Save button for FOC
When User select the Partialy Issued status from the filter for FOC
When User click on the Issue icon for Issue Module for FOC
When User click on the Save button for FOC
When User select the FOC Issued status from the filter for FOC
Then User verifies the FOC Status has been changed to Issued and Signout for FOC

Examples: 
|username|password|
|store@e-consystems.com|Store123|