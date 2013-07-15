package com.headwire.bnp.condition;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;

import com.day.cq.wcm.api.Page;
import com.headwire.bnp.ProcessingCondition;
import com.headwire.bnp.config.BnpConstants;

public class DeactivatedPageCondition extends AbstractProcessingCondition {

	@Override
	public boolean processOnResource(Resource res) throws RepositoryException {
		// TODO Auto-generated method stub
		
		if(isPage(res)) {
			Page page = convertToPage(res);
			if(page == null) {
				if(DEBUG) {
					LOG.warn("Node at path "+res.getPath()+" returned true for isPage() but convertToPage() returned null!");
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
	
	private boolean isPage(Resource res) {
		// TODO Check if node is a page
		return false;
	}
	
	private boolean isActivated(Page p) {
		// TODO check if page is activated
		return false;
	}
	
	private Page convertToPage(Resource res) {
		// TODO returns Page version of node
		return null;
	}

}
