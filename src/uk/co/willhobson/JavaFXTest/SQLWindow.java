package uk.co.willhobson.JavaFXTest;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SQLWindow {
	
	public static Stage start() {
		Stage stage = new Stage();
		stage.setTitle("SQL WINDOW");
		Button btn = new Button();
		btn.setText("Click me!");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("lets test the squiggle!");
				try {
					MySQLAccess.openConnection();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("the connections open! probably");
				ResultSet result = null;
				try {
					result = MySQLAccess.queryConnection("SELECT * FROM data_table");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					System.out.println(result.getMetaData());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("closing connection!");
				MySQLAccess.closeConnection();
			}
		});
		
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		stage.setScene(new Scene(root,300,250));
		stage.show();
		return stage;
	}

}
