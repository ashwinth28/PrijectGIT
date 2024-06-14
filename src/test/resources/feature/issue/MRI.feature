Feature: MRI Sanity Automation

## MRI Fully Received Flow ##

@MRI-Fully
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM-Domestic)
When User click on the save button
When User click on the Edit button
When User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@MRI-Fully
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

@MRI-Fully
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

@MRI-Fully
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - RM - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MRI-Fully
Scenario Outline: TC_05 Login with PM Team and Create the MRI Request
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User create the MRI Request
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@MRI-Fully
Scenario Outline: PO_06 Login with Store Team Member and Issue the MRI
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the MRI Requested status from the filter
When User click on the Issue icon for Issue Module
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MRI-Fully
Scenario Outline: PO_07 Login with Production Team Member and do the Production Complete
Given User on the login page
And User enters the Production Team Member "<username>" and "<password>"
When User select the MRI Issued status from the filter
When User click on the Dispatch icon for Issue Module
When User enters the Completed Qty for MRI
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@MRI-Fully
Scenario Outline: PO_08 Login with Store Team Member and Receive the Production Completed Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the MRI Production Completed status from the filter
When User click on the Dispatch icon for Issue Module
When User enter the Received Qty and Item Location for MRI
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## MRI Partially Received Flow ##

@MRI-Partially
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM-Domestic)
When User click on the save button
When User click on the Edit button
When User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@MRI-Partially
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

@MRI-Partially
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

@MRI-Partially
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - RM - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MRI-Partially
Scenario Outline: TC_05 Login with PM Team and Create the MRI Request
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User create the MRI Request
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@MRI-Partially
Scenario Outline: PO_06 Login with Store Team Member and Issue the MRI
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the MRI Requested status from the filter
When User click on the Issue icon for Issue Module
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MRI-Partially
Scenario Outline: PO_07 Login with Production Team Member and do the Partially Production Complete
Given User on the login page
And User enters the Production Team Member "<username>" and "<password>"
When User select the MRI Issued status from the filter
When User click on the Dispatch icon for Issue Module
When User enters the Partially Completed Qty for MRI
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@MRI-Partially
Scenario Outline: PO_08 Login with Store Team Member and Receive the Partially Production Completed Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the MRI Partially Production Completed status from the filter
When User click on the Dispatch icon for Issue Module
When User enter the Partially Production Completed Received Qty and Item Location for MRI
When User click on the Save button
When User select the MRI Partially Production Completed status from the filter
Then User verifies the MRI Status has been Remain the same as Partially Production Completed Status and Signout for MRI

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MRI-Partially
Scenario Outline: PO_09 Login with Production Team Member and do the Production Complete
Given User on the login page
And User enters the Production Team Member "<username>" and "<password>"
When User select the MRI Partially Production Completed status from the filter
When User click on the Dispatch icon for Issue Module
When User enters the Balance Completed Qty for MRI
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@MRI-Partially
Scenario Outline: PO_10 Login with Store Team Member and Receive the Balance Production Completed Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the MRI Production Completed status from the filter
When User click on the Dispatch icon for Issue Module
When User enter the Partially Received Qty and Item Location for MRI
When User click on the Save button
When User select the MRI Partially Received status from the filter
When User click on the Dispatch icon for Issue Module
When User enter the Balance Received Qty and Item Location for MRI
When User click on the Save button
When User select the MRI Received status from the filter
Then User verifies the MRI Status has been changed to Received and Signout for MRI

Examples: 
|username|password|
|store@e-consystems.com|Store123|