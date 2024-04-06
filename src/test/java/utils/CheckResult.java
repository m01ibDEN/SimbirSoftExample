package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckResult {
    protected WebDriver driver;
    private final By transactionTable = By.cssSelector("table.table tbody tr");
    private final By amountTransaction = By.cssSelector("td:nth-child(2)");
    private final By typeTransaction = By.cssSelector("td:nth-child(3)");

    public CheckResult(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Checking the Amount and Transaction Type in the Transaction Table")

    public void checkTransactions(String amount, String transactionType) {
        List<WebElement> transactions = driver.findElements(transactionTable);

        for (WebElement transaction : transactions) {
            String transactionAmount = transaction.findElement(amountTransaction).getText();
            String transactionTypeValue = transaction.findElement(typeTransaction).getText();

            if (transactionAmount.equals(amount) && transactionTypeValue.equals(transactionType)) {

                return;
            }
        }
        throw new AssertionError("The transaction was not found in the table.");
    }
}
