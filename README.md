# automationexercise_ui_test Task - Hybrid (BDD and DDT) Framework With Cucumber

### Codes And Tests Prepared By :
Fatih Tosun

QA Automation Engineer

Github name: FTosun21

email: fatihtosun.qa@gmail.com
___
### Getting Started
To get start with this framework, you will need to have the following software on your system.

• Java 8 or later \
• Maven 4.7 or later \
• For download step Chrome should be used
1. Open terminal or command prompt and navigate to the root directory of the project.
2. Run the following command to download the required dependencies:
    #### mvn clean install
3. Run the following command to run the tests:
    #### mvn verify
4. Open the project with Intellij IDEA
   - Go to Runner Class inside the project
   - Click Run button
   #### Run With Runner Class
   - Go to Runner Class 
   - Add a tag name
   - Click the "Run" Button
___
### Task
Go to  https://automationexercise.com/test_cases \
Choose one of the test cases from 12, 16 or 24 \
Use Selenium and Python/Java to create a test framework 

### What I did?
I chose Test Case 24: Download Invoice after purchase order.\
The test case consists of 25 steps.\
I configured Chrome for the "Download Invoice" step. Other browsers are available in the driver class, but they cannot be used for the download invoice step.\
The test scenario was done in e2e format.

___
### My framework is a Cucumber and Hybrid Framework which contains BDD and DDT Frameworks.
• I built my framework by using Java Programming Language.\
• I used maven as a build automation tool for this framework.\
• I used Selenium (4.23.0), Cucumber and Junit to orchestrate my tests, and put the dependencies inside pom.xml file.\
• For assertions/verifications, I utilized JUnit assertions to compare expected and actual results.\
• I created a properties file to store related data such as browser, url, credential and some info.\
• I used Page Object Model Design Pattern to enhance test maintenance and reducing code duplication. This is one of the most famous Selenium approaches.\
• Inside pages package; I used Page Classes to store and identify the elements that I worked on.\
• I used the PageFactory class and initElements method to initialize them.\
• In my tests, I obtained the necessary data randomly or by creating an array and used them in methods.\
• Inside runners package; in the Runner class, I used glues to connect feature files to step definitions.\
• I added the report plugin to Runner to generate Json and HTML reports.\
• I also used tags for tests that I want to run in bulk.\
• stepDefinitions package is the place where my actual test scripts are.\
• Inside stepDefinitions package I used Hooks class as pre-and post-test implementations.\
• I added a screenshot interface in After method in Hooks class; when the scenario fails, it takes a screenshot.\
• I defined the steps of  scenario e2e test.\
• Inside utilities package, utility classes such as BrowserUtils, Driver, and ConfigurationReader were stored.\
• I used the Singleton Design Pattern in Driver class by declaring constructor of class as private, so that no one instantiates class outside of it. \
• And declared a static method with return type as object of class which should check if class is already instantiated once.\
• Inside features directory, which is under resources directory, I created TC24_DownloadInvoiceAfterPurchaseOrder.feature .\
• In this feature file I used Cucumber and Gherkin language for non-technical people to understand what is going on in testing.\
• By this way I implemented BDD (Behavior Driven Development). \
• If needed, I can store my feature files separately in the features directory, and it helps the re-usability of the codes.\
• My framework is easy to maintain since I have elements and methods stored in one centralized place. \
• If any changes happen on the application about the elements, I know where to go and how to fix it to run test scripts correctly.
