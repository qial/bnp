package com.headwire.bnp;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;

public interface ProcessingActivity {
	
	public int performAction(Resource res) throws RepositoryException;
	
	public void setConditions(List<ProcessingCondition> conditions);
	
	public boolean checkConditions(Resource res) throws RepositoryException;
	
	public String getName();
	
	public void setName(String name);
}
