//PRATHAM VASA
//COMPUTER NETWORKS
//PROGRAMMING ASSIGNMENT 1


//Importing the required packages
import java.io.*;
import java.util.*;
import java.net.*;




//Client Class
class TCPClient
{

public static void main(String args[])
{

try
{

Scanner scr=new Scanner(System.in);
String sclient;


System.out.println("Enter 1 for text files and enter 2 for image(binary files):");
int choice_client=scr.nextInt();


if(choice_client==1)
{
System.out.println("Enter the port number to connect with the Server.");
System.out.println("Note that the port number should be the same as made available by the server.");
int port_number=scr.nextInt();



System.out.println("Enter the IP address of the server: ");
String ip_address=scr.next();



System.out.println("Operating with the text files");
System.out.println("Enter the complete path of the input file: ");
System.out.println("The input file is the one which has data.");
String input=scr.next();




System.out.println("Enter the complete path of the output file: ");
System.out.println("The output file is empty in the beginning.");
String output=scr.next();




//Sending request to the Server
Socket sock=new Socket(ip_address,port_number);




//Creating the file object and its stream
File file=new File(input);
FileInputStream fis=new FileInputStream(file);




//Creating objects to send and receive data
BufferedReader br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
PrintStream ps=new PrintStream(sock.getOutputStream());



//Sending the choice to the server
ps.println(choice_client);



//Sending the output file name to the server
ps.println(output);




//Total File Size
int file_size=fis.available();
System.out.println("The total file size is "+file_size+" bytes");




//Sending the number of iterations to the server
int xx=file_size%10;
int no_of_iterations=0;
if(xx==0)
{
no_of_iterations=file_size/10;
}
else
{
no_of_iterations=(file_size/10)+1;
}
ps.println(no_of_iterations);




//Sending the data of the input file in chunks of 10 bytes to the Server
byte bclient[]=new byte[10];
char cclient[]=new char[10];
int no_of_bytes_read=0;
byte lastbclient[]=new byte[xx];
char lastcclient[]=new char[xx];



while((no_of_bytes_read=fis.read(bclient))!=-1)
{
ps.println(no_of_bytes_read);





//This loop will work for the last iteration
if(no_of_bytes_read!=10)
{
for(int i=0;i<no_of_bytes_read;i++)
{
lastcclient[i]=(char)lastbclient[i];
}
sclient=new String(lastcclient);
ps.println(sclient);
}




else
{
//Converting the byte array into an array of characters
for(int i=0;i<bclient.length;i++)
{
cclient[i]=(char)bclient[i];
}


//Converting the character array into a String
sclient=new String(cclient);


//Sending the string to the server
ps.println(sclient);


for(int pv=0;pv<bclient.length;pv++)
{
bclient[pv]=0;
}

}//end of else
}//end of while



System.out.println("End of file reached");
System.out.println("File sending successful");
System.out.println("Closing the client");



br.close();
ps.close();



if(fis!=null)
{
fis.close();
}

sock.close();
}




else
{


System.out.println("Enter the port number to connect with the Server.");
System.out.println("Note that the port number should be the same as made available by the server.");
int port_number=scr.nextInt();




System.out.println("Enter the IP address of the server: ");
String ip_address=scr.next();



System.out.println("Operating with the image(binary) files");
System.out.println("Enter the complete path of the input file: ");
System.out.println("The input file is the one which has data.");
String input=scr.next();




System.out.println("Enter the complete path of the output file: ");
System.out.println("The output file is empty in the beginning.");
String output=scr.next();




//Sending request to the Server
Socket sock=new Socket(ip_address,port_number);




//Creating the file object and its stream
File file=new File(input);
FileInputStream fis=new FileInputStream(file);




//Creating objects to send and receive data
BufferedReader br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
PrintStream ps=new PrintStream(sock.getOutputStream());
//ObjectOutputStream oos=new ObjectOutputStream(sock.getOutputStream());



//Sending the choice to the server
ps.println(choice_client);


//Sending the input file name to the server
ps.println(input);



//Sending the output file name to the server
ps.println(output);




//Total File Size
int file_size=fis.available();
System.out.println("The total file size is "+file_size+" bytes");




//Sending the file size to the server
ps.println(file_size);


byte im_array[]=new byte[file_size];
char im_char_array[]=new char[file_size];
String abc_client;


int nobr=fis.read(im_array);
System.out.println("The number of bytes being read are:");
System.out.println(nobr);


for(int we=0;we<im_array.length;we++)
{
im_char_array[we]=(char)im_array[we];
}
 

abc_client=new String(im_char_array);
System.out.println("The size of the string is:");
System.out.println(abc_client.length());



//Passing the string to the server
ps.println(abc_client);



System.out.println("End of file reached");
System.out.println("File sending successful");
System.out.println("Closing the client");


br.close();
ps.close();


if(fis!=null)
{
fis.close();
}

sock.close();
}

}

catch(IOException e)
{
System.out.println("There is some problem");
System.out.println(e);
}



}
}