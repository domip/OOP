package ch.zhaw.domi.uebungen.GUIProgrammieren1;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MeinErstesGUI {
	private JFrame frame;
	private JButton button;
	JMenu dateiMenu;
	JMenuItem oeffnenItem;
	JMenuItem beendenItem;
	private EntscheidungsKnopf randomGenerator;

	public MeinErstesGUI() {
		
		randomGenerator = new EntscheidungsKnopf();
		setRandomText();
		createFrame();
	}

	private void createFrame() {
		frame = new JFrame("Mein erstes GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = frame.getContentPane();
		//button = new JButton("Drück mich"); //Aufgabe 5
		button = new JButton("Was soll ich heute Abend tun?"); //Aufgabe 6
		button.addActionListener(new Buttontext());
		contentPane.add(button);
		
		//JLabel label = new JLabel("Ich bin ein Label");  // Aufgabe 2
		//frame.pack();   //wird so klein gemacht wie möglich.
		
		JMenuBar bar = new JMenuBar(); 
		frame.setJMenuBar(bar);
		dateiMenu = new JMenu("Datei"); 
		bar.add(dateiMenu);
		
		oeffnenItem = new JMenuItem("Öffnen"); 
		dateiMenu.add(oeffnenItem);
		oeffnenItem.addActionListener(new Oeffentext());
		
		beendenItem = new JMenuItem("Beenden"); 
		dateiMenu.add(beendenItem);
		beendenItem.addActionListener(new Beendentext());
		
		frame.setSize(300,300);
		frame.setVisible(true);
	}

	private void setRandomText(){
		randomGenerator.addTexttoList("Kino");
		randomGenerator.addTexttoList("Gamen");
		randomGenerator.addTexttoList("TV");
		randomGenerator.addTexttoList("Auto fahren");
		randomGenerator.addTexttoList("Pizza");
	}
	
	
	class Buttontext implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			//button.setText("Danke"); //Aufgabe 5
			//System.out.print("Ich wurde geklickt");
			
			button.setText(randomGenerator.RandomString());

		}
	}

	class Oeffentext implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			System.out.print("Öffnen geklickt");

		}
	}

	class Beendentext implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			System.out.print("Beenden gedrückt");
			System.exit(0);

		}
	}

}