package main;

import java.util.Locale;

import com.sun.javafx.application.LauncherImpl;

public class Start {

	public static void main(String[] args) {
		/*
		 * TODO: get language settings from local machine
		 */
		Locale.setDefault( new Locale("de", "DE") );
		LauncherImpl.launchApplication(MainStage.class, ApplicationPreloader.class, args);
	}

}
