/**
 * 
 */
package com.request.data;

import java.io.Serializable;

/**
 * @author Nandish
 *
 */
public class RequestData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	//requestType can be realtime, historical, temporal, spatial
	private String requestType;
	private String startDate;
	private String EndDate;
	private String ticker;
	private String location;
	private String sector;
	private String industry;
	
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
