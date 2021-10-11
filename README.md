# Distributed Systems

Distributed programming aims to have a job done by more than one computer. If there is more than one element in the middle, they need to communicate with each other in order to work together. Distributed programming basically relies on the communication of computers in the system. This communication is done via network connections.

![ServerClient](https://user-images.githubusercontent.com/59657939/136689792-302cdaab-3cf6-4beb-8425-e551924ca722.png)

With the network connection, communication is done via ports. The port must be specified on the server computer created with the ServerSocket class. Likewise, in the Socket class used to connect to the server, the ip address should be given along with the port.

## SingleThread Package

Communication between clients takes place via variables of type InputStream and OutputStream in the Socket class. These variables of the Socket class are used in the server.java file in the SingleThread package. In this way, it has been possible for the computer that will work as a server to send and receive data.

## MultiThread Package



