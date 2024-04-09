package main;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Account;
import pages.Customer;
import pages.Login;
import pages.Transaction;
import utils.Arithmetic;

@DisplayName("Testing XYZ Bank Transactions")
public class TransactionTest extends MainTest {
    @Test
    @Description("Testing transactions for XYZ Bank user with deposit and withdrawal")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "Xyz Bank", url = BaseUrl)
    @Issue("USER-XYZ")
    public void transactionsUserTest() {
        Account accountPage = new Account(driver);
        Customer customerPage = new Customer(driver);
        Login loginPage = new Login(driver);
        Transaction transactionPage = new Transaction(driver);

        int amount = Arithmetic.fibonacciCalc();

        loginPage.clickCustomerLoginButton();

        customerPage
                .openUserList()
                .selectUser("Potter")
                .clickLoginButton();

        accountPage
                .clickDepositButton()
                .enterDepositAmount(amount)
                .confirmDeposit()
                .clickWithdrawButton()
                .enterWithdrawAmount(amount)
                .confirmWithdrawal()
                .checkBalance("0")
                .clickTransactionsButton();

        Assertions.assertEquals(transactionPage.getAmountCredit(), amount + "");
        Assertions.assertEquals(transactionPage.getAmountDebit(), amount + "");

        transactionPage.performTransactionActions("transactions.csv");

    }
}
