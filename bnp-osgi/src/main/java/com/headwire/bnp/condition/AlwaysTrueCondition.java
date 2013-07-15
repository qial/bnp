package com.headwire.bnp.condition;

import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;

public class AlwaysTrueCondition extends AbstractProcessingCondition {

	@Override
	public boolean processOnResource(Resource res) throws RepositoryException {
		// always return true (for testing and for making scripts more explicit
		return true;
	}

	@Override
	public void configure(String configString) {
		// nothing to do

	}

}
