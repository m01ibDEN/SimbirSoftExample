package pages;

import io.qameta.allure.Step;
import main.MainTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Customer {
    protected final WebDriver driver;

    @FindBy(id = "userSelect")
    private WebElement userList;

    @FindBy(css = "#userSelect > option:nth-child(2)")
    private WebElement selectGranger;

    @FindBy(css = "#userSelect > option:nth-child(3)")
    private WebElement selectPotter;

    @FindBy(css = "#userSelect > option:nth-child(4)")
    private WebElement selectWesley;

    @FindBy(css = "#userSelect > option:nth-child(5)")
    private WebElement selectDumbledore;

    @FindBy(css = "#userSelect > option:nth-child(6)")
    private WebElement selectLongbottom;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    public Customer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click on 'Your Name' dropdown to open the list of users")
    public Customer openUserList() {
        MainTest.wait.until(ExpectedConditions.elementToBeClickable(userList)).click();
        return this;
    }

    @Step("Select user from the list")
    public Customer selectUser(String name) {
        switch (name) {
            case "Granger":
                MainTest.wait.until(ExpectedConditions.elementToBeClickable(selectGranger)).click();
                break;
            case "Potter":
                MainTest.wait.until(ExpectedConditions.elementToBeClickable(selectPotter)).click();
                break;
            case "Wesley":
                MainTest.wait.until(ExpectedConditions.elementToBeClickable(selectWesley)).click();
                break;
            case "Dumbledore":
                MainTest.wait.until(ExpectedConditions.elementToBeClickable(selectDumbledore)).click();
                break;
            case "Longbottom":
                MainTest.wait.until(ExpectedConditions.elementToBeClickable(selectLongbottom)).click();
                break;
        }

        return this;
    }

    @Step("Click on 'Login' button to log in")
    public Customer clickLoginButton() {
        MainTest.wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return this;
    }
}
