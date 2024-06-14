Feature: Issue

## FG Fully Received Flow ##

@FG-Fully
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
|n.sivapradeep@e-consystems.com|Sivap123|

@FG-Fully
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@FG-Fully
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

## GRN CREATION - Fully Received

@FG-Fully
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
|r.sureshkumar@e-consystems.com|Suresh123|

@FG-Fully
Scenario Outline: TC_05 Login with PM Team and Create the FG Request
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User create the FG Request
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|s.prabhakar@e-consystems.com|Prabhakar123|

@FG-Fully
Scenario Outline: PO_06 Login with Store Team Member and Issue the FG
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the FG Requested status from the filter
When User click on the Issue icon for Issue Module
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|r.sureshkumar@e-consystems.com|Suresh123|

@FG-Fully
Scenario Outline: PO_07 Login with Production Team Member and do the Production Complete
Given User on the login page
And User enters the Production Team Member "<username>" and "<password>"
When User select the FG Issued status from the filter
When User click on the Dispatch icon for Issue Module
When User enters the Completed Qty for FG
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|s.sangavi@e-consystems.com|Sangavi123|

@FG-Fully
Scenario Outline: PO_08 Login with Logistics Team Member and Shipment Receive the Completed Qty
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the FG Production Completed status from the filter
When User click on the Dispatch icon for Issue Module
When User click the Shipment Received Checkbox
When User click on the Save button
When User select the FG Shipment Received status from the filter
When User click on the Dispatch icon for Issue Module
When User enter the FG Shipping Qty with isDispatched Checkbox
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|v.vijay@e-consystems.com|Vijay123|

## MRD Partially Received Flow ##

@MRD-Partially
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
|n.sivapradeep@e-consystems.com|Sivap123|

@MRD-Partially
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@MRD-Partially
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

## GRN CREATION - Fully Received

@MRD-Partially
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
|r.sureshkumar@e-consystems.com|Suresh123|

@MRD-Partially
Scenario Outline: TC_05 Login with PM Team and Create the MRD Request
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User create the MRD Request
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|s.prabhakar@e-consystems.com|Prabhakar123|

@MRD-Partially
Scenario Outline: PO_06 Login with Store Team Member and Issue the MRD
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the MRD Requested status from the filter
When User click on the Issue icon for Issue Module
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|r.sureshkumar@e-consystems.com|Suresh123|

@MRD-Partially
Scenario Outline: PO_07 Login with Production Team Member and do the Production Complete
Given User on the login page
And User enters the Production Team Member "<username>" and "<password>"
When User select the MRD Issued status from the filter
When User click on the Dispatch icon for Issue Module
When User enters the Partially Completed Qty for MRD
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|s.sangavi@e-consystems.com|Sangavi123|

@MRD-Partially
Scenario Outline: TC_08 Login with PM Team and Approve the MRD Request
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the MRD Partially Production Completed status from the filter
When User click on the Dispatch icon for Issue Module
When User Approve the MRD Request
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|s.prabhakar@e-consystems.com|Prabhakar123|

@MRD-Partially
Scenario Outline: PO_09 Login with Logistics Team Member and Shipment Receive the Partially Completed Qty
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the MRD Approved status from the filter
When User click on the Dispatch icon for Issue Module
When User click the Shipment Received Checkbox
When User click on the Save button
When User select the MRD Shipment Received status from the filter
When User click on the Dispatch icon for Issue Module
When User enter the Partially Shipping Qty with isDispatched Checkbox
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|v.vijay@e-consystems.com|Vijay123|
