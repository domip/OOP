package ch.zhaw.domi.vorlesung.vorlesung_03_07_2012;

import java.awt.Container;

import javax.swing.JFrame;


public class ImageViewer {
	private JFrame frame;
	
	
	public ImageViewer() {
		createFrame();
	}
	
	

private void createFrame() {
	frame = new JFrame("ImageViewer");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container contentPane = frame.getContentPane();
	contentPane.add(new RandomColor());
	
	frame.setSize(600, 600);
	frame.setVisible(true);
}



}
