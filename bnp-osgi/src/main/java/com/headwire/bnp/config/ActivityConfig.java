package com.headwire.bnp.config;

import java.util.Arrays;
import java.util.HashMap;

public class ActivityConfig {

	private String name;
	private String className;
	private boolean enabled = true;
	private HashMap<String,String> config = new HashMap<String,String>();
	
	private ConditionConfig[] conditions;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ActivityConfig({");
		sb.append(" name = ").append(name);
		sb.append(", ");
		sb.append(" className = ").append(className);
		sb.append(", ");
		sb.append(" config = ").append(config);
		sb.append(", ");
		sb.append(" conditions = ");
		sb.append((conditions == null) ? "null" : Arrays.asList(conditions).toString());
		sb.append(" })");
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ConditionConfig[] getConditions() {
		if(conditions == null) {
			// don't return null for conditions
			return new ConditionConfig[0];
		}
		return conditions;
	}

	public void setConditions(ConditionConfig[] conditions) {
		this.conditions = conditions;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public HashMap<String,String> getConfig() {
		return config;
	}

	public void setConfig(HashMap<String,String> config) {
		this.config = config;
	}
}
