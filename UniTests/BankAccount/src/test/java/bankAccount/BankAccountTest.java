package bankAccount;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS BankAccount
    private BankAccount bankAccount;

    @Before
    public void setup() {
        this.bankAccount = new BankAccount("test", new BigDecimal(100));
    }

    @Test
    public void getNameShouldWork() {
        Assert.assertEquals("test", this.bankAccount.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameMoreThanThreeSymbolsThrows() {
        new BankAccount("AB", new BigDecimal(100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNamelessThanTwentyFiveSymbolsThrows() {
        new BankAccount("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", new BigDecimal(1203));
    }

    @Test
    public void setNameShouldWork() {
        BankAccount bankAccount = new BankAccount("Pesho", new BigDecimal(10));
        Assert.assertEquals("Pesho", bankAccount.getName());
    }

    @Test
    public void getBalanceShouldWork() {
        Assert.assertEquals(new BigDecimal(100), this.bankAccount.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBalanceShouldNotBeNegative() {
        new BankAccount("Asdasd", new BigDecimal(-1));
    }

    @Test
    public void setBalanceShouldWork() {
        BankAccount bank = new BankAccount("adssad", new BigDecimal(3));
        Assert.assertEquals(new BigDecimal(3), bank.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void depositShouldNotBeNegativeThrows() {
        this.bankAccount.deposit(new BigDecimal(-1));
    }

    @Test
    public void depositShouldWork() {
        this.bankAccount.deposit(new BigDecimal(2));
        Assert.assertEquals(new BigDecimal(102), this.bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawShouldNotBeNegativeThrows() {
        this.bankAccount.withdraw(new BigDecimal(-1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawShouldBeInRangeOfAccountMoney() {
        this.bankAccount.withdraw(new BigDecimal(101023));
    }

    @Test
    public void withdrawShouldSetBalanceCorrectly() {
        this.bankAccount.withdraw(new BigDecimal(1));
        Assert.assertEquals(new BigDecimal(99), this.bankAccount.getBalance());
    }

    @Test
    public void withdrawShouldWork() {
        Assert.assertEquals(new BigDecimal(5), this.bankAccount.withdraw(new BigDecimal(5)));
    }
}