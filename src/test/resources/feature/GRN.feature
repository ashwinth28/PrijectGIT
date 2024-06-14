Feature: Validating GRN Module

					##************************************** "PO ORDER (RM - DOMESTIC)" *************************************##

## PO CREATION AGAINST PO ORDER (RM-Domestic) ## Fully Received

@POORDER-RM-DOMESTIC-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-DOMESTIC-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-DOMESTIC-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-RM-DOMESTIC-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - RM - "Domestic") - Fully Received - Domestic (Duty Exemption - "NO", Without "CHA")

@POORDER-RM-DOMESTIC-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - RM - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-RM-DOMESTIC-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Domestic), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@POORDER-RM-DOMESTIC-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-DOMESTIC-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-FR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-DOMESTIC-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-DOMESTIC-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (PO Order - RM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST PO ORDER (RM-Domestic) ## Partially Received

@POORDER-RM-DOMESTIC-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-DOMESTIC-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-DOMESTIC-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-RM-DOMESTIC-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - RM - "Domestic") - Partially Received - Domestic (With "CHA")

@POORDER-RM-DOMESTIC-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (PO Order - RM - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to Freight status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-RM-DOMESTIC-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@POORDER-RM-DOMESTIC-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-DOMESTIC-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-PR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-DOMESTIC-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-DOMESTIC-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (PO Order - RM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST PO ORDER (RM-Domestic) ## Instore with Fully

@POORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - RM - "Domestic") - Instore - Domestic (Without "CHA")

@POORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - RM - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (PO Order - RM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST PO ORDER (RM-Domestic) ## Instore with Partially

@POORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - RM - "Domestic") - Instore - Domestic (With "CHA")

@POORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (PO Order - RM - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (PO Order - RM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (PO Order - RM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Domestic), (Incoterm - DAP, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

					##************************************** "PO ORDER (RM - IMPORT)" *************************************##

## PO CREATION AGAINST PO ORDER (RM-Import) ## Fully Received

@POORDER-RM-IMPORT-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-IMPORT-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-IMPORT-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-RM-IMPORT-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - RM - "Import") - Fully Received - Import (Without "CHA")

@POORDER-RM-IMPORT-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - RM - Import)
When User click on the save button
When User select the Fully Received status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (PO Order - RM - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-RM-IMPORT-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@POORDER-RM-IMPORT-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-IMPORT-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-FR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - RM - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-IMPORT-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-IMPORT-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (PO Order - RM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST PO ORDER (RM-Import) ## Partially Received

@POORDER-RM-IMPORT-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-IMPORT-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-IMPORT-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-RM-IMPORT-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - RM - "Import") - Partially Received - Import (With "CHA")

@POORDER-RM-IMPORT-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (PO Order - RM - Import)
When User click on the save button
When User select the Partially Received status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (PO Order - RM - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (PO Order - RM - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-RM-IMPORT-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@POORDER-RM-IMPORT-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-IMPORT-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-PR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - RM - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-IMPORT-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-IMPORT-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (PO Order - RM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST PO ORDER (RM-Import) ## Instore with Fully

@POORDER-RM-IMPORT-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-IMPORT-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-IMPORT-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-RM-IMPORT-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - RM - "Import") - Instore - Import (Without "CHA")

@POORDER-RM-IMPORT-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - RM - Import)
When User click on the save button
When User select the Fully Received status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-IMPORT-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-IFR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - RM - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-IMPORT-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-IMPORT-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (PO Order - RM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-RM-IMPORT-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST PO ORDER (RM-Import) ## Instore with Partially

@POORDER-RM-IMPORT-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-IMPORT-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-IMPORT-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-RM-IMPORT-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - RM - "Import") - Instore - Import (With "CHA")

@POORDER-RM-IMPORT-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (PO Order - RM - Import)
When User click on the save button
When User select the Partially Received status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-IMPORT-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-IPR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - RM - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-RM-IMPORT-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-RM-IMPORT-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (PO Order - RM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-RM-IMPORT-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (PO Order - RM - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-RM-IMPORT-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (PO Order - RM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - DAP, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

					##************************************** "PO ORDER (FG - DOMESTIC)" *************************************##

## PO CREATION AGAINST PO ORDER (FG-Domestic) ## Fully Received

@POORDER-FG-DOMESTIC-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (FG-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-DOMESTIC-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-DOMESTIC-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-FG-DOMESTIC-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - FG - "Domestic") - Fully Received - Domestic (Duty Exemption - "NO", Without "CHA")

@POORDER-FG-DOMESTIC-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - FG - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-FG-DOMESTIC-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Domestic), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@POORDER-FG-DOMESTIC-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-DOMESTIC-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-FR
Scenario Outline: PO_10 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@POORDER-FG-DOMESTIC-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-DOMESTIC-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (PO Order - FG - Domestic)
Then User click on the signout button

Examples:
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST PO ORDER (FG-Domestic) ## Partially Received

@POORDER-FG-DOMESTIC-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (FG-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-DOMESTIC-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-DOMESTIC-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-FG-DOMESTIC-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - FG - "Domestic") - Partially Received - Domestic (With "CHA")

@POORDER-FG-DOMESTIC-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (PO Order - FG - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to Freight status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-FG-DOMESTIC-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@POORDER-FG-DOMESTIC-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-DOMESTIC-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-PR
Scenario Outline: PO_10 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@POORDER-FG-DOMESTIC-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-DOMESTIC-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (PO Order - FG - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST PO ORDER (FG-Domestic) ## Instore with Fully

@POORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (FG-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - FG - "Domestic") - Instore - Domestic (Without "CHA")

@POORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - FG - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_08 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@POORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (PO Order - FG - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - FG - Domestic), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - FG - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST PO ORDER (FG-Domestic) ## Instore with Partially

@POORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (FG-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - FG - "Domestic") - Instore - Domestic (With "CHA")

@POORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (PO Order - FG - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_08 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@POORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (PO Order - FG - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (PO Order - FG - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Domestic), (Incoterm - DAP, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

					##************************************** "PO ORDER (FG - IMPORT)" *************************************##

## PO CREATION AGAINST PO ORDER (FG-Import) ## Fully Received

@POORDER-FG-IMPORT-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (FG-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-IMPORT-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-IMPORT-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-FG-IMPORT-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - FG - "Import") - Fully Received - Import (Without "CHA")

@POORDER-FG-IMPORT-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - FG - Import)
When User click on the save button
When User select the Fully Received status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (PO Order - FG - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-FG-IMPORT-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@POORDER-FG-IMPORT-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-IMPORT-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-FR
Scenario Outline: PO_10 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - FG - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@POORDER-FG-IMPORT-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-IMPORT-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (PO Order - FG - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST PO ORDER (FG-Import) ## Partially Received

@POORDER-FG-IMPORT-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (FG-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-IMPORT-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-IMPORT-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-FG-IMPORT-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - FG - "Import") - Partially Received - Import (With "CHA")

@POORDER-FG-IMPORT-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (PO Order - FG - Import)
When User click on the save button
When User select the Partially Received status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (PO Order - FG - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (PO Order - FG - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-FG-IMPORT-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@POORDER-FG-IMPORT-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-IMPORT-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-PR
Scenario Outline: PO_10 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - FG - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@POORDER-FG-IMPORT-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-IMPORT-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (PO Order - FG - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST PO ORDER (FG-Import) ## Instore with Fully

@POORDER-FG-IMPORT-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (FG-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-IMPORT-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-IMPORT-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-FG-IMPORT-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - FG - "Import") - Instore - Import (Without "CHA")

@POORDER-FG-IMPORT-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - FG - Import)
When User click on the save button
When User select the Fully Received status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-IMPORT-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-IFR
Scenario Outline: PO_08 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - FG - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@POORDER-FG-IMPORT-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-IMPORT-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (PO Order - FG - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-FG-IMPORT-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST PO ORDER (FG-Import) ## Instore with Partially

@POORDER-FG-IMPORT-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (FG-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-IMPORT-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-FG-IMPORT-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-FG-IMPORT-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - FG - "Import") - Instore - Import (With "CHA")

@POORDER-FG-IMPORT-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (PO Order - FG - Import)
When User click on the save button
When User select the Partially Received status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-IMPORT-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-IPR
Scenario Outline: PO_08 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - FG - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@POORDER-FG-IMPORT-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-FG-IMPORT-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (PO Order - FG - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-FG-IMPORT-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (PO Order - FG - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-FG-IMPORT-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - DAP, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

					##********************************* "PO ORDER (NPM - DOMESTIC)" *************************************##

## PO CREATION AGAINST PO ORDER (NPM-Domestic) ## Fully Received

@POORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (NPM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - NPM - "Domestic") - Fully Received - Domestic (Duty Exemption - "NO", Without "CHA")

@POORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - NPM - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Domestic), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@POORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (PO Order - NPM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST PO ORDER (NPM-Domestic) ## Partially Received

@POORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (NPM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - NPM - "Domestic") - Partially Received - Domestic (With "CHA")

@POORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (PO Order - NPM - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to Freight status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@POORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received) (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Partially Received status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (PO Order - NPM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST PO ORDER (NPM-Domestic) ## Instore with Fully

@POORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (NPM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - NPM - "Domestic") - Instore - Domestic (Without "CHA")

@POORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - NPM - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (PO Order - NPM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST PO ORDER (NPM-Domestic) ## Instore with Partially

@POORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (NPM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - NPM - "Domestic") - Instore - Domestic (With "CHA")

@POORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (PO Order - NPM - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received) (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Partially Received status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (PO Order - NPM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (PO Order - NPM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Domestic), (Incoterm - DAP, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

					##************************************** "PO ORDER (NPM - IMPORT)" *************************************##

## PO CREATION AGAINST PO ORDER (NPM-Import) ## Fully Received

@POORDER-NPM-IMPORT-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (NPM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-IMPORT-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-IMPORT-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-NPM-IMPORT-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - NPM - "Import") - Fully Received - Import (Without "CHA")

@POORDER-NPM-IMPORT-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - NPM - Import)
When User click on the save button
When User select the Fully Received status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Import), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-NPM-IMPORT-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Import), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@POORDER-NPM-IMPORT-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-IMPORT-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-FR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - NPM - Import)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-IMPORT-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-IMPORT-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (PO Order - NPM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST PO ORDER (NPM-Import) ## Partially Received

@POORDER-NPM-IMPORT-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (NPM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-IMPORT-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-IMPORT-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-NPM-IMPORT-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - NPM - "Import") - Partially Received - Import (With "CHA")

@POORDER-NPM-IMPORT-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (PO Order - NPM - Import)
When User click on the save button
When User select the Partially Received status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (PO Order - NPM - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-NPM-IMPORT-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@POORDER-NPM-IMPORT-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received) (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-IMPORT-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-PR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - NPM - Import)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-IMPORT-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Partially Received status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-IMPORT-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (PO Order - NPM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST PO ORDER (NPM-Import) ## Instore with Fully

@POORDER-NPM-IMPORT-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (NPM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-IMPORT-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-IMPORT-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-NPM-IMPORT-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - NPM - "Import") - Instore - Import (Without "CHA")

@POORDER-NPM-IMPORT-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - NPM - Import)
When User click on the save button
When User select the Fully Received status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-IMPORT-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-IFR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - NPM - Import)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-IMPORT-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-IMPORT-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (PO Order - NPM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Import), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-NPM-IMPORT-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Import), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST PO ORDER (NPM-Import) ## Instore with Partially

@POORDER-NPM-IMPORT-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (NPM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-IMPORT-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-IMPORT-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@POORDER-NPM-IMPORT-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (PO ORDER - NPM - "Import") - Instore - Import (With "CHA")

@POORDER-NPM-IMPORT-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (PO Order - NPM - Import)
When User click on the save button
When User select the Partially Received status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received) (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-IMPORT-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-IPR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (PO Order - NPM - Import)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@POORDER-NPM-IMPORT-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Partially Received status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@POORDER-NPM-IMPORT-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (PO Order - NPM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@POORDER-NPM-IMPORT-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (PO Order - NPM - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@POORDER-NPM-IMPORT-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (PO Order - NPM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Import), (Incoterm - DAP, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

					##************************************** "WEB ORDER (RM - DOMESTIC)" *************************************##

## PO CREATION AGAINST WEB ORDER (RM-Domestic) ## Fully Received

@WEBORDER-RM-DOMESTIC-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (RM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-DOMESTIC-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-DOMESTIC-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-RM-DOMESTIC-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - RM - "Domestic") - Fully Received - Domestic (Duty Exemption - "NO", Without "CHA")

@WEBORDER-RM-DOMESTIC-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (WEB Order - RM - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-RM-DOMESTIC-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Domestic), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@WEBORDER-RM-DOMESTIC-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-DOMESTIC-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-FR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-DOMESTIC-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-DOMESTIC-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (WEB Order - RM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST WEB ORDER (RM-Domestic) ## Partially Received

@WEBORDER-RM-DOMESTIC-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (RM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-DOMESTIC-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-DOMESTIC-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-RM-DOMESTIC-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - RM - "Domestic") - Partially Received - Domestic (With "CHA")

@WEBORDER-RM-DOMESTIC-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (WEB Order - RM - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to Freight status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-RM-DOMESTIC-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@WEBORDER-RM-DOMESTIC-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-DOMESTIC-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-PR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-DOMESTIC-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-DOMESTIC-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (WEB Order - RM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST WEB ORDER (RM-Domestic) ## Instore with Fully

@WEBORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (RM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - RM - "Domestic") - Instore - Domestic (Without "CHA")

@WEBORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (WEB Order - RM - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (WEB Order - RM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - FG - Domestic), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-RM-DOMESTIC-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - FG - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST WEB ORDER (RM-Domestic) ## Instore with Partially

@WEBORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (RM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - RM - "Domestic") - Instore - Domestic (With "CHA")

@WEBORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (WEB Order - RM - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (WEB Order - RM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-RM-DOMESTIC-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (WEB Order - RM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Domestic), (Incoterm - DAP, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

					##************************************** "WEB ORDER (RM - IMPORT)" *************************************##

## PO CREATION AGAINST WEB ORDER (RM-Import) ## Fully Received

@WEBORDER-RM-IMPORT-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (RM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-IMPORT-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-IMPORT-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-RM-IMPORT-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - RM - "Import") - Fully Received - Import (Without "CHA")

@WEBORDER-RM-IMPORT-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (WEB Order - RM - Import)
When User click on the save button
When User select the Fully Received status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-RM-IMPORT-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@WEBORDER-RM-IMPORT-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-IMPORT-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-FR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - RM - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-IMPORT-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-IMPORT-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (WEB Order - RM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST PO ORDER (RM-Import) ## Partially Received

@WEBORDER-RM-IMPORT-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (RM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-IMPORT-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-IMPORT-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-RM-IMPORT-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - RM - "Import") - Partially Received - Import (With "CHA")

@WEBORDER-RM-IMPORT-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (WEB Order - RM - Import)
When User click on the save button
When User select the Partially Received status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (WEB Order - RM - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-RM-IMPORT-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@WEBORDER-RM-IMPORT-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-IMPORT-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-PR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - RM - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-IMPORT-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-IMPORT-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (WEB Order - RM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST WEB ORDER (RM-Import) ## Instore with Fully

@WEBORDER-RM-IMPORT-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (RM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-IMPORT-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-IMPORT-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-RM-IMPORT-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - RM - "Import") - Instore - Import (Without "CHA")

@WEBORDER-RM-IMPORT-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (WEB Order - RM - Import)
When User click on the save button
When User select the Fully Received status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-IMPORT-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-IFR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - RM - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-IMPORT-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-IMPORT-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (WEB Order - RM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-RM-IMPORT-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST WEB ORDER (RM-Import) ## Instore with Partially

@WEBORDER-RM-IMPORT-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (RM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-IMPORT-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-IMPORT-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-RM-IMPORT-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - RM - "Import") - Instore - Import (With "CHA")

@WEBORDER-RM-IMPORT-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (WEB Order - RM - Import)
When User click on the save button
When User select the Partially Received status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-IMPORT-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-IPR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - RM - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-RM-IMPORT-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-RM-IMPORT-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (WEB Order - RM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-RM-IMPORT-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (WEB Order - RM - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-RM-IMPORT-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (WEB Order - RM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - DAP, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

					##************************************** "WEB ORDER (FG - DOMESTIC)" *************************************##

## PO CREATION AGAINST WEB ORDER (FG-Domestic) ## Fully Received

@WEBORDER-FG-DOMESTIC-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (FG-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-DOMESTIC-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-DOMESTIC-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-FG-DOMESTIC-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - FG - "Domestic") - Fully Received - Domestic (Duty Exemption - "NO", Without "CHA")

@WEBORDER-FG-DOMESTIC-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (WEB Order - FG - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-FG-DOMESTIC-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Domestic), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@WEBORDER-FG-DOMESTIC-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-DOMESTIC-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-FR
Scenario Outline: PO_10 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@WEBORDER-FG-DOMESTIC-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-DOMESTIC-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (WEB Order - FG - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST WEB ORDER (FG-Domestic) ## Partially Received

@WEBORDER-FG-DOMESTIC-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (FG-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-DOMESTIC-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-DOMESTIC-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-FG-DOMESTIC-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - FG - "Domestic") - Partially Received - Domestic (With "CHA")

@WEBORDER-FG-DOMESTIC-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (WEB Order - FG - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to Freight status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-FG-DOMESTIC-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@WEBORDER-FG-DOMESTIC-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-DOMESTIC-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-PR
Scenario Outline: PO_10 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@WEBORDER-FG-DOMESTIC-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-DOMESTIC-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (WEB Order - FG - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST WEB ORDER (FG-Domestic) ## Instore with Fully

@WEBORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (FG-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - FG - "Domestic") - Instore - Domestic (Without "CHA")

@WEBORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (WEB Order - FG - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_08 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@WEBORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (WEB Order - FG - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - FG - Domestic), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-FG-DOMESTIC-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - FG - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST WEB ORDER (FG-Domestic) ## Instore with Partially

@WEBORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (FG-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - FG - "Domestic") - Instore - Domestic (With "CHA")

@WEBORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (WEB Order - FG - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_08 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@WEBORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (WEB Order - FG - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-FG-DOMESTIC-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (WEB Order - FG - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Domestic), (Incoterm - DAP, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

					##************************************** "WEB ORDER (FG - IMPORT)" *************************************##

## PO CREATION AGAINST WEB ORDER (FG-Import) ## Fully Received

@WEBORDER-FG-IMPORT-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (FG-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-IMPORT-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-IMPORT-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-FG-IMPORT-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - FG - "Import") - Fully Received - Import (Without "CHA")

@WEBORDER-FG-IMPORT-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (WEB Order - FG - Import)
When User click on the save button
When User select the Fully Received status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-FG-IMPORT-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@WEBORDER-FG-IMPORT-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-IMPORT-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-FR
Scenario Outline: PO_10 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - FG - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@WEBORDER-FG-IMPORT-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-IMPORT-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (WEB Order - FG - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST WEB ORDER (FG-Import) ## Partially Received

@WEBORDER-FG-IMPORT-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (FG-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-IMPORT-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-IMPORT-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-FG-IMPORT-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - FG - "Import") - Partially Received - Import (With "CHA")

@WEBORDER-FG-IMPORT-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (WEB Order - FG - Import)
When User click on the save button
When User select the Partially Received status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (WEB Order - FG - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-FG-IMPORT-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@WEBORDER-FG-IMPORT-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-IMPORT-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-PR
Scenario Outline: PO_10 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - FG - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@WEBORDER-FG-IMPORT-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-IMPORT-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (WEB Order - FG - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST WEB ORDER (FG-Import) ## Instore with Fully

@WEBORDER-FG-IMPORT-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (FG-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-IMPORT-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-IMPORT-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-FG-IMPORT-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - FG - "Import") - Instore - Import (Without "CHA")

@WEBORDER-FG-IMPORT-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (WEB Order - FG - Import)
When User click on the save button
When User select the Fully Received status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid
When User click on the Save button
When User select the Under Quarantine status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-IMPORT-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-IFR
Scenario Outline: PO_08 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - FG - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@WEBORDER-FG-IMPORT-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Fully Received status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-IMPORT-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (WEB Order - FG - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-FG-IMPORT-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST WEB ORDER (FG-Import) ## Instore with Partially

@WEBORDER-FG-IMPORT-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (FG-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-IMPORT-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-FG-IMPORT-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-FG-IMPORT-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - FG - "Import") - Instore - Import (With "CHA")

@WEBORDER-FG-IMPORT-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (WEB Order - FG - Import)
When User click on the save button
When User select the Partially Received status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Rejected qty
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-IMPORT-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-IPR
Scenario Outline: PO_08 Login with PM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the PM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - FG - Import)
When User click on the edit button
When User enters the P-MRA Qty
When User click on the Short closure in Grid
When User enter the Credit Note No
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@WEBORDER-FG-IMPORT-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty
When User click on the Save button
When User select the Partially Received status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the Accepted qty in the grid
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-FG-IMPORT-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (WEB Order - FG - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-FG-IMPORT-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (WEB Order - FG - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-FG-IMPORT-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (WEB Order - FG - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - RM - Import), (Incoterm - DAP, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

					##********************************* "WEB ORDER (NPM - DOMESTIC)" *************************************##

## PO CREATION AGAINST WEB ORDER (NPM-Domestic) ## Fully Received

@WEBORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (NPM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - NPM - "Domestic") - Fully Received - Domestic (Duty Exemption - "NO", Without "CHA")

@WEBORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (WEB Order - NPM - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Domestic), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@WEBORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-DOMESTIC-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (WEB Order - NPM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST WEB ORDER (NPM-Domestic) ## Partially Received

@WEBORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (NPM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - NPM - "Domestic") - Partially Received - Domestic (With "CHA")

@WEBORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (WEB Order - NPM - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to Freight status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@WEBORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received) (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Partially Received status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-DOMESTIC-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (WEB Order - NPM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST WEB ORDER (NPM-Domestic) ## Instore with Fully

@WEBORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (NPM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - NPM - "Domestic") - Instore - Domestic (Without "CHA")

@WEBORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (WEB Order - NPM - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (WEB Order - NPM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-NPM-DOMESTIC-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST WEB ORDER (NPM-Domestic) ## Instore with Partially

@WEBORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (NPM-Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - NPM - "Domestic") - Instore - Domestic (With "CHA")

@WEBORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (WEB Order - NPM - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received) (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Partially Received status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (WEB Order - NPM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-NPM-DOMESTIC-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (WEB Order - NPM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Domestic), (Incoterm - DAP, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

					##************************************** "WEB ORDER (NPM - IMPORT)" *************************************##

## PO CREATION AGAINST WEB ORDER (NPM-Import) ## Fully Received

@WEBORDER-NPM-IMPORT-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (NPM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-IMPORT-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-IMPORT-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-NPM-IMPORT-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - NPM - "Import") - Fully Received - Import (Without "CHA")

@WEBORDER-NPM-IMPORT-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (WEB Order - NPM - Import)
When User click on the save button
When User select the Fully Received status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Import), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-NPM-IMPORT-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Import), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@WEBORDER-NPM-IMPORT-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-IMPORT-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-FR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-IMPORT-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-IMPORT-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (WEB Order - NPM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST WEB ORDER (NPM-Import) ## Partially Received

@WEBORDER-NPM-IMPORT-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (NPM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-IMPORT-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-IMPORT-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-NPM-IMPORT-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - NPM - "Import") - Partially Received - Import (With "CHA")

@WEBORDER-NPM-IMPORT-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (WEB Order - NPM - Import)
When User click on the save button
When User select the Partially Received status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-NPM-IMPORT-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@WEBORDER-NPM-IMPORT-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received) (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-IMPORT-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-PR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-IMPORT-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Partially Received status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-IMPORT-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (WEB Order - NPM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST WEB ORDER (NPM-Import) ## Instore with Fully

@WEBORDER-NPM-IMPORT-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (NPM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-IMPORT-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-IMPORT-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-NPM-IMPORT-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - NPM - "Import") - Instore - Import (Without "CHA")

@WEBORDER-NPM-IMPORT-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (WEB Order - NPM - Import)
When User click on the save button
When User select the Fully Received status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-IMPORT-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-IFR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-IMPORT-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-IMPORT-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (WEB Order - NPM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Import), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-NPM-IMPORT-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Import), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST WEB ORDER (NPM-Import) ## Instore with Partially

@WEBORDER-NPM-IMPORT-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (NPM-Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-IMPORT-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-IMPORT-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@WEBORDER-NPM-IMPORT-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (WEB ORDER - NPM - "Import") - Instore - Import (With "CHA")

@WEBORDER-NPM-IMPORT-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (WEB Order - NPM - Import)
When User click on the save button
When User select the Partially Received status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received) (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-IMPORT-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-IPR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@WEBORDER-NPM-IMPORT-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Partially Received status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@WEBORDER-NPM-IMPORT-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter  - (WEB Order - NPM - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@WEBORDER-NPM-IMPORT-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (PO Order - NPM - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (WEB Order - NPM - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@WEBORDER-NPM-IMPORT-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter  - (WEB Order - NPM - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown  - (PO Order - NPM - Import), (Incoterm - DAP, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

							#****************************** (Testing & Services - Domestic)*****************************#
							
## PO CREATION AGAINST Testing & Services (Domestic) ## Fully Received

@TESTING&SERVICES-DOMESTIC-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for Testing & Services (Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-DOMESTIC-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-DOMESTIC-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@TESTING&SERVICES-DOMESTIC-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (Testing & Services - "Domestic") - Fully Received - Domestic (Duty Exemption - "NO", Without "CHA")

@TESTING&SERVICES-DOMESTIC-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (Testing & Services - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (Testing & Services - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@TESTING&SERVICES-DOMESTIC-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (Testing & Services - Domestic), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@TESTING&SERVICES-DOMESTIC-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-DOMESTIC-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-FR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-DOMESTIC-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-DOMESTIC-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (Testing & Services - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST Testing & Services (Domestic) ## Partially Received

@TESTING&SERVICES-DOMESTIC-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for Testing & Services (Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-DOMESTIC-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-DOMESTIC-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@TESTING&SERVICES-DOMESTIC-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (Testing & Services - "Domestic") - Partially Received - Domestic (With "CHA")

@TESTING&SERVICES-DOMESTIC-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (Testing & Services - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (Testing & Services - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to Freight status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - FOB, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@TESTING&SERVICES-DOMESTIC-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (Testing & Services - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@TESTING&SERVICES-DOMESTIC-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received) (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-DOMESTIC-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-PR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-DOMESTIC-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Partially Received status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-DOMESTIC-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (Testing & Services - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST Testing & Services (Domestic) ## Instore with Fully

@TESTING&SERVICES-DOMESTIC-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for Testing & Services (Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-DOMESTIC-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-DOMESTIC-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@TESTING&SERVICES-DOMESTIC-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (Testing & Services - "Domestic") - Instore - Domestic (Without "CHA")

@TESTING&SERVICES-DOMESTIC-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (Testing & Services - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-DOMESTIC-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-IFR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-DOMESTIC-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-DOMESTIC-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (Testing & Services - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (Testing & Services - Domestic), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@TESTING&SERVICES-DOMESTIC-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (Testing & Services - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST Testing & Services (Domestic) ## Instore with Partially

@TESTING&SERVICES-DOMESTIC-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for Testing & Services (Domestic)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-DOMESTIC-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-DOMESTIC-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@TESTING&SERVICES-DOMESTIC-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (Testing & Services - "Domestic") - Instore - Domestic (With "CHA")

@TESTING&SERVICES-DOMESTIC-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (Testing & Services - Domestic)
When User click on the save button
When User select the Partially Received status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received) (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-DOMESTIC-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-IPR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-DOMESTIC-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Partially Received status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-DOMESTIC-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (Testing & Services - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-DOMESTIC-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (Testing & Services - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to DTAP status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the DTAP fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
When User select the Yet to CHA status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Domestic), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@TESTING&SERVICES-DOMESTIC-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (Testing & Services - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (Testing & Services - Domestic), (Incoterm - DAP, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

			##**************************** "TESTING & SERVICES - (RM - IMPORT)" ******************************##

## PO CREATION AGAINST Testing & Services (Import) ## Fully Received

@TESTING&SERVICES-IMPORT-FR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for Testing & Services (Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-IMPORT-FR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-IMPORT-FR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@TESTING&SERVICES-IMPORT-FR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (Testing & Services - "Import") - Fully Received - Import (Without "CHA")

@TESTING&SERVICES-IMPORT-FR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (Testing & Services - Import)
When User click on the save button
When User select the Fully Received status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-FR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (Testing & Services - Import), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@TESTING&SERVICES-IMPORT-FR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (Testing & Services - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (Testing & Services - Import), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@TESTING&SERVICES-IMPORT-FR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-IMPORT-FR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-FR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-IMPORT-FR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-FR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-IMPORT-FR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (Testing & Services - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST Testing & Services (Import) ## Partially Received

@TESTING&SERVICES-IMPORT-PR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for Testing & Services (Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-IMPORT-PR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-IMPORT-PR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@TESTING&SERVICES-IMPORT-PR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (Testing & Services - "Import") - Partially Received - Import (With "CHA")

@TESTING&SERVICES-IMPORT-PR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (Testing & Services - Import)
When User click on the save button
When User select the Partially Received status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-PR
Scenario Outline: PO_06 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (Testing & Services - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - FOB, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@TESTING&SERVICES-IMPORT-PR
Scenario Outline: PO_07 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (Testing & Services - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (Testing & Services - Import), (Incoterm - EXW, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@TESTING&SERVICES-IMPORT-PR
Scenario Outline: PO_08 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received) (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-IMPORT-PR
Scenario Outline: PO_09 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-PR
Scenario Outline: PO_10 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-IMPORT-PR
Scenario Outline: PO_11 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Partially Received status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-PR
Scenario Outline: PO_12 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-IMPORT-PR
Scenario Outline: PO_13 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (Testing & Services - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

## PO CREATION AGAINST Testing & Services (Import) ## Instore with Fully

@TESTING&SERVICES-IMPORT-IFR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for Testing & Services (Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-IMPORT-IFR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-IMPORT-IFR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@TESTING&SERVICES-IMPORT-IFR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (Testing & Services - "Import") - Instore - Import (Without "CHA")

@TESTING&SERVICES-IMPORT-IFR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (Testing & Services - Import)
When User click on the save button
When User select the Fully Received status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-IFR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-IMPORT-IFR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-IFR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-IMPORT-IFR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Fully Received status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-IFR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-IMPORT-IFR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (Testing & Services - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-IFR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (Testing & Services - Import), (Incoterm - CIF, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@TESTING&SERVICES-IMPORT-IFR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (Testing & Services - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (Testing & Services - Import), (Incoterm - DDU, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

## PO CREATION AGAINST Testing & Services (Import) ## Instore with Partially

@TESTING&SERVICES-IMPORT-IPR
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for Testing & Services (Import)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-IMPORT-IPR
Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-IMPORT-IPR
Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|manufacturinghead@e-consystems.com|Manufacturinghead123|

@TESTING&SERVICES-IMPORT-IPR
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

## GRN CREATION FOR (Testing & Services - "Import") - Instore - Import (With "CHA")

@TESTING&SERVICES-IMPORT-IPR
Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Partially Received - (Testing & Services - Import)
When User click on the save button
When User select the Partially Received status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-IPR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (Partially Received) (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Rejected qty - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-IMPORT-IPR
Scenario Outline: PO_07 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-IPR
Scenario Outline: PO_08 Login with SCM Team Member and Move the Reject Qty to P-MRA
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User select the Yet to MRA/Short Closure status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the P-MRA Qty - (PO Order - NPM - Domestic)
When User click on the Short closure in Grid - (PO Order - NPM - Domestic)
When User enter the Credit Note No - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|purchasehead@e-consystems.com|Purchasehead123|

@TESTING&SERVICES-IMPORT-IPR
Scenario Outline: PO_09 Login with Store Team Member and Move the P-MRA Qty to Store Received Qty
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Partially Received status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (PO Order - NPM - Domestic)
When User click on the Save button
When User select the Partially Received status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-IPR
Scenario Outline: PO_10 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the Accepted qty in the grid - (PO Order - NPM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@TESTING&SERVICES-IMPORT-IPR
Scenario Outline: PO_11 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (Testing & Services - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (Testing & Services - Import)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@TESTING&SERVICES-IMPORT-IPR
Scenario Outline: PO_12 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (Testing & Services - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to CHA status from the filter - (Testing & Services - Import)
When User click on the edit button
When User enters the CHA fields in logistics tile dropdown - (PO Order - RM - Import), (Incoterm - DDU, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@TESTING&SERVICES-IMPORT-IPR
Scenario Outline: PO_13 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (Testing & Services - Import)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (Testing & Services - Import), (Incoterm - DAP, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

								##**********************(CSM - Domestic) - Fully Received***********************##
																		
## GRN CREATION FOR (CSM - "Domestic") - Fully Received - (Duty Exemption - "NO", Without "CHA")

@CSM-DOMESTIC-FR
Scenario Outline: PO_01 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (CSM - Domestic)
When User click on the save button
When User select the Fully Received status from the filter - (CSM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@CSM-DOMESTIC-FR
Scenario Outline: PO_02 Login with Logistics Team Member and enter the fields
Given User on the login page
And User enters the Logistics Team Member "<username>" and "<password>"
When User select the Yet to Logistics status from the filter - (CSM - Domestic)
When User click on the edit button
When User enters the logistics fields in logistics tile dropdown - (CSM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
When User select the Yet to Freight status from the filter - (CSM - Domestic)
When User click on the edit button
When User enters the Freight fields in logistics tile dropdown - (CSM - Domestic), (Incoterm - EXW, Duty Exemption - NO)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logistics@e-consystems.com|Logistics123|

@CSM-DOMESTIC-FR
Scenario Outline: PO_03 Login with Logistics Team Head and edit the fields
Given User on the login page
And User enters the Logistics Team Head "<username>" and "<password>"
When User select the Logistics Completed status from the filter - (CSM - Domestic)
When User click on the edit button
When User ensure the store fields are in disabled status
When User edit the logistics fields in logistics tile dropdown - (CSM - Domestic), (Incoterm - FCA, Duty Exemption - YES)
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|logisticshead@e-consystems.com|Logisticshead123|

@CSM-DOMESTIC-FR
Scenario Outline: PO_04 Login with IQC Team Member and Do the IQC Approval or Reject
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (CSM - Domestic)
When User click on the edit button
When User enters the Accepted qty, Date code in the grid - (CSM - Domestic)
When User click on the Save button
When User select the Under Quarantine status from the filter - (CSM - Domestic)
When User click on the edit button
When User enters the Rejected qty - (CSM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@CSM-DOMESTIC-FR
Scenario Outline: PO_05 Login with Store Team Member and Move the Accepted Qty to Store
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (CSM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Yet to MRA/Short Closure status from the filter - (CSM - Domestic)
When User click on the edit button
When User enters the P-MRA Qty - (CSM - Domestic)
When User click on the Short closure in Grid - (CSM - Domestic)
When User enter the Credit Note No - (CSM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter - (CSM - Domestic)
When User click on the edit button
When User move the stock from the P-MRA to S-Receive Qty - (CSM - Domestic)
When User click on the Save button
When User select the Fully Received status from the filter - (CSM - Domestic)
When User click on the edit button
When User move the stock to the IQC team
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@CSM-DOMESTIC-FR
Scenario Outline: PO_06 Login with IQC Team Member and Do the IQC Approval
Given User on the login page
And User enters the IQC Team Member "<username>" and "<password>"
When User select the Under Inspection status from the filter - (CSM - Domestic)
When User click on the edit button
When User enters the Accepted qty in the grid - (CSM - Domestic)
When User click on the Save button
Then User click on the signout button

Examples:
|username|password|
|iqc@e-consystems.com|Iqc123|

@CSM-DOMESTIC-FR
Scenario Outline: PO_07 Login with Store Team Member and Move the Qty to Instore
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User select the Yet to Instore status from the filter - (CSM - Domestic)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
When User select the Instore status from the filter - (CSM - Domestic)
Then User click on the signout button

Examples: 
|username|password|
|store@e-consystems.com|Store123|
