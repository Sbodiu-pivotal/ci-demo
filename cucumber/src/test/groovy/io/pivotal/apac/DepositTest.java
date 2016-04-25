package io.pivotal.apac;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

/**
 * @author Sergiu Bodiu
 */

public class DepositTest {

    private Account account;

    @Given("^a User has no money in their account$")
    public void a_User_has_no_money_in_their_current_account() {
        User user = new User();
        account = new Account();
        user.setAccount(account);

        assertTrue("The balance is not zero.", account.getBalance() == 0L);
    }

    @When("^\\$(\\d+) is deposited in to the account$")
    public void $_is_deposited_in_to_the_account(int amount) {
        account.deposit(amount);
    }

    @Then("^the balance should be \\$(\\d+)$")
    public void the_balance_should_be_$(int expectedBalance) throws Throwable {
        int currentBalance = account.getBalance();
        assertTrue("The expected balance was £100, but actually was: " + currentBalance, currentBalance == expectedBalance);
    }


}
