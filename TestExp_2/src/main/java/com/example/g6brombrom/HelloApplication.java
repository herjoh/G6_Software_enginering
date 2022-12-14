package com.example.g6brombrom;

//import Sample.modelV2.CarsDAO;
        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.layout.BorderPane;
        import javafx.stage.Stage;


        import java.io.IOException;
        import java.sql.SQLException;

//Sample.Main class which extends from Application Class
public class HelloApplication extends Application {

    //This is our PrimaryStage (It contains everything)
    private Stage primaryStage;

    //This is the BorderPane of RootLayout
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        //1) Declare a primary stage (Everything will be on this stage)
        this.primaryStage = primaryStage;

        //Optional: Set a title for primary stage
        this.primaryStage.setTitle("SW Test Academy - Sample JavaFX App");

        //2) Initialize RootLayout
        initRootLayout();

        //3) Display the EmployeeOperations View
        showEmployeeView();
    }

    //Initializes the root layout.
    public void initRootLayout() {
        try {
            //First, load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            //loader.setLocation(Main.class.getResource("/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            //Second, show the scene containing the root layout.
            Scene scene = new Scene(rootLayout); //We are sending rootLayout to the Scene.
            primaryStage.setScene(scene); //Set the scene in primary stage.

            /*//Give the Sample.controller access to the main.
            RootLayoutController Sample.controller = loader.getController();
            Sample.controller.setMain(this);*/

            //Third, show the primary stage
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Shows the employee operations Sample.view inside the root layout.
    public void showEmployeeView() {
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("gui.fxml"));
            AnchorPane employeeOperationsView = (AnchorPane) loader.load();

            // Set Employee Operations Sample.view into the center of root layout.
            rootLayout.setCenter(employeeOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //CarsDAO.updateCarEier("56608","Ben Dover");
        launch(args);
    }
}