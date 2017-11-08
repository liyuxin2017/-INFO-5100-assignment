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
		synchronized (device) {
			while (true) {
				this.updateValue();
				device.notify();
			}
		}
	}
}
