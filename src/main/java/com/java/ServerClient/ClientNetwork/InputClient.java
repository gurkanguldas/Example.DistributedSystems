package com.java.ServerClient.ClientNetwork;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InputClient {

	private Socket client;
	private PrintStream output;
	
	public InputClient(String IP, int port, String name) 
	{
		Scanner inputLine = new Scanner(System.in);
		
		try 
		{
			client = new Socket(IP, port);
			output = new PrintStream(client.getOutputStream());
			
			output.println(name);
			
			String line = "";
			
			while (true) {
				line = inputLine.nextLine();

				if (line.equalsIgnoreCase("/exit"))
				{
					output.println(line);
					break;
				}
				else
					output.println(line);
			}
					
			
		} 
		catch (UnknownHostException e) 
		{
			
		} 
		catch (IOException e) 
		{
			
		}
		
	}
	public static void main(String[] args) 
	{
		InputClient newClient = new InputClient("127.0.0.1", 5001, "PC-1");
	}
}
