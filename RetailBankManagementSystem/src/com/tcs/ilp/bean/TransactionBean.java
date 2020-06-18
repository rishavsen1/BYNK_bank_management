package com.tcs.ilp.bean;

public class TransactionBean {
	private int sourceId;
	private int sourceAmt;
	private int targetId;
	private int targetAmt;
	
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public int getSourceAmt() {
		return sourceAmt;
	}
	public void setSourceAmt(int sourceAmt) {
		this.sourceAmt = sourceAmt;
	}
	public int getTargetId() {
		return targetId;
	}
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}
	public int getTargetAmt() {
		return targetAmt;
	}
	public void setTargetAmt(int targetAmt) {
		this.targetAmt = targetAmt;
	}
	
	
}
