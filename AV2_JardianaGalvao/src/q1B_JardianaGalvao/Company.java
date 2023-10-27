package q1B_JardianaGalvao;

import java.util.ArrayList;
import java.util.List;

public class Company {

	private String name;
	private List<Employee> employees;
	private List<Vehicle> vehicles;

	public Company(String name) {
		this.name = name;
		this.employees = new ArrayList<>();
		this.vehicles = new ArrayList<>();
	}

	public void hireEmployee(Employee employee) {
		this.employees.add(employee);
	}

	public void fireEmployee(Employee employee) {
		this.employees.remove(employee);
	}

	public String getName() {
		return this.name;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}
}
