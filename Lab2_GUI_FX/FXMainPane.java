


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	private Button buttonOne;
	private Button buttonTwo;
	private Button buttonThree;
	private Button buttonFour;
	private Button buttonFive;
	
	private Label messageOne;
	private TextField textField;
	//  declare two HBoxes
	private HBox hboxOne;
	private HBox hboxTwo;
	
	
	//student Task #4:
	//  declare an instance of DataManager
	private DataManager newManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		buttonOne = new Button("Hello");
		buttonTwo = new Button("Howdy");
		buttonThree = new Button("Chinese");
		buttonFour = new Button("Clear");
		buttonFive = new Button("Exit");
		
		messageOne = new Label("Feedback");
		textField = new TextField();
		//  instantiate the HBoxes
		hboxOne = new HBox();
		hboxTwo = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		newManager = new DataManager();
		//  set margins and set alignment of the components
		hboxOne.setAlignment(Pos.CENTER);
		hboxTwo.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hboxOne.getChildren().addAll(buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive);
		//  add the buttons to the other HBox
		hboxTwo.getChildren().addAll(messageOne, textField);
		//  add the HBoxes to this FXMainPanel (a VBox)
		this.getChildren().addAll(hboxOne, hboxTwo);
		
		
		ButtonHandler handler = new ButtonHandler();
		buttonOne.setOnAction(handler);
		buttonTwo.setOnAction(handler);
		buttonThree.setOnAction(handler);
		buttonFour.setOnAction(handler);
		buttonFive.setOnAction(handler);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			Object source = event.getTarget();
			if(source == buttonOne) {
				textField.setText(newManager.getHello());
			} else if(source == buttonTwo) {
				textField.setText(newManager.getHowdy());
			} else if (source == buttonThree) {
				textField.setText(newManager.getChinese());
			} else if (source == buttonFour) {
				textField.setText("");
			} else if (source == buttonFive) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	
