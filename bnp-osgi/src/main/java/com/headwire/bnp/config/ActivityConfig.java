package com.headwire.bnp.config;

import java.util.Arrays;

public class ActivityConfig {

	private String name;
	private String className;
	
	private ConditionConfig[] conditions;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ActivityConfig({");
		sb.append(" name = ").append(name);
		sb.append(", ");
		sb.append(" className = ").append(className);
		sb.append(", ");
		sb.append(" conditions = ");
		sb.append((conditions == null) ? "null" : Arrays.asList(conditions).toString());
		sb.append(" })");
		return sb.toString();
	}
}
