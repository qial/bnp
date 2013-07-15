package com.headwire.bnp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headwire.bnp.config.ActivityConfig;
import com.headwire.bnp.config.ConditionConfig;
import com.headwire.bnp.config.ProcessingConfiguration;

public class NodeRunner {
	
	private static final Logger LOG = LoggerFactory.getLogger(NodeRunner.class);
	
	public static void main(String[] args) {
		
	}
	
	public NodeRunner(ProcessingConfiguration config) {
		init(config);
	}
	
	public void run() {
		LOG.info("Beginning NodeRunner run");
		for(String startPath : startPaths) {
			LOG.info("Noderunner: Start path is "+startPath);
			
			
		}
	}
	
	private void init(ProcessingConfiguration config) {
		startPaths = config.getStartPaths();
		
		activities = new ArrayList<ProcessingActivity>();
		
		// TODO error checking for if ProcessingConfiguration isn't set up right
		for(ActivityConfig aConfig : config.getActivities()) {
			String activityClass = aConfig.getClassName();
			
			// get activity instance & load everything but conditions
			ProcessingActivity activity = getProcessingActivityInstance(activityClass);
			initProcessingActivity(activity,aConfig);

			// go through conditions
			List<ProcessingCondition> conditions = new ArrayList<ProcessingCondition>();
			
			// TODO can the aConfig.getConditions() be null?
			for(ConditionConfig cConfig : aConfig.getConditions()) {
				String conditionClass = cConfig.getClassName();
				
				// get condition instance & configure it
				ProcessingCondition condition = getProcessingConditionInstance(conditionClass);
				initProcessingCondition(condition, cConfig);
				
				// add condition to list for this activity
				conditions.add(condition);
			}
			
			// add conditions to activity and add activity to the list
			activity.setConditions(conditions);
			activities.add(activity);
		}
	}
	
	// pieces of info we need
	private String startPaths[];
	
	// the activities it'll be doing on nodes
	private List<ProcessingActivity> activities = new ArrayList<ProcessingActivity>();
	
	private void initProcessingActivity(ProcessingActivity activity, ActivityConfig config) {
		// initialize variables
		activity.setName(config.getName());
	}
	
	private void initProcessingCondition(ProcessingCondition condition, ConditionConfig config) {
		// configure processing condition
		condition.configure(config.getConfigString());
	}
	
	private ProcessingActivity getProcessingActivityInstance(String className) {
		Class activityClass = null;
		try {
			activityClass = Thread.currentThread().getContextClassLoader().loadClass( className );
		} catch(ClassNotFoundException e) {
			// TODO error checking, teehee
			e.printStackTrace();
			return null;
		} catch(ClassCastException e) {
			// TODO error checking, teehee
			e.printStackTrace();
			return null;
		}
		
		ProcessingActivity pAct = null;
		try {
			activityClass.newInstance();
		} catch(IllegalAccessException e) {
			// TODO error checking, teehee
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			// TODO error checking, teehee
			e.printStackTrace();
			return null;
		}
		
		return pAct;
	}
	
	private ProcessingCondition getProcessingConditionInstance(String className) {
		Class conditionClass = null;
		try {
			conditionClass = Thread.currentThread().getContextClassLoader().loadClass( className );
		} catch(ClassNotFoundException e) {
			// TODO error checking, teehee
			e.printStackTrace();
			return null;
		} catch(ClassCastException e) {
			// TODO error checking, teehee
			e.printStackTrace();
			return null;
		}
		
		ProcessingCondition pCond = null;
		try {
			conditionClass.newInstance();
		} catch(IllegalAccessException e) {
			// TODO error checking, teehee
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			// TODO error checking, teehee
			e.printStackTrace();
			return null;
		}
		
		return pCond;
	}
}
