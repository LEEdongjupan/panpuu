package org.zerock.domain;

public class SampleVO {

	private String first;
	private String last;
	
	@Override
	public String toString() {
		return "SampleVO [first=" + first + ", last=" + last + "]";
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	
}
