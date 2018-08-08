package test.java;

import org.junit.Before;
import org.junit.Test;

import main.java.controller.CustomerController;
import main.java.controller.Dispatcher;
import main.java.controller.EmployeeController;
import main.java.model.CallCenter;
import main.java.model.Customer;
import main.java.model.Employee;

public class DispatcherTest<E> {
	Dispatcher<E> d;
	int numberOfCalls;
	Customer c1;
	Employee e1;
	CallCenter<Employee> callCenter;

	@Before
	public void setUp() throws Exception {
		numberOfCalls = 100;
		c1 = new Customer("Cesar");
		e1 = new Employee("Julian", "operador");
                
		callCenter = new CallCenter<Employee>();
		callCenter.addEmployeeToShift(e1);
		d = new Dispatcher<E>(new EmployeeController(callCenter), new CustomerController(callCenter));
	}

	/**
	 * 100 calls are executed, with a call pool size of 10. This test runs all
	 * calls by the same customer and are assigned to the same employee.
	 * 
	 * @throws InterruptedException
	 */

	public void runCalls() throws InterruptedException {
		for (int customerCallId = 1; customerCallId <= numberOfCalls; customerCallId++) {
			d.dispatchCall(customerCallId, c1);
		}
		d.terminateDispatch();
	}

	/**
	 * only one employee available to take calls
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void runOneCall() throws InterruptedException {
		d.dispatchCall(1, c1);
		d.terminateDispatch();
	}

}
