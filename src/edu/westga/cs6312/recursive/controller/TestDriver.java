package edu.westga.cs6312.recursive.controller;

import edu.westga.cs6312.recursive.model.TestManager;

/**
 * This class will serve to drive the Test Manager Application
 * 
 * @author J. Allen Burton
 * @version Mar 7, 2020
 *
 */
public class TestDriver {
	
	/**
	* This method is the entry point of the application
	*
	* @param args Command-line arguments, not used
	*/
	public static void main(String[] args) {
		TestManager userTestManager = new TestManager();
		userTestManager.run();
	}
}
