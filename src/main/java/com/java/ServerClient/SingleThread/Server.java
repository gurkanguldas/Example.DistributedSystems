package com.java.ServerClient.SingleThread;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable{

	private ServerSocket server;
	private Socket client;
	private DataInputStream input;
	private PrintStream output;
	
	public Server(int port) 
	{
		try 
		{
			server = new ServerSocket(port);
			
			System.out.println("Server started in port: "+port);
			System.out.println("Waiting for a client...");
			
			client = server.accept();
			
			input = new DataInputStream(client.getInputStream());
			output = new PrintStream(client.getOutputStream());
			
			System.out.println("Client accepted.");
			String line = "";
			
			Thread inputLine = new Thread(this);
			inputLine.start();
			
			while(true)
			{
				line = input.readLine();
				
				if(line.equalsIgnoreCase("/exit"))
					break;
				else
					System.out.println(line);
			}
		} 
		catch (IOException e) 
		{

		}
		
	}

	@Override
	public void run() {
		
		Scanner inputLine = new Scanner(System.in);
		String line;
		
		while(true)
		{
			line = inputLine.nextLine();
			
			if(line.equalsIgnoreCase("/exit"))
				break;
			else
				output.println(line);
		}
		
	}
	public static void main(String[] args) 
	{
		Server newServer = new Server(5001);
	}
}
