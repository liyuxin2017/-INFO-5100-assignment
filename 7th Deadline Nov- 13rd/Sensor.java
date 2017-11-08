package javaass7;

public class Sensor extends Thread {
	private final Device device;
	private double value;

	public Sensor(Device device) {
		this.device = device;
	}

	public double getValue() {
		return value;
	}

	public void updateValue() {
		this.value += 0.001;
	}

	public void run() {
		while (true) {
			synchronized (device) {
				this.updateValue();
				device.notify();
			}
		}
	}
}
