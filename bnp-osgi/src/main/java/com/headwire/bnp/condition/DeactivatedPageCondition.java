package com.headwire.bnp.condition;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import com.day.cq.wcm.api.Page;
import com.headwire.bnp.ProcessingCondition;
import com.headwire.bnp.config.BnpConstants;

public class DeactivatedPageCondition extends AbstractProcessingCondition {

	@Override
	public boolean processOnNode(Node node) throws RepositoryException {
		// TODO Auto-generated method stub
		
		if(isPage(node)) {
			Page page = convertToPage(node);
			if(page == null) {
				if(DEBUG) {
					LOG.warn("Node at path "+node.getPath()+" returned true for isPage() but convertToPage() returned null!");
				}
				return false;
			}
			else {
				if(isActivated(page)) {
					// if activated, don't process
					return false;
				}
				else {
					// isActivated() was false, so process on this node
					return true;
				}
			}
		}
		
		// if node is not a page, then don't process on this node
		// if the node is an activated page, don't process on this node
		return false;
	}

	@Override
	public void configure(String configString) {
		// nothing to configure
	}
	
	private boolean isPage(Node n) {
		// TODO Check if node is a page
		return false;
	}
	
	private boolean isActivated(Page p) {
		// TODO check if page is activated
		return false;
	}
	
	private Page convertToPage(Node n) {
		// TODO returns Page version of node
		return null;
	}

}
