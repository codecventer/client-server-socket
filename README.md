## Client Server Socket
This application makes use of a web socket in order for a client application and server application to communicate with each other in order to write the user's input to a newly created text file.

## Motivation
The motivation behind this project is simply to showcase the development of a client-server application using Java.

## Features
- Multiple clients can simultaneously connect to the server
- User input is written to a text file

## Installation
- Clone the repo:
```
git clone https://github.com/codecventer/client-server-sockets.git
```
- cd into the project folder and compile both server and client applications:
```
javac FileServer.java
javac FileClient.java
```

## How to use?
- Run the server application:
```
java FileServer
```
- Run the client application:
```
java FileClient
```
- Follow the prompts on the client's terminal window
- View the newly created text file in the project's directory

## Authors
- [Christiaan Venter](https://www.github.com/codecventer)
