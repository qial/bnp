package com.headwire.bnp;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;

public interface ProcessingCondition {
	
	public boolean processOnResource(Resource res) throws RepositoryException;
	
	public void configure(String configString);
}
