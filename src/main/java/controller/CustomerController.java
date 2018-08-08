package main.java.controller;

import java.util.Deque;

import main.java.model.CallCenter;
import main.java.model.Customer;
import main.java.model.Employee;

/**
 * This class provides the functionality to manipulate customers in the model.
 * 
 * @author Jorge
 *
 */
public class CustomerController {

	private CallCenter<Employee> callCenter;
	private Deque<Customer> customers;

	public CustomerController(CallCenter<Employee> cc) {
		callCenter = cc;
		customers = callCenter.getAllCustomersQueued();
	}

	public Deque<Customer> getCustomers() {
		return customers;
	}

	/**
	 * gets and removes the head of the collection
	 * 
	 * @return
	 */
	public Customer getNextCustomer() {
		return customers.poll();
	}

	/**
	 * inserts the customer at the beginning of the collection (head) this
	 * method is used to model the case when there are not available employees
	 * to take the call
	 * 
	 * @param c
	 */
	public void addNextCustomer(Customer c) {
		customers.offerFirst(c);
	}

}
