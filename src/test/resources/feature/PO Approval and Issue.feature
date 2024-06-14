Feature: Validating PO Approval and Rejection Flow

## PO CREATION AGAINST PO ORDER (RM) ##
@POORDER-RM
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-RM
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
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-RM
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
|salimjaved@e-consystems.com|Salim123|

@POORDER-RM
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#To Be Revised and Rejection Flow

@POORDER-RM
Scenario Outline: PO_05 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM)
Then User click on the Save button and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-RM
Scenario Outline: PO_06 Login with SCM Team Head and Provide To-Be Revised
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing To-Be Revised
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-RM
Scenario Outline: PO_07 Login with SCM Team Member and Modify the PO with Necessary Changes
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Edit button
And User made the changes accordingly
Then User click the Save and Signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-RM
Scenario Outline: PO_08 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approved
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-RM
Scenario Outline: PO_09 Login with Operations Head and Provide Final-Approval Reject
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval Reject
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

#Force Closure Flow

@POORDER-RM
Scenario Outline: PO_10 Login with SCM Team Member and Create the PO and do the Force Closure
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM)
When User click on the save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
When User create the PO Request for PO ORDER (RM)
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-RM
Scenario Outline: PO_11 Login With SCM Team Member and Provide the Pre-Approval and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-RM
Scenario Outline: PO_12 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (RM)
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-RM
Scenario Outline: PO_13 Login With SCM Team Member and Provide the Pre-Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-RM
Scenario Outline: PO_14 Login with Operations Head and Provide the Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@POORDER-RM
Scenario Outline: PO_15 Login With SCM Team Member and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#Amendment Flow

@POORDER-RM
Scenario Outline: PO_16 Login with SCM Team Member and Modify the Unimportant Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Unimportant changes (RM)
When User click on the save button
Then User verifies the Issued PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-RM
Scenario Outline: PO_17 Login with SCM Team Member and Modify the Required Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Required changes (RM)
When User click on the save button
Then User verifies the PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-RM
Scenario Outline: PO_18 Login With SCM Team Member and Provide the Pre-Approval for Amended PO
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User select the Amended PO from the filter
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-RM
Scenario Outline: PO_19 Login with Operations Head and Provide the Final-Approval for Amended PO
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User select the Pre-Approved PO from the filter
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@POORDER-RM
Scenario Outline: PO_20 Login with SCM Team Member and Issue the Amended PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Final-Approved PO from the filter
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status by filter and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

## PO CREATION AGAINST PO ORDER (FG) ##

@POORDER-FG
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (FG)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-FG
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
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-FG
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
|salimjaved@e-consystems.com|Salim123|

@POORDER-FG
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#To Be Revised and Rejection Flow

@POORDER-FG
Scenario Outline: PO_05 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (FG)
Then User click on the Save button and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-FG
Scenario Outline: PO_06 Login with SCM Team Head and Provide To-Be Revised
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing To-Be Revised
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-FG
Scenario Outline: PO_07 Login with SCM Team Member and Modify the PO with Necessary Changes
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Edit button
And User made the changes accordingly
Then User click the Save and Signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-FG
Scenario Outline: PO_08 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approved
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-FG
Scenario Outline: PO_09 Login with Operations Head and Provide Final-Approval Reject
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval Reject
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

#Force Closure Flow

@POORDER-FG
Scenario Outline: PO_10 Login with SCM Team Member and Create the PO and do the Force Closure
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (FG)
When User click on the save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
When User create the PO Request for PO ORDER (FG)
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-FG
Scenario Outline: PO_11 Login With SCM Team Member and Provide the Pre-Approval and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-FG
Scenario Outline: PO_12 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (FG)
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-FG
Scenario Outline: PO_13 Login With SCM Team Member and Provide the Pre-Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-FG
Scenario Outline: PO_14 Login with Operations Head and Provide the Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@POORDER-FG
Scenario Outline: PO_15 Login With SCM Team Member and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#Amendment Flow

@POORDER-FG
Scenario Outline: PO_16 Login with SCM Team Member and Modify the Unimportant Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Unimportant changes (FG)
When User click on the save button
Then User verifies the Issued PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-FG
Scenario Outline: PO_17 Login with SCM Team Member and Modify the Required Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Required changes (FG)
When User click on the save button
Then User verifies the PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-FG
Scenario Outline: PO_18 Login With SCM Team Member and Provide the Pre-Approval for Amended PO
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User select the Amended PO from the filter
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-FG
Scenario Outline: PO_19 Login with Operations Head and Provide the Final-Approval for Amended PO
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User select the Pre-Approved PO from the filter
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@POORDER-FG
Scenario Outline: PO_20 Login with SCM Team Member and Issue the Amended PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Final-Approved PO from the filter
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status by filter and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

## PO CREATION AGAINST PO ORDER (NPM) ##

@POORDER-NPM
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (NPM)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-NPM
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
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-NPM
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
|salimjaved@e-consystems.com|Salim123|

@POORDER-NPM
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#To Be Revised and Rejection Flow

@POORDER-NPM
Scenario Outline: PO_05 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (NPM)
Then User click on the Save button and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-NPM
Scenario Outline: PO_06 Login with SCM Team Head and Provide To-Be Revised
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing To-Be Revised
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-NPM
Scenario Outline: PO_07 Login with SCM Team Member and Modify the PO with Necessary Changes
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Edit button
And User made the changes accordingly
Then User click the Save and Signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-NPM
Scenario Outline: PO_08 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approved
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-NPM
Scenario Outline: PO_09 Login with Operations Head and Provide Final-Approval Reject
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval Reject
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

#Force Closure Flow

@POORDER-NPM
Scenario Outline: PO_10 Login with SCM Team Member and Create the PO and do the Force Closure
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (NPM)
When User click on the save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
When User create the PO Request for PO ORDER (NPM)
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-NPM
Scenario Outline: PO_11 Login With SCM Team Member and Provide the Pre-Approval and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-NPM
Scenario Outline: PO_12 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for PO ORDER (NPM)
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-NPM
Scenario Outline: PO_13 Login With SCM Team Member and Provide the Pre-Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-NPM
Scenario Outline: PO_14 Login with Operations Head and Provide the Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@POORDER-NPM
Scenario Outline: PO_15 Login With SCM Team Member and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#Amendment Flow

@POORDER-NPM
Scenario Outline: PO_16 Login with SCM Team Member and Modify the Unimportant Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Unimportant changes (NPM)
When User click on the save button
Then User verifies the Issued PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-NPM
Scenario Outline: PO_17 Login with SCM Team Member and Modify the Required Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Required changes (NPM)
When User click on the save button
Then User verifies the PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-NPM
Scenario Outline: PO_18 Login With SCM Team Member and Provide the Pre-Approval for Amended PO
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User select the Amended PO from the filter
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@POORDER-NPM
Scenario Outline: PO_19 Login with Operations Head and Provide the Final-Approval for Amended PO
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User select the Pre-Approved PO from the filter
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@POORDER-NPM
Scenario Outline: PO_20 Login with SCM Team Member and Issue the Amended PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Final-Approved PO from the filter
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status by filter and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

											     #**********************************************************#

## PO CREATION AGAINST WEB ORDER (RM) ##

@WEBORDER-RM
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (RM)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-RM
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
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-RM
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
|salimjaved@e-consystems.com|Salim123|

@WEBORDER-RM
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#To Be Revised and Rejection Flow

@WEBORDER-RM
Scenario Outline: PO_05 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (RM)
Then User click on the Save button and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-RM
Scenario Outline: PO_06 Login with SCM Team Head and Provide To-Be Revised
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing To-Be Revised
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-RM
Scenario Outline: PO_07 Login with SCM Team Member and Modify the PO with Necessary Changes
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Edit button
And User made the changes accordingly
Then User click the Save and Signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-RM
Scenario Outline: PO_08 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approved
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-RM
Scenario Outline: PO_09 Login with Operations Head and Provide Final-Approval Reject
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval Reject
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

#Force Closure Flow

@WEBORDER-RM
Scenario Outline: PO_10 Login with SCM Team Member and Create the PO and do the Force Closure
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (RM)
When User click on the save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
When User create the PO Request for WEB ORDER (RM)
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-RM
Scenario Outline: PO_11 Login With SCM Team Member and Provide the Pre-Approval and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-RM
Scenario Outline: PO_12 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (RM)
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-RM
Scenario Outline: PO_13 Login With SCM Team Member and Provide the Pre-Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-RM
Scenario Outline: PO_14 Login with Operations Head and Provide the Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@WEBORDER-RM
Scenario Outline: PO_15 Login With SCM Team Member and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#Amendment Flow

@WEBORDER-RM
Scenario Outline: PO_16 Login with SCM Team Member and Modify the Unimportant Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Unimportant changes (RM)
When User click on the save button
Then User verifies the Issued PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-RM
Scenario Outline: PO_17 Login with SCM Team Member and Modify the Required Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Required changes (RM)
When User click on the save button
Then User verifies the PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-RM
Scenario Outline: PO_18 Login With SCM Team Member and Provide the Pre-Approval for Amended PO
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User select the Amended PO from the filter
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-RM
Scenario Outline: PO_19 Login with Operations Head and Provide the Final-Approval for Amended PO
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User select the Pre-Approved PO from the filter
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@WEBORDER-RM
Scenario Outline: PO_20 Login with SCM Team Member and Issue the Amended PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Final-Approved PO from the filter
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status by filter and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

## PO CREATION AGAINST WEB ORDER (FG) ##

@WEBORDER-FG
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (FG)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-FG
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
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-FG
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
|salimjaved@e-consystems.com|Salim123|

@WEBORDER-FG
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#To Be Revised and Rejection Flow

@WEBORDER-FG
Scenario Outline: PO_05 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (FG)
Then User click on the Save button and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-FG
Scenario Outline: PO_06 Login with SCM Team Head and Provide To-Be Revised
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing To-Be Revised
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-FG
Scenario Outline: PO_07 Login with SCM Team Member and Modify the PO with Necessary Changes
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Edit button
And User made the changes accordingly
Then User click the Save and Signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-FG
Scenario Outline: PO_08 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approved
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-FG
Scenario Outline: PO_09 Login with Operations Head and Provide Final-Approval Reject
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval Reject
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

#Force Closure Flow

@WEBORDER-FG
Scenario Outline: PO_10 Login with SCM Team Member and Create the PO and do the Force Closure
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (FG)
When User click on the save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
When User create the PO Request for WEB ORDER (FG)
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-FG
Scenario Outline: PO_11 Login With SCM Team Member and Provide the Pre-Approval and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-FG
Scenario Outline: PO_12 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (FG)
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-FG
Scenario Outline: PO_13 Login With SCM Team Member and Provide the Pre-Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-FG
Scenario Outline: PO_14 Login with Operations Head and Provide the Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@WEBORDER-FG
Scenario Outline: PO_15 Login With SCM Team Member and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#Amendment Flow

@WEBORDER-FG
Scenario Outline: PO_16 Login with SCM Team Member and Modify the Unimportant Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Unimportant changes (FG)
When User click on the save button
Then User verifies the Issued PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-FG
Scenario Outline: PO_17 Login with SCM Team Member and Modify the Required Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Required changes (FG)
When User click on the save button
Then User verifies the PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-FG
Scenario Outline: PO_18 Login With SCM Team Member and Provide the Pre-Approval for Amended PO
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User select the Amended PO from the filter
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-FG
Scenario Outline: PO_19 Login with Operations Head and Provide the Final-Approval for Amended PO
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User select the Pre-Approved PO from the filter
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@WEBORDER-FG
Scenario Outline: PO_20 Login with SCM Team Member and Issue the Amended PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Final-Approved PO from the filter
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status by filter and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

## PO CREATION AGAINST WEB ORDER (NPM) ##

@WEBORDER-NPM
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (NPM)
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-NPM
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
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-NPM
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
|salimjaved@e-consystems.com|Salim123|

@WEBORDER-NPM
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#To Be Revised and Rejection Flow

@WEBORDER-NPM
Scenario Outline: PO_05 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (NPM)
Then User click on the Save button and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-NPM
Scenario Outline: PO_06 Login with SCM Team Head and Provide To-Be Revised
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing To-Be Revised
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-NPM
Scenario Outline: PO_07 Login with SCM Team Member and Modify the PO with Necessary Changes
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Edit button
And User made the changes accordingly
Then User click the Save and Signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-NPM
Scenario Outline: PO_08 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approved
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-NPM
Scenario Outline: PO_09 Login with Operations Head and Provide Final-Approval Reject
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval Reject
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

#Force Closure Flow

@WEBORDER-NPM
Scenario Outline: PO_10 Login with SCM Team Member and Create the PO and do the Force Closure
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (NPM)
When User click on the save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
When User create the PO Request for WEB ORDER (NPM)
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-NPM
Scenario Outline: PO_11 Login With SCM Team Member and Provide the Pre-Approval and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-NPM
Scenario Outline: PO_12 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for WEB ORDER (NPM)
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-NPM
Scenario Outline: PO_13 Login With SCM Team Member and Provide the Pre-Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-NPM
Scenario Outline: PO_14 Login with Operations Head and Provide the Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@WEBORDER-NPM
Scenario Outline: PO_15 Login With SCM Team Member and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#Amendment Flow

@WEBORDER-NPM
Scenario Outline: PO_16 Login with SCM Team Member and Modify the Unimportant Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Unimportant changes (NPM)
When User click on the save button
Then User verifies the Issued PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-NPM
Scenario Outline: PO_17 Login with SCM Team Member and Modify the Required Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Required changes (NPM)
When User click on the save button
Then User verifies the PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-NPM
Scenario Outline: PO_18 Login With SCM Team Member and Provide the Pre-Approval for Amended PO
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User select the Amended PO from the filter
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@WEBORDER-NPM
Scenario Outline: PO_19 Login with Operations Head and Provide the Final-Approval for Amended PO
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User select the Pre-Approved PO from the filter
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@WEBORDER-NPM
Scenario Outline: PO_20 Login with SCM Team Member and Issue the Amended PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Final-Approved PO from the filter
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status by filter and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

									#**********************************************************************************#

## PO CREATION AGAINST TESTING & SERVICES ##

@TESTING-SERVICES
Scenario Outline: PO_01 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for Testing and Services
When User click on the save button
When User click on the Issue icon
When User click on the Download and Cancel button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@TESTING-SERVICES
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
|n.sivapradeep@e-consystems.com|Sivap123|

@TESTING-SERVICES
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
|salimjaved@e-consystems.com|Salim123|

@TESTING-SERVICES
Scenario Outline: PO_04 Login with SCM Team Member and Issue the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status has been changed to Issued and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#To Be Revised and Rejection Flow

@TESTING-SERVICES
Scenario Outline: PO_05 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for Testing and Services
Then User click on the Save button and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@TESTING-SERVICES
Scenario Outline: PO_06 Login with SCM Team Head and Provide To-Be Revised
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing To-Be Revised
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@TESTING-SERVICES
Scenario Outline: PO_07 Login with SCM Team Member and Modify the PO with Necessary Changes
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User click on the Edit button
And User made the changes accordingly
Then User click the Save and Signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@TESTING-SERVICES
Scenario Outline: PO_08 Login with SCM Team Head and Provide Pre Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approved
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@TESTING-SERVICES
Scenario Outline: PO_09 Login with Operations Head and Provide Final-Approval Reject
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval Reject
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

#Force Closure Flow

@TESTING-SERVICES
Scenario Outline: PO_10 Login with SCM Team Member and Create the PO and do the Force Closure
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for Testing and Services
When User click on the save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
When User create the PO Request for Testing and Services
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@TESTING-SERVICES
Scenario Outline: PO_11 Login With SCM Team Member and Provide the Pre-Approval and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@TESTING-SERVICES
Scenario Outline: PO_12 Login with SCM Team Member and Create the PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
When User create the PO Request for Testing and Services
When User click on the save button
Then User click on the signout button

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@TESTING-SERVICES
Scenario Outline: PO_13 Login With SCM Team Member and Provide the Pre-Approval
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@TESTING-SERVICES
Scenario Outline: PO_14 Login with Operations Head and Provide the Final-Approval
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@TESTING-SERVICES
Scenario Outline: PO_15 Login With SCM Team Member and do the Force Closure
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User click on the Edit button
And User click on the Force Closure
When User click on the save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

#Amendment Flow

@TESTING-SERVICES
Scenario Outline: PO_16 Login with SCM Team Member and Modify the Unimportant Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Unimportant changes for Testing and Services
When User click on the save button
Then User verifies the Issued PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@TESTING-SERVICES
Scenario Outline: PO_17 Login with SCM Team Member and Modify the Required Changes in Issued PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Issued PO from the filter
And User click the Edit button and do the Required changes for Testing and Services
When User click on the save button
Then User verifies the PO Status by filter and Signout

Examples:
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@TESTING-SERVICES
Scenario Outline: PO_18 Login With SCM Team Member and Provide the Pre-Approval for Amended PO
Given User on the login page
And User enters the SCM Team Head "<username>" and "<password>"
And User select the Amended PO from the filter
And User click on the Edit button
And User verify the PO and providing Pre-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|

@TESTING-SERVICES
Scenario Outline: PO_19 Login with Operations Head and Provide the Final-Approval for Amended PO
Given User on the login page
And User enters the Operations Head "<username>" and "<password>"
And User select the Pre-Approved PO from the filter
And User click on the Edit button
And User verify the PO and providing Final-Approval
When User click on the Save button
Then User verifies the PO Status has been changed and Signout

Examples: 
|username|password|
|salimjaved@e-consystems.com|Salim123|

@TESTING-SERVICES
Scenario Outline: PO_20 Login with SCM Team Member and Issue the Amended PO
Given User on the login page
And User enters the SCM Team Member "<username>" and "<password>"
And User select the Final-Approved PO from the filter
And User click on the Issue icon
When User click on the Issue button
Then User verifies the PO Status by filter and Signout

Examples: 
|username|password|
|n.sivapradeep@e-consystems.com|Sivap123|