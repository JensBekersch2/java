package exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.MainStage;
import tools.Messages;

public class ConfigurationException extends Exception {

	private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger(ConfigurationException.class);   
    
	public ConfigurationException(String message) {
		super(message);
		logger.error(message);
		System.exit(0);
	}
}
