package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utils.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {

    public InventoryPage() {
        WebDriver driver = LocalDriverManager.getInstance();
        PageFactory.initElements(driver, this);
    }

    @Getter
    @FindBy(how = How.CLASS_NAME, className = "inventory_item")
    private List<WebElement> inventoryItems;

    @Getter
    @FindBy(how = How.ID, id = "logout_sidebar_link")
    WebElement logoutButtonCheck;

    @FindBy(how = How.CLASS_NAME, className = "bm-burger-button")
    WebElement burgerButton;

    @FindBy(how = How.ID, id = "logout_sidebar_link")
    WebElement logoutButton;

    public void burgerMenu() {
        burgerButton.click();
    }

    public void logOut() {
        logoutButton.click();
    }
}


