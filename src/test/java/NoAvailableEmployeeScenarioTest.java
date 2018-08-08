package test.java;

import org.junit.Before;
import org.junit.Test;

import main.java.controller.MainController;
import main.java.model.CallCenter;
import main.java.model.Customer;
import main.java.model.Employee;

/**
 * Main test case that runs 7 calls with a MainController and only two available
 * employees to take calls. Tests the no available employee scenario.
 * 
 * @author Jorge
 *
 * @param <E>
 */
public class NoAvailableEmployeeScenarioTest<E> {
	private MainController<Employee> mainController;

	@Before
	public void setUp() throws Exception {
		// create employees
		Employee sp1 = new Employee("Blanca", "supervisor");
		Employee op1 = new Employee("Daniela", "operador");
		// create a callcenter and add employees
		CallCenter<Employee> callCenter = new CallCenter<Employee>();
		callCenter.addEmployeeToShift(op1);
		callCenter.addEmployeeToShift(sp1);
		// create customers
		Customer c1 = new Customer("Nataly");
		Customer c2 = new Customer("Bruce");
		Customer c3 = new Customer("Armando");
		Customer c4 = new Customer("Cesar");
		Customer c5 = new Customer("Patricia");
		Customer c6 = new Customer("Juliana");
		Customer c7 = new Customer("Antonio");
		// add customers to call center
		callCenter.addCustomer(c1);
		callCenter.addCustomer(c2);
		callCenter.addCustomer(c3);
		callCenter.addCustomer(c4);
		callCenter.addCustomer(c5);
		callCenter.addCustomer(c6);
		callCenter.addCustomer(c7);
		// create a main controller
		mainController = new MainController<>(callCenter);
	}

	/**
	 * Wait is required so the only 2 available employees are able to attend the
	 * 7 customer calls defined.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void runCalls() throws InterruptedException {
		mainController.runCallCenter();
		mainController.getDispatcher().terminateDispatch();
	}

}
