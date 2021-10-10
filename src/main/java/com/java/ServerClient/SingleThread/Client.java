package com.java.ServerClient.SingleThread;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable {

	private Socket client;
	private DataInputStream input;
	private PrintStream output;

	public Client(String IP, int port) {
		try {
			client = new Socket(IP, port);
			
			System.out.println("Connected in " + IP + ":" + port);

			input = new DataInputStream(client.getInputStream());
			output = new PrintStream(client.getOutputStream());

			
			Scanner inputLine = new Scanner(System.in);
			String line = "";

			Thread outputLine = new Thread(this);
			outputLine.start();
			
			while (true) {
				line = inputLine.nextLine();

				if (line.equalsIgnoreCase("/exit"))
					break;
				else
					output.println(line);
			}

			input.close();
			output.close();
			inputLine.close();
			client.close();
		} catch (UnknownHostException e) {

		} catch (IOException e) {

		}
	}

	@Override
	public void run() {
		try {
			String line = "";
			while (true) {

				line = input.readLine();

				if (line.equalsIgnoreCase("/exit"))
					break;
				else
					System.out.println(line);
			}

		} catch (IOException e) 
		{
			
		}
	}

	public static void main(String[] args) {
		Client newClient = new Client("127.0.0.1", 5001);
	}
}
