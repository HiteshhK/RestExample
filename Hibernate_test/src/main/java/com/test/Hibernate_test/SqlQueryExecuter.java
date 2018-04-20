package com.test.Hibernate_test;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SqlQueryExecuter {
	private String elapsedTime = "";
	

	private String NumberOfExecution  = "";
	
	private String TotalWorkerTime = "";
	
	@Id
    private String derivedSqlId = "";
	
	private String DB = "";
	
	private String StartOffset = "";

	/**
	 * @return the elapsedTime
	 */
	public String getElapsedTime() {
		return elapsedTime;
	}

	/**
	 * @param elapsedTime the elapsedTime to set
	 */
	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	/**
	 * @return the numberOfExecution
	 */
	public String getNumberOfExecution() {
		return NumberOfExecution;
	}

	/**
	 * @param numberOfExecution the numberOfExecution to set
	 */
	public void setNumberOfExecution(String numberOfExecution) {
		NumberOfExecution = numberOfExecution;
	}

	/**
	 * @return the totalWorkerTime
	 */
	public String getTotalWorkerTime() {
		return TotalWorkerTime;
	}

	/**
	 * @param totalWorkerTime the totalWorkerTime to set
	 */
	public void setTotalWorkerTime(String totalWorkerTime) {
		TotalWorkerTime = totalWorkerTime;
	}

	/**
	 * @return the derivedSqlId
	 */
	public String getDerivedSqlId() {
		return derivedSqlId;
	}

	/**
	 * @param derivedSqlId the derivedSqlId to set
	 */
	public void setDerivedSqlId(String derivedSqlId) {
		this.derivedSqlId = derivedSqlId;
	}

	/**
	 * @return the dB
	 */
	public String getDB() {
		return DB;
	}

	/**
	 * @param dB the dB to set
	 */
	public void setDB(String dB) {
		DB = dB;
	}

	/**
	 * @return the startOffset
	 */
	public String getStartOffset() {
		return StartOffset;
	}

	/**
	 * @param startOffset the startOffset to set
	 */
	public void setStartOffset(String startOffset) {
		StartOffset = startOffset;
	}
	
}
