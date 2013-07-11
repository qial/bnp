package com.headwire.bnp;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface ProcessingActivity {
	
	public void performAction(Node node);
	
	public void setConditions(List<ProcessingCondition> conditions);
	
	public boolean checkConditions(Node node) throws RepositoryException;
	
}
