Feature: MPN Automation

## MPN Creation Flow ##

@MPN
Scenario Outline: PO_01 Login with Sustanance Team Member and Create the MPN
Given User on the login page
And User enters the Sustanance Team Member "<username>" and "<password>"
When User create the MPN Request and Save
When User Enter the Search By With MPN
Then User verifies the MPN Status and Signout

Examples: 
|username|password|
|compengg@e-consystems.com|Compengg123|