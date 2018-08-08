package test.java;

import org.junit.Before;
import org.junit.Test;

import main.java.controller.MainController;
import main.java.model.CallCenter;
import main.java.model.Customer;
import main.java.model.Employee;

/**
 * Main test case that runs 10 calls with a MainController.
 * 
 * @author Jorge
 *
 * @param <E>
 */
public class CallCenterTest<E> {
	private MainController<Employee> mainController;

	@Before
	public void setUp() throws Exception {
		// create employees
		Employee sp1 = new Employee("Blanca", "supervisor");
		Employee sp2 = new Employee("Francisco", "supervisor");
		Employee dir1 = new Employee("Fredy", "director");
		Employee op1 = new Employee("Jose", "operador");
		Employee op2 = new Employee("Pedro", "operador");
		Employee op3 = new Employee("Daniela", "operador");
		Employee op4 = new Employee("Julian", "operador");
		Employee op5 = new Employee("Ricardo", "operador");
		Employee op6 = new Employee("Victoria", "operador");
		Employee op7 = new Employee("Carolina", "operador");
		Employee op8 = new Employee("Dana", "operador");
		Employee op9 = new Employee("Mateo", "operador");
		// create a callcenter and add employees
		CallCenter<Employee> callCenter = new CallCenter<Employee>();
		callCenter.addEmployeeToShift(sp1);
		callCenter.addEmployeeToShift(sp2);
		callCenter.addEmployeeToShift(dir1);
		callCenter.addEmployeeToShift(op1);
		callCenter.addEmployeeToShift(op2);
		callCenter.addEmployeeToShift(op3);
		callCenter.addEmployeeToShift(op4);
		callCenter.addEmployeeToShift(op5);
		callCenter.addEmployeeToShift(op6);
		callCenter.addEmployeeToShift(op7);
		callCenter.addEmployeeToShift(op8);
		callCenter.addEmployeeToShift(op9);
		// create customers
		Customer c1 = new Customer("Nataly");
		Customer c2 = new Customer("Bruce");
		Customer c3 = new Customer("Armando");
		Customer c4 = new Customer("Cesar");
		Customer c5 = new Customer("Patricia");
		Customer c6 = new Customer("Juliana");
		Customer c7 = new Customer("Antonio");
		Customer c8 = new Customer("Daniel");
		Customer c9 = new Customer("Pablo");
		Customer c10 = new Customer("Jair");
		// add customers to call center
		callCenter.addCustomer(c1);
		callCenter.addCustomer(c2);
		callCenter.addCustomer(c3);
		callCenter.addCustomer(c4);
		callCenter.addCustomer(c5);
		callCenter.addCustomer(c6);
		callCenter.addCustomer(c7);
		callCenter.addCustomer(c8);
		callCenter.addCustomer(c9);
		callCenter.addCustomer(c10);
		// create a main controller
		mainController = new MainController<>(callCenter);
	}

	@Test
	public void runTenCalls() throws InterruptedException {
		mainController.runCallCenter();
	}

}
