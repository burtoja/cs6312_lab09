package edu.westga.cs6312.recursive.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.recursive.model.TestManager;

/**
 * Test the ReverseListWithRecursion method in the TestManager class
 * 
 * @author J. Allen Burton
 * @version Mar 6, 2020
 *
 */
public class TestManagerWhenReverseListWithRecursion {


	/**
	 * Test the reverseListWithRecursion by creating a TestManager object, adding three
	 * scores, and calling the reverseListWithRecursion()
	 * 
	 * ORIGINAL LIST ORDER: 22 33 44
	 * 
	 * EXPECT: 44 33 22
	 */
	@Test
	public void testReverseListWithRecursionExpect443322() {
		TestManager theTestManager = new TestManager();
		theTestManager.addTestScore(22);
		theTestManager.addTestScore(33);
		theTestManager.addTestScore(44);
		String report = theTestManager.reverseListWithRecursion();
		assertEquals("44 33 22 ", report);

	}

	/**
	 * Test the reverseListWithRecursion if no scores added by creating a TestManager
	 * object and calling the reverseListWithRecursion()
	 * 
	 * EXPECT: There are no current test scores
	 */
	@Test
	public void testReverseListWithRecursionNoScoresAdded() {
		TestManager theTestManager = new TestManager();
		String report = theTestManager.reverseListWithRecursion();
		assertEquals("There are no current test scores", report);

	}

	/**
	 * Test the reverseListWithRecursion if one score added by creating a TestManager
	 * object, adding one score, and calling the reverseListWithRecursion().  Add a score of 55.
	 * 
	 * EXPECT: 55
	 */
	@Test
	public void testReverseListWithRecursionSingleScoreAddedExpect55() {
		TestManager theTestManager = new TestManager();
		theTestManager.addTestScore(55);
		String report = theTestManager.reverseListWithRecursion();
		assertEquals("55 ", report);

	}

}
