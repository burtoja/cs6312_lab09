package edu.westga.cs6312.recursive.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.recursive.model.TestManager;

/**
 * This will serve as a test of the TestManager class constructor and toString
 * method.
 * 
 * @author J. Allen Burton
 * @version Mar 6, 2020
 *
 */
public class TestManagerWhenCreateTestManager {

	/**
	 * Test the constructor and toString method by creating a new TestManager object
	 * and then calling the toString() method which should return the following:
	 * 
	 * Current Test Scores:\n\tThere are no current test scores
	 */
	@Test
	public void testCreateNewTestManager() {
		TestManager theTestManager = new TestManager();
		String report = theTestManager.toString();
		assertEquals("There are no current test scores", report);
	}
}
