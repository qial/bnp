package com.headwire.bnp.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class ProcessingConfigurationLoader {
	private static final Logger LOG = LoggerFactory.getLogger(ProcessingConfigurationLoader.class);
	
	public static ProcessingConfiguration loadConfiguration( String fileName ) {
        // 1st Try to load the configuration from the local directory
        InputStream configurationStream = null;
        try {
            File localFile = new File( ".", fileName );
            if( !localFile.exists() || !localFile.isFile() || !localFile.canRead() ) {
            	LOG.warn("First attempt at finding file "+localFile.getAbsolutePath()+" failed");
                throw new FileNotFoundException( "Local File not found" );
            }
            configurationStream = new FileInputStream( fileName );
        } catch( FileNotFoundException e ) {
            configurationStream = Thread.currentThread().getContextClassLoader().getResourceAsStream( fileName );
        }
        if( configurationStream != null ) {
            // Unmarshall the Body JSon Content into the Style Merger Info Object
        	ProcessingConfiguration config = new Gson().fromJson(
                new InputStreamReader( configurationStream ),
                ProcessingConfiguration.class
            );
            LOG.info( "loadConfiguration(), configuration: {}", config );
            return config;
        } else {
            throw new RuntimeException( "Could not obtain the Configuration File" );
        }
    }
}
