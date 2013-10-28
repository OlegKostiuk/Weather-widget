package com.olegkostiuk.weatherwidget;

import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageJPanel extends JPanel {

	public void setImage(String imgSrcUrl) throws MalformedURLException {
		URL imageURL = new URL(imgSrcUrl);
		ImageIcon icon = new ImageIcon(imageURL);
		JLabel label = new JLabel(icon, JLabel.CENTER);
		add(label);
		//repaint();
	}

}
