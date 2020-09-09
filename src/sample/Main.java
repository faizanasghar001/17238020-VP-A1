package sample;


import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.*;


public class Main extends Application {


    private String output;

    private TextField marksText;
    private Label marksLbl;

    private Label dateLbl;
    private DatePicker datePicker;

   private Button saveBtn;

    private HBox tileLblHbox;
    private HBox marksLblHbox;
    private HBox saveBtnHbox;
   private VBox root;


    @Override
    public void start(Stage primaryStage) {
        Label titleLbl = new Label("My CP Tracker");
        dateLbl = new Label("Date");
        datePicker = new DatePicker();

      marksLbl = new Label("Marks");
        marksText = new TextField();
        marksText.setPromptText("Marks");
        tileLblHbox = new HBox(titleLbl);
        HBox dateLblHbox = new HBox(dateLbl, datePicker);
        marksLblHbox = new HBox(marksLbl,marksText);
        saveBtnHbox = new HBox(saveBtn);


        root = new VBox(tileLblHbox, dateLblHbox,marksLblHbox,saveBtnHbox);

        saveBtn = new Button("Save Data");

        saveBtn.setOnAction(e -> {

                   if (marksText.getText().trim().isEmpty()) {
                        Alert fail = new Alert(Alert.AlertType.ERROR);
                        fail.setHeaderText("Failure");
                        fail.setContentText("you have not typed anything");
                        fail.showAndWait();
                    } else {

                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle("CP data saved");
                       alert.setHeaderText("Your CP data is saved successfully");
                       output = "------CP marks on " + datePicker.getValue() + "--------" + "\n"
                              + "Marks : " + marksText.getText();
                       alert.setContentText(output);
                       alert.showAndWait();
                   }

               });



//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("17238020 CP Calculator");
        Scene scene = new Scene(root, 300, 275);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void main(String[] args) throws IOException {

     FileWriter file = new FileWriter("CP.txt", true);
     BufferedWriter bw = new BufferedWriter(file);

     bw.write(output);
     bw.newLine();
     bw.close();
     file.close();




    }
}
