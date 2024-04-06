package main;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Account;
import pages.Customer;
import pages.Login;
import pages.Transaction;
import utils.Arithmetic;
import utils.CheckResult;

@DisplayName("Testing XYZ Bank Transactions")
public class TransactionTest extends MainTest {
    @Test
    @Description("Testing transactions for XYZ Bank user with deposit and withdrawal")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "Xyz Bank", url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login")
    @Issue("USER-XYZ")
    public void transactionsUserTest() {
        Account accountPage = new Account(driver);
        Customer customerPage = new Customer(driver);
        Login loginPage = new Login(driver);
        CheckResult tableResulComponent = new CheckResult(driver);
        Transaction transactionPage = new Transaction(driver);

        loginPage.clickCustomerLoginButton();
        customerPage.openUserList();
        customerPage.selectPotterUser();
        customerPage.clickLoginButton();
        accountPage.clickDepositButton();
        accountPage.enterDepositAmount(Arithmetic.fibonacciCalc());
        accountPage.confirmDeposit();
        accountPage.clickWithdrawButton();
        accountPage.enterWithdrawAmount(Arithmetic.fibonacciCalc());
        accountPage.confirmWithdrawal();
        accountPage.checkBalance("0");
        accountPage.clickTransactionsButton();

        tableResulComponent.checkTransactions(String.valueOf
                (Arithmetic.fibonacciCalc()), "Credit");
        tableResulComponent.checkTransactions(String.valueOf
                (Arithmetic.fibonacciCalc()), "Debit");

        transactionPage.performTransactionActions("transactions.csv");

    }
}
