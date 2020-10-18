Feature: Homepage navigation

Scenario Outline: Navigate Guide links
Given I initialize the browser with chrome
And I navigate to <url>
And I accept the cookie policy
When I click on the <linkName> link
Then The <pageTitle> page title should be correct

Examples:
|url|linkName|pageTitle|
|https://fourwheelscout.com|Ultimate Guides|Ultimate Guides|