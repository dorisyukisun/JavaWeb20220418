package service;

import java.util.concurrent.CopyOnWriteArrayList;

 
import entity.Employee;

//支援 SingleTon pattern

public class EmployeeService {
	private CopyOnWriteArrayList<Employee> employees = new CopyOnWriteArrayList<Employee>();
	private static final EmployeeService _instance = new EmployeeService();
	private EmployeeService() {
		
	}
	public static EmployeeService getInstance() {
		return  _instance;
		
	}
	public void addEmployee(Employee employee) {
		employees.add(employee);
		System.out.println(findAll());//每加入都印出來看一下
	}
	public CopyOnWriteArrayList<Employee> findAll(){
		return employees;
	}

}
