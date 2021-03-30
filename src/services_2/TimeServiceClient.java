package services_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TimeServiceClient {
	public static void main(String[] args) {
		String date = dateFromServer("127.0.0.1");
		String time = timeFromServer("127.0.0.1");
		System.out.println(date);
		System.out.println(time);
	}

	public static String dateFromServer(String ipAdress) {

		try (Socket socket = new Socket(ipAdress, 75);) {

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			reader.readLine();
			writer.write("date");
			writer.newLine();
			writer.flush();

			return reader.readLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String timeFromServer(String ipAdress) {
		try (Socket socket = new Socket(ipAdress, 75);) {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			reader.readLine();
			writer.write("time");
			writer.newLine();
			writer.flush();

			return reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
