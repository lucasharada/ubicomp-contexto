package org.ubicomp.event;

import java.util.Date;

public class LuminosityEvent {

	private double luminosity;

	private Date timeOfReading;

	public LuminosityEvent (double luminosity, Date timeOfReading) {
		this.luminosity = luminosity;
		this.timeOfReading = timeOfReading;
	}

	public double getLuminosity() {
		return luminosity;
	}

	public Date getTimeOfReading() {
		return timeOfReading;
	}

	@Override
	public String toString() {
		return "LuminosityEvent [" + luminosity + "%]";
	}

}