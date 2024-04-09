package pages;

import io.qameta.allure.Step;
import main.MainTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    public Account clickDepositButton() {
        MainTest.wait.until(ExpectedConditions.elementToBeClickable(depositButton)).click();
        return this;
    }

    @Step("Enter deposit amount in the field")
    public Account enterDepositAmount(int amount) {
        MainTest.wait.until(ExpectedConditions.elementToBeClickable(depositAmountField)).sendKeys(String.valueOf(amount));
        return this;
    }

    @Step("Confirm deposit")
    public Account confirmDeposit() {
        MainTest.wait.until(ExpectedConditions.elementToBeClickable(depositConfirmButton)).click();
        return this;
    }

    @Step("Click on 'Withdraw' button")
    public Account clickWithdrawButton() {
        MainTest.wait.until(ExpectedConditions.elementToBeClickable(withdrawButton)).click();
        return this;
    }

    @Step("Enter withdrawal amount in the field")
    public Account enterWithdrawAmount(int amount) {
        MainTest.wait.until(ExpectedConditions.elementToBeClickable(withdrawAmountField)).sendKeys(String.valueOf(amount));
        return this;
    }

    @Step("Confirm withdrawal")
    public Account confirmWithdrawal() {
        MainTest.wait.until(ExpectedConditions.elementToBeClickable(withdrawConfirmButton)).click();
        return this;
    }

    @Step("Check user balance")
    public Account checkBalance(String expectedBalance) {
        String actualBalance = balanceIndicator.getText();
        assertEquals(actualBalance, expectedBalance);
        return this;
    }

    @Step("Click on 'Transactions' button")
    public void clickTransactionsButton() {
        MainTest.wait.until(ExpectedConditions.elementToBeClickable(transactionsButton)).click();
    }
}
