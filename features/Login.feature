Feature: Login feature

Background: User is Logged In
 	Given open the browser
	Then enter the url
	

Scenario: testing the login with valid credentials

	And  enter the valid emailid and password
	When i click on login button
	Then user should logged to Admin dashboard page 
	
Scenario: testing the login with invalid credentials
	And  enter the invalid emailid and password
	When i click on login button
	Then user shouldnot  logged into Admin dashboard page 

