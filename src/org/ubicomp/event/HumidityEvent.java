package org.ubicomp.event;

import java.util.Date;

public class HumidityEvent {

	private double humidity;

	private Date timeOfReading;

	public HumidityEvent(double humidity, Date timeOfReading) {
		this.humidity = humidity;
		this.timeOfReading = timeOfReading;
	}

	public double getHumidity() {
		return humidity;
	}

	public Date getTimeOfReading() {
		return timeOfReading;
	}

	@Override
	public String toString() {
		return "HumidityEvent [" + humidity + "%]";
	}

}