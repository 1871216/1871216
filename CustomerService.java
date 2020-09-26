package service;

import java.util.*;

import model.Customer;

public class CustomerService {

	private Map<String, Customer> customerMap;
	private static final CustomerService instance = new CustomerService();

	public CustomerService() {
		customerMap = new HashMap<String, Customer>();
	}
	
	public static CustomerService getInstance() {
		return instance;
	}


	public void addCustomer(Customer customer) {
		customerMap.put(customer.getId(), customer);
	}

	
	public Customer login(String id, String password) {

		
		if (id == null || password == null)
			return null;
		
		
		if(id.equals(customerMap.get(id).getId()) && 										    password.equals(customerMap.get(id).getPassword()))
			return (customerMap.get(id.toLowerCase()));
		else
			return null;
			
	}

	public Customer findCustomer(String id) {
		return customerMap.get(id.toLowerCase());
	}


}
