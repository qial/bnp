package com.headwire.bnp.activity;



import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.PropertyType;
import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headwire.bnp.ProcessingActivity;

public class EditTextProperties extends AbstractProcessingActivity {
	
	private static final Logger LOG = LoggerFactory.getLogger(EditTextProperties.class); 

	@Override
	public int performAction(Resource res) throws RepositoryException {
		// get value map and node
		ValueMap vm = res.adaptTo(ValueMap.class);
		Node node = res.adaptTo(Node.class);
		
		PropertyIterator pIter = node.getProperties();
		while(pIter.hasNext()) {
			Property prop = pIter.nextProperty();
			
			if(isModifiable(prop)) {
				doModifications(prop);
			}
			else {
				// move on to next property
			}
		}
		
		return 0;
	}

	private void doModifications(Property prop) {
		// TODO Auto-generated method stub
		
	}

	private boolean isModifiable(Property prop) throws RepositoryException {
		if(prop == null) {
			// can this even happen?
			//LOG.warn("Property was null!");
		}
		
		// TODO anything else to check for?
		if(PropertyType.STRING == prop.getType()) {
			return true;
		}
		
		return false;
	}

}
