Feature: Job Work Allocation Sanity Automation

## JW Alloc Fully Received Flow ##

@JW_Alloc-Fully
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for JW Alloc
And User enters the SCM Team Member "<username>" and "<password>" for JW Alloc
When User create the PO Request for PO ORDER for JW Alloc
When User click on the save button for JW Alloc
When User click on the Edit button for JW Alloc
When User verify the PO and providing Pre-Approval for JW Alloc
When User click on the Save button for JW Alloc
Then User verifies the PO Status has been changed and Signout for JW Alloc

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@JW_Alloc-Fully
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for JW Alloc
And User enters the Operations Head "<username>" and "<password>" for JW Alloc
And User click on the Edit button for JW Alloc
And User verify the PO and providing Final-Approval for JW Alloc
When User click on the Save button for JW Alloc
Then User verifies the PO Status has been changed and Signout for JW Alloc

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@JW_Alloc-Fully
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for JW Alloc
And User enters the SCM Team Member "<username>" and "<password>" for JW Alloc
And User click on the Issue icon for JW Alloc
When User click on the Issue button for JW Alloc
Then User verifies the PO Status has been changed to Issued and Signout for JW Alloc

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@JW_Alloc-Fully
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for JW Alloc
And User enters the Store Team Member "<username>" and "<password>" for JW Alloc
When User create the GRN Request for Fully Received for JW Alloc
When User click on the save button for JW Alloc
When User select the Fully Received status from the filter for JW Alloc
When User click on the edit button for JW Alloc
When User move the stock to the Store for JW Alloc
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@JW_Alloc-Fully
Scenario Outline: TC_05 Login with PM Team and Create the JW Alloc Request
Given User on the login page for JW Alloc
And User enters the PM Team Member "<username>" and "<password>" for JW Alloc
When User create the JW Alloc Request
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@JW_Alloc-Fully
Scenario Outline: TC_06 Login with Store Team and Allocate the Job Work Allocation Request
Given User on the login page for JW Alloc
And User enters the Store Team Member "<username>" and "<password>" for JW Alloc
When User select the JW Alloc Requested status from the filter
When User click on the edit button for Issue Module for JW Alloc
When User enter the Kit Location and Move to Alloc Qty for JW Alloc
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@JW_Alloc-Fully
Scenario Outline: TC_07 Login with SCM Team and Request for Re-Alloc the JW Alloc Request
Given User on the login page for JW Alloc
And User enters the SCM Team Member "<username>" and "<password>" for JW Alloc
When User select the JW Alloc Allocated status from the filter for JW Alloc
When User click on the edit button for Issue Module for JW Alloc
When User Enter the Release Qty for JW Alloc
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@JW_Alloc-Fully
Scenario Outline: TC_08 Login with Store Team and Release the Qty
Given User on the login page for JW Alloc
And User enters the Store Team Member "<username>" and "<password>" for JW Alloc
When User select the JW Alloc Request for Reallocation status from the filter for JW Alloc
When User click on the edit button for Issue Module for JW Alloc
When User click on the Save button for JW Alloc
When User select the JW Alloc Partially Allocated status from the filter for JW Alloc
When User click on the edit button for Issue Module for JW Alloc
When User enters the Remaining Qty to be Allocate for JW Alloc
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@JW_Alloc-Fully
Scenario Outline: TC_09 Login with PM Team and Create the Job Work Request
Given User on the login page for JW Alloc
And User enters the PM Team Member "<username>" and "<password>" for JW Alloc
When User select the JW Alloc Allocated status from the filter for JW Alloc
When User create the Job Work Request
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@JW_Alloc-Fully
Scenario Outline: TC_10 Login with Store Team and Issue the Job Work Request
Given User on the login page for JW Alloc
And User enters the Store Team Member "<username>" and "<password>" for JW Alloc
When User select the Job Work Requested status from the filter for JW Alloc
When User click on the Issue icon for Issue Module for JW Alloc
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@JW_Alloc-Fully
Scenario Outline: PO_11 Login with SCM Team Member and Create the PO for Testing & Services
Given User on the login page for JW Alloc
And User enters the SCM Team Member "<username>" and "<password>" for JW Alloc
When User create the PO Request for Testing and Services for JW Alloc
When User click on the save button for JW Alloc
When User click on the Edit button for JW Alloc
When User verify the PO and providing Pre-Approval for JW Alloc
When User click on the Save button for JW Alloc
Then User verifies the PO Status has been changed and Signout for JW Alloc

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@JW_Alloc-Fully
Scenario Outline: PO_12 Login with Operations Head and Provide Final-Approval
Given User on the login page for JW Alloc
And User enters the Operations Head "<username>" and "<password>" for JW Alloc
And User click on the Edit button for JW Alloc
And User verify the PO and providing Final-Approval for JW Alloc
When User click on the Save button for JW Alloc
Then User verifies the PO Status has been changed and Signout for JW Alloc

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@JW_Alloc-Fully
Scenario Outline: PO_13 Login with SCM Team Member and Issue the PO
Given User on the login page for JW Alloc
And User enters the SCM Team Member "<username>" and "<password>" for JW Alloc
And User click on the Issue icon for JW Alloc
When User click on the Issue button for JW Alloc
Then User verifies the PO Status has been changed to Issued and Signout for JW Alloc

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@JW_Alloc-Fully
Scenario Outline: PO_14 Login with Store Team Member and Create the GRN
Given User on the login page for JW Alloc
And User enters the Store Team Member "<username>" and "<password>" for JW Alloc
When User select the Job Work Issued status from the filter for JW Alloc
When User create the GRN Request for Testing and Services for JW Alloc
When User click on the save button for JW Alloc
When User select the Fully Received status from the filter for JW Alloc
When User click on the edit button for JW Alloc
When User move the stock to the Store for JW Alloc
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@JW_Alloc-Fully
Scenario Outline: PO_15 Login with Store Team Member and do the Production Complete
Given User on the login page for JW Alloc
And User enters the Store Team Member "<username>" and "<password>" for JW Alloc
When User select the Job Work Issued status from the filter for JW Alloc
When User click on the Dispatch icon for Issue Module for JW Alloc
When User enters the Completed Qty for JW Alloc
When User click on the Save button for JW Alloc
When User select the Job Work Production Completed status from the filter for JW Alloc
Then User verifies the Job Work Status has been changed to Production Complete and Signout for JW Alloc

Examples: 
|username|password|
|store@e-consystems.com|Store123|

##Allocation Proto - Partially

@JW_Alloc-Partially
Scenario Outline: TC_01 Login with PM Team and Create the JW Alloc Request
Given User on the login page for JW Alloc
And User enters the PM Team Member "<username>" and "<password>" for JW Alloc
When User create the JW Alloc Request
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@JW_Alloc-Partially
Scenario Outline: TC_02 Login with Store Team and Allocate the Job Work Allocation Request
Given User on the login page for JW Alloc
And User enters the Store Team Member "<username>" and "<password>" for JW Alloc
When User select the JW Alloc Requested status from the filter
When User click on the edit button for Issue Module for JW Alloc
When User enter the Kit Location and Move to Alloc Qty for JW Alloc
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@JW_Alloc-Partially
Scenario Outline: TC_03 Login with SCM Team and Request for Re-Alloc the JW Alloc Request
Given User on the login page for JW Alloc
And User enters the SCM Team Member "<username>" and "<password>" for JW Alloc
When User select the JW Alloc Allocated status from the filter for JW Alloc
When User click on the edit button for Issue Module for JW Alloc
When User Enter the Release Qty for JW Alloc
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@JW_Alloc-Partially
Scenario Outline: TC_04 Login with Store Team and Release the Qty
Given User on the login page for JW Alloc
And User enters the Store Team Member "<username>" and "<password>" for JW Alloc
When User select the JW Alloc Request for Reallocation status from the filter for JW Alloc
When User click on the edit button for Issue Module for JW Alloc
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@JW_Alloc-Partially
Scenario Outline: TC_05 Login with PM Team and Create the Job Work Request
Given User on the login page for JW Alloc
And User enters the PM Team Member "<username>" and "<password>" for JW Alloc
When User select the JW Alloc Partially Allocated status from the filter for JW Alloc
When User create the Job Work Request
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@JW_Alloc-Partially
Scenario Outline: TC_06 Login with Store Team and Issue the Job Work Request
Given User on the login page for JW Alloc
And User enters the Store Team Member "<username>" and "<password>" for JW Alloc
When User select the Job Work Requested status from the filter for JW Alloc
When User click on the Issue icon for Issue Module for JW Alloc
When User click on the Save button for JW Alloc
When User select the JW Alloc Partially Allocated status from the filter for JW Alloc
When User click on the edit button for Issue Module for JW Alloc
When User enters the Remaining Qty to be Allocate for JW Alloc
When User click on the Save button for JW Alloc
When User select the Job Work Partially Issued status from the filter for JW Alloc
When User click on the Issue icon for Issue Module for JW Alloc
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@JW_Alloc-Partially
Scenario Outline: PO_07 Login with SCM Team Member and Create the PO for Testing & Services
Given User on the login page for JW Alloc
And User enters the SCM Team Member "<username>" and "<password>" for JW Alloc
When User create the PO Request for Testing and Services for JW Alloc
When User click on the save button for JW Alloc
When User click on the Edit button for JW Alloc
When User verify the PO and providing Pre-Approval for JW Alloc
When User click on the Save button for JW Alloc
Then User verifies the PO Status has been changed and Signout for JW Alloc

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@JW_Alloc-Partially
Scenario Outline: PO_08 Login with Operations Head and Provide Final-Approval
Given User on the login page for JW Alloc
And User enters the Operations Head "<username>" and "<password>" for JW Alloc
And User click on the Edit button for JW Alloc
And User verify the PO and providing Final-Approval for JW Alloc
When User click on the Save button for JW Alloc
Then User verifies the PO Status has been changed and Signout for JW Alloc

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@JW_Alloc-Partially
Scenario Outline: PO_09 Login with SCM Team Member and Issue the PO
Given User on the login page for JW Alloc
And User enters the SCM Team Member "<username>" and "<password>" for JW Alloc
And User click on the Issue icon for JW Alloc
When User click on the Issue button for JW Alloc
Then User verifies the PO Status has been changed to Issued and Signout for JW Alloc

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received
@JW_Alloc-Partially
Scenario Outline: PO_10 Login with Store Team Member and Create the GRN
Given User on the login page for JW Alloc
And User enters the Store Team Member "<username>" and "<password>" for JW Alloc
When User select the Job Work Issued status from the filter for JW Alloc
When User create the GRN Request for Testing and Services for JW Alloc
When User click on the save button for JW Alloc
When User select the Fully Received status from the filter for JW Alloc
When User click on the edit button for JW Alloc
When User move the stock to the Store for JW Alloc
When User click on the Save button for JW Alloc
Then User click on the signout button for JW Alloc

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@JW_Alloc-Partially
Scenario Outline: PO_11 Login with Store Team Member and do the Production Complete
Given User on the login page for JW Alloc
And User enters the Store Team Member "<username>" and "<password>" for JW Alloc
When User select the Job Work Issued status from the filter for JW Alloc
When User click on the Dispatch icon for Issue Module for JW Alloc
When User enters the Partially Completed Qty for JW Alloc
When User click on the Save button for JW Alloc
When User select the Job Work Partially Production Completed status from the filter for JW Alloc
When User click on the Dispatch icon for Issue Module for JW Alloc
When User enters the Balance Completed Qty for JW Alloc
When User click on the Save button for JW Alloc
When User select the Job Work Production Completed status from the filter for JW Alloc
Then User verifies the Job Work Status has been changed to Production Complete and Signout for JW Alloc

Examples: 
|username|password|
|store@e-consystems.com|Store123|