Feature: User Registration
i wanna check if the user can register in the website nopeCommerce

Scenario Outline: User Registration
Given the user at home page
When the user click on register link
And enter the "<firstname>" , "<lastname>" , "<email>", "<password>"
Then the registration is displayed successfully

Examples:
|firstname|lastname|email|password|
|noza|swelam|MsM@gmail.com|123456|