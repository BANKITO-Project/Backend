
   
package com.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.model.Customer;
import com.app.model.Transactions;
import com.app.repository.CustomerRepository;
import com.app.repository.TransactionsRepository;
import com.app.service.CustomerCRUDService;
import com.app.service.CustomerSearchService;
import com.app.service.TransactionsService;
@RunWith(SpringRunner.class)
@SpringBootTest
class BankitoApplicationTests {
	@Autowired
	private CustomerSearchService service;
	
	@Autowired
	private CustomerCRUDService crudservice;
	@Autowired
	private TransactionsService tservice;
	
	@MockBean
	private CustomerRepository repository;
	@MockBean
	private TransactionsRepository tnrepository;
	
	@Test
	public void getCustomerTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Customer(100,"riya","soni","riya1@gmail.com","1234","USA",8658,1000, 289), new Customer(101,"Hitesh","Mintoo","Hitesh7@gmail.com","4534","NewZealand",874,2500,900)).collect(Collectors.toList()));
		assertEquals(2,service.getAllCustomers().size());
	}
	
	@Test
	public void getCustomerByAddress() {
		String city="samastipur";
		when(repository.findByCustomerCity(city)).thenReturn(Stream.of(new Customer(100,"riya","soni","riya1@gmail.com","1234","samastipur",8658,1000,32)).collect(Collectors.toList()));
		assertEquals(1,service.getCustomerByCity(city).size());
	}
	@Test
	public void getCustomerByName() {
		String fname="riya";
		when(repository.findByCustomerFirstname(fname)).thenReturn(Stream.of(new Customer(101,"riya","soni","riya1@gmail.com","1234","samastipur",8658,1000,89)).collect(Collectors.toList()));
		assertEquals(1,service.getCustomerByName(fname).size());
	}
	@Test
	public void addCustomerTest() throws Exception {
		Customer customer=new Customer(107,"Vikar","raj","mintoo@gmail.com","76899","lidhiana",8658,5000,900);
		when(repository.save(customer)).thenReturn(customer);
		assertEquals(customer,crudservice.addCustomer(customer));
	}
	@Test
	public void updateCustomerTest(){
		Customer customer=new Customer(107,"riya","soni","kohli@gmail.com","76899","lidhiana",8658,5000,80);
		when(repository.save(customer)).thenReturn(customer);
		assertEquals(customer,crudservice.updateCustomer(customer));
	}
	
	@Test
	public void deleteCustomerTest() {
	Customer c=new Customer();
	c.setCustomerId(100);
	crudservice.deleteCustomer(c.getCustomerId());
	verify(repository,times(1)).deleteById(c.getCustomerId());
	}
	/*@Test
	public void findByCustomerEmailTest() {
		String cemail="riya1@gmail.com";
		when(repository.findByCustomerEmail(cemail)).thenReturn(Stream.of(new Customer(101,"riya","soni","riya1@gmail.com","1234","samastipur",8658L,1000,90)).collect(Collectors.toList()));
		assertEquals(1,crudservice.findByCustomerEmail("riya1@gmail.com").size());
	}*/
	/*@Test
	public void getCustomerByIdTest() {
		int cid=101;
		when(repository.findById(cid)).thenReturn((Customer) Stream.of(new Customer(101,"riya","soni","riya1@gmail.com","1234","samastipur",8658,1000)).collect(Collectors.toList()));
		assertEquals(1, crudservice.getCustomerById(cid)).size());
	}*/
	/*@Test
	public void getBalanceTest() {
		Customer c=new Customer();
		c.setCustomerId(105);
		when(repository.findById(c.getCustomerId()).thenReturn(Stream.of(new Customer(65000)).collect(Collectors.toList()));
		assertEquals(1,service.getBalance(c.getCustomerId()));
	}*/
	
//	@Test
//	public void depositeAmountTest(){
//		Customer c=new Customer();
//		c.setCustomerId(101);
//		Transactions t=new Transactions(145,333,"Deposite","20/11/2021",5000L,"deposited successfully");
//		when(tnrepository.findByCustomerId(c.getCustomerId())).thenReturn(Stream.of(new Transactions(101,123,"Deposite","20/11/2021",5000L,"deposited successfully")).collect(Collectors.toList()));
//		c.setCustomerBalance(2000);
//		c.setCustomerBalance(c.getCustomerBalance()+500);
//		//when(repository.save(c)).thenReturn(c);
//		assertEquals(t,tservice.depositeAmount(c.getCustomerId(),500));
//	}
//	
//	@Test
//	public void withdrawAmountTest() {
//		Customer c=new Customer();
//		c.setCustomerId(101);
//		Transactions t=new Transactions(145,333,"Deposite","20/11/2021",5000L,"deposited successfully");
//		when(tnrepository.findByCustomerId(c.getCustomerId())).thenReturn(Stream.of(new Transactions(101,123,"Deposite","20/11/2021",5000L,"deposited successfully")).collect(Collectors.toList()));
//		c.setCustomerBalance(2000);
//		c.setCustomerBalance(c.getCustomerBalance()-100);
//		//when(repository.save(c)).thenReturn(c);
//		assertEquals(t,tservice.withdrawAmount(c.getCustomerId(),100));
//	}
	@Test
	public void AllTransactionTest() {
		Customer c=new Customer();
		when(tnrepository.findByCustomerId(c.getCustomerId())).thenReturn(Stream.of(new Transactions(101,123,"Deposite","20/11/2021",5000L,"deposited successfully"),
				new Transactions(641,125,"Deposite","28/09/2021",500L,"withdrawn successfully")).collect(Collectors.toList()));
		assertEquals(2,tservice.allTransactions(c.getCustomerId()).size());
	}
//	@Test
//	public void amountTransferTest() {
//		Customer c=new Customer();
//		c.setCustomerId(101);
//		c.setCustomerBalance(c.getCustomerBalance()-120);
//		when(repository.save(c)).thenReturn(c);
//		assertEquals(c,tservice.amountTransfer(c.getCustomerId(),120));
//	}
		
}

