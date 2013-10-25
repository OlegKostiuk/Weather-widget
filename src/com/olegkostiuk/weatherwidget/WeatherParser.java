package com.olegkostiuk.weatherwidget;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherParser {

	public Weather getCurentConditionForSity(String location) {
		
		Weather currentWeather = new Weather();
		NodeList nl = null;
		try {
			URL url = new URL("http://api.worldweatheronline.com/free/v1/weather.ashx?q="+location+"&format=xml&fx=no&key=4ysvy8mc459skxg64a9zrbwk");
			Document doc;

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			InputStream is = con.getInputStream();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(is);
			doc.getDocumentElement().normalize();

			nl = doc.getElementsByTagName("data").item(0).getChildNodes();

		} catch (Exception e) {
			System.out.println("API error");
		}
		
		// parse part
		Node child = null;

		for (int i = 0; i < nl.getLength(); i++) {
			child = nl.item(i);

			if (child instanceof Element) {
				if (child.getNodeName().equals("request")) {
					NodeList childNodes = child.getChildNodes();

					for (int j = 0; j < childNodes.getLength(); j++) {
						if (childNodes.item(j).getNodeName().equals("query")) {
							currentWeather.setLocation(childNodes.item(j).getTextContent());
						}
					}

				}

				if (child.getNodeName().equals("current_condition")) {

					NodeList childNodes = child.getChildNodes();

					for (int j = 0; j < childNodes.getLength(); j++) {
						String textContent = childNodes.item(j).getTextContent();
						String nodeName = childNodes.item(j).getNodeName();
						
						if (nodeName.equals("observation_time")) {
							currentWeather.setObservationTime(textContent);
						}
						if (nodeName.equals("temp_C")) {
							currentWeather.setTempC(textContent);
						}
						if (nodeName.equals("temp_F")) {
							currentWeather.setTempF(textContent);
						}
						if (nodeName.equals("weatherCode")) {
							currentWeather.setWeatherCode(textContent);
						}
						if (nodeName.equals("weatherIconUrl")) {
							currentWeather.setWeatherIconUrl(textContent);
						}
						if (nodeName.equals("weatherDesc")) {
							currentWeather.setWeatherDesc(textContent);
						}
						if (nodeName.equals("windspeedMiles")) {
							currentWeather.setWindspeedMiles(textContent);
						}
						if (nodeName.equals("windspeedKmph")) {
							currentWeather.setWindspeedKmph(textContent);
						}
						if (nodeName.equals("winddirDegree")) {
							currentWeather.setWinddirDegree(textContent);
						}
						if (nodeName.equals("winddir16Point")) {
							currentWeather.setWinddir16Point(textContent);
						}
						if (nodeName.equals("precipMM")) {
							currentWeather.setPrecipMM(textContent);
						}
						if (nodeName.equals("humidity")) {
							currentWeather.setHumidity(textContent);
						}
						if (nodeName.equals("visibility")) {
							currentWeather.setVisibility(textContent);
						}
						if (nodeName.equals("pressure")) {
							currentWeather.setPressure(textContent);
						}
						if (nodeName.equals("cloudcover")) {
							currentWeather.setCloudcover(textContent);
						}
					}

				}
			}
		}
		
		return currentWeather;
	}

	public static void main(String[] args) {
		
		String weatherInCity = "Lviv";
		
		WeatherParser parse = new WeatherParser();
		System.out.println(parse.getCurentConditionForSity(weatherInCity));
	}

}
