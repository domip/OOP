package ch.zhaw.domi.vorlesung.vorlesung_03_07_2012;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class RandomColor extends JPanel {


	
	public RandomColor() {
		
	}

	public void paintComponent(Graphics g){
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		int rot = (int) (Math.random() * 255);
		int grün = (int) (Math.random() * 255);
		int blau = (int) (Math.random() * 255);
		
		Color randomColor = new Color (rot, grün, blau);
		g.setColor(randomColor);
		g.fillOval(70, 70, 100, 100);
	}
	
}


