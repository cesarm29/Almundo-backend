package main.java.controller;

import main.java.model.CallCenter;
import main.java.model.Customer;
import main.java.model.Employee;

/**
 * This is the main controller, that will run all calls. Each call to be run
 * needs a customer and a pool of available employees.
 * 
 * @author Jorge
 *
 * @param <E>
 */
public class MainController<E> {
	private EmployeeController employeeController;
	private CustomerController customerController;
	private Dispatcher<E> dispatcher;
	private CallCenter<Employee> callCenter;

	/**
	 * @param callCenter
	 */
	public MainController(CallCenter<Employee> cc) {
		callCenter = cc;
		employeeController = new EmployeeController(callCenter);
		customerController = new CustomerController(callCenter);
		dispatcher = new Dispatcher<E>(employeeController, customerController);
	}

	/**
	 * Main method to run all calls for the customer and employees defined in
	 * the CallCenter
	 * 
	 * @throws InterruptedException
	 */
	public void runCallCenter() throws InterruptedException {
		int callId = 0;
		Customer tempCustomer = customerController.getNextCustomer();
		while (tempCustomer != null) {
			getDispatcher().dispatchCall(callId, tempCustomer);
			callId++;
			tempCustomer = customerController.getNextCustomer();
		}
		getDispatcher().terminateDispatch();
	}

	public static void main(String[] args) throws InterruptedException {
		// create Employees
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
		// Create Call Center
		CallCenter<Employee> callCenter = new CallCenter<Employee>();
		// Add employees to call center
		callCenter.addEmployeeToShift(sp1);
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
		callCenter.addEmployeeToShift(sp2);
		// Create a main controller
		MainController<Employee> mainController = new MainController<>(callCenter);
		// create customers
		Customer c1 = new Customer("Nataly");
		Customer c2 = new Customer("Bruce");

		// add customers to call center
		callCenter.addCustomer(c1);
		callCenter.addCustomer(c2);

		// run calls
		mainController.runCallCenter();

	}

	public Dispatcher<E> getDispatcher() {
		return dispatcher;
	}
}
