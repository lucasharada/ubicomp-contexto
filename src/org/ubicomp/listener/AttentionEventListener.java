package org.ubicomp.listener;

import org.ubicomp.input.EsperHttpInputAdapter;

import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class AttentionEventListener implements UpdateListener {
	
	public AttentionEventListener() {
        String expression = "SELECT *" + 
        					" FROM TemperatureEvent.std:lastevent() AS temperature," +
        					" HumidityEvent.std:lastevent() AS humidity,"+ 
        					" LuminosityEvent.std:lastevent() AS luminosity" +
        					" WHERE temperature > 50 AND humidity < 0.30 AND luminosity > 0.80";
        EPStatement statement = EsperHttpInputAdapter.epService.getEPAdministrator().createEPL(expression);
        statement.addListener(this);
	}

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		StringBuilder sb = new StringBuilder();
		sb.append("---------------------------------");
		sb.append("\n- [ATTENTION] : ");
		sb.append(newEvents[0].getUnderlying().toString());
		sb.append("\n---------------------------------");
		System.out.println(sb.toString());
	}
	
}
