package main.java.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import main.java.model.CallCenter;
import main.java.model.Employee;
import main.java.model.EmployeeTypeTable;

/**
 * This class will provide the functionality to manipulate employees in the
 * model.
 * 
 * @author Jorge
 *
 */
public class EmployeeController {

	CallCenter<Employee> callCenter;
	Map<String, Deque<Employee>> shiftEmployees;

	public EmployeeController(CallCenter<Employee> cc) {
		callCenter = cc;
		shiftEmployees = cc.getAllEmployeesInShift();
	}

	/**
	 * @return the next available employee whose status is available. The first
	 *         iteraton will look for the employee list that contain the
	 *         employees by type (operator, supervisor and director
	 *         respectively). The second iteration will looked into a linked
	 *         list of a type of employee and retrieve the next employee
	 *         available and will reassign it to the end of the list)
	 */
	public Employee getNextAvailableEmployee() {
		Employee tempEmployee = null;
		boolean found = false;
		// traverse until found
		int typeOfEmployeeIndex = 0;
		// traverse employee map
		while (typeOfEmployeeIndex < shiftEmployees.size() && found == false) {
			int employeeIndex = 0;
			// traverse the employee type deque
			Deque<Employee> employeesOfType = shiftEmployees.get(EmployeeTypeTable.employeeTypes[typeOfEmployeeIndex]);
			while (employeeIndex < employeesOfType.size()) {
				tempEmployee = employeesOfType.poll();
				employeesOfType.offer(tempEmployee);
				// if available, removes head and points to last
				if (tempEmployee.getStatus().equals("available")) {
					found = true;
					tempEmployee.setStatus("busy");
					break;
				} else {
					tempEmployee = null;
					employeeIndex++;
				}

			}
			typeOfEmployeeIndex++;
		}
		return tempEmployee;
	}

	/**
	 * @param status
	 * @return all employees matching the search criteria (status)
	 */
	public List<Employee> getEmployeesByStatus(String status) {
		List<Employee> filteredEmployees = null;

		filteredEmployees = shiftEmployees.values().stream().flatMap(Collection::stream)
				.filter(x -> status.equals(x.getStatus())).collect(Collectors.toList());

		return Collections.unmodifiableList(filteredEmployees);
	}

}
