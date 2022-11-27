package com.example.g6brombrom;



import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.application.Platform;

import javafx.stage.Stage;

import static org.junit.jupiter.api.Assertions.*;

class HelloApplicationTest {



    @Test
    public void testA() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
              //  new JFXPanel(); // Initializes the JavaFx Platform
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        new HelloApplication().start(new Stage()); // Create and initialize your app.

                    }
                });
            }
        });
        thread.start();// Initialize the thread
        Thread.sleep(10000); // Time to use the app, with out this, the thread
        // will be killed before you can tell.
    }



    @Test
    void initRootLayout() {
    }

    @Test
    void showEmployeeView() {
    }

    @Test
    void main() {
    }
}