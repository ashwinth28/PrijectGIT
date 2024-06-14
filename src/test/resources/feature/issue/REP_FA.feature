Feature: Replacement & FA Sanity Automation

## MRI Fully Received Flow ##

@MRI-REP_FA-Fully-1
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page for FA
And User enters the SCM Team Member "<username>" and "<password>" for FA
When User create the PO Request for PO ORDER (RM-Domestic) for FA
When User click on the save button for FA
When User click on the Edit button for FA
When User verify the PO and providing Pre-Approval for FA
When User click on the Save button for FA
Then User verifies the PO Status has been changed and Signout for FA

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@MRI-REP_FA-Fully-1
Scenario Outline: PO_02 Login with Operations Head and Provide Final-Approval
Given User on the login page for FA
And User enters the Operations Head "<username>" and "<password>" for FA
And User click on the Edit button for FA
And User verify the PO and providing Final-Approval for FA
When User click on the Save button for FA
Then User verifies the PO Status has been changed and Signout for FA

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@MRI-REP_FA-Fully-1
Scenario Outline: PO_03 Login with SCM Team Member and Issue the PO
Given User on the login page for FA
And User enters the SCM Team Member "<username>" and "<password>" for FA
And User click on the Issue icon for FA
When User click on the Issue button for FA
Then User verifies the PO Status has been changed to Issued and Signout for FA

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION - Fully Received

@MRI-REP_FA-Fully-1
Scenario Outline: PO_04 Login with Store Team Member and Create the GRN
Given User on the login page for FA
And User enters the Store Team Member "<username>" and "<password>" for FA
When User create the GRN Request for Fully Received - (PO Order - RM - Domestic) for FA
When User click on the save button for FA
When User select the Fully Received status from the filter - (PO Order - RM - Domestic) for FA
When User click on the edit button for FA
When User move the stock to the Store for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MRI-REP_FA-Fully
Scenario Outline: TC_05 Login with PM Team and Create the MRI Request
Given User on the login page for FA
And User enters the PM Team Member "<username>" and "<password>" for FA
When User create the MRI Request for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@MRI-REP_FA-Fully
Scenario Outline: PO_06 Login with Store Team Member and Issue the MRI
Given User on the login page for FA
And User enters the Store Team Member "<username>" and "<password>" for FA
When User select the MRI Requested status from the filter for FA
When User click on the Issue icon for Issue Module for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MRI-REP_FA-Fully
Scenario Outline: PO_07 Login with Production Team Member and Enter the Failure Qty
Given User on the login page for FA
And User enters the Production Team Member "<username>" and "<password>" for FA
When User select the MRI Issued status from the filter for FA
When User click on the edit button for Issue Module for FA
When User enters the Failure Qty for FA
When User click on the Save button for FA
When User create the Replacement Request for FA
When User click on the Save button for FA
When User select the FA Requested status from the filter for FA
When User click on the Issue icon for Issue Module for FA
When User enters the Failure Reason and Unit Serial Number for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@MRI-REP_FA-Fully
Scenario Outline: PO_08 Login with FA Team Member and Enter the Dependent Team and Qty
Given User on the login page for FA
And User enters the FA Team Member "<username>" and "<password>" for FA
When User select the FA Issued status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the Dependent Team and Dependent Qty for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|fa@e-consystems.com|Fa@12345|

@MRI-REP_FA-Fully
Scenario Outline: PO_09 Login with MET Team Member and Enter the FA Qty
Given User on the login page for FA
And User enters the MET Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the FA Qty for MET for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|met@e-consystems.com|Met@12345|

@MRI-REP_FA-Fully
Scenario Outline: PO_10 Login with Process Quality Team Member and Enter the FA Qty
Given User on the login page for FA
And User enters the PQ Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the FA Qty for PQ for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|processquality@e-consystems.com|Processquality123|

@MRI-REP_FA-Fully
Scenario Outline: PO_11 Login with Design Team Member and Enter the FA Qty
Given User on the login page for FA
And User enters the Design Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the FA Qty for Design for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|serviceshardware@e-consystems.com|Service123|

@MRI-REP_FA-Fully
Scenario Outline: PO_12 Login with FA Team Member and Enter the Working Qty
Given User on the login page for FA
And User enters the FA Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the Working Qty for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|fa@e-consystems.com|Fa@12345|

@MRI-REP_FA-Fully
Scenario Outline: PO_13 Login with FQC Team Member and Enter the FQC Qty
Given User on the login page for FA
And User enters the FQC Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the FQC Qty for FA
When User click on the Save button for FA
When User select the FA Completed status from the filter for FA
Then User verifies the FA Status has been changed to FA Completed and Signout for FA

Examples: 
|username|password|
|fqc@e-consystems.com|Fqc12345|

## MRD Fully Received Flow ##

@MRD-REP_FA-Fully
Scenario Outline: TC_01 Login with PM Team and Create the MRD Request
Given User on the login page for FA
And User enters the PM Team Member "<username>" and "<password>" for FA
When User create the MRD Request for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@MRD-REP_FA-Fully
Scenario Outline: PO_02 Login with Store Team Member and Issue the MRD
Given User on the login page for FA
And User enters the Store Team Member "<username>" and "<password>" for FA
When User select the MRD Requested status from the filter for FA
When User click on the Issue icon for Issue Module for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MRD-REP_FA-Fully
Scenario Outline: PO_03 Login with Production Team Member and Enter the Failure Qty
Given User on the login page for FA
And User enters the Production Team Member "<username>" and "<password>" for FA
When User select the MRD Issued status from the filter for FA
When User click on the edit button for Issue Module for FA
When User enters the Failure Qty for FA
When User click on the Save button for FA
When User create the Replacement Request for FA
When User click on the Save button for FA
When User select the FA Requested status from the filter for FA
When User click on the Issue icon for Issue Module for FA
When User enters the Failure Reason and Unit Serial Number for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@MRD-REP_FA-Fully
Scenario Outline: PO_04 Login with FA Team Member and Enter the Dependent Team and Qty
Given User on the login page for FA
And User enters the FA Team Member "<username>" and "<password>" for FA
When User select the FA Issued status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the Dependent Team and Dependent Qty for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|fa@e-consystems.com|Fa@12345|

@MRD-REP_FA-Fully
Scenario Outline: PO_05 Login with MET Team Member and Enter the FA Qty
Given User on the login page for FA
And User enters the MET Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the FA Qty for MET for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|met@e-consystems.com|Met@12345|

@MRD-REP_FA-Fully
Scenario Outline: PO_06 Login with Process Quality Team Member and Enter the FA Qty
Given User on the login page for FA
And User enters the PQ Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the FA Qty for PQ for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|processquality@e-consystems.com|Processquality123|

@MRD-REP_FA-Fully
Scenario Outline: PO_07 Login with Design Team Member and Enter the FA Qty
Given User on the login page for FA
And User enters the Design Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the FA Qty for Design for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|serviceshardware@e-consystems.com|Service123|

@MRD-REP_FA-Fully
Scenario Outline: PO_08 Login with FA Team Member and Enter the Working Qty
Given User on the login page for FA
And User enters the FA Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the Working Qty for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|fa@e-consystems.com|Fa@12345|

@MRD-REP_FA-Fully
Scenario Outline: PO_09 Login with FQC Team Member and Enter the FQC Qty
Given User on the login page for FA
And User enters the FQC Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the FQC Qty for FA
When User click on the Save button for FA
When User select the FA Completed status from the filter for FA
Then User verifies the FA Status has been changed to FA Completed and Signout for FA

Examples: 
|username|password|
|fqc@e-consystems.com|Fqc12345|

## CR Fully Received Flow ##

@CR-REP_FA-Fully
Scenario Outline: TC_01 Login with PM Team and Create the MRD Request
Given User on the login page for FA
And User enters the PM Team Member "<username>" and "<password>" for FA
When User create the CR Request for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@CR-REP_FA-Fully
Scenario Outline: PO_02 Login with Store Team Member and Issue the MRD
Given User on the login page for FA
And User enters the Store Team Member "<username>" and "<password>" for FA
When User select the CR Requested status from the filter for FA
When User click on the Issue icon for Issue Module for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@CR-REP_FA-Fully
Scenario Outline: PO_03 Login with Production Team Member and Enter the Failure Qty
Given User on the login page for FA
And User enters the Production Team Member "<username>" and "<password>" for FA
When User select the CR Issued status from the filter for FA
When User click on the edit button for Issue Module for FA
When User enters the Failure Qty for FA
When User click on the Save button for FA
When User create the Replacement Request for FA
When User click on the Save button for FA
When User select the FA Requested status from the filter for FA
When User click on the Issue icon for Issue Module for FA
When User enters the Failure Reason and Unit Serial Number for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|production@e-consystems.com|Production123|

@CR-REP_FA-Fully
Scenario Outline: PO_04 Login with FA Team Member and Enter the Dependent Team and Qty
Given User on the login page for FA
And User enters the FA Team Member "<username>" and "<password>" for FA
When User select the FA Issued status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the Dependent Team and Dependent Qty for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|fa@e-consystems.com|Fa@12345|

@CR-REP_FA-Fully
Scenario Outline: PO_05 Login with MET Team Member and Enter the FA Qty
Given User on the login page for FA
And User enters the MET Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the FA Qty for MET for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|met@e-consystems.com|Met@12345|

@CR-REP_FA-Fully
Scenario Outline: PO_06 Login with Process Quality Team Member and Enter the FA Qty
Given User on the login page for FA
And User enters the PQ Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the FA Qty for PQ for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|processquality@e-consystems.com|Processquality123|

@CR-REP_FA-Fully
Scenario Outline: PO_07 Login with Design Team Member and Enter the FA Qty
Given User on the login page for FA
And User enters the Design Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the FA Qty for Design for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|serviceshardware@e-consystems.com|Service123|

@CR-REP_FA-Fully
Scenario Outline: PO_08 Login with FA Team Member and Enter the Working Qty
Given User on the login page for FA
And User enters the FA Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the Working Qty for FA
When User click on the Save button for FA
Then User click on the signout button for FA

Examples: 
|username|password|
|fa@e-consystems.com|Fa@12345|

@CR-REP_FA-Fully
Scenario Outline: PO_09 Login with FQC Team Member and Enter the FQC Qty
Given User on the login page for FA
And User enters the FQC Team Member "<username>" and "<password>" for FA
When User select the FA Under Progress status from the filter for FA
When User click on the Dispatch icon for Issue Module for FA
When User enters the FQC Qty for FA
When User click on the Save button for FA
When User select the FA Completed status from the filter for FA
Then User verifies the FA Status has been changed to FA Completed and Signout for FA

Examples: 
|username|password|
|fqc@e-consystems.com|Fqc12345|
