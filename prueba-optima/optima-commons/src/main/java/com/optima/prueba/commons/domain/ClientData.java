package com.optima.prueba.commons.domain;

import java.util.Date;

public class ClientData {
	
	
	private String ip;
	private String longitude;
	private String latitude;
	private String deviceType;
	private Date dateCurrent;
	
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public Date getDateCurrent() {
		return dateCurrent;
	}
	public void setDateCurrent(Date dateCurrent) {
		this.dateCurrent = dateCurrent;
	}
	
	

}
