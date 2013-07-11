package com.headwire.bnp.condition;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

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
	public boolean processOnNode(Node node) throws RepositoryException {
		String givenType = node.getPrimaryNodeType().getName();
		if(DEBUG) {
			LOG.info("Node type of "+node.getPath()+" was "+givenType);
		}
		if(givenType.equals(nodeType)) {
			return true;
		}
		return false;
	}

}
