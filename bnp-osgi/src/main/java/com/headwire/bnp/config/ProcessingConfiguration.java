package com.headwire.bnp.config;

import java.util.Arrays;

public class ProcessingConfiguration {
	
	private ActivityConfig[] activities;
	
	private String name;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ProcessingConfiguration({");
		sb.append(" name = ").append(name);
		sb.append(", ");
		sb.append(" activities = ");
		sb.append((activities == null) ? "null" : Arrays.asList(activities).toString());
		sb.append(" })");
		return sb.toString();
	}

	public ActivityConfig[] getActivities() {
		return activities;
	}

	public void setActivities(ActivityConfig[] activities) {
		this.activities = activities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
