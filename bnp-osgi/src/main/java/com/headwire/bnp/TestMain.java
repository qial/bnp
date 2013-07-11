package com.headwire.bnp;

import com.headwire.bnp.config.ProcessingConfiguration;
import com.headwire.bnp.config.ProcessingConfigurationLoader;

public class TestMain {

	public static void main(String[] args) {
		
		ProcessingConfiguration config = ProcessingConfigurationLoader.loadConfiguration("test-config.json");
		System.out.println(config.toString());
	}
	
	
}
