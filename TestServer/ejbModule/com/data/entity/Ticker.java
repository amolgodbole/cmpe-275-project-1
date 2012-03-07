package com.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import org.jboss.beans.metadata.api.annotations.NullValue;

import com.sun.istack.internal.Nullable;

@Entity
@Table(name="Ticker")
public class Ticker {

	private int number;
	private String ticker;
	private String company;
	private String sector;
	private String industry;
	private String country;
	private Float marketcap;
	
	
	@Id
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTicker() {
		return ticker;
	}
	
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(nullable=true)
	public Float getMarketcap() {
		return marketcap;
	}
	public void setMarketcap(Float marketcap) {
		this.marketcap = marketcap;
	}
	
	
}
