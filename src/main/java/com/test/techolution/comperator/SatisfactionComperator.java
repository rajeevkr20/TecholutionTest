package com.test.techolution.comperator;

import java.util.Comparator;

import com.test.techolution.util.SatisfactionTime;

/**
 * @author Rajeev
 *
 */
public class SatisfactionComperator implements Comparator<SatisfactionTime> {

	public int compare(SatisfactionTime o1, SatisfactionTime o2) {
		
		return o1.getSatisfactionAmount() - o2.getSatisfactionAmount();
	}

}
