package ch.zhaw.domi.uebungen.GUIProgrammieren3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MeinErstesGUI implements Serializable{
	private JFrame frame;
	private JTextField field;
	private JButton button;
	private JLabel label;
	private JMenu dateiMenu;
	private JMenuItem oeffnenItem;
	private JMenuItem beendenItem;
	private JMenuItem speichernItem;
	private JMenuItem ladenItem;
	private ArrayList<String> eingaben;
	private Random generator;

	public MeinErstesGUI() {

		createFrame();
		eingaben = new ArrayList<String>();
		generator = new Random();
	}

	public static void main(String[] args) {

		new MeinErstesGUI();
	}

	private void createFrame() {
		frame = new JFrame("Mein erstes GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);

		JButton savebutton = createSaveButton();

		field = new JTextField(10);
		field.requestFocus();

		button = new JButton("Was soll ich heute Abend tun?"); 
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				

				if (eingaben.isEmpty()) {

					System.out.println("Eingabe erforderlich!");

				} else {
					button.setText(RandomString());
				}
			}
		});
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
		oeffnenItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.print("Öffnen geklickt");

			}
		});


		speichernItem = new JMenuItem("speichern");
		dateiMenu.add(speichernItem);
		speichernItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				JFileChooser chooser = new JFileChooser();
				int yeswecansave = chooser.showSaveDialog(null);
				
				if (yeswecansave == chooser.APPROVE_OPTION) {
					
					
					try {
						ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(chooser.getSelectedFile()));
						os.writeObject(eingaben);
						os.close();
						System.out.println("Die Datei wurde gespeichert");
						
					} catch (IOException e) {
						
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Die Datei konnte nicht gespeichert werden");
					}
					
				}
				
			}
		});
		
		
		
		ladenItem = new JMenuItem("laden");
		dateiMenu.add(ladenItem);
		ladenItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooserr = new JFileChooser();
				int yeswecansaveagain = chooserr.showOpenDialog(null);
				
				if (yeswecansaveagain == chooserr.APPROVE_OPTION) {
					
					
					try {
						ObjectInputStream is = new ObjectInputStream(new FileInputStream(chooserr.getSelectedFile()));
						eingaben = (ArrayList<String>) is.readObject();
						is.close();
						
					} catch (IOException e1) {
						
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Die Datei konnte nicht geladen werden");
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		

		
		beendenItem = new JMenuItem("Beenden");
		dateiMenu.add(beendenItem);
		beendenItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				int eingabe = JOptionPane.showConfirmDialog(null,
						"Wirklich Beenden?", "Beenden",
						JOptionPane.YES_NO_OPTION);

				if (eingabe == JOptionPane.NO_OPTION) {
					return;
				}

				else {
					System.exit(0);
				}

			}
		});

		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	private JButton createSaveButton() {
		JButton savebutton = new JButton("save");
		savebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
				if (field.getText().isEmpty()) {

					System.out.println("Eingabe erforderlich!");

				}

				else if (eingaben.contains(field.getText())) {
					System.out.println("Eingabe schon vorhanden");
					field.requestFocus();
				}

				else {
					eingaben.add(field.getText());
					field.setText("");
					field.requestFocus();
				}

			}
		});
		return savebutton;
	}

	public String RandomString() {

		String randomText = eingaben.get(generator.nextInt(eingaben.size()));

		return randomText;
	}

}