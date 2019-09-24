package dad.javafx.CheckPalindrome;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindromeApp extends Application {
	private Label checkLabel;
	private Button checkButton;
	private TextField nombreText;
	boolean checkPalindrome(String inputString) {
		int largo=inputString.length();
		for(int i=0;i<=largo/2;i++){
		    if(inputString.charAt(i) != inputString.charAt(largo-1-i)){
		         return false; 
		    }        
		}
		    return true;
		}

	@Override
	public void start(Stage primaryStage) throws Exception {
		nombreText = new TextField();
		nombreText.setPrefColumnCount(5);
		nombreText.setPromptText("Introduce una palabra: ");
		nombreText.setMaxWidth(150);
		
		checkLabel = new Label();
		checkLabel.setText("Aquí saldrá la solución.");
		
		checkButton = new Button();
		checkButton.setText("Check");
		checkButton.setOnAction(e -> onCheckButtonAction(e));
		checkButton.setDefaultButton(true);

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(nombreText, checkButton, checkLabel);

		Scene escena = new Scene(root, 320, 200);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("Check Palindrome");
		primaryStage.show();

	}

	private void onCheckButtonAction(ActionEvent e) {
		String palabra = nombreText.getText();
		if(checkPalindrome(palabra)==true) {
			checkLabel.setText("la palabra "+palabra+" es palindrome");
			checkLabel.setStyle("-fx-text-fill: green; -fx-font: italic bold 30 sans-serif;");
		}else {
			checkLabel.setText("la palabra "+palabra+" no es palindrome");
			checkLabel.setStyle("-fx-text-fill: red; -fx-font: italic bold 30 sans-serif;");
		}
		
			
	}
	

	public static void main(String[] args) {
		launch(args);

	}

}
