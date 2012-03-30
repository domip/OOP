package ch.zhaw.domi.vorlesung.vorlesung_02_29_2012;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MeinErstesGUI {
	private JFrame frame;

	public MeinErstesGUI() {
		createFrame();
	}

	private void createFrame() {
		frame = new JFrame("Mein erstes GUI");
		createMenu();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		JLabel label = new JLabel("Ich bin ein Label");
		contentPane.add(label);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void createMenu(){
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		
		JMenu datei = new JMenu("Datei");
		bar.add(datei);
		
		JMenuItem oeffnen = new JMenuItem("šffnen");
		oeffnen.addActionListener(new OeffnenActionListener());
		datei.add(oeffnen);
		
		
		JMenuItem schliessen = new JMenuItem("schliessen");
		schliessen.addActionListener(new SchliessenActionListener());
		datei.add(schliessen);
		
		
	}
	
	private class OeffnenActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			System.out.println("šffnen geklickt");
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class SchliessenActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("schliessen geklickt");
			
			// TODO Auto-generated method stub
			
		}
		
	}
}