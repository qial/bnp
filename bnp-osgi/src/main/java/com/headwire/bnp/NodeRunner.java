package com.headwire.bnp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
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
	
	public void run(ResourceResolver resolver) throws RepositoryException {
		LOG.info("Beginning NodeRunner run");
		for(String startPath : startPaths) {
			LOG.info("Starting run on startPath "+startPath);
			
			Resource res = resolver.getResource(startPath);
			if(res == null) {
				LOG.warn("Resource at start path "+startPath+" was not found!");
				continue;
			}
			
			runRecursively(res);
			

			LOG.info("Finished run on startPath "+startPath);
		}
		LOG.info("Finished NodeRunner run!");
	}
	
	protected void runRecursively(Resource root) throws RepositoryException {
		// first run on this node
//		Node resNode = root.adaptTo(Node.class);
//		if(resNode == null) {
//			LOG.warn("Could not get Node for Resource at path "+root.getPath());
//			return;
//		}
		boolean continu = runOnResource(root);
		
		if(continu) {
			//LOG.info("Recursing on children of "+resNode.getPath());
			Iterator<Resource> children = root.listChildren();
			while(children.hasNext()) {
				Resource child = children.next();
				runRecursively(child);
			}
		}
		else {
			// just move on, don't recurse
		}
		
	}
	
	protected boolean runOnResource(Resource res) throws RepositoryException {
		//LOG.info("NodeRunner: running on "+res.getPath());
		
		// TODO session control stuff will likely go here
		
		// run through activities
		for(ProcessingActivity activity : activities) {
			if(activity.checkConditions(res)) {
				LOG.info("Conditions passed for "+activity.getName()+" on resource "+res.getPath());
				// conditions returned true, run activity
				
				int acts = activity.performAction(res);
				// TODO session control with acts stuff
				if(acts == -1) {
					// return false to signify we should not do this nodes children
					return false;
				}
			}
			else {
				LOG.info("Conditions failed for "+activity.getName()+" on resource "+res.getPath());
			}
		}
		return true;
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
			// answer: yes D:
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
			LOG.error("Caught error loading ProcessingActivity class instance "+className,e);
			return null;
		}
		
		ProcessingActivity pAct = null;
		try {
			pAct = (ProcessingActivity) activityClass.newInstance();
		} catch(IllegalAccessException e) {
			LOG.error("Caught error getting ProcessingActivity instance",e);
		} catch (InstantiationException e) {
			LOG.error("Caught error getting ProcessingActivity instance",e);
		} catch(ClassCastException e) {
			LOG.error("Caught error getting ProcessingActivity instance",e);
		}
		
		return pAct;
	}
	
	private ProcessingCondition getProcessingConditionInstance(String className) {
		Class conditionClass = null;
		try {
			conditionClass = Thread.currentThread().getContextClassLoader().loadClass( className );
		} catch(ClassNotFoundException e) {
			LOG.error("Caught error loading ProcessingCondition class instance "+className,e);
			return null;
		}
		
		ProcessingCondition pCond = null;
		try {
			pCond = (ProcessingCondition) conditionClass.newInstance();
		} catch(IllegalAccessException e) {
			LOG.error("Caught error getting ProcessingCondition instance",e);
		} catch (InstantiationException e) {
			LOG.error("Caught error getting ProcessingCondition instance",e);
		} catch(ClassCastException e) {
			LOG.error("Caught error getting ProcessingCondition instance",e);
		}
		
		return pCond;
	}
}
