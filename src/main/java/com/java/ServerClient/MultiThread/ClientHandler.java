package com.java.ServerClient.MultiThread;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {

	private Socket client;
	private DataInputStream input;
	private PrintStream output;
	private ArrayList<ClientHandler> clientThreads;

	public ClientHandler(Socket client, ArrayList<ClientHandler> clientThreads) 
	{
		this.client = client;
		this.clientThreads = clientThreads;
	}

	@Override
	public void run() 
	{
		try 
		{
			input = new DataInputStream(client.getInputStream());
			output = new PrintStream(client.getOutputStream());
			this.setName(input.readLine());

			System.out.println("Client accepted for a " + this.getName());

			String line = "";

			while (true) 
			{
				line = input.readLine();
				if (line != null)
					if (line.equalsIgnoreCase("/exit"))
					{
						break;
					}
					else 
					{

						System.out.println(this.getName() + ": " + line);

						/******************** Communication Between Clients (Input -> Output) **********************/
						CommunicationConditions(line, "PC-1", "PC-2");
						/*******************************************************************************************/
					}
			}
		} 
		catch (IOException e) 
		{

		}

	}

	private void CommunicationConditions(String line, String input, String output) 
	{
		if (this.getName().equalsIgnoreCase(input))
		{
			for (ClientHandler clientHandler : clientThreads)
			{
				if (clientHandler.getName().equalsIgnoreCase(output))
				{
					clientHandler.output.println(this.getName() + ": " + line);
				}
			}
		}
	}

}
