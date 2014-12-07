package net.austinj.chisel.ui;


import java.net.URL;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.web.WebView;

public class Chisel extends Application 
{

	@Override
	public void start(Stage stage) throws Exception 
	{
		try
		{
			String url = Chisel.class.getResource("/html/index.html").toExternalForm();
			System.out.println(url);
			WebView web = new WebView();
			web.setContextMenuEnabled(false);
	        web.getEngine().load(url);  
	        Scene scene = new Scene(web,375,667);
	        stage.setTitle("Chisel");
	        stage.setScene(scene);  
	        stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
}
