package duke.main;

import duke.exception.DukeException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import duke.command.Command;

/**
 * JavaFX main class that user interacts with
 */
public class Main extends Application {
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private Parser parser;
    private Duke duke;
    private Ui ui;

    @Override
    public void start(Stage stage) {
        duke = new Duke("data/tasks.txt");
        parser = new Parser();
        ui = new Ui();

        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        dialogContainer.setPadding(new Insets(10));
        dialogContainer.setSpacing(10);

        scrollPane.setContent(dialogContainer);
        scrollPane.setFitToWidth(true);

        userInput = new TextField();
        sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        // Set up layout constraints
        AnchorPane.setTopAnchor(scrollPane, 0.0);
        AnchorPane.setLeftAnchor(scrollPane, 0.0);
        AnchorPane.setRightAnchor(scrollPane, 0.0);
        AnchorPane.setBottomAnchor(scrollPane, 50.0);

        AnchorPane.setLeftAnchor(userInput, 10.0);
        AnchorPane.setRightAnchor(userInput, 70.0);
        AnchorPane.setBottomAnchor(userInput, 10.0);

        AnchorPane.setRightAnchor(sendButton, 10.0);
        AnchorPane.setBottomAnchor(sendButton, 10.0);

        scene = new Scene(mainLayout, 400, 600);
        stage.setTitle("Duke Chatbot");
        stage.setScene(scene);

        // Set up event handlers
        sendButton.setOnAction((event) -> handleInput());
        userInput.setOnAction((event) -> handleInput());

        showMessage(ui.welcome());
        stage.show();
    }

    private void handleInput() {
        String input = userInput.getText().trim();
        if (!input.isEmpty()) {
            showMessage("You: " + input);
        }
        try {
            boolean canRun = duke.executeCommand(input);
            if (canRun) {
                showMessage("Success");

            }
            else {
                showMessage("Error");
            }
        }
        catch (DukeException e) {
            showMessage("Oops something went wrong");
        }


    }
    private void showMessage(String message) {
        Label messageLabel = new Label(message);
        messageLabel.setWrapText(true);
        dialogContainer.getChildren().add(messageLabel);
    }
}