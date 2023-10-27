package q1B_JardianaGalvao;

public class Car extends Vehicle {
	private String transmission;

	public Car(String registrationNumber, String transmission) {
		super(registrationNumber);
		this.transmission = transmission;
	}

	public String getTransmission() {
		return transmission;
	}


}
