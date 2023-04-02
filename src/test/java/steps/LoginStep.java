package steps;

import com.yllu.SaltEdgeClientE2E.pages.HomePage;
import com.yllu.SaltEdgeClientE2E.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.List;

@Component
public class LoginStep {

    public final HomePage homePage;
    public final LoginPage loginPage;

    public LoginStep(HomePage homePage, LoginPage loginPage) {
        this.homePage = homePage;
        this.loginPage = loginPage;
    }

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        homePage.ClickLogin();
    }

    @And("I enter the following for Login")
    public void iEnterTheFollowingForLogin(DataTable dataTable) {
        List<String> data = dataTable.asList();
        loginPage.Login(data.get(2), data.get(3));
    }

    @And("I click login button")
    public void iClickLoginButton() {
        loginPage.ClickSubmit();
    }

    @Then("I should see the userform page")
    public void iShouldSeeTheUserformPage() {
        Assert.assertEquals(true, homePage.existEmployeeDetails());
    }

}
