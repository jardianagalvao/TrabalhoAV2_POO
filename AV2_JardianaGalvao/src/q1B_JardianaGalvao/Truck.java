package q1B_JardianaGalvao;

public class Truck extends Vehicle {
	private int mass;

	public Truck(String registrationNumber, int mass) {
		super(registrationNumber);
		this.mass = mass;
	}

	public int getMass() {
		return mass;
	}

}
