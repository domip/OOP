package ch.zhaw.domi.uebungen.NetzwerkClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		new Client();
	}

	public Client() {

		// try {
		// Socket sock = new Socket("127.0.0.1", 5555);
		//
		// InputStreamReader streamReader = new InputStreamReader(
		// sock.getInputStream());
		// BufferedReader reader = new BufferedReader(streamReader);
		//
		// String frage = reader.readLine();
		// System.out.println("Die Frage lautet: " + frage);
		// } catch (IOException ex) {
		// ex.printStackTrace();
		// }

		try {

			Socket sock = new Socket("127.0.0.1", 4444);

			PrintWriter writer = new PrintWriter(sock.getOutputStream());

			writer.println("Keine Ahnung");
			writer.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
