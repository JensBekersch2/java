package main;

import java.nio.file.Files;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import env.Const;
import exceptions.ConfigurationException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainStage extends Application {
	
    private static final Logger logger = LogManager.getLogger(MainStage.class);    
    private String baseName = "resources.exceptionMessages";
    private ResourceBundle bundle;

	@Override
	public void init() throws Exception {
		/*
		 * TODO: Delete lines
		 */		
		for(int i=0; i<1000000; i++) {
			System.out.println("Startup: " + i);
		}
	    try
	    {
	      bundle = ResourceBundle.getBundle( baseName );
	    }
	    catch ( MissingResourceException e ) {
	      System.err.println( e );
	    }

	    if(Files.exists(Const.CONFIG_LOCATION.getParent())) {
	    	throw new ConfigurationException(bundle.getString("ConfigurationPathFail"));
	    }
		/*
		 * Check if config file exists
		 */	     
		if(!Files.exists(Const.CONFIG_LOCATION.getParent())) {				
			if(Files.createDirectory(Const.CONFIG_LOCATION.getParent()) != null) {
					logger.info(bundle.getString("ConfigurationPathSucces"));	
				} else {
					throw new ConfigurationException(bundle.getString("ConfigurationPathFail"));
				}
		} 
		if(!Files.exists(Const.CONFIG_LOCATION)) {				
			if(Files.createFile(Const.CONFIG_LOCATION) != null) {
				logger.info(bundle.getString("ConfigurationFileSucces"));	
			} else {
				throw new ConfigurationException(bundle.getString("ConfigurationFileFail"));
			}
		} else {
			logger.info(bundle.getString("ConfigurationLoadSuccess"));
		}			
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
	      BorderPane root = new BorderPane(new Label("Loading complete!"));
	      Scene scene = new Scene(root);
	      mainStage.setWidth(800);
	      mainStage.setHeight(600);
	      mainStage.setScene(scene);
	      mainStage.show();
	}

}
