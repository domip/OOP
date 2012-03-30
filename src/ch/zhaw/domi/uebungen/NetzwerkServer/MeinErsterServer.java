package ch.zhaw.domi.uebungen.NetzwerkServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class MeinErsterServer {

	private ArrayList<String> dieFragen;
	private Random generator;
	private String randomFrage;

	public static void main(String[] args) {
		new MeinErsterServer();

	}

	public MeinErsterServer() {

		generator = new Random();

		fragenErstellen();

		startServer();

	}

	public void fragenErstellen() {

		dieFragen = new ArrayList<String>();

		dieFragen.add("Was ist der Sinn des Lebens?");
		dieFragen.add("Wieso ist der Himmel blau?");
		dieFragen.add("Wann ist endlich Freitag?");
		dieFragen.add("Ist der Osterhase echt?");

	}

	public void startServer() {

		// try {
		// ServerSocket serverSock = new ServerSocket(5555);
		//
		// while (true) {
		//
		// Socket outputSock = serverSock.accept();
		//
		// PrintWriter writer = new PrintWriter(outputSock.getOutputStream());
		//
		// String frage = RandomString();
		//
		// writer.println(frage);
		// writer.close();
		// System.out.println("frage");
		//
		// }
		//
		// } catch (IOException e) {
		//
		// e.printStackTrace();
		// }

		try {

			ServerSocket serverSock = new ServerSocket(4444);

			while (true) {

				Socket inputSock = serverSock.accept();

				InputStreamReader streamReader = new InputStreamReader(
						inputSock.getInputStream());
				BufferedReader reader = new BufferedReader(streamReader);

				String antwort = reader.readLine();
				System.out.println(antwort);

			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public String RandomString() {

		randomFrage = dieFragen.get(generator.nextInt(dieFragen.size()));

		return randomFrage;
	}

}
