Feature: Allocation Proto - RM Sanity Automation

## Alloc Proto Fully Received Flow ##

@Alloc_Proto-Fully
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for Alloc Proto
And User enters the SCM Team Member "<username>" and "<password>" for Alloc Proto
When User create the PO Request for PO ORDER for Alloc Proto
When User click on the save button for Alloc Proto
When User click on the Edit button for Alloc Proto
When User verify the PO and providing Pre-Approval for Alloc Proto
When User click on the Save button for Alloc Proto
Then User verifies the PO Status has been changed and Signout for Alloc Proto

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@Alloc_Proto-Fully
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for Alloc Proto
And User enters the Operations Head "<username>" and "<password>" for Alloc Proto
And User click on the Edit button for Alloc Proto
And User verify the PO and providing Final-Approval for Alloc Proto
When User click on the Save button for Alloc Proto
Then User verifies the PO Status has been changed and Signout for Alloc Proto

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@Alloc_Proto-Fully
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for Alloc Proto
And User enters the SCM Team Member "<username>" and "<password>" for Alloc Proto
And User click on the Issue icon for Alloc Proto
When User click on the Issue button for Alloc Proto
Then User verifies the PO Status has been changed to Issued and Signout for Alloc Proto

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@Alloc_Proto-Fully
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for Alloc Proto
And User enters the Store Team Member "<username>" and "<password>" for Alloc Proto
When User create the GRN Request for Fully Received for Alloc Proto
When User click on the save button for Alloc Proto
When User select the Fully Received status from the filter for Alloc Proto
When User click on the edit button for Alloc Proto
When User move the stock to the Store for Alloc Proto
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@Alloc_Proto-Fully
Scenario Outline: TC_05 Login with PM Team and Create the Alloc Proto Request
Given User on the login page for Alloc Proto
And User enters the PM Team Member "<username>" and "<password>" for Alloc Proto
When User create the Alloc Proto Request
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@Alloc_Proto-Fully
Scenario Outline: TC_06 Login with Store Team and Allocate the Allocation Proto - RM Request
Given User on the login page for Alloc Proto
And User enters the Store Team Member "<username>" and "<password>" for Alloc Proto
When User select the Alloc Proto Requested status from the filter
When User click on the edit button for Issue Module for Alloc Proto
When User enter the Kit Location and Move to Alloc Qty
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@Alloc_Proto-Fully
Scenario Outline: TC_07 Login with PM Team and Re Alloc Proto Request
Given User on the login page for Alloc Proto
And User enters the PM Team Member "<username>" and "<password>" for Alloc Proto
When User select the Alloc Proto Allocated status from the filter for Alloc Proto
When User click on the edit button for Issue Module for Alloc Proto
When User Import the Qty Revised BOM Sheet
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@Alloc_Proto-Fully
Scenario Outline: TC_08 Login with Store Team and Release the Qty
Given User on the login page for Alloc Proto
And User enters the Store Team Member "<username>" and "<password>" for Alloc Proto
When User select the Alloc Proto Request for Reallocation status from the filter for Alloc Proto
When User click on the edit button for Issue Module for Alloc Proto
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@Alloc_Proto-Fully
Scenario Outline: TC_09 Login with PM Team and Create the Proto-Job Work Request
Given User on the login page for Alloc Proto
And User enters the PM Team Member "<username>" and "<password>" for Alloc Proto
When User select the Alloc Proto Allocated status from the filter for Alloc Proto
When User create the Proto Job Work Request
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@Alloc_Proto-Fully
Scenario Outline: TC_10 Login with Store Team and Issue the Proto Job Work Request
Given User on the login page for Alloc Proto
And User enters the Store Team Member "<username>" and "<password>" for Alloc Proto
When User select the Proto Job Work Requested status from the filter for Alloc Proto
When User click on the Issue icon for Issue Module for Alloc Proto
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@Alloc_Proto-Fully
Scenario Outline: PO_11 Login with SCM Team Member and Create the PO for Testing & Services
Given User on the login page for Alloc Proto
And User enters the SCM Team Member "<username>" and "<password>" for Alloc Proto
When User create the PO Request for Testing and Services for Alloc Proto
When User click on the save button for Alloc Proto
When User click on the Edit button for Alloc Proto
When User verify the PO and providing Pre-Approval for Alloc Proto
When User click on the Save button for Alloc Proto
Then User verifies the PO Status has been changed and Signout for Alloc Proto

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@Alloc_Proto-Fully
Scenario Outline: PO_12 Login with Operations Head and Provide Final-Approval
Given User on the login page for Alloc Proto
And User enters the Operations Head "<username>" and "<password>" for Alloc Proto
And User click on the Edit button for Alloc Proto
And User verify the PO and providing Final-Approval for Alloc Proto
When User click on the Save button for Alloc Proto
Then User verifies the PO Status has been changed and Signout for Alloc Proto

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@Alloc_Proto-Fully
Scenario Outline: PO_13 Login with SCM Team Member and Issue the PO
Given User on the login page for Alloc Proto
And User enters the SCM Team Member "<username>" and "<password>" for Alloc Proto
And User click on the Issue icon for Alloc Proto
When User click on the Issue button for Alloc Proto
Then User verifies the PO Status has been changed to Issued and Signout for Alloc Proto

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@Alloc_Proto-Fully
Scenario Outline: PO_14 Login with Store Team Member and Create the GRN
Given User on the login page for Alloc Proto
And User enters the Store Team Member "<username>" and "<password>" for Alloc Proto
When User select the Proto Job Work Issued status from the filter for Alloc Proto
When User create the GRN Request for Testing and Services for Alloc Proto
When User click on the save button for Alloc Proto
When User select the Fully Received status from the filter for Alloc Proto
When User click on the edit button for Alloc Proto
When User move the stock to the Store for Alloc Proto
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@Alloc_Proto-Fully
Scenario Outline: PO_15 Login with Store Team Member and do the Production Complete
Given User on the login page for Alloc Proto
And User enters the Store Team Member "<username>" and "<password>" for Alloc Proto
When User select the Proto Job Work Issued status from the filter for Alloc Proto
When User click on the Dispatch icon for Issue Module for Alloc Proto
When User enters the Completed Qty for Alloc Proto
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|store@e-consystems.com|Store123|

##Allocation Proto - Partially

@Alloc_Proto-Partially
Scenario Outline: TC_01 Login with PM Team and Create the Alloc Proto Request
Given User on the login page for Alloc Proto
And User enters the PM Team Member "<username>" and "<password>" for Alloc Proto
When User create the Alloc Proto Request
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@Alloc_Proto-Partially
Scenario Outline: TC_02 Login with Store Team and Allocate the Allocation Proto - RM Request
Given User on the login page for Alloc Proto
And User enters the Store Team Member "<username>" and "<password>" for Alloc Proto
When User select the Alloc Proto Requested status from the filter
When User click on the edit button for Issue Module for Alloc Proto
When User enter the Kit Location and Move to Alloc Qty and Enter the Partially Alloc Qty
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@Alloc_Proto-Partially
Scenario Outline: TC_03 Login with PM Team and Re Alloc Proto Request
Given User on the login page for Alloc Proto
And User enters the PM Team Member "<username>" and "<password>" for Alloc Proto
When User select the Alloc Proto Partially Allocated status from the filter for Alloc Proto
When User click on the edit button for Issue Module for Alloc Proto
When User Import the Qty Revised BOM Sheet
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@Alloc_Proto-Partially
Scenario Outline: TC_04 Login with Store Team and Release the Qty
Given User on the login page for Alloc Proto
And User enters the Store Team Member "<username>" and "<password>" for Alloc Proto
When User select the Alloc Proto Request for Reallocation status from the filter for Alloc Proto
When User click on the edit button for Issue Module for Alloc Proto
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@Alloc_Proto-Partially
Scenario Outline: TC_05 Login with PM Team and Create the Proto-Job Work Request
Given User on the login page for Alloc Proto
And User enters the PM Team Member "<username>" and "<password>" for Alloc Proto
When User select the Alloc Proto Allocated status from the filter for Alloc Proto
When User create the Proto Job Work Request
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@Alloc_Proto-Partially
Scenario Outline: TC_06 Login with Store Team and Issue the Proto Job Work Request
Given User on the login page for Alloc Proto
And User enters the Store Team Member "<username>" and "<password>" for Alloc Proto
When User select the Proto Job Work Requested status from the filter for Alloc Proto
When User click on the Issue icon for Issue Module for Alloc Proto
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@Alloc_Proto-Partially
Scenario Outline: PO_07 Login with SCM Team Member and Create the PO for Testing & Services
Given User on the login page for Alloc Proto
And User enters the SCM Team Member "<username>" and "<password>" for Alloc Proto
When User create the PO Request for Testing and Services for Alloc Proto
When User click on the save button for Alloc Proto
When User click on the Edit button for Alloc Proto
When User verify the PO and providing Pre-Approval for Alloc Proto
When User click on the Save button for Alloc Proto
Then User verifies the PO Status has been changed and Signout for Alloc Proto

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@Alloc_Proto-Partially
Scenario Outline: PO_08 Login with Operations Head and Provide Final-Approval
Given User on the login page for Alloc Proto
And User enters the Operations Head "<username>" and "<password>" for Alloc Proto
And User click on the Edit button for Alloc Proto
And User verify the PO and providing Final-Approval for Alloc Proto
When User click on the Save button for Alloc Proto
Then User verifies the PO Status has been changed and Signout for Alloc Proto

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@Alloc_Proto-Partially
Scenario Outline: PO_09 Login with SCM Team Member and Issue the PO
Given User on the login page for Alloc Proto
And User enters the SCM Team Member "<username>" and "<password>" for Alloc Proto
And User click on the Issue icon for Alloc Proto
When User click on the Issue button for Alloc Proto
Then User verifies the PO Status has been changed to Issued and Signout for Alloc Proto

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@Alloc_Proto-Partially
Scenario Outline: PO_10 Login with Store Team Member and Create the GRN
Given User on the login page for Alloc Proto
And User enters the Store Team Member "<username>" and "<password>" for Alloc Proto
When User select the Proto Job Work Issued status from the filter for Alloc Proto
When User create the GRN Request for Testing and Services for Alloc Proto
When User click on the save button for Alloc Proto
When User select the Fully Received status from the filter for Alloc Proto
When User click on the edit button for Alloc Proto
When User move the stock to the Store for Alloc Proto
When User click on the Save button for Alloc Proto
Then User click on the signout button for Alloc Proto

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@Alloc_Proto-Partially
Scenario Outline: PO_11 Login with Store Team Member and do the Production Complete
Given User on the login page for Alloc Proto
And User enters the Store Team Member "<username>" and "<password>" for Alloc Proto
When User select the Proto Job Work Issued status from the filter for Alloc Proto
When User click on the Dispatch icon for Issue Module for Alloc Proto
When User enters the Partially Completed Qty for Alloc Proto
When User click on the Save button for Alloc Proto
When User select the Proto Job Work Partially Production Completed status from the filter for Alloc Proto
When User click on the Dispatch icon for Issue Module for Alloc Proto
When User enters the Balance Completed Qty for Alloc Proto
When User click on the Save button for Alloc Proto
When User select the Proto Job Work Production Completed status from the filter for Alloc Proto
Then User verifies the Proto Job Work Status has been changed to Production Complete and Signout for Alloc Proto

Examples: 
|username|password|
|store@e-consystems.com|Store123|