package com.headwire.bnp.config;

import java.util.Arrays;

public class ConditionConfig {
	private String className;
	private String configString;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ConditionConfig({");
		sb.append(" className = ").append(className);
		sb.append(", ");
		sb.append(" configString = ").append(configString);
		sb.append(" })");
		return sb.toString();
	}
}
