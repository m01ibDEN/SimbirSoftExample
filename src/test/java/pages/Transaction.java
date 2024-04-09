package pages;

import com.opencsv.CSVWriter;
import main.MainTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DateTimeHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    protected final WebDriver driver;
    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    private WebElement timeCredit;

    @FindBy(xpath = "//tbody/tr[2]/td[1]")
    private WebElement timeDebit;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    private WebElement amountCredit;

    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    private WebElement amountDebit;

    @FindBy(xpath = "//tbody/tr[1]/td[3]")
    private WebElement typeCredit;

    @FindBy(xpath = "//tbody/tr[2]/td[3]")
    private WebElement typeDebit;

    public Transaction(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTimeCredit() {
        return MainTest.wait.until(ExpectedConditions.visibilityOf(timeCredit)).getText();
    }

    public String getTimeDebit() {
        return MainTest.wait.until(ExpectedConditions.visibilityOf(timeDebit)).getText();
    }

    public String getAmountCredit() {
        return MainTest.wait.until(ExpectedConditions.visibilityOf(amountCredit)).getText();
    }

    public String getAmountDebit() {
        return MainTest.wait.until(ExpectedConditions.visibilityOf(amountDebit)).getText();
    }

    public String getTypeCredit() {
        return MainTest.wait.until(ExpectedConditions.visibilityOf(typeCredit)).getText();
    }

    public String getTypeDebit() {
        return MainTest.wait.until(ExpectedConditions.visibilityOf(typeDebit)).getText();
    }

    public List<String> getTransactionsList() {
        LocalDateTime creditDate = DateTimeHelper.parseDateTime(getTimeCredit());
        LocalDateTime debitDate = DateTimeHelper.parseDateTime(getTimeDebit());

        String formattedFirstDate = DateTimeHelper.formatDateTime(creditDate, "d MMM yyyy h:mm:ss a");
        String formattedLastDate = DateTimeHelper.formatDateTime(debitDate, "d MMM yyyy h:mm:ss a");

        String amountFirst = getAmountCredit();
        String amountSecond = getAmountDebit();
        String typeFirst = getTypeCredit();
        String typeSecond = getTypeDebit();

        List<String> dateList = new ArrayList<>();
        dateList.add(formattedFirstDate + " " + amountFirst + " " + typeFirst);
        dateList.add(formattedLastDate + " " + amountSecond + " " + typeSecond);

        return dateList;
    }

    public Transaction saveToFile(List<String> data, String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            for (String line : data) {
                String[] values = line.split(" ");
                writer.writeNext(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Transaction performTransactionActions(String file) {
        List<String> transactionsList = getTransactionsList();
        saveToFile(transactionsList, "src/test/resources/" + file);
        return this;
    }
}
