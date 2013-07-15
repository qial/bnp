package com.headwire.bnp.activity;

import javax.jcr.AccessDeniedException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import org.apache.sling.api.resource.Resource;

public class DeleteNode extends AbstractProcessingActivity {

	@Override
	public int performAction(Resource res) throws RepositoryException {
		Session sess = node.getSession();
		sess.removeItem(node.getPath());
		sess.save();
		return -1;
	}

}
