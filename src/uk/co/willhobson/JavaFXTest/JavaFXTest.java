package uk.co.willhobson.JavaFXTest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXTest extends Application implements EventHandler {
	Stage SQLStage = null;
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("Line Chart Test");
		
		//define the axis's
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Number of Month");
		
		//make the chart
		final LineChart<Number,Number> lineChart = 
			new LineChart<Number,Number>(xAxis,yAxis);
		
		lineChart.setTitle("Dis mah chart, 'tis pre great.");

		
		//a series, what ever that is.
		XYChart.Series<Number, Number> series = new Series<Number, Number>();
		series.setName("My prtofoliolo");
		
		//lets get some data
		series.getData().add(new Data<Number, Number>(1, 23));
        series.getData().add(new Data<Number, Number>(2, 14));
        series.getData().add(new Data<Number, Number>(3, 15));

		//sql window
		Button btnsql = new Button();
		btnsql.setText("Open SQL Window");
		btnsql.setOnAction(this);
		btnsql.setLayoutX(3);
		btnsql.setLayoutY(3);
		
		Pane root = new Pane();
		root.getChildren().add(lineChart);
		root.getChildren().add(btnsql);
        
        //what could go wrong
        Scene scene = new Scene(root,500,400);
        lineChart.getData().add(series);
        stage.setScene(scene);
        stage.show();
	}
	public static void main(String[] args){
		launch(args);
	}
	
	public void handle(Event event)
	{
		if(SQLStage != null)
		{
			SQLStage.close();
			SQLStage = null;
		}
		else
		{
			SQLStage = SQLWindow.start();
		}
	}
}
