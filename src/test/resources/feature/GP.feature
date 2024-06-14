Feature: Gross Profit Module Automation

Scenario Outline: 01_Validate the Gross Profit Module
Given User create the Data Base Instance
When User validate the Database data with UI Data
When User read the excel sheet
When User compare the GP Data

Examples: 
|username|password|
|sai@e-consystems.com|Saikrishnan123|