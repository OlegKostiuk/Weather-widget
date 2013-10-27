package com.olegkostiuk.weatherwidget;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class CurrentWeatherFrame extends JFrame {

	private String[] defaultJLabelValues = { "Location: ", "N/A",
			"Temperature: ", "0", "Weather description: ", "N/A",
			"Wind speed: ", "0", "Humidity: ", "0" };
	private final String LOCATION = "Lviv";

	private JPanel contentPane;
	private JLabel[] currentWeatherLabels;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrentWeatherFrame frame = new CurrentWeatherFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CurrentWeatherFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(5, 2));
		setContentPane(contentPane);

		currentWeatherLabels = new JLabel[10];

		for (int i = 0; i < currentWeatherLabels.length; i++) {
			currentWeatherLabels[i] = new JLabel(defaultJLabelValues[i]);
			contentPane.add(currentWeatherLabels[i]);
		}

		updateCurrentWeather(LOCATION);

	}

	private void updateCurrentWeather(String location) {

		WeatherParser parser = new WeatherParser();
		Weather weather = parser.getCurentConditionForCity(location);

		currentWeatherLabels[1].setText(weather.getLocation());
		currentWeatherLabels[3].setText(weather.getTempC());
		currentWeatherLabels[5].setText(weather.getWeatherDesc());
		currentWeatherLabels[7].setText(weather.getWindspeedKmph());
		currentWeatherLabels[9].setText(weather.getHumidity());
	}
}
