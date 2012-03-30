package ch.zhaw.domi.uebungen.GUIProgrammieren2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MeinErstesGUI {
	private JFrame frame;
	private JButton savebutton;
	private JTextField field;
	private JPanel panel;
	private JButton button;
	private JLabel label;
	private JMenu dateiMenu;
	private JMenuItem oeffnenItem;
	private JMenuItem beendenItem;
	private ArrayList<String> eingaben;
	private Random generator;



	public MeinErstesGUI() {


		createFrame();
		eingaben = new ArrayList<String>();
		generator = new Random();
	}

	private void createFrame() {
		frame = new JFrame("Mein erstes GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);

		savebutton = new JButton("save");
		savebutton.addActionListener(new save());

		field = new JTextField(10);
		field.requestFocus();


		button = new JButton("Was soll ich heute Abend tun?"); // Aufgabe 6
		button.addActionListener(new Buttontext());
		frame.getContentPane().add(BorderLayout.CENTER, button);

		label = new JLabel("Tat:");
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		panel.add(label);
		panel.add(field);
		panel.add(savebutton);

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

		frame.setSize(500, 500);
		frame.setVisible(true);
	}


	public String RandomString() {

		String randomText = eingaben.get(generator.nextInt(eingaben.size()));

		return randomText;
	}

	class Buttontext implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			// button.setText("Danke"); //Aufgabe 5
			// System.out.print("Ich wurde geklickt");

			if (eingaben.isEmpty()) {

				System.out.println("Eingabe erforderlich!");

			} else {
				button.setText(RandomString());
			}
		}

	}

	class save implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			// button.setText("Danke"); //Aufgabe 5
			// System.out.print("Ich wurde geklickt");

			// button.setText(randomGenerator.RandomString()); //Aufgabe GUI 1

			if (field.getText().isEmpty()) {

				System.out.println("Eingabe erforderlich!");

			}

			if (eingaben.contains(field.getText())) {
				System.out.println("Eingabe schon vorhanden");
				field.requestFocus();
			}
			
			
			else {
				eingaben.add(field.getText());
				field.setText("");
				field.requestFocus();
			}

		}

	}

	
	
	class Oeffentext implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			System.out.print("Öffnen geklickt");

		}
	}

	class Beendentext implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			int eingabe = JOptionPane.showConfirmDialog(null,
                    "Wirklich Beenden?",
                    "Beenden",
                    JOptionPane.YES_NO_OPTION);
System.out.println(eingabe);
System.exit(0);
			


		}
	}

}