package com.headwire.bnp.condition;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headwire.bnp.ProcessingCondition;

public class ResourceTypeCondition extends AbstractProcessingCondition {
	
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
		//String givenType = "";//res.g.getName();
		String resType = res.getResourceType();
		if(DEBUG) {
			LOG.info("Resource type of "+res.getPath()+" was "+resType);
		}
		if(resType.equals(nodeType)) {
			return true;
		}
		return false;
	}

}
