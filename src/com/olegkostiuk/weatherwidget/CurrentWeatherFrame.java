package com.olegkostiuk.weatherwidget;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class CurrentWeatherFrame extends JFrame {

	private String[] defaultJLabelValues = { "Wind speed: ", "0", "Pressure: ",
			"0", "Cloudcover: ", "N/A", "Visibility: ", "0", "Humidity: ", "0" };
	private final String LOCATION = "Lviv";
	private final Color GREEN_LABEL = new Color( 146, 167, 59);
	private final Color GRAY_LABEL = new Color(130, 130, 130);
	
	
	private JPanel contentPane;
	private JPanel mainInformationPanel;
	private JPanel mainTextInformation;
	private ImageJPanel imagePanel;
	private JPanel additionalInformation;
	private JLabel locationLabel;
	private JLabel temperatureLabel;
	private JLabel descriptionLabel;
	private JLabel[] currentWeatherAdditionalLabels;

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
		setBounds(100, 100, 300, 180);
		setMinimumSize(new Dimension(300,180));
		setTitle("Weather");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(2, 1));
		setContentPane(contentPane);
		
		// set system look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mainInformationPanel = new JPanel();
		mainInformationPanel.setLayout(new GridLayout(1, 2));

		imagePanel = new ImageJPanel();

		mainTextInformation = new JPanel();
		mainTextInformation.setLayout(new GridLayout(3, 1));

		locationLabel = new JLabel();
		locationLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		locationLabel.setHorizontalAlignment(JLabel.CENTER);

		temperatureLabel = new JLabel();
		
		temperatureLabel.setHorizontalAlignment(JLabel.CENTER);

		descriptionLabel = new JLabel();
		descriptionLabel.setHorizontalAlignment(JLabel.CENTER);

		mainTextInformation.add(locationLabel);
		mainTextInformation.add(temperatureLabel);
		mainTextInformation.add(descriptionLabel);

		mainInformationPanel.add(imagePanel);
		mainInformationPanel.add(mainTextInformation);

		additionalInformation = new JPanel();
		additionalInformation.setLayout(new GridLayout(5, 2));

		currentWeatherAdditionalLabels = new JLabel[10];

		for (int i = 0; i < currentWeatherAdditionalLabels.length; i++) {
			currentWeatherAdditionalLabels[i] = new JLabel(defaultJLabelValues[i]);
			additionalInformation.add(currentWeatherAdditionalLabels[i]);

			// set green color for field name, and grey for field values 
			if (i % 2 == 0) {	
				currentWeatherAdditionalLabels[i].setForeground(GREEN_LABEL);
			} else {
				currentWeatherAdditionalLabels[i].setForeground(GRAY_LABEL);
			}
		}

		contentPane.add(mainInformationPanel);
		contentPane.add(additionalInformation);

		updateCurrentWeather(LOCATION);

	}

	private void updateCurrentWeather(String location) {

		WeatherParser parser = new WeatherParser();
		Weather weather = parser.getCurentConditionForCity(location);

		try {
			imagePanel.setImage(weather.getWeatherIconUrl());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		locationLabel.setText(weather.getLocation());
		temperatureLabel.setText(weather.getTempC() + " °C");
		descriptionLabel.setText(weather.getWeatherDesc());

		currentWeatherAdditionalLabels[1].setText(weather.getWindspeedKmph()
				+ " kmph");
		currentWeatherAdditionalLabels[3]
				.setText(weather.getPressure() + " mb");
		currentWeatherAdditionalLabels[5].setText(weather.getCloudcover()
				+ " %");
		currentWeatherAdditionalLabels[7].setText(weather.getVisibility()
				+ " km");
		currentWeatherAdditionalLabels[9].setText(weather.getHumidity() + " %");
		
		setTitle(weather.getLocation()+" " + weather.getWeatherDesc()+" "+weather.getTempC()+" °C");
	}
}
