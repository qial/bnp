package com.headwire.bnp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.headwire.bnp.config.ActivityConfig;
import com.headwire.bnp.config.ProcessingConfiguration;

public class NodeRunner {
	public static void main(String[] args) {
		
	}
	
	public NodeRunner(ProcessingConfiguration config) {
		init(config);
	}
	
	private void init(ProcessingConfiguration config) {
		// TODO error checking for if ProcessingConfiguration isn't set up right
		for(ActivityConfig activity : config.getActivities()) {
			
		}
	}
	
	// pieces of info we need
	private String startPath;
	
	// key is string to replace, value is replacement
//	private Map<String,String> changes;
	
	// possible things we could need
//	private String[] componentTypes;
	
	// the activities it'll be doing on nodes
	private List<ProcessingActivity> activities = new ArrayList<ProcessingActivity>();
	
//	public void changeValuesOnNode() {
//		
//	}
}
