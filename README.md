


# TheRightDoctors-SQL-Injection-Attsck

 **Overview**

THis assessment is a Java program that uses Selenium WebDriver to automate a web browser and test for SQL injection vulnerabilities on the OWASP Juice Shop login page. The program attempts to perform an SQL injection attack by entering a malicious username and a valid password, then checks if an error message is displayed.

**Process**

    -Used Selenium WebDriver to automate the web browser and test for SQL injection.
    -Initialized ChromeDriver and navigation to the OWASP Login Page using Chrome.
    -Locating the username and password by their ID attributes
    -Performing SQL injection Attempt by providing malicious Username and password
    -Provided a delay of 30 seconds for login button to be clickable by Id as well as checking CSS selector
    -It waits for the response and analyses the error occured.

