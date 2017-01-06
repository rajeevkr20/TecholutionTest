package com.test.techolution.util;

public class SatisfactionTime {

	private int index;
	private int satisfactionAmount;
	private int timeTaken;
	
	
	@Override
	public String toString() {
			return "index=" + index + ", satisfactionAmount=" + satisfactionAmount + ", timeTaken=" + timeTaken + "";
	}
	public int getSatisfactionAmount() {
		return satisfactionAmount;
	}
	public void setSatisfactionAmount(int satisfactionAmount) {
		this.satisfactionAmount = satisfactionAmount;
	}
	public int getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
