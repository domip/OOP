package ch.zhaw.domi.uebungen.GuiSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class SwingGui {

	private JFrame frame;
	private JMenu dateiMenu;
	private JMenuItem ladenItem;
	private JMenuItem neuItem;
	private BufferedWriter writer;
	private JTextArea textArea;
	private final JFileChooser chooser = new JFileChooser();
	private JLabel label;
	private JMenuItem beendenItem;
	private JPanel panelNorth;
	private JScrollPane scroller;
	private JButton savebutton;

	public static void main(String[] args) {

		new SwingGui();
	}

	public SwingGui() {

		createFrame();
	}

	private void createFrame() {

		frame = new JFrame("TextEditor V.05");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createMenu();

		textArea = new JTextArea();
		textArea.setLineWrap(true);

		label = new JLabel("File:");

		panelNorth = new JPanel();
		panelNorth.add(label);
		panelNorth.setBackground(Color.GRAY);
		frame.getContentPane().add(BorderLayout.NORTH, panelNorth);

		scroller = new JScrollPane(textArea);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		frame.getContentPane().add(BorderLayout.CENTER, scroller);

		savebutton = new JButton("save");
		frame.getContentPane().add(BorderLayout.SOUTH, savebutton);
		savebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {

					writer = new BufferedWriter(new FileWriter(chooser
							.getSelectedFile()));
					writer.write(textArea.getText());
					writer.close();
					System.out.println("Die Datei wurde gespeichert");
					JOptionPane.showMessageDialog(null, "Text gespeichert");

				} catch (IOException e) {

					e.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Die Datei konnte nicht gespeichert werden");
				}

				catch (NullPointerException e1) {
					e1.printStackTrace();
					JOptionPane
							.showMessageDialog(null, "Keine Datei vorhanden");
				}

			}
		});

		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	private void createMenu() {
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		dateiMenu = new JMenu("Datei");
		bar.add(dateiMenu);

		neuItem = new JMenuItem("Neu");
		dateiMenu.add(neuItem);
		neuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int yeswecansave = chooser.showSaveDialog(null);

				if (yeswecansave == chooser.APPROVE_OPTION) {

					try {

						label.setText("File:"
								+ chooser.getSelectedFile().getCanonicalFile());

						writer = new BufferedWriter(new FileWriter(chooser
								.getSelectedFile()));
						writer.write(textArea.getText());
						writer.close();
						textArea.setText("");
						System.out.println("Neue Textdatei erstellt");
						JOptionPane.showMessageDialog(null,
								"Neue Textdatei erstellt");

					} catch (IOException e) {

						e.printStackTrace();
						JOptionPane.showMessageDialog(null,
								"Die Datei wurde nicht erstellt");
					}

				}

			}

		});

		ladenItem = new JMenuItem("Laden");
		dateiMenu.add(ladenItem);
		ladenItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int yeswecanload = chooser.showOpenDialog(null);

				if (yeswecanload == chooser.APPROVE_OPTION) {

					loadFile();

				}

			}

			private void loadFile() {
				try {

					initTextArea();

				} catch (IOException e1) {

					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Die Datei konnte nicht geladen werden");

				} catch (NullPointerException e1) {

					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Die Datei konnte nicht geladen werden");

				}
			}

			private void initTextArea() throws IOException,
					FileNotFoundException {
				label.setText("File:"
						+ chooser.getSelectedFile().getCanonicalFile());

				BufferedReader reader = new BufferedReader(new FileReader(
						chooser.getSelectedFile()));

				textArea.setText("");

				appendLines(reader);

				reader.close();
				textArea.setCaretPosition(0);
			}

			private void appendLines(BufferedReader reader) throws IOException {
				String line = null;
				while ((line = reader.readLine()) != null) {
					textArea.append(line);
					textArea.append("\n"); // es wird immer eine neue
											// Zeile eingefügt
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

				if (selectedYes(eingabe)) {
					System.exit(0);
				}

			}

			private boolean selectedYes(int eingabe) {
				return eingabe != JOptionPane.NO_OPTION;
			}
		});

	}

}
