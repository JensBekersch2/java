package tools;

import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Messages {
    
	public static void errorDialog(String meldung, String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(meldung);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
