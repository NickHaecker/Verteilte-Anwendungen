package services_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeService {

	public static void main(String[] args) {
		try {
			try (ServerSocket serverSocket = new ServerSocket(75);) {
				while (true) {
					try {
						Socket socket = serverSocket.accept();
						BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
						BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						Write(writer, "time service");
						while (!socket.isClosed()) {
							String answer = reader.readLine();
							if (answer != null) {
								switch (answer) {
								case "date":
									Write(writer, Clock.date());
									break;
								case "time":
									Write(writer, Clock.time());
									break;
								default:
									Write(writer, "end");
									socket.close();
									break;
								}
							} else {
								socket.close();
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void Write(BufferedWriter writer, String message) {
		try {
			writer.write(message);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
