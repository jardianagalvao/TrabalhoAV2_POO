package q1B_JardianaGalvao;

public class Sistema {
	public static void main(String[] args) {
		Company company = new Company("Unifor");

		Employee employee = new Employee("Samuel Barrocas", company);
		Vehicle vehicle = new Vehicle("ABC-123");
		
		employee.addVehicle(vehicle);

		System.out.println("Nome do funcionario: " + employee.getName());
		System.out.println("Empresa do funcionario: " + employee.getCompany().getName());
		System.out.println("Veiculos do funcionario: " + vehicle.getRegistrationNumber());
	}
}