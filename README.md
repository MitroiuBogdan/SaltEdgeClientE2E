Headers allHeaders = response.getHeaders();
// Get a single header value:
String headerName = response.getHeader("headerName");

// Get all cookies as simple name-value pairs
Map<String, String> allCookies = response.getCookies();
// Get a single cookie value:
String cookieValue = response.getCookie("cookieName");

// Get status line
String statusLine = response.getStatusLine();
// Get status code
int statusCode = response.getStatusCode();


Feature
• Background
• Scenario
• Given
• When
• Then
• And
• But
• *
• Scenario Outline
• Examples

Feature: Delete Widgets
Background:
Given I am logged in as an administrator
...
An alternative is to tag the feature and then use a @Before hook to run this
same code to log in as an administrator.
@admin
Feature: Delete Widgets
...
@Before("@admin")
public void logInAsAdmin() {
//