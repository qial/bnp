package com.headwire.bnp.condition;

import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;

public class NodeNameCondition extends AbstractProcessingCondition {

	private String nodeName = "";
	
	@Override
	public boolean processOnResource(Resource res) throws RepositoryException {
		return res.getName().equals(nodeName);
	}

	@Override
	public void configure(String configString) {
		nodeName = configString;
	}

}
