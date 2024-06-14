Feature: MRD Sanity Automation

## MRD Fully Received Flow ##

@MRD-Fully
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for MRD
And User enters the SCM Team Member "<username>" and "<password>" for MRD
When User create the PO Request for PO ORDER for MRD
When User click on the save button for MRD
When User click on the Edit button for MRD
When User verify the PO and providing Pre-Approval for MRD
When User click on the Save button for MRD
Then User verifies the PO Status has been changed and Signout for MRD

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@MRD-Fully
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for MRD
And User enters the Operations Head "<username>" and "<password>" for MRD
And User click on the Edit button for MRD
And User verify the PO and providing Final-Approval for MRD
When User click on the Save button for MRD
Then User verifies the PO Status has been changed and Signout for MRD

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@MRD-Fully
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for MRD
And User enters the SCM Team Member "<username>" and "<password>" for MRD
And User click on the Issue icon for MRD
When User click on the Issue button for MRD
Then User verifies the PO Status has been changed to Issued and Signout for MRD

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@MRD-Fully
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for MRD
And User enters the Store Team Member "<username>" and "<password>" for MRD
When User create the GRN Request for Fully Received for MRD
When User click on the save button for MRD
When User select the Fully Received status from the filter for MRD
When User click on the edit button for MRD
When User move the stock to the Store for MRD
When User click on the Save button for MRD
Then User click on the signout button for MRD

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MRD-Fully
Scenario Outline: TC_05 Login with PM Team and Create the MRI Request
Given User on the login page for MRD
And User enters the PM Team Member "<username>" and "<password>" for MRD
When User create the MRD Request
When User click on the Save button for MRD
Then User click on the signout button for MRD

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@MRD-Fully
Scenario Outline: PO_06 Login with Store Team Member and Issue the MRI
Given User on the login page for MRD
And User enters the Store Team Member "<username>" and "<password>" for MRD
When User select the MRD Requested status from the filter
When User click on the Issue icon for Issue Module for MRD
When User click on the Save button for MRD
Then User click on the signout button for MRD

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MRD-Fully
Scenario Outline: PO_07 Login with Production Team Member and do the Production Complete
Given User on the login page for MRD
And User enters the Production Team Member "<username>" and "<password>" for MRD
When User select the MRD Issued status from the filter
When User click on the Dispatch icon for Issue Module for MRD
When User enters the Completed Qty for MRD
When User click on the Save button for MRD
Then User click on the signout button for MRD

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@MRD-Fully
Scenario Outline: PO_08 Login with Logistics Team Member and Shipment Receive the Completed Qty
Given User on the login page for MRD
And User enters the Logistics Team Member "<username>" and "<password>" for MRD
When User select the MRD Production Completed status from the filter
When User click on the Dispatch icon for Issue Module for MRD
When User click the Shipment Received Checkbox for MRD
When User click on the Save button for MRD
When User select the MRD Shipment Received status from the filter
When User click on the Dispatch icon for Issue Module for MRD
When User enter the Shipping Qty with isDispatched Checkbox for MRD
When User click on the Save button for MRD
Then User click on the signout button for MRD

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

## MRD Partially Received Flow ##

@MRD-Partially
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for MRD
And User enters the SCM Team Member "<username>" and "<password>" for MRD
When User create the PO Request for PO ORDER for MRD
When User click on the save button for MRD
When User click on the Edit button for MRD
When User verify the PO and providing Pre-Approval for MRD
When User click on the Save button for MRD
Then User verifies the PO Status has been changed and Signout for MRD

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@MRD-Partially
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for MRD
And User enters the Operations Head "<username>" and "<password>" for MRD
And User click on the Edit button for MRD
And User verify the PO and providing Final-Approval for MRD
When User click on the Save button for MRD
Then User verifies the PO Status has been changed and Signout for MRD

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@MRD-Partially
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for MRD
And User enters the SCM Team Member "<username>" and "<password>" for MRD
And User click on the Issue icon for MRD
When User click on the Issue button for MRD
Then User verifies the PO Status has been changed to Issued and Signout for MRD

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@MRD-Partially
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for MRD
And User enters the Store Team Member "<username>" and "<password>" for MRD
When User create the GRN Request for Fully Received for MRD
When User click on the save button for MRD
When User select the Fully Received status from the filter for MRD
When User click on the edit button for MRD
When User move the stock to the Store for MRD
When User click on the Save button for MRD
Then User click on the signout button for MRD

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MRD-Partially
Scenario Outline: TC_05 Login with PM Team and Create the MRD Request
Given User on the login page for MRD
And User enters the PM Team Member "<username>" and "<password>" for MRD
When User create the MRD Request
When User click on the Save button for MRD
Then User click on the signout button for MRD

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@MRD-Partially
Scenario Outline: PO_06 Login with Store Team Member and Issue the MRD
Given User on the login page for MRD
And User enters the Store Team Member "<username>" and "<password>" for MRD
When User select the MRD Requested status from the filter
When User click on the Issue icon for Issue Module for MRD
When User click on the Save button for MRD
Then User click on the signout button for MRD

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MRD-Partially
Scenario Outline: PO_07 Login with Production Team Member and do the Production Complete
Given User on the login page for MRD
And User enters the Production Team Member "<username>" and "<password>" for MRD
When User select the MRD Issued status from the filter
When User click on the Dispatch icon for Issue Module for MRD
When User enters the Partially Completed Qty for MRD
When User click on the Save button for MRD
Then User click on the signout button for MRD

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@MRD-Partially
Scenario Outline: TC_08 Login with PM Team and Approve the MRD Request
Given User on the login page for MRD
And User enters the PM Team Member "<username>" and "<password>" for MRD
When User select the MRD Partially Production Completed status from the filter
When User click on the Dispatch icon for Issue Module for MRD
When User Approve the MRD Request
When User click on the Save button for MRD
Then User click on the signout button for MRD

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@MRD-Partially
Scenario Outline: PO_09 Login with Logistics Team Member and Shipment Receive the Partially Completed Qty
Given User on the login page for MRD
And User enters the Logistics Team Member "<username>" and "<password>" for MRD
When User select the MRD Approved status from the filter
When User click on the Dispatch icon for Issue Module for MRD
When User click the Shipment Received Checkbox for MRD
When User click on the Save button for MRD
When User select the MRD Shipment Received status from the filter
When User click on the Dispatch icon for Issue Module for MRD
When User enter the Partially Shipping Qty with isDispatched Checkbox for MRD
When User click on the Save button for MRD
Then User click on the signout button for MRD

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@MRD-Partially
Scenario Outline: PO_10 Login with Production Team Member and do the Production Complete
Given User on the login page for MRD
And User enters the Production Team Member "<username>" and "<password>" for MRD
When User select the MRD Partially Dispatched status from the filter
When User click on the Dispatch icon for Issue Module for MRD
When User enters the Balance Completed Qty for MRD
When User click on the Save button for MRD
Then User click on the signout button for MRD

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@MRD-Partially
Scenario Outline: PO_11 Login with Logistics Team Member and Shipment Receive the Balance Completed Qty
Given User on the login page for MRD
And User enters the Logistics Team Member "<username>" and "<password>" for MRD
When User select the MRD Production Completed status from the filter
When User click on the Dispatch icon for Issue Module for MRD
When User click on the Save button for MRD
When User select the MRD Shipment Received status from the filter
When User click on the Dispatch icon for Issue Module for MRD
When User enter the Balance Shipping Qty for MRD
When User click on the Save button for MRD
When User select the MRD Dispatched status from the filter
Then User verifies the MRD Status has been changed to Dispatched and Signout for MRD

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|