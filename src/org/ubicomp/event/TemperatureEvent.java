package org.ubicomp.event;

public class TemperatureEvent {

	private double temperature;

	private String timeOfReading;

	public TemperatureEvent(){}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public void setTimeOfReading(String timeOfReading) {
		this.timeOfReading = timeOfReading;
	}

	public String getTimeOfReading() {
		return timeOfReading;
	}

	@Override
	public String toString() {
		return "TemperatureEvent [" + temperature + "C]";
	}

}
