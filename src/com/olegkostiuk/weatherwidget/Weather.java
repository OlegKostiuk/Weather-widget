package com.olegkostiuk.weatherwidget;

public class Weather {
		
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getObservationTime() {
		return observationTime;
	}
	public void setObservationTime(String observationTime) {
		this.observationTime = observationTime;
	}
	public String getTempC() {
		return tempC;
	}
	public void setTempC(String tempC) {
		this.tempC = tempC;
	}
	public String getTempF() {
		return tempF;
	}
	public void setTempF(String tempF) {
		this.tempF = tempF;
	}
	public String getWeatherCode() {
		return weatherCode;
	}
	public void setWeatherCode(String weatherCode) {
		this.weatherCode = weatherCode;
	}
	public String getWeatherIconUrl() {
		return weatherIconUrl;
	}
	public void setWeatherIconUrl(String weatherIconUrl) {
		this.weatherIconUrl = weatherIconUrl;
	}
	public String getWeatherDesc() {
		return weatherDesc;
	}
	public void setWeatherDesc(String weatherDesc) {
		this.weatherDesc = weatherDesc;
	}
	public String getWindspeedMiles() {
		return windspeedMiles;
	}
	public void setWindspeedMiles(String windspeedMiles) {
		this.windspeedMiles = windspeedMiles;
	}
	public String getWindspeedKmph() {
		return windspeedKmph;
	}
	public void setWindspeedKmph(String windspeedKmph) {
		this.windspeedKmph = windspeedKmph;
	}
	public String getWinddirDegree() {
		return winddirDegree;
	}
	public void setWinddirDegree(String winddirDegree) {
		this.winddirDegree = winddirDegree;
	}
	public String getWinddir16Point() {
		return winddir16Point;
	}
	public void setWinddir16Point(String winddir16Point) {
		this.winddir16Point = winddir16Point;
	}
	public String getPrecipMM() {
		return precipMM;
	}
	public void setPrecipMM(String precipMM) {
		this.precipMM = precipMM;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getCloudcover() {
		return cloudcover;
	}
	public void setCloudcover(String cloudcover) {
		this.cloudcover = cloudcover;
	}
	
	@Override
	public String toString(){
		return "Weather is [ "+"Location: "+location+"; Weather description: "+weatherDesc+"; Temperature: "+tempC+"; Wind speed: "+windspeedKmph;
	}
	
	private String location;
	private String observationTime;
	private String tempC;
	private String tempF;
	private String weatherCode;
	private String weatherIconUrl;
	private String weatherDesc;
	private String windspeedMiles;
	private String windspeedKmph;
	private String winddirDegree;
	private String winddir16Point;
	private String precipMM;
	private String humidity;
	private String visibility;
	private String pressure;
	private String cloudcover;

}
