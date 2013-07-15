package com.headwire.bnp.activity;

import javax.jcr.AccessDeniedException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteNode extends AbstractProcessingActivity {

	private static final Logger LOG = LoggerFactory.getLogger(DeleteNode.class);
	
	@Override
	public int performAction(Resource res) throws RepositoryException {
		Node node = getNode(res);
		LOG.info("Deleting node at "+node.getPath()+" and saving Session");
		Session sess = node.getSession();
		sess.removeItem(node.getPath());
		sess.save();
		return -1;
	}

}
