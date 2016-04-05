package tpsmonitor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SQLWindow {
	
	public static Stage start() {
		Stage stage = new Stage();
		stage.setTitle( "SQL WINDOW" );
		Button btn = new Button();
		btn.setText( "Click me!" );
		btn.setOnAction( new EventHandler<ActionEvent>() {
			
			@Override
			public void handle( ActionEvent event ) {
				MySQLAccess.TestConnection();
			}
		} );
		
		StackPane root = new StackPane();
		root.getChildren().add( btn );
		stage.setScene( new Scene( root, 300, 250 ) );
		stage.show();
		return stage;
	}
	
}
