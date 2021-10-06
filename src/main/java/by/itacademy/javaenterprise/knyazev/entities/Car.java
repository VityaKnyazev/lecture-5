package by.itacademy.javaenterprise.knyazev.entities;

public class Car {
	
	private String firm;
	private String model;
	private long serialNumber;
	
	
	public Car(String firm, String model, long serialNumber) {
		this.firm = firm;
		this.model = model;
		this.serialNumber = serialNumber;
	}
	
	public String getFirm() {
		return firm;
	}
	public String getModel() {
		return model;
	}
	public long getSerialNumber() {
		return serialNumber;
	}
	
	public void setFirm(String firm) {
		this.firm = firm;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}
}
