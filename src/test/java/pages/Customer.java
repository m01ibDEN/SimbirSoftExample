package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customer {
    protected final WebDriver driver;

    @FindBy(id = "userSelect")
    private WebElement userList;

    @FindBy(css = "#userSelect > option:nth-child(3)")
    private WebElement selectPotter;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    public Customer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click on 'Your Name' dropdown to open the list of users")
    public void openUserList() {
        userList.click();
    }

    @Step("Select 'Harry Potter' user from the list")
    public void selectPotterUser() {
        selectPotter.click();
    }

    @Step("Click on 'Login' button to log in")
    public void clickLoginButton() {
        loginButton.click();
    }
}
