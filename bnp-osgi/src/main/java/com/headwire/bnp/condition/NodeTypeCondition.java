package com.headwire.bnp.condition;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headwire.bnp.ProcessingCondition;

public class NodeTypeCondition extends AbstractProcessingCondition {
	
	private String nodeType;
	
	@Override
	public void configure(String configString) {
		nodeType = configString;
		if(DEBUG) {
			LOG.info("Configured NodeTypeCondition with given string '"+configString+"'");
		}
	}
	
	@Override
	public boolean processOnResource(Resource res) throws RepositoryException {
		// TODO this, change for resource
		//String givenType = "";//res.g.getName();
		ValueMap vm = res.adaptTo(ValueMap.class);
		String givenType = vm.get("jcr:primaryType",String.class);
		if(DEBUG) {
			LOG.info("Node type of "+res.getPath()+" was "+givenType);
		}
		if(givenType.equals(nodeType)) {
			return true;
		}
		return false;
	}

}
