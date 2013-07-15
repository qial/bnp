package com.headwire.bnp.condition;

import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;

public class AlwaysFalseCondition extends AbstractProcessingCondition {

	@Override
	public boolean processOnResource(Resource res) throws RepositoryException {
		// always return false (for testing the nodeRunner without doing anything)
		return false;
	}

	@Override
	public void configure(String configString) {
		// do nothing
	}

}
