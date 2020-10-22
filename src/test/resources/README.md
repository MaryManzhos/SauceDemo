mvn versions:use-latest-versions
[INFO] --- versions-maven-plugin:2.8.1:use-latest-versions (default-cli) @ SauceDemo ---
[INFO] Major version changes allowed
[INFO] Updated org.testng:testng:jar:7.1.0 to version 7.3.0
[INFO] Updated org.seleniumhq.selenium:selenium-java:jar:3.141.59 to version 4.0.0-alpha-6
================================================================

mvn clean test
[INFO] Tests run: 21, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 40.276 s - in TestSuite
[INFO] Results:
[INFO] Tests run: 21, Failures: 0, Errors: 0, Skipped: 0
================================================================

mvn clean test -Dtest=LoginTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.873 s - in tests.LoginTest
[INFO] Results:
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
================================================================

mvn clean test -Dtest=LoginTest,ProductsTest
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 8.699 s - in TestSuite
[INFO] Results:
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
================================================================

mvn clean test -Dtest=CheckoutInformationTest#isSuccessfulCheckoutInformation
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.934 s - in tests.CheckoutInformationTest
[INFO] Results:
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
================================================================

mvn clean test -Dtest=CheckoutInformationTest#isSuccessfulCheckoutInformation+isCanceledToCheckoutInformation,LoginTest#isSuccessfulAuthorization
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 7.13 s - in TestSuite
[INFO] Results:
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
================================================================

mvn clean test -DsuiteXmlFile=src/test/resources/smoketest.xml
[INFO] Tests run: 21, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 21.206 s - in TestSuite
[INFO] Results:
[INFO] Tests run: 21, Failures: 0, Errors: 0, Skipped: 0
================================================================

mvn clean test -Dtest=LoginTest#isSuccessfulAuthorization -Dpassword=secret_sauce
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.617 s - in tests.LoginTest
[INFO] Results:
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
================================================================

