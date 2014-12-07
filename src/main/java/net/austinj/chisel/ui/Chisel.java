package net.austinj.chisel.ui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import net.austinj.chisel.Debug;

public class Chisel extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        String url = getClass().getResource("/html/index.html").toExternalForm();
        Debug.printInfo(url);

        WebView web = new WebView();
        web.setContextMenuEnabled(false);
        web.getEngine().load(url);

        Scene scene = new Scene(web, 375, 667);

        stage.setTitle("Chisel");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
