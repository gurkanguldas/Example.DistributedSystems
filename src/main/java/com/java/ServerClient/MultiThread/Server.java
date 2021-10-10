package com.java.ServerClient.MultiThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server
{
	private ServerSocket server;
	private Socket client;
	private ArrayList<ClientHandler> clientThreads;
	public Server(int port) 
	{
		try
		{
			server = new ServerSocket(port);

			System.out.println("Server started in port: "+port);
			System.out.println("Waiting for a client...");
			
			clientThreads = new ArrayList<ClientHandler>();
			int i = 0;
			while(true)
			{
				client = server.accept();
				
				clientThreads.add(new ClientHandler(client, clientThreads));
				clientThreads.get(i).start();
				
				i++;	
			}
			
		} catch (IOException e) 
		{
			
		}
	}
	
	public static void main(String[] args) 
	{
		Server newServer = new Server(5001);
	}
}
