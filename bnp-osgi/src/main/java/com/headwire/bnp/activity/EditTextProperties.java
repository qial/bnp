package com.headwire.bnp.activity;



import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.PropertyType;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

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
		
		int propsModified = 0;
		
		PropertyIterator pIter = node.getProperties();
		while(pIter.hasNext()) {
			Property prop = pIter.nextProperty();
			
			if(isModifiable(prop)) {
				boolean modified = doModifications(prop);
				if(modified) {
					// increase our modification count
					propsModified ++;
				}
			}
			else {
				// move on to next property
			}
		}
		
		return propsModified;
	}

	private boolean doModifications(Property prop) throws RepositoryException {
		// get the value and save it
		String propValue = prop.getString();
		String originalValue = propValue;
		
		// run through the regex changes
		for(Map.Entry<String, String> entry : getConfigMap().entrySet()) {
			String regex = entry.getKey();
			String replacement = entry.getValue();
			propValue = propValue.replaceAll(regex, replacement);
		}
		
		if(propValue.equals(originalValue)) {
			// no change
			return false;
		}
		
		// print out final value
		LOG.info("Modified value for Property "+prop.getPath()+"\nOriginal:\n"+originalValue+"\nNew:\n"+propValue);
		
		prop.setValue(propValue);
		// NOTE: saving will be done elsewhere
		return true;
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
