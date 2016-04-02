//PRATHAM VASA
//COMPUTER NETWORKS
//PROGRAMMING ASSIGNMENT 1




//Importing the required packages
import java.io.*;
import java.util.*;
import java.net.*;




//Server Class
class TCPServer
{

public static void main(String args[])
{

try
{

//Showing the Cient the available port number for communication
ServerSocket server_sock=new ServerSocket(3624);
System.out.println("Waiting for the Client....");




//Waiting for the incoming client request
Socket sock=server_sock.accept();
System.out.println("Connection successfully established....");




//Creating the objects to send and receive the data
BufferedReader br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
PrintStream ps=new PrintStream(sock.getOutputStream());



//Accepting the choice from the user
int choice_server=Integer.parseInt(br.readLine());
if(choice_server==1)
{
//Accepting the name of the output file from the client
String output=br.readLine();
System.out.println("The complete PATH NAME of the output file is as follows: "+output);




//Creating the file object and its stream
File file=new File(output);
FileOutputStream fos=new FileOutputStream(file);





//Accepting the number of iterations from the client side
int no_of_iterations=Integer.parseInt(br.readLine());
System.out.println("Number of iterations to be performed on the server side are: "+no_of_iterations);




//int temp1,temp2;
byte aarray1[];
byte aarray2[];
byte barray1[];
byte barray2[];
byte carray1[];

char cserver[];
byte bserver[];




for(int m=0;m<no_of_iterations;m++)
{
int no_of_bytes_read=Integer.parseInt(br.readLine());
System.out.println("The number of bytes read are: "+no_of_bytes_read);



//Accepting the string from the client
String sserver=br.readLine();
System.out.println("The length of the string received is: "+sserver.length());



if(sserver.length()!=10)
{
//String converted to character array
char lastcserver[]=new char[sserver.length()];
for(int qt=0;qt<lastcserver.length;qt++)
{
lastcserver[qt]=sserver.charAt(qt);
}



//Character array converted to byte array
byte lastbserver[]=new byte[sserver.length()];
for(int i=0;i<lastbserver.length;i++)
{
lastbserver[i]=(byte)lastcserver[i];
}



if((no_of_bytes_read>5)&&(no_of_bytes_read<10))
{



barray1=new byte[5];
barray2=new byte[no_of_bytes_read-5];
for(int bx=0;bx<barray1.length;bx++)
{
barray1[bx]=lastbserver[bx];
}



for(int by=0;by<barray2.length;by++)
{
barray2[by]=lastbserver[by];
}
fos.write(barray1);
fos.write(barray2);
}





//else if(no_of_bytes_read<=5)
else
{

carray1=new byte[no_of_bytes_read];
for(int cx=0;cx<carray1.length;cx++)
{
carray1[cx]=lastbserver[cx];
}
fos.write(carray1);
}




}//end of if





else
{
//String converted to character array 
cserver=new char[10];
for(int qt=0;qt<cserver.length;qt++)
{
cserver[qt]=sserver.charAt(qt);
}


//Character array converted to byte array
bserver=new byte[10];
for(int i=0;i<bserver.length;i++)
{
bserver[i]=(byte)cserver[i];
}



int temp1=5;
//int temp2=5;




//Writing in the chunks of 5 bytes 
if(no_of_bytes_read==10)
{
aarray1=new byte[5]; 
aarray2=new byte[5];

for(int ax=0;ax<aarray1.length;ax++)
{
aarray1[ax]=bserver[ax];

}

for(int ay=0;ay<aarray2.length;ay++)
{
aarray2[ay]=bserver[temp1];
temp1=temp1+1;
}
fos.write(aarray1);
fos.write(aarray2);
}

}//end of else





}//end of for



System.out.println("File Writing done successfully in chunks of 5 bytes");
br.close();
ps.close();
//ois.close();



if(fos!=null)
{
fos.close();
}

sock.close();
server_sock.close();
}




//if the user choice is 2
else
{


//Accepting the name of the input file from the client
String input=br.readLine();



//Accepting the name of the output file from the client
String output=br.readLine();



System.out.println("The complete PATH NAME of the output file is as follows: "+output);



//Creating the file object and its stream
File file1=new File(output);
FileOutputStream fos=new FileOutputStream(file1);
File file2=new File(input);
FileInputStream fis=new FileInputStream(file2);



//Accepting the size of the file from the client
int file_size1=Integer.parseInt(br.readLine());
System.out.println("The file size sent by the client is:");
System.out.println(file_size1);



byte im_array[]=new byte[file_size1];
char im_char_array[]=new char[file_size1];
byte im_array1[]=new byte[file_size1];
char im_char_array1[]=new char[file_size1];
String abc_server_1;



//Accepting the string from the client
String abc_server=br.readLine();
fis.read(im_array);



for(int yt=0;yt<im_array.length;yt++)
{
im_char_array[yt]=(char)im_array[yt];
}

abc_server_1=new String(im_char_array);



for(int wr=0;wr<im_array1.length;wr++)
{
im_char_array1[wr]=abc_server_1.charAt(wr);
}


for(int wt=0;wt<im_array.length;wt++)
{
im_array1[wt]=(byte)im_char_array1[wt];
}


fos.write(im_array1);



System.out.println("File Writing done successfully in chunks of 5 bytes");
br.close();
ps.close();




if(fos!=null)
{
fos.close();
}


if(fis!=null)
{
fis.close();
}

sock.close();
server_sock.close();



}
}

catch(IOException e)
{
System.out.println("There is some problem in IO");
System.out.println(e);
}


}
}