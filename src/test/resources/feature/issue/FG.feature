Feature: FG Sanity Automation

## FG Fully Received Flow ##

@FG-Fully
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for FG
And User enters the SCM Team Member "<username>" and "<password>" for FG
When User create the PO Request for PO ORDER for FG
When User click on the save button for FG
When User click on the Edit button for FG
When User verify the PO and providing Pre-Approval for FG
When User click on the Save button for FG
Then User verifies the PO Status has been changed and Signout for FG

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@FG-Fully
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for FG
And User enters the Operations Head "<username>" and "<password>" for FG
And User click on the Edit button for FG
And User verify the PO and providing Final-Approval for FG
When User click on the Save button for FG
Then User verifies the PO Status has been changed and Signout for FG

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@FG-Fully
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for FG
And User enters the SCM Team Member "<username>" and "<password>" for FG
And User click on the Issue icon for FG
When User click on the Issue button for FG
Then User verifies the PO Status has been changed to Issued and Signout for FG

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@FG-Fully
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for FG
And User enters the Store Team Member "<username>" and "<password>" for FG
When User create the GRN Request for Fully Received for FG
When User click on the save button for FG
When User select the Fully Received status from the filter for FG
When User click on the edit button for FG
When User move the stock to the Store for FG
When User click on the Save button for FG
Then User click on the signout button for FG

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@FG-Fully
Scenario Outline: TC_05 Login with PM Team and Create the FG Request
Given User on the login page for FG
And User enters the PM Team Member "<username>" and "<password>" for FG
When User create the FG Request
When User click on the Save button for FG
Then User click on the signout button for FG

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@FG-Fully
Scenario Outline: PO_06 Login with Store Team Member and Issue the FG
Given User on the login page for FG
And User enters the Store Team Member "<username>" and "<password>" for FG
When User select the FG Requested status from the filter
When User click on the Issue icon for Issue Module for FG
When User click on the Save button for FG
Then User click on the signout button for FG

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@FG-Fully
Scenario Outline: PO_07 Login with Production Team Member and do the Production Complete
Given User on the login page for FG
And User enters the Production Team Member "<username>" and "<password>" for FG
When User select the FG Issued status from the filter
When User click on the Dispatch icon for Issue Module for FG
When User enters the Completed Qty for FG
When User click on the Save button for FG
Then User click on the signout button for FG

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@FG-Fully
Scenario Outline: PO_08 Login with Logistics Team Member and Shipment Receive the Completed Qty
Given User on the login page for FG
And User enters the Logistics Team Member "<username>" and "<password>" for FG
When User select the FG Production Completed status from the filter
When User click on the Dispatch icon for Issue Module for FG
When User click the Shipment Received Checkbox for FG
When User click on the Save button for FG
When User select the FG Shipment Received status from the filter
When User click on the Dispatch icon for Issue Module for FG
When User enter the Shipping Qty with isDispatched Checkbox for FG
When User click on the Save button for FG
Then User click on the signout button for FG

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

## FG Partially Received Flow ##

@FG-Partially
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for FG
And User enters the SCM Team Member "<username>" and "<password>" for FG
When User create the PO Request for PO ORDER for FG
When User click on the save button for FG
When User click on the Edit button for FG
When User verify the PO and providing Pre-Approval for FG
When User click on the Save button for FG
Then User verifies the PO Status has been changed and Signout for FG

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@FG-Partially
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for FG
And User enters the Operations Head "<username>" and "<password>" for FG
And User click on the Edit button for FG
And User verify the PO and providing Final-Approval for FG
When User click on the Save button for FG
Then User verifies the PO Status has been changed and Signout for FG

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@FG-Partially
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for FG
And User enters the SCM Team Member "<username>" and "<password>" for FG
And User click on the Issue icon for FG
When User click on the Issue button for FG
Then User verifies the PO Status has been changed to Issued and Signout for FG

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@FG-Partially
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for FG
And User enters the Store Team Member "<username>" and "<password>" for FG
When User create the GRN Request for Fully Received for FG
When User click on the save button for FG
When User select the Fully Received status from the filter for FG
When User click on the edit button for FG
When User move the stock to the Store for FG
When User click on the Save button for FG
Then User click on the signout button for FG

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@FG-Partially
Scenario Outline: TC_05 Login with PM Team and Create the FG Request
Given User on the login page for FG
And User enters the PM Team Member "<username>" and "<password>" for FG
When User create the FG Request
When User click on the Save button for FG
Then User click on the signout button for FG

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@FG-Partially
Scenario Outline: PO_06 Login with Store Team Member and Issue the FG
Given User on the login page for FG
And User enters the Store Team Member "<username>" and "<password>" for FG
When User select the FG Requested status from the filter
When User click on the Issue icon for Issue Module for FG
When User click on the Save button for FG
Then User click on the signout button for FG

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@FG-Partially
Scenario Outline: PO_07 Login with Production Team Member and do the Production Complete
Given User on the login page for FG
And User enters the Production Team Member "<username>" and "<password>" for FG
When User select the FG Issued status from the filter
When User click on the Dispatch icon for Issue Module for FG
When User enters the Partially Completed Qty for FG
When User click on the Save button for FG
Then User click on the signout button for FG

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@FG-Partially
Scenario Outline: TC_08 Login with PM Team and Approve the FG Request
Given User on the login page for FG
And User enters the PM Team Member "<username>" and "<password>" for FG
When User select the FG Partially Production Completed status from the filter
When User click on the Dispatch icon for Issue Module for FG
When User Approve the FG Request
When User click on the Save button for FG
Then User click on the signout button for FG

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@FG-Partially
Scenario Outline: PO_09 Login with Logistics Team Member and Shipment Receive the Partially Completed Qty
Given User on the login page for FG
And User enters the Logistics Team Member "<username>" and "<password>" for FG
When User select the FG Approved status from the filter
When User click on the Dispatch icon for Issue Module for FG
When User click the Shipment Received Checkbox for FG
When User click on the Save button for FG
When User select the FG Shipment Received status from the filter
When User click on the Dispatch icon for Issue Module for FG
When User enter the Partially Shipping Qty with isDispatched Checkbox for FG
When User click on the Save button for FG
Then User click on the signout button for FG

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@FG-Partially
Scenario Outline: PO_10 Login with Production Team Member and do the Production Complete
Given User on the login page for FG
And User enters the Production Team Member "<username>" and "<password>" for FG
When User select the FG Partially Dispatched status from the filter
When User click on the Dispatch icon for Issue Module for FG
When User enters the Balance Completed Qty for FG
When User click on the Save button for FG
Then User click on the signout button for FG

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@FG-Partially
Scenario Outline: PO_11 Login with Logistics Team Member and Shipment Receive the Balance Completed Qty
Given User on the login page for FG
And User enters the Logistics Team Member "<username>" and "<password>" for FG
When User select the FG Production Completed status from the filter
When User click on the Dispatch icon for Issue Module for FG
When User click on the Save button for FG
When User select the FG Shipment Received status from the filter
When User click on the Dispatch icon for Issue Module for FG
When User enter the Balance Shipping Qty for FG
When User click on the Save button for FG
When User select the FG Dispatched status from the filter
Then User verifies the FG Status has been changed to Dispatched and Signout for FG

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|