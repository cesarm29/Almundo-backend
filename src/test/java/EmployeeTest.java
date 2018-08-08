package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.controller.EmployeeController;
import main.java.model.CallCenter;
import main.java.model.Employee;

public class EmployeeTest {
	Employee op1, op2, op3, sp1, sp2, dir1;
	CallCenter<Employee> callCenter;
	EmployeeController ec;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		op1 = new Employee("Jose", "operador");
		op2 = new Employee("Pedro", "operador");
		op2.setStatus("busy");
		op3 = new Employee("Daniela", "operador");
		op3.setStatus("busy");
		sp1 = new Employee("Julian", "supervisor");
		sp2 = new Employee("Ricardo", "supervisor");
		sp2.setStatus("busy");
		dir1 = new Employee("Fredy", "director");
		dir1.setStatus("busy");
		callCenter = new CallCenter<Employee>();
		callCenter.addEmployeeToShift(op1);
		callCenter.addEmployeeToShift(op2);
		callCenter.addEmployeeToShift(op3);
		callCenter.addEmployeeToShift(sp1);
		callCenter.addEmployeeToShift(sp2);
		callCenter.addEmployeeToShift(dir1);
		ec = new EmployeeController(callCenter);
	}

	@Test
	public void isSameEmployee() {
		assertEquals("Different employees", op1, op1);
	}

	@Test
	public void isNotSameEmployee() {
		assertNotEquals("Same employees", op1, op2);
	}

	@Test
	public void sameOperatorsNumber() {
		assertEquals("Not the right number of operators", callCenter.getAllEmployeesInShift().get("operator").size(),
				3);
	}

	@Test
	public void sameSupervisorsNumber() {
		assertEquals("Not the right number of supervisors",
				callCenter.getAllEmployeesInShift().get("supervisor").size(), 2);
	}

	@Test
	public void sameDirectorsNumber() {
		assertEquals("Not the right number of directors", callCenter.getAllEmployeesInShift().get("director").size(),
				1);
	}

	@Test
	public void getAvailableEmployee() throws InterruptedException {
		assertEquals(ec.getNextAvailableEmployee().getName(), "Celeste");
		assertEquals(ec.getNextAvailableEmployee().getName(), "Claudia");
	}

	/**
	 * Expecting 6 employees busy in the call center shift
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void employeesBusyCount() throws InterruptedException {
		assertEquals(ec.getEmployeesByStatus("busy").size(), 4);
	}

	/**
	 * Expecting 6 employees busy in the call center shift
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void employeesAvailableCount() throws InterruptedException {
		assertEquals(ec.getEmployeesByStatus("available").size(), 2);
	}
}
