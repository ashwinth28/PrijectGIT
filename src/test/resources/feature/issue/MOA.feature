Feature: MOA Sanity Automation

@MOA-FullyRequest
Scenario Outline: TC_01 Login with PM Team and Create the MOA Request for MOA
Given User on the login page for MOA
And User enters the PM Team Member "<username>" and "<password>" for MOA
When User create the MOA Request for MOA
When User click on the Save button for MOA
When User select the MOA Requested status from the filter for MOA
Then User click on the signout button for MOA

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@MOA-Fullyallocation
Scenario Outline: TC_02 Login with Store Team and Allocate the MOA Request
Given User on the login page for MOA
And User enters the Store Team Member "<username>" and "<password>" for MOA
When User select the MOA Requested status from the filter for MOA
When User click on the edit icon for MOA
When User Should be Allocate the Entry for MOA
When User click on the Save button for MOA
Then User click on the signout button for MOA

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MOA-Req_for_allocation
Scenario Outline: TC_01 Login with PM Team and Open the Allocated Request
Given User on the login page for MOA
And User enters the PM Team Member "<username>" and "<password>" for MOA
When User select the MOA Allocated status from the filter for Realloc the for MOA
When User click on the edit icon for MOA
When User enter the Release Qty for MOA
When User click on the Save button for MOA
When User select the MOA Req for Reallocation status from the filter for MOA
Then User click on the signout button for MOA

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@MOA-Req_for_allocation
Scenario Outline: TC_02 Login with Store Team and Reallocate the Allocated MOA Request
Given User on the login page for MOA
And User enters the Store Team Member "<username>" and "<password>" for MOA
When User select the MOA Req for Reallocation status from the filter for MOA
When User click on the edit icon for MOA
When User click on the Save button for MOA
Then User click on the signout button for MOA

Examples: 
|username|password|
|store@e-consystems.com|Store123|


@MOA-Partially_Request
Scenario Outline: TC_01 Login with PM Team and Create the MOA Partially_Requested
Given User on the login page for MOA
And User enters the PM Team Member "<username>" and "<password>" for MOA
When User create the MOA Partially Request for MOA
When User click on the Save button for MOA
When User select the MOA Partially Requested status from the filter for MOA
Then User click on the signout button for MOA

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@MOA-Partially_Allocation
Scenario Outline: TC_02 Login with Store Team and Allocate the MOA Partially_Requested
Given User on the login page for MOA
And User enters the Store Team Member "<username>" and "<password>" for MOA
When User select the MOA Partially Requested status from the filter for MOA
When User click on the edit icon for MOA
When User should be allocate the Entry
When User click on the Save button for MOA
Then User click on the signout button for MOA

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MOA-Deallocation	
Scenario Outline: TC_01 Login with PM team to create MOA Request and Partially Request to Deallocation.
Given User on the login page for MOA
And User enters the PM Team Member "<username>" and "<password>" for MOA
When User create the MOA Request for MOA
When User click on the Save button for MOA
When User select the MOA Requested status from the filter for MOA
And Click on the Cancel icon for MOA
When Click on the Req for Deallocate button and Click ok on the alert for MOA
When User create the MOA Partially Request for MOA
When User click on the Save button for MOA
When User select the MOA Partially Requested status from the filter for dealloc the for MOA
And Click on the Cancel icon for MOA
When Click on the Req for Deallocate button and Click ok on the alert for MOA
And User select the MOA Dellocated status from the filter for MOA
Then User click on the signout button for MOA
Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|


@MOA-Req_for_Deallocation
Scenario Outline: TC_01 Login with PM Team and create a MOA Request for Req for Deallocation
Given User on the login page for MOA
And User enters the PM Team Member "<username>" and "<password>" for MOA
Given User create the MOA Request for MOA
When User click on the Save button for MOA
Then User click on the signout button for MOA

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|


@MOA-Req_for_Deallocation
Scenario Outline: TC_02 Login with Store Team and Allocate the MOA Request for Req for Deallocation
Given User on the login page for MOA
And User enters the Store Team Member "<username>" and "<password>" for MOA
When User select the MOA Requested status from the filter for MOA
When User click on the edit icon for MOA
When User Should be Allocate the Entry for MOA
When User click on the Save button for MOA
Then User click on the signout button for MOA

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MOA-Req_for_Deallocation
Scenario Outline: TC_03 Login with PM Team and Move the entry to Req for Deallocation
Given User on the login page for MOA
And User enters the PM Team Member "<username>" and "<password>" for MOA
When User select the MOA Allocated status from the filter for dealloc the for MOA
And Click on the Cancel icon for MOA
When Click on the Req for Deallocate button and Click ok on the alert for MOA
Then User click on the signout button for MOA
Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|


@MOA-Req_for_Deallocation
Scenario Outline: TC_04 Login with Store Team and Move from Req for Deallocation to entry to Deallocation
Given User on the login page for MOA
When User enters the Store Team Member "<username>" and "<password>" for MOA
When User select the MOA Req for Deallocation status from the filter for dealloc the for MOA
And Click on the Cancel icon for MOA
When Click on the Req for Deallocate button and Click ok on the alert for MOA
Then User click on the signout button for MOA


Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MOA-Req_for_Deallocation_from_Partially_Allocation_Request
Scenario Outline: TC_01 Login with PM Team and Create the MOA Partially_Request
Given User on the login page for MOA
And User enters the PM Team Member "<username>" and "<password>" for MOA
When User create the MOA Partially Request for MOA
When User click on the Save button for MOA
Then User click on the signout button for MOA

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@MOA-Req_for_Deallocation_from_Partially_Allocation_Request
Scenario Outline: TC_02 Login with Store Team and Allocate the MOA Partially_Request
Given User on the login page for MOA
And User enters the Store Team Member "<username>" and "<password>" for MOA
When User select the MOA Partially Requested status from the filter for MOA
When User click on the edit icon for MOA
When User should be allocate the Entry
When User click on the Save button for MOA
When User select the MOA Partially Allocated status from the filter for the MOA
Then User click on the signout button for MOA

Examples: 
|username|password|
|store@e-consystems.com|Store123|

@MOA-Req_for_Deallocation_from_Partially_Allocation_Request
Scenario Outline: TC_03 Login with PM Team and Move the entry from Partially Allocated to Req for Deallocation
Given User on the login page for MOA
And User enters the PM Team Member "<username>" and "<password>" for MOA
When User select the MOA Partially Allocated status from the filter for the MOA
And Click on the Cancel icon for MOA
When Click on the Req for Deallocate button and Click ok on the alert for MOA
Then User click on the signout button for MOA

Examples: 
|username|password|
|pmhead@e-consystems.com|Pmhead123|

@MOA-Req_for_Deallocation_from_Partially_Allocation_Request
Scenario Outline: TC_04 Login with Store Team and Move from Req for Deallocation to entry to Deallocation
Given User on the login page for MOA
When User enters the Store Team Member "<username>" and "<password>" for MOA
When User select the MOA Req for Deallocation status from the filter for dealloc the for MOA
And Click on the Cancel icon for MOA
When Click on the Req for Deallocate button and Click ok on the alert for MOA
Then User click on the signout button for MOA

Examples: 
|username|password|
|store@e-consystems.com|Store123|