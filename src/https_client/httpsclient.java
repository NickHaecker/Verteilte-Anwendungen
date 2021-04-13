package https_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class httpsclient {

	public static void main(String[] args) throws IOException {
		String searchURL = "https://www.bundestag.de/presse";

		if(urlExists(searchURL)) {
            System.out.println(getPayload(searchURL));
		}
		else {
			System.out.println("URL existiert nicht. Bitte neu eingeben!");
		}
	}

	public static void get(String url) throws IOException {
		URL u = new URL(url);

		String path = u.getFile();
		String host = u.getHost();
		
		int port;
		if(u.getPort() != -1) {
			port = u.getPort();
		}
		else port = 443;
		
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		
		writer.write("GET " + path + " HTTP/1.1");
		writer.newLine();
		
		writer.write("Host: " + host);
		writer.newLine();
		
		writer.newLine();
		
		writer.flush();		
		
		String response = reader.readLine();
		while(response != null) {			
			System.out.println(response);
			response = reader.readLine();
		}

		socket.close();
	}
	
	public static String getPayload(String s) throws IOException {
		URL u = new URL(s);

		String path = u.getFile();
		String host = u.getHost();
		
		int port;
		if(u.getPort() != -1) {
			port = u.getPort();
		}
		else port = 443;
		
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		
		writer.write("GET " + path + " HTTP/1.1");
		writer.newLine();
		
		writer.write("Host: " + host);
		writer.newLine();
		
		writer.newLine();
		
		writer.flush();		
		
		boolean status = false;
		String data = "";
		
		String response = reader.readLine();
		//while(response != null) {		
		for(int i = 0; i < 1000; i++) {	
			if(response.equals("<!DOCTYPE html>")) {
				status = true;
			}
			if(status == true) {
				data = data + " " + response + "\n";
			}
			response = reader.readLine();
		}
		
		socket.close();
		return data;
	}
	
	public static boolean urlExists(String s) throws IOException {
		URL u = new URL(s);

		String path = u.getFile();
		String host = u.getHost();
		
		int port;
		if(u.getPort() != -1) {
			port = u.getPort();
		}
		else port = 443;
		
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		
		writer.write("GET " + path + " HTTP/1.1");
		writer.newLine();
		
		writer.write("Host: " + host);
		writer.newLine();
		
		writer.newLine();
		
		writer.flush();			
		
		String response = reader.readLine();
		socket.close();

		if(response.equals("HTTP/1.1 200 OK")) return true;
		else return false;
	}
}
