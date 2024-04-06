package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Account {
    protected final WebDriver driver;

    @FindBy(xpath = "//button[@ng-click='deposit()']")
    private WebElement depositButton;

    @FindBy(xpath = "//input[@ng-model='amount']")
    private WebElement depositAmountField;

    @FindBy(xpath = "//button[text()='Deposit']")
    private WebElement depositConfirmButton;

    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    private WebElement withdrawButton;

    @FindBy(xpath = "//label[text()='Amount to be Withdrawn :']/following-sibling::input")
    private WebElement withdrawAmountField;

    @FindBy(xpath = "//button[text()='Withdraw']")
    private WebElement withdrawConfirmButton;

    @FindBy(xpath = "//strong[2]")
    private WebElement balanceIndicator;

    @FindBy(xpath = "//button[@ng-click='transactions()']")
    private WebElement transactionsButton;

    public Account(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click on 'Deposit' button")
    public void clickDepositButton() {
        depositButton.click();
    }

    @Step("Enter deposit amount in the field")
    public void enterDepositAmount(int amount) {
        depositAmountField.sendKeys(String.valueOf(amount));
    }

    @Step("Confirm deposit")
    public void confirmDeposit() {
        new Actions(driver)
                .pause(Duration.ofSeconds(1))
                .click(depositConfirmButton)
                .perform();
    }

    @Step("Click on 'Withdraw' button")
    public void clickWithdrawButton() {
        withdrawButton.click();
    }

    @Step("Enter withdrawal amount in the field")
    public void enterWithdrawAmount(int amount) {
        withdrawAmountField.sendKeys(String.valueOf(amount));
    }

    @Step("Confirm withdrawal")
    public void confirmWithdrawal() {
        new Actions(driver)
                .pause(Duration.ofSeconds(1))
                .click(withdrawConfirmButton)
                .perform();

    }

    @Step("Check user balance")
    public void checkBalance(String expectedBalance) {
        String actualBalance = balanceIndicator.getText();
        assertEquals(actualBalance, expectedBalance);
    }

    @Step("Click on 'Transactions' button")
    public void clickTransactionsButton() {
        new Actions(driver)
                .pause(Duration.ofSeconds(2))
                .click(transactionsButton)
                .perform();

    }
}
