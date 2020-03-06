package edu.westga.cs6312.recursive.model;

import java.util.ArrayList;

/**
 * This class will manage data and methods for test scores
 * 
 * @author J. Allen Burton
 * @version Mar 6, 2020
 *
 */
public class TestManager {
	private ArrayList<Integer> testScores;

	/**
	 * Constructor for TestManager object. This constructor sets up an ArrayList for
	 * managing the test scores
	 *
	 * @precondition none
	 *
	 * @postcondition new TestManager object created with initialized ArrayList
	 *                ready for integer scores
	 */
	public TestManager() {
		this.testScores = new ArrayList<Integer>();
	}
	
	/**
	 * This method adds an integer score to the list of test scores
	 * 
	 * @param scoreToAddToList	integer test score to be added to the object list
	 *
	 * @precondition	scoreToAddToList >=0 && scoreToAddToList <= 100
	 *
	 * @postcondition	the new test score is added to the list
	 */
	public void	addTestScore(int scoreToAddToList) {
		if (scoreToAddToList < 0) {
			throw new IllegalArgumentException("Test score must be a non-zero integer");
		}
		if (scoreToAddToList > 100) {
			throw new IllegalArgumentException("Test score cannot be greater than 100");
		}
		this.testScores.add(scoreToAddToList);
	}
	
	/**
	 * This method returns a String representation of the object data (test scores)
	 * 
	 * @return	String representation of the test scores held by the object
	 *
	 * @precondition	none
	 *
	 * @postcondition	no change to object
	 */
	@Override
	public String toString() {
		String report = "Current Test Scores:\n";
		if (this.testScores.size() == 0) {
			report += "\tThere are no current test scores";
		} else {
			for (int currentScore : this.testScores) {
				report += "\t" + currentScore + "\n";
			}
		}
		return report;
	}
}
