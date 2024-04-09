package pages;

import io.qameta.allure.Step;
import main.MainTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login {
    protected final WebDriver driver;

    @FindBy(xpath = "//button[text()='Customer Login']")
    private WebElement customerLoginButton;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click on 'Customer Login' button")
    public Login clickCustomerLoginButton() {
        MainTest.wait.until(ExpectedConditions.elementToBeClickable(customerLoginButton)).click();
        return this;
    }
}
