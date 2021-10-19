package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.application.entities.Account;
import com.sun.net.httpserver.Authenticator.Result;

import tests.factory.AccountFactory;

public class AccountTests {

	/*
	 * ARRANGE Instanciar os objetos necessários
	 */

	/*
	 * ACTION Executar as ações necessárias
	 */

	/*
	 * ASSERT Resultado esperado
	 */

	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		// ARRANGE
		double amount = 200.0;
		double expectedValue = 196.0;
		Account account = AccountFactory.createEmptyAccount();

		// ACTION
		account.deposit(amount);

		// ASSERT
		Assertions.assertEquals(expectedValue, account.getBalance());
	}

	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		// ARRANGE
		double expectedValue = 100.0;
		Account account = new Account(1L, expectedValue);
		double amount = -200.0;

		// ACTION
		account.deposit(amount);

		// ASSERT
		Assertions.assertEquals(expectedValue, account.getBalance());
	}

	@Test
	public void fullWithdrawShouldClearBalance() {
		// ARRANGE
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account account = AccountFactory.createAccount(initialBalance);

		// ACTION
		double result = account.fullWithdraw();

		// ASSERT
		Assertions.assertTrue(expectedValue == account.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}

	@Test
	public void withdrawDecreaseBalanceWhenSufficientBalance() {
		// ARRANGE
		Account account = AccountFactory.createAccount(800.0);

		// ACTION
		account.withdraw(500.0);

		// ASSERT
		Assertions.assertEquals(300.0, account.getBalance());
	}

	@Test
	public void withdrawShouldThrowExceptionWhenSufficientBalance() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account account = AccountFactory.createAccount(800.0);
			account.withdraw(801.0);
		});
	}
}
