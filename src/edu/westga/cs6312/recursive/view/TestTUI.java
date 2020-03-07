package edu.westga.cs6312.recursive.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.westga.cs6312.recursive.model.TestManager;

/**
 * This class will serve as the TUI for the Test Manager Application. It will
 * present the user with a series of options to choose from a manage the
 * processing of those requests.
 * 
 * @author J. Allen Burton
 * @version Mar 7, 2020
 *
 */
public class TestTUI {
	private Scanner input;
	private TestManager userTestManager;

	/**
	 * Constructor for TestTUI objects which takes a TestManager object.
	 *
	 * @param userTestManager a TestManager object ready to be used to manage the
	 *                        test score data
	 *
	 * @precondition userTestManager != null
	 *
	 * @postcondition new TestTUI created with TestManager object and Scanner object
	 *                instantiated
	 */
	public TestTUI(TestManager userTestManager) {
		if (userTestManager == null) {
			throw new IllegalArgumentException("Parameter cannot be null");
		}
		this.userTestManager = userTestManager;
		this.input = new Scanner(System.in);
	}

	/**
	 * This method serves as the director of the user interface
	 *
	 * @precondition none
	 *
	 * @postcondition changes to the object dictated by private methods within this
	 *                method
	 */
	public void run() {
		System.out.println("Welcome to the Test Score Manager Application.");
		int userChoice;
		do {
			this.displayMenu();
			userChoice = this.getIntegerFromUser("Please enter your choice from the menu: ");
			switch (userChoice) {
				case 1:
					System.out.println("Please type the name of the test score file: ");
					String fileName = this.input.nextLine();
					this.addTestScoreFromFile(fileName);
					break;
				case 2:
					this.displayOriginalScores();
					break;
				case 3:
					this.displayLoopReversedTestScores();
					break;
				case 4:
					this.displayRecursiveReversedTestScores();
					break;
				case 5:
					break;
				default:
					System.out.println("Invalid menu choice. Please choose from the following options:");
			}
		} while (userChoice != 5);
		System.out.println("Thank you for using the Test Manager Application.");
	}

	/**
	 * This method will display the menu of choices for the user
	 *
	 * @precondition none
	 *
	 * @postcondition displayed menu to console
	 */
	private void displayMenu() {
		System.out.println("\n\t----------------------------------------------------------");
		System.out.println("\t| 1 - Add test scores from a file                        |");
		System.out.println("\t| 2 - Display original test scores on console            |");
		System.out.println("\t| 3 - Display loop-reversed test scores on console       |");
		System.out.println("\t| 4 - Display recursive-reversed test scores on console  |");
		System.out.println("\t| 5 - Quit                                               |");
		System.out.println("\t----------------------------------------------------------");
	}

	/**
	 * This method displays the message provided in the parameter, reads the user
	 * input, and returns the integer provided by the user.
	 * 
	 * @return integer value provided by the user
	 *
	 * @precondition none
	 *
	 * @postcondition integer returned corresponding to user input
	 */
	private int getIntegerFromUser(String message) {
		String input = "";
		int userInteger = 0;
		boolean isValid = false;
		do {
			try {
				System.out.println(message);
				input = this.input.nextLine();
				userInteger = Integer.parseInt(input);
				isValid = true;
			} catch (NumberFormatException nfe) {
				System.out.println("Your entry (" + input + ") was not a valid integer.  Please try again.");
			}
		} while (!isValid);
		return userInteger;
	}

	/**
	 * This method will prompt the user to input a file name. It will then open and
	 * read the file adding test scores into the TestManager object as appropriate.
	 * 
	 * @param fileName the name of the file
	 * 
	 * @precondition fileName must be a valid file with a list of test scores (one
	 *               on each line)
	 *
	 * @postcondition the userTestManager object will have the test scores added to
	 *                it
	 */
	private void addTestScoreFromFile(String fileName) {
		File userFile = new File(fileName);
		Scanner inFile = null;
		try {
			inFile = new Scanner(userFile);
			System.out.println("Test Scores read: ");
			while (inFile.hasNext()) {
				String input = inFile.nextLine();
				try {
					this.userTestManager.addTestScore(Integer.parseInt(input));
					System.out.println("Testscore read: " + input);
				} catch (IllegalArgumentException iae) {
					System.out.println("Error reading score: " + input + " (Score not added)");
				}
			}
			inFile.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Data file does not exist.  Returning to main menu.");
		} catch (NoSuchElementException nsee) {
			System.out.println("Read past the end of the file.");
			inFile.close();
		}
	}

	/**
	 * This method displays the test scores currently in the application in the
	 * original order
	 *
	 * @precondition none
	 *
	 * @postcondition no change to object
	 */
	private void displayOriginalScores() {
		System.out.println("The original test scores are:\n" + this.userTestManager.toString());
	}
	
	/**
	 * This method displays the test scores currently in the application in the
	 * reverse order through using a looping structure
	 *
	 * @precondition none
	 *
	 * @postcondition no change to object
	 */
	private void displayLoopReversedTestScores() {
		System.out.println("The loop-reversed test scores are:\n" + this.userTestManager.reverseListWithALoop());
	}
	
	/**
	 * This method displays the test scores currently in the application in the
	 * reverse order through using a recursive approach
	 * 
	 * @precondition none
	 *
	 * @postcondition no change to object
	 */
	private void displayRecursiveReversedTestScores() {
		System.out.println("The loop-reversed test scores are:\n" + this.userTestManager.reverseListWithRecursion());
	}
}
