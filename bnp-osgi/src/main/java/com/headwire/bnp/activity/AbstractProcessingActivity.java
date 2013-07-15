package com.headwire.bnp.activity;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headwire.bnp.ProcessingActivity;
import com.headwire.bnp.ProcessingCondition;
import com.headwire.bnp.config.BnpConstants;

public abstract class AbstractProcessingActivity implements ProcessingActivity {
	
	private static final Logger LOG = LoggerFactory.getLogger(AbstractProcessingActivity.class);

	protected static final boolean DEBUG = BnpConstants.DEBUG;
	
	private List<ProcessingCondition> conditions = null; 
	
	private String name;
	
	public void setConditions(List<ProcessingCondition> conditions) {
		this.conditions = conditions;
	}
	
	@Override
	public boolean checkConditions(Resource res) throws RepositoryException {
		// no conditions -> always true
		if(conditions == null) {
			return true;
		}
		for(ProcessingCondition condition : conditions) {
			boolean status = condition.processOnResource(res);
			if(status) {
				// we're good for this one!
				continue;
			}
			else {
				// oh no!
				return false;
			}
		}
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	protected Node getNode(Resource res) {
		Node n = res.adaptTo(Node.class);
		if(n == null) {
			LOG.warn("Could not get Node from Resource "+res.getPath());
		}
		return n;
	}
}
