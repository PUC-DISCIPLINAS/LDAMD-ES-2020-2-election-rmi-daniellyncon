# Election with Java RMI

A simple election distributed system using Java Remote Method Invocation.

## Description

The core of the project is a remote interface, a servant class that implements the remote methods, a server and a client that instantiates the servant and bind it as a stub. The goal is that the server keeps running and, if it crashes, it can recover using a file that keeps the votes. Also, the client will retry to vote for 30 seconds with a 3 seconds interval between tries if an exception is thrown and one voter should not be able to vote again. 

## Getting Started

### Dependencies

* Java 8

### Executing program

* Navigate to the src folder and run
```
javac *.java
```
* Open 3 diferent terminals;
* In each of them run the commands in this order:
```
rmiregistry
```
```
java ElectionServer
```
```
java ElectionClient
```

## Help

Some refactor is needed 

## Authors

Daniel Lyncon Gonçalves de Souza 