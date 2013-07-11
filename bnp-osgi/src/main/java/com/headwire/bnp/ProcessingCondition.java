package com.headwire.bnp;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface ProcessingCondition {
	
	public boolean processOnNode(Node node) throws RepositoryException;
	
	public void configure(String configString);
}
