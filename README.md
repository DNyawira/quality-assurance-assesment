# quality-assurance-assesment

This is a test automation framework that utilizes Cucumber, Java, and Selenium WebDriver to perform regression testing on web applications. 
The framework is designed to be easy to use, maintainable, and scalable.

**Prerequisites**

* Java 8 or higher

* Maven

* Selenium WebDriver

* Cucumber

**Installation**

* Clone the Project to your local machine:  https://github.com/DNyawira/quality-assurance-assesment.git

**Project Structure**

* `src/main/java/factory`: Contains the Web Driver Manager
* `src/main/java/pages`: Contains Page Elements
* `src/main/java/utils`: Contains util Classes
* `src/test/java/apphooks`: Contains Hooks
* `src/test/java/config`: Contains config properties file
* `src/test/java/stepdefinition`: Contains step definitions
* `src/test/java/testrunner`: Contains test runners
* `src/test/resources/features`: Contains feature files

**Running the Tests**
* Open `src/test/resources/features/common`: Pick one tag (e.g.) @Tests => To execute All the scenarios
* Open `src/test/java/testrunner/TestRunner.java`: Paste the Copied tag on the **tags** option make sure you have the **@** symbol.
* Run TestRunner.java

**Results & Reporting**
* Check the terminal and we shall have the test results and a cucumber report.
* We shall implement Extent Reports / Allure Reports we are currently using the cucumber reporting style.

