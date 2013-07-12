package com.headwire.bnp.activity;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import com.headwire.bnp.ProcessingActivity;
import com.headwire.bnp.ProcessingCondition;
import com.headwire.bnp.config.BnpConstants;

public abstract class AbstractProcessingActivity implements ProcessingActivity {

	protected static final boolean DEBUG = BnpConstants.DEBUG;
	
	private List<ProcessingCondition> conditions = null; 
	
	public void setConditions(List<ProcessingCondition> conditions) {
		this.conditions = conditions;
	}
	
	public boolean checkConditions(Node node) throws RepositoryException {
		// no conditions -> always true
		if(conditions == null) {
			return true;
		}
		for(ProcessingCondition condition : conditions) {
			boolean status = condition.processOnNode(node);
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
}
