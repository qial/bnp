package com.headwire.bnp;

import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.ResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headwire.bnp.config.ProcessingConfiguration;
import com.headwire.bnp.config.ProcessingConfigurationLoader;

public class TestJCR {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestJCR.class);
	
	public static void runNodeRunner(String configFilePath, ResourceResolver rr) {
		LOG.info("Running NodeRunner on config file "+configFilePath);
		
		ProcessingConfiguration config = ProcessingConfigurationLoader.loadConfiguration("test-config.json");
		NodeRunner runner = new NodeRunner(config);
		
		try {
			runner.run(rr);
		} catch (RepositoryException e) {
			LOG.error("Got error during run",e);
		}
	}
}
