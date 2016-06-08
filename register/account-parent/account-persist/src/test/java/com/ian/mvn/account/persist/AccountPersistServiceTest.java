package com.ian.mvn.account.persist;

import static org.junit.Assert.*;

import java.io.File;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountPersistServiceTest{

	private AccountPersistService service;

	@Before
	public void prepare() throws Exception{

		File persistDataFile = new File("target/test-classes/persist-data.xml");

		if (persistDataFile.exists()) {
			persistDataFile.delete();
		}

		ApplicationContext ctx = new ClassPathXmlApplicationContext("account-persist.xml");

		service = (AccountPersistService)ctx.getBean("accountPersistService");

		Account account = new Account();
		account.setId("ian");
		account.setName("Ian Zheng");
		account.setEmail("ian.zheng@sap.com");
		account.setPassword("1234567");
		account.setActivated(true);

		service.createAccount(account);
	}

	@Test
	public void testReadAccount() throws Exception{

		Account account = service.readAccount("ian");

		assertNotNull(account);
		assertEquals("ian", account.getId());
		assertEquals("Ian Zheng", account.getName());
		assertEquals("ian.zheng@sap.com", account.getEmail());
		assertEquals("1234567", account.getPassword());
		assertTrue(account.getActivated());

	}
}