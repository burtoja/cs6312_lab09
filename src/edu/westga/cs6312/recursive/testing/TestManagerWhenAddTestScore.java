package edu.westga.cs6312.recursive.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.recursive.model.TestManager;

/**
 * Test the addTestScore method in the TestManager class
 * 
 * @author J. Allen Burton
 * @version Mar 6, 2020
 *
 */
public class TestManagerWhenAddTestScore {

	/**
	 * Test the addTestScore method by creating a new TestManager object, adding a
	 * test score of 55 and then calling the toString() method which should return
	 * the following:
	 * 
	 * Current Test Scores:\n\t55\n
	 */
	@Test
	public void testAddTestScoreAdd55() {
		TestManager theTestManager = new TestManager();
		theTestManager.addTestScore(55);
		String report = theTestManager.toString();
		assertEquals("Current Test Scores:\n\t55\n", report);
	}

	/**
	 * Test the addTestScore method by creating a new TestManager object, adding
	 * three test scores of 55, 79, 99 and then calling the toString() method which
	 * should return the following:
	 * 
	 * Current Test Scores:\n\t55\nt79\nt99\n
	 */
	@Test
	public void testAddTestScoreAddMultiple557999() {
		TestManager theTestManager = new TestManager();
		theTestManager.addTestScore(55);
		theTestManager.addTestScore(79);
		theTestManager.addTestScore(99);
		String report = theTestManager.toString();
		assertEquals("Current Test Scores:\n\t55\n\t79\n\t99\n", report);
	}
	
	/**
	 * Test the addTestScore method by creating a new TestManager object, adding
	 * a test score of 0 and then calling the toString() method which
	 * should return the following:
	 * 
	 * Current Test Scores:\n\t0\n
	 */
	@Test
	public void testAddTestScoreAddLowEnd0() {
		TestManager theTestManager = new TestManager();
		theTestManager.addTestScore(0);
		String report = theTestManager.toString();
		assertEquals("Current Test Scores:\n\t0\n", report);
	}
	
	/**
	 * Test the addTestScore method by creating a new TestManager object, adding
	 * a test score of 100 and then calling the toString() method which
	 * should return the following:
	 * 
	 * Current Test Scores:\n\t1000\n
	 */
	@Test
	public void testAddTestScoreAddTopEnd100() {
		TestManager theTestManager = new TestManager();
		theTestManager.addTestScore(100);
		String report = theTestManager.toString();
		assertEquals("Current Test Scores:\n\t100\n", report);
	}

}
