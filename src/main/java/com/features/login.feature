Feature: login test for Offline JBK Application

@run
Scenario Outline: valid login test
Given User enters "file:///D:/software/selenium/Offline%20website/index.html"
When user enter "<uname>" and "<pass>"
And click login button
Then user will be on homepage 

Examples:
|uname|pass|
|kiran@gmail.com|123456|
|mangesh@gmail.com|12451|
|soumya@gmail.com|4567|


Scenario: verify logo test
Then User should see the Logo

Scenario: verify the statelist in users page
When User enter username,password and click on login button
And User click on user sidemenu bar
Then User will check the statelists in userpage