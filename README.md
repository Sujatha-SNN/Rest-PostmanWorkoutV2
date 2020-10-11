
# RestWorkout 

Contains API testscripts implemented in Rest Assured framework for scenarios based on SurveyMonkey and PayStack APIs.

## Paystack Scenario :
1. Create payment page on paystack - use oauth2.0 for authorization using the client id and client secret.
2. Get all payments pages and verify the newly created page detail.(using Hamcrest and assertion)
3. Get the newly created payments page and check the details.(Using Hamcrest and assertion)

It is implemented in REST API custom Framework using Chaining in TestNG.

### Packages and Classes :

#### paystack/BaseClass
* Parent class extended by PayStackPayments,GetPage,GetAllPaymentPages
* Loads the PaySatck URL and handles the authentication using OAUTH2.0
####  paystack/PayStackPayments 
* This class creates payment page on paystack - use oauth2.0 for authorization using the client id and client secret.
* Makes a Post call to the endPoint for payment page creation with the body param set as JSON.
* Parse the response to extract the id generated for the payments page created.
* Use Assertion to check the status code for 200(Success Code).
#### paystack/GetAllPaymentPages
* This class gets all payments pages and verify the newly created page detail.(using Hamcrest and assertion)
* Makes a Get call to the endPoint for getAllPaymentsPage with the query params as required.
* Use Assertion and Hamcrest(String Pattern matcher) to check the presence of id generated in the previous step
#### paystack/GetPage 
* This class gets the newly created payments page and check the details.(Using Hamcrest and assertion)
* Makes a Get call to the endPoint to get the payment page creation with the path param as required.
* Use Assertion and Hamcrest(String Pattern matcher) to check the presence of id generated in the previous step

### Above mentioned scenario is also implemented in BDD Framework.

## Packages and Classes:
#### features/paymentpage.feature 
* Feature file Feature and Scenario definitions using Gherkin keywords (Given,When,Then And)
* Background keyword defines the common steps of the scenarios.
#### steps/PaymentPageSteps
* Step Definitions file matching the steps in feature file.
#### runner/Runner
* Runner File which executes the feature defined in paymentpage.feature
* This class extends AbstractTestNGCucumberTests(TestNG class with corresponding annotations to run the feature)
#### hooks/BaseClass
* Defines the common steps defined under Background in feature file.

## SurveyMonkey Scenario:

  1. Create a new survey using Rest API by providing the existing template id / survey id
  2. Create survey page for the newly created survey
  3. Create 2 questions for the newly created page
  4. Replace one of the question with another question using PUT method
  5. Delete the unchanged question from the page

#### Above scenario is implemented in custom made Testng framework with generation of ExtentReports

## Packages and Classes:
* src/tests/rest/PreAndTest
  * Defines the methods with the annotations @BeforeSuite,@BeforeClass,@BeforeMethod,@AfterMethod,@DataProvider and implements abstract method
* tests/rest/RESTAssuredBase 
  * Contains wrappers for the RESTAssured calls.
* lib/utils/DataInputProvider
  * Loads data from Excel in xlxs format
* lib/utils/HTMLReporter
  * Handles the Extent Report generation with a) capturing screenshots of web pages involved / b)Log status of API requests
* tests/rest/TC001_CreateSurveyRequest
  * Contains @BeforeTest method for setting the values for report generation and @Test method with REST Assured steps for creating a survey.
* tests/rest/TC002_CreatePageRequest
  * Contains @BeforeTest method for setting the values for report generation and @Test method with REST Assured steps for creating a page for the survey.
* tests/rest/TC003_CreateQuestionsRequest
  * Contains @BeforeTest method for setting the values for report generation and @Test method with REST Assured steps for creating questions for the survey.
* tests/rest/TC004_ModifyQuestionsRequest
  * Contains @BeforeTest method for setting the values for report generation and @Test method with REST Assured steps for modifying a question based on id in the Survey.
* tests/rest/TC005_DeleteQuestionsRequest
   * Contains @BeforeTest method for setting the values for report generation and @Test method with REST Assured steps for deleting a question based on id in the Survey.

## Miscellaneous Files:

* src/test/resources
	* config.properties
		* Repository of configuration required for REST API calls
* reponseAttributes.properties 
	* Repository for maintaining paramters for chaining to REST API calls
* data
    * Contains json files to be passed to @DataProvider
* reports
    * result.html - ExtentReports generated for the scenarios excecuted
* pom.xml
	* Contains the maven dependencies required for the project and
	* Maven plugin to run as Maven Test
* REST.xml
	* testNG.xml with the testcase classes to executed sequentially
