Feature: CR Sanity Automation

## NON-EMS ##
## CR Fully Received Flow ##

@CR-Fully-1
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for CR
And User enters the SCM Team Member "<username>" and "<password>" for CR
When User create the PO Request for PO ORDER for CR
When User click on the save button for CR
When User click on the Edit button for CR
When User verify the PO and providing Pre-Approval for CR
When User click on the Save button for CR
Then User verifies the PO Status has been changed and Signout for CR

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@CR-Fully-1
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for CR
And User enters the Operations Head "<username>" and "<password>" for CR
And User click on the Edit button for CR
And User verify the PO and providing Final-Approval for CR
When User click on the Save button for CR
Then User verifies the PO Status has been changed and Signout for CR

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@CR-Fully-1
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for CR
And User enters the SCM Team Member "<username>" and "<password>" for CR
And User click on the Issue icon for CR
When User click on the Issue button for CR
Then User verifies the PO Status has been changed to Issued and Signout for CR

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@CR-Fully-1
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for CR
And User enters the Store Team Member "<username>" and "<password>" for CR
When User create the GRN Request for Fully Received for CR
When User click on the save button for CR
When User select the Fully Received status from the filter for CR
When User click on the edit button for CR
When User move the stock to the Store for CR
When User click on the Save button for CR
Then User click on the signout button for CR

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@CR-Fully
Scenario Outline: TC_05 Login with PM Team and Create the CR Request
Given User on the login page for CR
And User enters the PM Team Member "<username>" and "<password>" for CR
When User create the CR Request
When User click on the Save button for CR
Then User click on the signout button for CR

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@CR-Fully
Scenario Outline: PO_06 Login with Store Team Member and Issue the CR
Given User on the login page for CR
And User enters the Store Team Member "<username>" and "<password>" for CR
When User select the CR Requested status from the filter
When User click on the Issue icon for Issue Module for CR
When User click on the Save button for CR
When User select the CR Issued status from the filter for CR
Then User verifies the CR Status has been changed to Issued and Signout for CR

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@CR-Fully
Scenario Outline: PO_07 Login with Production Team Member and do the Production Complete
Given User on the login page for CR
And User enters the Production Team Member "<username>" and "<password>" for CR
When User select the CR Issued status from the filter for CR
When User click on the Dispatch icon for Issue Module for CR
When User enters the Completed Qty for CR
When User click on the Save button for CR
Then User click on the signout button for CR

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@CR-Fully
Scenario Outline: PO_08 Login with Store Team Member and Receive the Production Completed Qty
Given User on the login page for CR
And User enters the Store Team Member "<username>" and "<password>" for CR
When User select the CR Production Completed status from the filter
When User click on the Dispatch icon for Issue Module for CR
When User enter the Received Qty and Item Location for CR
When User click on the Save button for CR
When User select the CR Received status from the filter for CR
Then User verifies the CR Status has been changed to Received and Signout for CR

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## CR Partially Received Flow ##

@CR-Partially
Scenario Outline: TC_01 Login with PM Team and Create the CR Request
Given User on the login page for CR
And User enters the PM Team Member "<username>" and "<password>" for CR
When User create the CR Request
When User click on the Save button for CR
Then User click on the signout button for CR

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@CR-Partially
Scenario Outline: PO_02 Login with Store Team Member and Issue the CR
Given User on the login page for CR
And User enters the Store Team Member "<username>" and "<password>" for CR
When User select the CR Requested status from the filter
When User click on the Issue icon for Issue Module for CR
When User click on the Save button for CR
When User select the CR Issued status from the filter for CR
Then User verifies the CR Status has been changed to Issued and Signout for CR

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@CR-Partially
Scenario Outline: PO_03 Login with Production Team Member and do the Partially Production Complete
Given User on the login page for CR
And User enters the Production Team Member "<username>" and "<password>" for CR
When User select the CR Issued status from the filter for CR
When User click on the Dispatch icon for Issue Module for CR
When User enters the Partially Completed Qty for CR
When User click on the Save button for CR
Then User click on the signout button for CR

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@CR-Partially
Scenario Outline: PO_04 Login with Store Team Member and Receive the Partially Production Completed Qty
Given User on the login page for CR
And User enters the Store Team Member "<username>" and "<password>" for CR
When User select the CR Partially Production Completed status from the filter
When User click on the Dispatch icon for Issue Module for CR
When User enter the Partially Production Completed Received Qty and Item Location for CR
When User click on the Save button for CR
When User select the CR Partially Production Completed status from the filter
Then User verifies the CR Status has been Remain the same as Partially Production Completed Status and Signout for CR

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@CR-Partially
Scenario Outline: PO_05 Login with Production Team Member and do the Production Complete
Given User on the login page for CR
And User enters the Production Team Member "<username>" and "<password>" for CR
When User select the CR Partially Production Completed status from the filter
When User click on the Dispatch icon for Issue Module for CR
When User enters the Balance Completed Qty for CR
When User click on the Save button for CR
Then User click on the signout button for CR

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@CR-Partially
Scenario Outline: PO_06 Login with Store Team Member and Receive the Balance Production Completed Qty
Given User on the login page for CR
And User enters the Store Team Member "<username>" and "<password>" for CR
When User select the CR Production Completed status from the filter
When User click on the Dispatch icon for Issue Module for CR
When User enter the Partially Received Qty and Item Location for CR
When User click on the Save button for CR
When User select the CR Partially Received status from the filter
When User click on the Dispatch icon for Issue Module for CR
When User enter the Balance Received Qty and Item Location for CR
When User click on the Save button for CR
When User select the CR Received status from the filter for CR
Then User verifies the CR Status has been changed to Received and Signout for CR

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## EMS ##
## CR Eliminated Flow ##

@CR-Eliminated
Scenario Outline: TC_01 Login with PM Team and Create the CR Request
Given User on the login page for CR
And User enters the PM Team Member "<username>" and "<password>" for CR
When User create the CR Request with Elimination
When User click on the Save button for CR
Then User click on the signout button for CR

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@CR-Eliminated
Scenario Outline: PO_02 Login with Store Team Member and Issue the CR
Given User on the login page for CR
And User enters the Store Team Member "<username>" and "<password>" for CR
When User select the CR Requested status from the filter
When User click on the Issue icon for Issue Module for CR
When User click on the Save button for CR
When User select the CR Issued status from the filter for CR
Then User verifies the CR Status has been changed to Issued and Signout for CR

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@CR-Eliminated
Scenario Outline: TC_03 Login with PM Team and Create the CR Request
Given User on the login page for CR
And User enters the PM Team Member "<username>" and "<password>" for CR
When User select the CR Issued status from the filter for CR
When User click on the Issue icon for Issue Module for CR
When User enter the Cost Value for the Eliminated items
When User click on the Save button for CR
Then User click on the signout button for CR

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@CR-Eliminated
Scenario Outline: PO_04 Login with Store Team Member and do the Production Complete
Given User on the login page for CR
And User enters the Store Team Member "<username>" and "<password>" for CR
When User select the CR Issued status from the filter for CR
When User click on the Dispatch icon for Issue Module for CR
When User enters the Completed Qty for CR
When User click on the Save button for CR
When User select the CR Production Completed status from the filter
When User click on the Dispatch icon for Issue Module for CR
When User enter the Received Qty with Eliminated Items and Item Location for CR
When User click on the Save button for CR
When User select the CR Received status from the filter for CR
Then User verifies the CR Status has been changed to Received and Signout for CR

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## EMS ##
## CR Without Output Product Code ##

@CR-Without_Output_Product_Code
Scenario Outline: TC_01 Login with PM Team and Create the CR Request
Given User on the login page for CR
And User enters the PM Team Member "<username>" and "<password>" for CR
When User create the CR Request without Output Product Code
When User click on the Save button for CR
Then User click on the signout button for CR

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@CR-Without_Output_Product_Code
Scenario Outline: PO_02 Login with Store Team Member and Issue the CR
Given User on the login page for CR
And User enters the Store Team Member "<username>" and "<password>" for CR
When User select the CR Requested status from the filter
When User click on the Issue icon for Issue Module for CR
When User click on the Save button for CR
When User select the WIP status from the product category filter
When User verifies the expected results in the dashboard
When User select the CR Issued status from the filter for CR
Then User verifies the CR Status has been changed to Issued and Signout for CR

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@CR-Without_Output_Product_Code
Scenario Outline: PO_03 Login with Store Team Member and do the Production Complete
Given User on the login page for CR
And User enters the Store Team Member "<username>" and "<password>" for CR
When User select the CR Issued status from the filter for CR
When User click on the Dispatch icon for Issue Module for CR
When User enters the Completed Qty for CR
When User click on the Save button for CR
When User select the CR Production Completed status from the filter
When User click on the Dispatch icon for Issue Module for CR
When User enter the Received Qty and Item Location for CR
When User click on the Save button for CR
When User select the CR Received status from the filter for CR
Then User verifies the CR Status has been changed to Received and Signout for CR

Examples: 
|username|password|
|store@e-consystems.com|Store123|