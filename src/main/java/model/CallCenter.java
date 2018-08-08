package main.java.model;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CallCenter<E> {
	private Map<String, Deque<Employee>> employeesInShift;
	private Deque<Customer> queuedCustomers;
	
	public CallCenter() {
		employeesInShift = new HashMap<String, Deque<Employee>>();
		queuedCustomers = new LinkedList<Customer>();
		employeesInShift.put(EmployeeTypeTable.employeeTypes[0], new LinkedList<Employee>());//0 = operador
		employeesInShift.put(EmployeeTypeTable.employeeTypes[1], new LinkedList<Employee>());//1 = supervisor
		employeesInShift.put(EmployeeTypeTable.employeeTypes[2], new LinkedList<Employee>());//2 = director
	}

	public void addEmployeeToShift(Employee e) {
		employeesInShift.get(e.getType()).push(e);
	}

	public Map<String, Deque<Employee>> getAllEmployeesInShift() {
		return employeesInShift;
	}

	public Deque<Customer> getAllCustomersQueued() {
		return queuedCustomers;
	}
	
	public void addCustomer(Customer c) {
		queuedCustomers.add(c);
	}

}
