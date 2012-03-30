package ch.zhaw.domi.uebungen.GuiSwing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextEditor {
	// Instanzvariablen
	private JFrame frame;
	private JTextArea textArea;
	private JLabel filePathLabel;
	private Container contentPane;
//	private JScrollPane jScrollPane1;

	
	public static void main(String[] args) {
		new TextEditor();
	}
	
	
	// Konstruktor
	public TextEditor() {
		createGui();
	}

	private void createGui() {

		frame = new JFrame("TextEditor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		filePathLabel = new JLabel("File: ");
		contentPane = frame.getContentPane();

		// Menubar erstellen
		createMenubar();

		// Layout erstellen
		contentPane.setLayout(new BorderLayout());
		contentPane.add(BorderLayout.NORTH, filePathLabel);
		contentPane.add(BorderLayout.CENTER, new JScrollPane(createTextArea()));

		frame.setSize(500, 300);
		frame.setVisible(true);
	}

	private void createMenubar() {
		// Neue Menubar erstellen und dem Frame hinzufŸgen
		JMenuBar bar = new JMenuBar();

		// Menubar dem Frame hinzufŸgen
		frame.setJMenuBar(bar);

		// Neue MenubareintrŠge hinzufŸgen
		JMenu menuFile = new JMenu("File");
		JMenu menuHelp = new JMenu("Help");

		// Neue MenueintrŠge erstellen
		JMenuItem itemLoad = new JMenuItem("Open...");
		JMenuItem itemSave = new JMenuItem("Save as...");
		JMenuItem itemQuit = new JMenuItem("Quit");
		JMenuItem itemUeber = new JMenuItem("About");

		// EintrŠge dem Menu hinzufŸgen
		menuFile.add(itemLoad);
		menuFile.add(itemSave);
		menuFile.add(itemQuit);
		menuHelp.add(itemUeber);

		// Action fŸr Menu Items hinzufŸgen
		itemLoad.addActionListener(new LoadActionListener());
		itemSave.addActionListener(new SaveActionListener());
		itemQuit.addActionListener(new QuitActionListener());

		// Der Menubar das Menu "Datei" und "Hilfe" hinzufŸgen
		bar.add(menuFile);
		bar.add(menuHelp);
	}

	private Component createTextArea() {
		// TODO: ScrollPane implementieren
		textArea = new JTextArea();
		textArea.setColumns(20);
		textArea.setLineWrap(true);
		textArea.setRows(5);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(true);
//		jScrollPane1 = new JScrollPane(textArea);

		return textArea;
	}

	/*
	 * ReadFileBuffered
	 */
	public void readFile(String file) {
		BufferedReader reader = null;
		String zeile;
		try {
			reader = new BufferedReader(new FileReader(file));
			textArea.setText("");
			while ((zeile = reader.readLine()) != null) {
				textArea.append(zeile);
				textArea.append("\n");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Invalid data!", null,
					JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * saveFileBuffered
	 */
	public void saveFile(String file) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			String text = textArea.getText();
			writer.write(text);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Invalid data!", null,
					JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	/*
	 * ActionListeners
	 */
	private class LoadActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			JFileChooser loadDialog = new JFileChooser();
			int returnVal = loadDialog.showOpenDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					String filePath = loadDialog.getSelectedFile().getCanonicalPath();
					filePathLabel.setText(filePath);
					readFile(filePath);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private class SaveActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			JFileChooser saveDialog = new JFileChooser();
			int returnVal = saveDialog.showSaveDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					saveFile(saveDialog.getSelectedFile().getCanonicalPath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private class QuitActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			int wertInt = JOptionPane.showConfirmDialog(frame, "Quit?", null,
					JOptionPane.YES_NO_OPTION);
			if (wertInt == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

}
