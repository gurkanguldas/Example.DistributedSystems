package com.java.ServerClient.ClientNetwork;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class OutputClient 
{
	private Socket client;
	private DataInputStream input;
	private PrintStream output;
	
	public OutputClient(String IP, int port, String name) 
	{
		try 
		{
			client = new Socket(IP, port);
			input = new DataInputStream(client.getInputStream());
			output = new PrintStream(client.getOutputStream());

			output.println(name);
			
			String line = "";
			while (true) {

				line = input.readLine();

				if (line.split(":")[1].trim().equalsIgnoreCase("/exitOutput"))
					break;
				else
				{

					System.out.println(line);
				}
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
		OutputClient newClient = new OutputClient("127.0.0.1", 5001, "PC-2");
	}
}
