package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.application.entities.Account;

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
}
