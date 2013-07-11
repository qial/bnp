package com.headwire.bnp.condition;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headwire.bnp.ProcessingCondition;
import com.headwire.bnp.config.BnpConstants;

public abstract class AbstractProcessingCondition implements
		ProcessingCondition {
	
	protected static final boolean DEBUG = BnpConstants.DEBUG;

	protected Logger LOG = LoggerFactory.getLogger(AbstractProcessingCondition.class);
	
//	@Override
//	public boolean processOnNode(Node node) throws RepositoryException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void configure(String configString) {
//		// TODO Auto-generated method stub
//
//	}

}
