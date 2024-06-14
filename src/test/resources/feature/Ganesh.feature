Feature: Ganesh Validation

## PO CREATION AGAINST PO ORDER (FG-Import) ## Fully Received

Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (FG-Import)
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|c.rajahvijay@e-consystems.com|Rajah123|

Scenario Outline: PO_02 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

Scenario Outline: PO_03 Login with Operations Head and Provide Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|c.rajahvijay@e-consystems.com|Rajah123|

## GRN CREATION FOR (PO ORDER - FG - "Import") - Fully Received - Import (Without "CHA")

Scenario Outline: PO_05 Login with Store Team Member and Create the GRN
Given User on the login page
And User enters the Store Team Member "<username>" and "<password>"
When User create the GRN Request for Fully Received - (PO Order - FG - Import)
When User click on the save button
When User select the Fully Received status from the filter  - (PO Order - FG - Import)
When User click on the edit button
When User move the stock to the Store
When User click on the Save button
Then User click on the signout button

Examples: 
|username|password|
|r.sureshkumar@e-consystems.com|Suresh123|
