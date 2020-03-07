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
	 * @param scoreToAddToList integer test score to be added to the object list
	 *
	 * @precondition scoreToAddToList >=0 && scoreToAddToList <= 100
	 *
	 * @postcondition the new test score is added to the list
	 */
	public void addTestScore(int scoreToAddToList) {
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
	 * in a single line
	 * 
	 * @return String representation of the test scores on single line separated by
	 *         single spaces
	 *
	 * @precondition none
	 *
	 * @postcondition no change to object
	 */
	@Override
	public String toString() {
		String report = "";
		if (this.testScores.size() == 0) {
			report += "There are no current test scores";
		} else {
			for (int currentScore : this.testScores) {
				report += currentScore + " ";
			}
		}
		return report;
	}

	/**
	 * This method will return a String of the test scores separated by single
	 * spaces in reverse order (using a loop).
	 * 
	 * @return single line of test scores separated by single spaces in reverse
	 *         order
	 *
	 * @precondition none
	 *
	 * @postcondition no change to object
	 */
	public String reverseListWithALoop() {
		String report = "";
		if (this.testScores.size() == 0) {
			report += "There are no current test scores";
		} else {
			for (int currentScore : this.testScores) {
				report = currentScore + " " + report;
			}
		}
		return report;
	}

	/**
	 * This method will return a String of the test scores separated by single
	 * spaces in reverse order (using recursion).
	 * 
	 * @return single line of test scores separated by single spaces in reverse
	 *         order
	 *
	 * @precondition none
	 *
	 * @postcondition no change to object
	 */
	public String reverseListWithRecursion() {
		String report = "";
		if (this.testScores.size() == 0) {
			report += "There are no current test scores";
		} else {
			report = this.reverseListHelper(this.testScores.size() - 1);
		}
		return report;
	}

	/**
	 * Helper method to recursively create a String representation of the test
	 * scores in reverse order
	 * 
	 * @param currentIndex
	 * 
	 * @return single line of test scores separated by single spaces in reverse
	 *         order
	 *
	 * @precondition currentIndex >= 0
	 *
	 * @postcondition no change to object
	 */
	private String reverseListHelper(int currentIndex) {
		String report = "";
		if (currentIndex == 0) {
			report = this.testScores.get(0) + " ";
		} else {
			report = this.testScores.get(currentIndex) + " " + this.reverseListHelper(currentIndex - 1);
		}
		return report;
	}
}
