import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox; 
import javafx.scene.layout.Background; 
import javafx.geometry.Pos; 
import javafx.scene.control.Button; 
import javafx.scene.layout.*;
import javafx.scene.control.TextField; 
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.geometry.Insets;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Slider; 
import javafx.beans.value.ChangeListener; 
import javafx.beans.value.ObservableValue;



public class testCoinSorterGUI extends Application{ //inherits from Application class to allow use of javaFX graphics

	public void start(Stage stage) {
		
		
		
		//creates an object from the program source code
		CoinSorterGUI testGUI = new CoinSorterGUI();
		
		
		
		//MAIN MENU:
		
		
		
		//creates a text style with a shadow effect
		DropShadow ds = new DropShadow();
		ds.setOffsetX(3.0);
		ds.setOffsetY(3.0);
		ds.setColor(Color.color(0.4f, 0.5f, 0.5f));
		ds.setRadius(5.0);
		
		
		
		//creates and styles the scene header text 
		Text t = new Text ();
		t.setEffect(ds);
		t.setCache(true);
		t.setX(10.0);
		t.setY(70.0);
		t.setFill(Color.AZURE);
		t.setText("Coin Sorter");
		t.setFont(Font.font(null, FontWeight.BOLD, 50));
		
		
		
		//creates and styles the main menu title
		Text menu = new Text ();
		menu.setFill(Color.WHITE);
		menu.setText("-Main Menu-");
		menu.setFont(Font.font(null, FontWeight.BOLD, 30));		
		
		
		
		//creates and styles the main menu option buttons
		Button mainOption1 = new Button("Coin Calculator");
		mainOption1.setPrefSize(200,50);
		Button mainOption2 = new Button("Multiple Coin Calculator");
		mainOption2.setPrefSize(200,50);
		Button mainOption3 = new Button("Print Coin List");
		mainOption3.setPrefSize(200,50);
		Button mainOption4 = new Button("Set Details");
		mainOption4.setPrefSize(200,50);
		Button mainOption5 = new Button("Display Program Configurations");
		mainOption5.setPrefSize(200,50);
		Button mainOption6 = new Button("Quit the Program");
		mainOption6.setPrefSize(200,50);
		
		
	
		//creates a flow pane template to make the layout of buttons responsive to window re-sizing
		FlowPane pane = new FlowPane();
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(10);
		pane.setHgap(5);
		pane.setStyle("-fx-background-color: #212F3C;");
		pane.setPadding(new Insets(30));
		pane.getChildren().addAll(mainOption1, mainOption2, mainOption3, mainOption4, mainOption5, mainOption6);
		
		
		
		//creates a vertical box to organise all scene nodes
		VBox mainBox = new VBox();
		mainBox.setStyle("-fx-background-color: #212F3C;");
		mainBox.setAlignment(Pos.TOP_CENTER);
		mainBox.getChildren().addAll(t, menu, pane);
		
		
		
		//creates the main scene and displays it
		Scene mainScene = new Scene(mainBox, 400, 550, Color.DARKSLATEGRAY);
		stage.setScene(mainScene);
		stage.setTitle("Coin Sorter");
		stage.show();
		
		
		
		//OPTION 1 COIN CALCULATOR:
		
		
		
		//creates and styles option 1 header (Coin Calculator)
		Text t1 = new Text ();
		t1.setEffect(ds);
		t1.setCache(true);
		t1.setX(10.0);
		t1.setY(70.0);
		t1.setFill(Color.AZURE);
		t1.setText("Coin Calculator");
		t1.setFont(Font.font(null, FontWeight.BOLD, 32));
		
		
		
		//creates and styles text instruction for user to input a coin type
		Text opt1instruct1 = new Text ();
		opt1instruct1 .setFill(Color.AZURE);
		opt1instruct1 .setText("Please enter the coin type (p) you wish to exchange:");
		opt1instruct1 .setTextAlignment(TextAlignment.CENTER);
		opt1instruct1 .setFont(Font.font(null, FontWeight.NORMAL, 18));
		
		
		
		//creates and styles a text field for users to enter a coin type (p)
		TextField enterCoinType = new TextField();
		enterCoinType.setMaxWidth(250); 
		enterCoinType.setText("Enter coin type"); 
		
		
		
		//creates and styles text instruction for user to input a total value (p)
		Text opt1instruct2 = new Text ();
		opt1instruct2 .setFill(Color.AZURE);
		opt1instruct2 .setText("Please select the total amount (p) you wish to exchange:");
		opt1instruct2 .setTextAlignment(TextAlignment.CENTER);
		opt1instruct2 .setFont(Font.font(null, FontWeight.NORMAL, 18));
		
		
		
		//creates and styles a label to display output of the Coin Calculator
		Label coinCalculatorLabel= new Label();
		coinCalculatorLabel.setTextFill(Color.DARKSLATEGRAY);
		coinCalculatorLabel.setFont(Font.font("Arial", 16)); 
		coinCalculatorLabel.setBackground(new Background(new BackgroundFill(Color.AZURE, new CornerRadii(5.0), new Insets(-8.0))));
		coinCalculatorLabel.setWrapText(true);
		coinCalculatorLabel.setMaxWidth(295);
				
				
				
		//creates calculate button for Coin Calculator
		Button opt1Enter= new Button();
		opt1Enter.setText("Calculate");

		
		
		//creates and initialises min and max values to use for slider
		double minSliderValue = testGUI.getMinCoinIn();
		double maxSliderValue = testGUI.getMaxCoinIn();
		double defaultSliderValue = testGUI.getMaxCoinIn();
		
		
		
		//creates and styles a label to display slider value
		Label slider1Label= new Label();
		slider1Label.setTextFill(Color.AZURE);
		slider1Label.setFont(Font.font("Arial", 16)); 
		slider1Label.setWrapText(true);
		slider1Label.setMaxWidth(295);
		
		
		
		//creates and styles a slider to take user input for total value
		Slider opt1TotalValueSlider = new Slider(minSliderValue, maxSliderValue, defaultSliderValue); 
		opt1TotalValueSlider.setMaxWidth(300);
		

		
		//collects user input from slider for use in calculation
		opt1TotalValueSlider.valueProperty().addListener( 
	             new ChangeListener<Number>() { 
	  
	            public void changed(ObservableValue <? extends Number >  
	                      observable, Number oldValue, Number newValue) 
	            { 
	  
	                slider1Label.setText("Value: " + newValue.intValue() + "p"); //displays current slider value to user
	                int enterCoinTotal = newValue.intValue(); //stores total value for use in calculation
	                
	                
	                
	              //sets action to be completed when coin calculator button is clicked
	        		opt1Enter.setOnAction(e -> 
	        		{
	        			try //try block to set button action when user input is in a valid format
	        			{
	        				int coinType = Integer.parseInt(enterCoinType.getText()); //retrieves user input and converts it to an integer
	        				
	        				
	        				
	        				testGUI.validateTotalValue(enterCoinTotal); //calls source code to validate user input for total value and update the attribute
	        		
	        				
	        				if(coinType < 1|| coinType > testGUI.getMaxCoinIn()) // checks coin type in is an expected value
	        				{
	        					
	        					coinCalculatorLabel.setText("Error. Invalid input.");
	        					
	        				}
	        				
	        				else {
	        					
	        			
	        				coinCalculatorLabel.setText(testGUI.coinCalculator(coinType)); //displays the output of coin calculator if user input was valid
	        				
	        				}
	        			}
	        			
	        			
	        			
	        			catch (NumberFormatException numExcep) //catch block to set button action when user input is in an invalid format
	        			{
	        				coinCalculatorLabel.setText("Error, please enter a coin type and total exchange value between: " + testGUI.getMinCoinIn() + " and "+ testGUI.getMaxCoinIn() + "p");
	        			}
	        		}
	        				);
	            } 
	        }); 
	
		
		
		//creates return to main menu button
		Button returnToMenu= new Button();
		returnToMenu.setText("Main Menu");
		returnToMenu.setOnAction(e -> stage.setScene(mainScene));
		
		
		
		//structures coin calculator nodes into vertical box
		VBox option1 = new VBox(20);
		option1.setBackground(Background.EMPTY);
		option1.setAlignment(Pos.TOP_CENTER);
		option1.getChildren().addAll(t1, opt1instruct1, enterCoinType, opt1instruct2, opt1TotalValueSlider, slider1Label, opt1Enter, coinCalculatorLabel, returnToMenu); 
		
		
		
		//creates a new scene for coin calculator
		Scene mainOption1Scene = new Scene(option1, 400, 550, Color.DARKSLATEGRAY);
		
		
		
		//adjusts text instructions for option 1 to always fit within window
		opt1instruct1.wrappingWidthProperty().bind(mainOption1Scene.widthProperty().subtract(15));
		opt1instruct2.wrappingWidthProperty().bind(mainOption1Scene.widthProperty().subtract(15));
		
		
	
		//sets coin calculator button on the main menu to open the coin calculator scene when clicked
		mainOption1.setOnAction(e -> stage.setScene(mainOption1Scene));
	
		
		
		//OPTION 2 MULTI COIN CALCULATOR
		
		
		
		//creates and styles option 2 header (Multi Coin Calculator)
		Text t2 = new Text ();
		t2.setEffect(ds);
		t2.setCache(true);
		t2.setX(10.0);
		t2.setY(70.0);
		t2.setFill(Color.AZURE);
		t2.setText("Multi Coin Calculator");
		t2.setFont(Font.font(null, FontWeight.BOLD, 32));
		
		
		
		//creates and styles text instruction for user to input excluded coin value (p)
		Text opt2instruct1 = new Text ();
		opt2instruct1 .setFill(Color.AZURE);
		opt2instruct1 .setText("Please a coin type (p) you wish to exclude from the calculation:");
		opt2instruct1 .setTextAlignment(TextAlignment.CENTER);
		opt2instruct1 .setFont(Font.font(null, FontWeight.NORMAL, 18));
		
		
		
		//creates and styles a text field for users to enter an excluded value (p)
		TextField enterExcludedCoinType = new TextField();
		enterExcludedCoinType.setMaxWidth(250); 
		enterExcludedCoinType.setText("Enter coin type to exclude"); 
		
		
		
		//creates and styles text instruction for user to input total value (p)
		Text opt2instruct2 = new Text ();
		opt2instruct2 .setFill(Color.AZURE);
		opt2instruct2 .setText("Please enter the total amount (p) you wish to exchange:");
		opt2instruct2 .setTextAlignment(TextAlignment.CENTER);
		opt2instruct2 .setFont(Font.font(null, FontWeight.NORMAL, 18));
		
		
		
		//creates and styles a text field for users to enter a total value (p)
		TextField enterMultiCoinTotal = new TextField();
		enterMultiCoinTotal.setMaxWidth(250); 
		enterMultiCoinTotal.setText("Enter total coins"); 
		
		
		
		//creates and styles a label to display output of the Multi Coin Calculator
		Label multiCoinCalculatorLabel= new Label();
		multiCoinCalculatorLabel.setTextFill(Color.DARKSLATEGRAY);
		multiCoinCalculatorLabel.setFont(Font.font("Arial", 16)); 
		multiCoinCalculatorLabel.setBackground(new Background(new BackgroundFill(Color.AZURE, new CornerRadii(5.0), new Insets(-8.0))));
		multiCoinCalculatorLabel.setWrapText(true);
		multiCoinCalculatorLabel.setMaxWidth(295);
		
		
		
		//creates calculate button for Multi Coin Calculator
		Button opt2Enter= new Button();
		opt2Enter.setText("Calculate");
		
		
		
		//sets action for Multi Coin Calculator button when clicked
		opt2Enter.setOnAction(e -> 
		{
			try //try block to set button action when user input is in a valid format
			{
				int enterCoinTypeMulti = Integer.parseInt(enterExcludedCoinType.getText()); //converts user input for excluded coin type to integer
				int enterTotalCoin = Integer.parseInt(enterMultiCoinTotal.getText()); //converts user input for total value to integer
		
				int validateTotal = testGUI.validateTotalValue(enterTotalCoin); //validates total value is within min-max range
				int validateExcludedCoin = testGUI.validateExcludedCoin(enterCoinTypeMulti); //validates excluded coin type is in circulation
		
				if(validateTotal == -1) 
				{
					multiCoinCalculatorLabel.setText("Error, please enter a total exchange value between: " + testGUI.getMinCoinIn() + " and "+ testGUI.getMaxCoinIn() + "p");
				}
		
				else if(validateExcludedCoin == -1) 
				{
					multiCoinCalculatorLabel.setText("Error. " + testGUI.printCoinList() + "p");
				}
				
				else 
				{
					multiCoinCalculatorLabel.setText(testGUI.coinCalculator(enterCoinTypeMulti));
				}
				}
			
			catch (NumberFormatException numExcep) //catch block to set button action when user input is in an invalid format
			{
				multiCoinCalculatorLabel.setText("Error. Invalid input");
			}
			}
		);
		
		
		
		//creates return to main menu button
		Button returnToMenu2= new Button();
		returnToMenu2.setText("Main Menu");
		returnToMenu2.setOnAction(e -> stage.setScene(mainScene));
		
		
		
		//structures contents of coin calculator into vertical box
		VBox option2 = new VBox(20);
		option2.setBackground(Background.EMPTY);
		option2.setAlignment(Pos.TOP_CENTER);
		option2.getChildren().addAll(t2, opt2instruct1, enterExcludedCoinType, opt2instruct2, enterMultiCoinTotal, opt2Enter, multiCoinCalculatorLabel, returnToMenu2); 
		
		
		
		//creates scene for option 2 Multi Coin Calulator
		Scene mainOption2Scene = new Scene(option2, 400, 550, Color.DARKSLATEGRAY);		
		
		
		
		//adjusts text instructions for option 1 to always fit within window
		opt2instruct1.wrappingWidthProperty().bind(mainOption2Scene.widthProperty().subtract(15));
		opt2instruct2.wrappingWidthProperty().bind(mainOption2Scene.widthProperty().subtract(15));
		
		
		
		//sets multi coin calculator button on the main menu to open the coin calculator scene when clicked
		mainOption2.setOnAction(e -> stage.setScene(mainOption2Scene));
		
		
		
		//OPTION 3 DISPLAY COIN LIST
		
		
		
		//creates and styles option 3 header (Coin List)
		Text t3 = new Text ();
		t3.setEffect(ds);
		t3.setCache(true);
		t3.setX(10.0);
		t3.setY(70.0);
		t3.setFill(Color.AZURE);
		t3.setText("Coin List");
		t3.setFont(Font.font(null, FontWeight.BOLD, 32));
		
		
		
		//sets and styles textual message informing which coin types are currently in circulation
		Text opt3instruct1 = new Text ();
		opt3instruct1.setFill(Color.AZURE);
		opt3instruct1.setTextAlignment(TextAlignment.CENTER);
		opt3instruct1.setText(testGUI.printCoinList());
		opt3instruct1.setFont(Font.font(null, FontWeight.NORMAL, 18));
		
		
		
		//creates return to main menu button 
		Button returnToMenu3= new Button();
		returnToMenu3.setText("Main Menu");
		returnToMenu3.setOnAction(e -> stage.setScene(mainScene));
		
		
		
		//structures contents of display coin list into vertical box
		VBox option3 = new VBox(20);
		option3.setBackground(Background.EMPTY);
		option3.setAlignment(Pos.TOP_CENTER);
		option3.getChildren().addAll(t3, opt3instruct1, returnToMenu3); 
		
		
		
		//creates a scene for option 3 Coin List
		Scene mainOption3Scene = new Scene(option3, 400, 550, Color.DARKSLATEGRAY);
		opt3instruct1.wrappingWidthProperty().bind(mainOption3Scene.widthProperty().subtract(15));
		
		
		
		//sets coin list button on the main menu to open the coin list scene when clicked
		mainOption3.setOnAction(e -> stage.setScene(mainOption3Scene));
		
		
		
		//OPTION 4 SET DETAILS
		
		
		
		//creates and styles option 4 header (Set Details) 
		Text t4 = new Text ();
		t4.setEffect(ds);
		t4.setCache(true);
		t4.setX(10.0);
		t4.setY(70.0);
		t4.setFill(Color.AZURE);
		t4.setText("Set Details");
		t4.setFont(Font.font(null, FontWeight.BOLD, 32));	
		
		
		Text t4c1 = new Text ();
		t4c1.setEffect(ds);
		t4c1.setCache(true);
		t4c1.setX(10.0);
		t4c1.setY(70.0);
		t4c1.setFill(Color.AZURE);
		t4c1.setText("Set Details");
		t4c1.setFont(Font.font(null, FontWeight.BOLD, 32));	
		
		
		
		Text t4c2 = new Text ();
		t4c2.setEffect(ds);
		t4c2.setCache(true);
		t4c2.setX(10.0);
		t4c2.setY(70.0);
		t4c2.setFill(Color.AZURE);
		t4c2.setText("Set Details");
		t4c2.setFont(Font.font(null, FontWeight.BOLD, 32));	
		
		
		Text t4c3 = new Text ();
		t4c3.setEffect(ds);
		t4c3.setCache(true);
		t4c3.setX(10.0);
		t4c3.setY(70.0);
		t4c3.setFill(Color.AZURE);
		t4c3.setText("Set Details");
		t4c3.setFont(Font.font(null, FontWeight.BOLD, 32));	

		
		
		//creates split menu button for sub menu 4
		SplitMenuButton subMenu4 = new SplitMenuButton();
		subMenu4.setText("Set value...");
		
		MenuItem choice1 = new MenuItem("Currency");
		MenuItem choice2 = new MenuItem("Minimum total value");
		MenuItem choice3 = new MenuItem("Maximum total value");

		
		
		//creates and styles text instruction for user to input currency
		Text opt4instruct1 = new Text ();
		opt4instruct1 .setFill(Color.AZURE);
		opt4instruct1 .setText("Set currency: ");
		opt4instruct1 .setTextAlignment(TextAlignment.CENTER);
		opt4instruct1 .setFont(Font.font(null, FontWeight.NORMAL, 18));
		
		
		
		//creates and styles a text field for users to enter currency
		TextField enterCurrency = new TextField();
		enterCurrency.setMaxWidth(250); 
		enterCurrency.setText("Enter currency"); 
		
		
		
		//creates and styles a label to display output of set currency
		Label setCurrencyLabel= new Label();
		setCurrencyLabel.setTextFill(Color.DARKSLATEGRAY);
		setCurrencyLabel.setFont(Font.font("Arial", 16)); 
		setCurrencyLabel.setBackground(new Background(new BackgroundFill(Color.AZURE, new CornerRadii(5.0), new Insets(-8.0))));
		setCurrencyLabel.setWrapText(true);
		setCurrencyLabel.setMaxWidth(295);
		
		
		
		//creates enter button for set currency
		Button opt4EnterCurrency= new Button();
		opt4EnterCurrency.setText("Enter");
		
		opt4EnterCurrency.setOnAction(e -> 
		{
			testGUI.setCurrency(enterCurrency.getText());
			setCurrencyLabel.setText("Currency set to: " + testGUI.getCurrency());
		}
		);
		
		
		
		//creates and styles text instruction for user to input minimum total value (p)
		Text opt4instruct2 = new Text ();
		opt4instruct2 .setFill(Color.AZURE);
		opt4instruct2 .setText("Set minimum total input value (p): ");
		opt4instruct2 .setTextAlignment(TextAlignment.CENTER);
		opt4instruct2 .setFont(Font.font(null, FontWeight.NORMAL, 18));
		
		
		
		//creates and styles a text field for users to enter min total value
		TextField enterMinValue = new TextField();
		enterMinValue.setMaxWidth(250); 
		enterMinValue.setText("Enter minimum total input value (p)"); 
		
		
		
		//creates and styles a label to display output of set min value
		Label setMinLabel= new Label();
		setMinLabel.setTextFill(Color.DARKSLATEGRAY);
		setMinLabel.setFont(Font.font("Arial", 16)); 
		setMinLabel.setBackground(new Background(new BackgroundFill(Color.AZURE, new CornerRadii(5.0), new Insets(-8.0))));
		setMinLabel.setWrapText(true);
		setMinLabel.setMaxWidth(295);
		
		
		
		//creates enter button for set min value
		Button opt4EnterMin= new Button();
		opt4EnterMin.setText("Enter");
		opt4EnterMin.setOnAction(e -> 
		{
			try //try block to set button action when user input is in a valid format
			{
			int minCoin = Integer.parseInt(enterMinValue.getText());
			testGUI.setMinCoinIn(minCoin);
			setMinLabel.setText("Minimum value set to: " + testGUI.getMinCoinIn() + "p");
			}
			catch (NumberFormatException numExcep) //catch block to set button action when user input is in an invalid format
			{
				setMinLabel.setText("Error. Invalid input.");
			}
		}
		);
		
		
		
		//creates and styles text instruction for user to input maximum total value (p)
		Text opt4instruct3 = new Text ();
		opt4instruct3 .setFill(Color.AZURE);
		opt4instruct3 .setText("Set maximum total input value (p): ");
		opt4instruct3 .setTextAlignment(TextAlignment.CENTER);
		opt4instruct3 .setFont(Font.font(null, FontWeight.NORMAL, 18));
		
		
		
		//creates and styles a text field for users to enter max total value
		TextField enterMaxValue = new TextField();
		enterMaxValue.setMaxWidth(250); 
		enterMaxValue.setText("Enter maximum total input value (p)"); 
		
		
		
		//creates and styles a label to display output of set max value
		Label setMaxLabel= new Label();
		setMaxLabel.setTextFill(Color.DARKSLATEGRAY);
		setMaxLabel.setFont(Font.font("Arial", 16)); 
		setMaxLabel.setBackground(new Background(new BackgroundFill(Color.AZURE, new CornerRadii(5.0), new Insets(-8.0))));
		setMaxLabel.setWrapText(true);
		setMaxLabel.setMaxWidth(295);
		
		
		
		//creates enter button for set min value
		Button opt4EnterMax= new Button();
		opt4EnterMax.setText("Enter");
		opt4EnterMax.setOnAction(e -> 
		{
			try //try block to set button action when user input is in a valid format
			{
			int maxCoin = Integer.parseInt(enterMaxValue.getText());
			testGUI.setMaxCoinIn(maxCoin);
			setMaxLabel.setText("Maximum value set to: " + testGUI.getMaxCoinIn() + "p");
			}
			catch (NumberFormatException numExcep) //catch block to set button action when user input is in an invalid format
			{
				setMaxLabel.setText("Error. Invalid input.");
			}
		}
		);
		
		
		
		//creates return to main menu buttons for all sub options
		Button returnToMenu4= new Button();
		returnToMenu4.setText("Main Menu");
		returnToMenu4.setOnAction(e -> stage.setScene(mainScene));
		

		Button returnToMenu4Choice1= new Button();
		returnToMenu4Choice1.setText("Main Menu");
		returnToMenu4Choice1.setOnAction(e -> stage.setScene(mainScene));
		
		
		Button returnToMenu4Choice2= new Button();
		returnToMenu4Choice2.setText("Main Menu");
		returnToMenu4Choice2.setOnAction(e -> stage.setScene(mainScene));
		
		
		Button returnToMenu4Choice3= new Button();
		returnToMenu4Choice3.setText("Main Menu");
		returnToMenu4Choice3.setOnAction(e -> stage.setScene(mainScene));		
		
		
		//creates vertical boxes to organise nodes for option 4 (set detail) scenes
		VBox option4 = new VBox(20);
		option4.setBackground(Background.EMPTY);
		option4.setAlignment(Pos.TOP_CENTER);
		option4.getChildren().addAll(t4, subMenu4, returnToMenu4); 
		
		
		VBox option4Choice1 = new VBox(20);
		option4Choice1.setBackground(Background.EMPTY);
		option4Choice1.setAlignment(Pos.TOP_CENTER);
		option4Choice1.getChildren().addAll (t4c1, opt4instruct1, enterCurrency, opt4EnterCurrency, setCurrencyLabel, returnToMenu4Choice1);
		
		
		
		VBox option4Choice2 = new VBox(20);
		option4Choice2.setBackground(Background.EMPTY);
		option4Choice2.setAlignment(Pos.TOP_CENTER);
		option4Choice2.getChildren().addAll(t4c2, opt4instruct2, enterMinValue, opt4EnterMin, setMinLabel, returnToMenu4Choice2);
		
		
		
		VBox option4Choice3 = new VBox(20);
		option4Choice3.setBackground(Background.EMPTY);
		option4Choice3.setAlignment(Pos.TOP_CENTER);
		option4Choice3.getChildren().addAll(t4c3, opt4instruct3, enterMaxValue, opt4EnterMax, setMaxLabel, returnToMenu4Choice3);
		
		
		//creates set details scene
		Scene mainOption4Scene = new Scene(option4, 400, 550, Color.DARKSLATEGRAY);
		Scene subOption1Scene = new Scene(option4Choice1, 400, 550, Color.DARKSLATEGRAY);
		Scene subOption2Scene = new Scene(option4Choice2, 400, 550, Color.DARKSLATEGRAY);
		Scene subOption3Scene = new Scene(option4Choice3, 400, 550, Color.DARKSLATEGRAY);
		
		
		//adjusts text instructions for option 4 to always fit within window
		opt4instruct1.wrappingWidthProperty().bind(subOption1Scene.widthProperty().subtract(15));
		opt4instruct2.wrappingWidthProperty().bind(subOption2Scene.widthProperty().subtract(15));
		opt4instruct3.wrappingWidthProperty().bind(subOption3Scene.widthProperty().subtract(15));
	
		
		
		//adds choices to the drop down sub menu for option 4
		subMenu4.getItems().addAll(choice1, choice2, choice3);
		
		
		
		//sets actions for sub menu choices, opening the relevant scenes
		choice1.setOnAction((e)-> {
		   
			stage.setScene(subOption1Scene);
			
		});
		
		choice2.setOnAction((e)-> {

			stage.setScene(subOption2Scene);

		});
		
		choice3.setOnAction((e)-> {
		    
			stage.setScene(subOption3Scene);
			
		});
		
		
		
		//sets set details button on the main menu to open the set details scene when clicked
		mainOption4.setOnAction(e -> stage.setScene(mainOption4Scene));
		
		
		
		//OPTION 5 DISPLAY PROGRAM CONFIGURATIONS
		
		

		//sets header for option 5 (Program Configurations)
		Text t5 = new Text ();
		t5.setEffect(ds);
		t5.setCache(true);
		t5.setX(10.0);
		t5.setY(70.0);
		t5.setFill(Color.AZURE);
		t5.setText("Program Configurations");
		t5.setFont(Font.font(null, FontWeight.BOLD, 32));
				
		
		
		//sets and styles textual message informing of program configurations
		Text opt5instruct1 = new Text ();
		opt5instruct1 .setFill(Color.AZURE);
		opt5instruct1 .setText("Here are the current program configurations: " + testGUI.displayProgramConfigs());
		opt5instruct1 .setTextAlignment(TextAlignment.CENTER);
		opt5instruct1 .setFont(Font.font(null, FontWeight.NORMAL, 18));
		
		
		
		//creates return to menu button
		Button returnToMenu5= new Button();
		returnToMenu5.setText("Main Menu");
		returnToMenu5.setOnAction(e -> stage.setScene(mainScene));
		
		
		
		//structures contents of program configurations into vertical box
		VBox option5 = new VBox(20);
		option5.setBackground(Background.EMPTY);
		option5.setAlignment(Pos.TOP_CENTER);
		option5.getChildren().addAll(t5, opt5instruct1, returnToMenu5); 
		
		
		
		//creates scene for option 5 
		Scene mainOption5Scene = new Scene(option5, 400, 550, Color.DARKSLATEGRAY);		
		
		
		
		//adjusts text instructions for option 5 to always fit within window
		opt5instruct1.wrappingWidthProperty().bind(mainOption5Scene.widthProperty().subtract(15));
		
		
		
		//sets program configurations button on the main menu to open the program configuration scene when clicked
		mainOption5.setOnAction(e -> stage.setScene(mainOption5Scene));
		
		
		
		//OPTION 6 QUIT THE PROGRAM
		
		
		
		//sets option 6 button on main menu to quit the program on button click
		mainOption6.setOnAction(e -> stage.close());
	
		
		
	}
	
		
	
	public static void main(String[] args)     
	 {         
		 launch(args);     //launches the program
	 }
	
}
