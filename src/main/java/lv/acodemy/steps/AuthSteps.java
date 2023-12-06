package lv.acodemy.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lv.acodemy.page_object.InventoryPage;
import lv.acodemy.page_object.LoginPage;
import lv.acodemy.utils.LocalDriverManager;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class AuthSteps {

    private final By productsLabel = By.className("product_label");

    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    WebDriverWait wait = new WebDriverWait(LocalDriverManager.getInstance(), Duration.ofSeconds(5));


    @When("user logs in with credentials: {string} and {string}")
    public void logIn(String username, String password) {
        loginPage.authorize(username, password);
    }

    @Then("user is authenticated")
    public void checkIfAuthenticated() {
        wait.until(visibilityOfAllElements(inventoryPage.getInventoryItems()));
        assertThat(inventoryPage.getInventoryItems()).hasSize(6);
    }

    @Then("user sees error message: {string}")
    public void userSeesErrorMessage(String errorMessage) {
        AssertionsForClassTypes.assertThat(loginPage.getErrorMessage().getText()).isEqualTo(errorMessage);
    }

    @Then("user logging out")
    public void userLoggingOut() {
        inventoryPage.burgerMenu();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("logout_sidebar_link")));
//        Assertions.assertThat(inventoryPage.getLogoutButtonCheck()).isEqualTo(By.id("logout_sidebar_link"));
        inventoryPage.logOut();
    }
}
