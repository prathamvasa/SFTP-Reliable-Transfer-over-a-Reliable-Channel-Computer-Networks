•Tools and technologies used: 
Java, socket programming for TCP, Eclipse IDE.

•This project consists of building an SFTP (Simple File Transfer Protocol). It consists of a client and a server that exchange one file using TCP. 

•The client requests a connection and then sends the name of the file <output> for output and the data in file <input> to the server, which saves the info received in the file <output>. 

•The client reads the file and sends the data in chunks of 10 bytes. After sending the file, the client closes the connection and exits. 

•The server receives the data and writes the file in chunks of 5 bytes.
