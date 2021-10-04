package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.application.entities.Account;

public class AccountTests {

	/*
	 * ARRANGE 
	 * Instanciar os objetos necessários
	*/
	
	/*
	 * ACTION 
	 * Executar as ações necessárias
	*/
	
	/*
	 * ASSERT
	 * Resultado esperado
	*/
	
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		
		double amount = 200.0;
		double expectedValue = 196.0;
		Account account = new Account(1L, 0.0);
		
		account.deposit(amount);
		
		Assertions.assertEquals(expectedValue, account.getBalance());
				
		//ARRANGE 
		
		//ACTION
		
		//ASSERT
	}
}
