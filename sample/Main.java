package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        StringBuilder str = new StringBuilder();
        try {
            InputStream input = Main.class.getResourceAsStream("values.txt");
            BufferedReader flr = new BufferedReader(new InputStreamReader(input));
            int data = flr.read();
            while (data != -1){
                str.append((char) data);
                data = flr.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        primaryStage.setTitle(str.toString());
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
