package com.test.techolution.comperator;

import java.util.Comparator;

import com.test.techolution.util.SatisfactionTime;

public class TimeTakenComperator implements Comparator<SatisfactionTime> {

	public int compare(SatisfactionTime o1, SatisfactionTime o2) {
		
		return o1.getTimeTaken() - o2.getTimeTaken();
	}

}
