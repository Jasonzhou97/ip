package duke.main;
import duke.exception.DukeException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX main class that user interacts with
 */
public class Main extends Application {
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private Image userImage;
    private Image lebumImage;
    private Parser parser;
    private Lebum lebum;
    private Ui ui;

    @Override
    public void start(Stage stage) {
        lebum = new Lebum("data/tasks.txt");
        parser = new Parser();
        ui = new Ui();
        //load user image
        try {
            userImage = new Image(this.getClass().getResourceAsStream("/images/user.jpg"));
            lebumImage = new Image(this.getClass().getResourceAsStream("/images/lebum.jpeg"));
        }
        catch (Exception e) {
            System.out.println("Error uploading image");
        }
        // Set up UI components
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        dialogContainer.setPadding(new Insets(10));
        dialogContainer.setSpacing(10);

        scrollPane.setContent(dialogContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

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
        stage.setTitle("Lebum Chatbot");
        stage.setScene(scene);

        // Set up event handlers
        sendButton.setOnAction((event) -> handleInput());
        userInput.setOnAction((event) -> handleInput());

        // Show welcome message
        showMessage(ui.welcome(), false);
        stage.show();
    }

    private void handleInput() {
        String input = userInput.getText().trim();
        if (!input.isEmpty()) {
            showMessage("You: " + input, true);
        }
        try {
            String response = lebum.executeCommand(input);
            if (!response.equals("Oops")) {
                showMessage("Lebum: " + response, false);
            }
            else {
                showMessage("Error", false);
            }
        }
        catch (DukeException e) {
            showMessage("Oops something went wrong", false);
        }
        userInput.clear();
    }
    private void showMessage(String message, boolean isUser) {
        HBox messageBox = new HBox(10);
        messageBox.setPadding(new Insets(5));
        Label messageLabel = new Label(message);
        messageLabel.setWrapText(true);
        messageLabel.setMaxWidth(250);
        messageLabel.setPadding(new Insets(8));
        //image
        ImageView imageView = new ImageView(isUser ? userImage : lebumImage);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        imageView.setPreserveRatio(true);
        //style message
        String bubbleStyle = String.format(
                "-fx-background-color: %s; -fx-background-radius: 10;",
                isUser ? "#DCF8C6" : "#E8E8E8"
        );
        if (isUser) {
            messageBox.setAlignment(Pos.CENTER_RIGHT);
            messageBox.getChildren().addAll(messageLabel, imageView);
        } else {
            messageBox.setAlignment(Pos.CENTER_LEFT);
            messageBox.getChildren().addAll(imageView, messageLabel);
        }

        dialogContainer.getChildren().add(messageBox);

        // Auto-scroll to bottom
        scrollPane.setVvalue(1.0);
    }
}
