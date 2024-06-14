Feature: NNBMG Sanity Automation

## NBMG Fully Received Flow ##

@NBMG-Fully
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for NBMG
And User enters the SCM Team Member "<username>" and "<password>" for NBMG
When User create the PO Request for PO ORDER for NBMG
When User click on the save button for NBMG
When User click on the Edit button for NBMG
When User verify the PO and providing Pre-Approval for NBMG
When User click on the Save button for NBMG
Then User verifies the PO Status has been changed and Signout for NBMG

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@NBMG-Fully
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for NBMG
And User enters the Operations Head "<username>" and "<password>" for NBMG
And User click on the Edit button for NBMG
And User verify the PO and providing Final-Approval for NBMG
When User click on the Save button for NBMG
Then User verifies the PO Status has been changed and Signout for NBMG

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@NBMG-Fully
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for NBMG
And User enters the SCM Team Member "<username>" and "<password>" for NBMG
And User click on the Issue icon for NBMG
When User click on the Issue button for NBMG
Then User verifies the PO Status has been changed to Issued and Signout for NBMG

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@NBMG-Fully
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for NBMG
And User enters the Store Team Member "<username>" and "<password>" for NBMG
When User create the GRN Request for Fully Received for NBMG
When User click on the save button for NBMG
When User select the Fully Received status from the filter for NBMG
When User click on the edit button for NBMG
When User move the stock to the Store for NBMG
When User click on the Save button for NBMG
Then User click on the signout button for NBMG

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@NBMG-Fully
Scenario Outline: TC_05 Login with PM Team and Create the NBMG Request
Given User on the login page for NBMG
And User enters the PM Team Member "<username>" and "<password>" for NBMG
When User create the NBMG Request
When User click on the Save button for NBMG
Then User click on the signout button for NBMG

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@NBMG-Fully
Scenario Outline: PO_06 Login with Store Team Member and Issue the NBMG
Given User on the login page for NBMG
And User enters the Store Team Member "<username>" and "<password>" for NBMG
When User select the NBMG Requested status from the filter for NBMG
When User click on the Issue icon for Issue Module for NBMG
When User click on the Save button for NBMG
When User select the NBMG Issued status from the filter for NBMG
Then User verifies the NBMG Status has been changed to Issued and Signout for NBMG

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## NBMG Partially Received Flow ##

@NBMG-Partially
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for NBMG
And User enters the SCM Team Member "<username>" and "<password>" for NBMG
When User create the PO Request for PO ORDER for NBMG
When User click on the save button for NBMG
When User click on the Edit button for NBMG
When User verify the PO and providing Pre-Approval for NBMG
When User click on the Save button for NBMG
Then User verifies the PO Status has been changed and Signout for NBMG

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@NBMG-Partially
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for NBMG
And User enters the Operations Head "<username>" and "<password>" for NBMG
And User click on the Edit button for NBMG
And User verify the PO and providing Final-Approval for NBMG
When User click on the Save button for NBMG
Then User verifies the PO Status has been changed and Signout for NBMG

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@NBMG-Partially
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for NBMG
And User enters the SCM Team Member "<username>" and "<password>" for NBMG
And User click on the Issue icon for NBMG
When User click on the Issue button for NBMG
Then User verifies the PO Status has been changed to Issued and Signout for NBMG

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@NBMG-Partially
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for NBMG
And User enters the Store Team Member "<username>" and "<password>" for NBMG
When User create the GRN Request for Fully Received for NBMG
When User click on the save button for NBMG
When User select the Fully Received status from the filter for NBMG
When User click on the edit button for NBMG
When User move the stock to the Store for NBMG
When User click on the Save button for NBMG
Then User click on the signout button for NBMG

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@NBMG-Partially
Scenario Outline: TC_05 Login with PM Team and Create the NBMG Request
Given User on the login page for NBMG
And User enters the PM Team Member "<username>" and "<password>" for NBMG
When User create the NBMG Request
When User click on the Save button for NBMG
Then User click on the signout button for NBMG

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@NBMG-Partially
Scenario Outline: PO_06 Login with Store Team Member and Issue the NBMG
Given User on the login page for NBMG
And User enters the Store Team Member "<username>" and "<password>" for NBMG
When User select the NBMG Requested status from the filter for NBMG
When User click on the Issue icon for Issue Module for NBMG
When User enter the Partially Issued Qty for NBMG
When User click on the Save button for NBMG
When User select the Partialy Issued status from the filter for NBMG
When User click on the Issue icon for Issue Module for NBMG
When User click on the Save button for NBMG
When User select the NBMG Issued status from the filter for NBMG
Then User verifies the NBMG Status has been changed to Issued and Signout for NBMG

Examples: 
|username|password|
|store@e-consystems.com|Store123|
