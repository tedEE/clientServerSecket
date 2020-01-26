package com.jeinmentalist;

import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws IOException {
        // ctrl p посмотреть параетры функции
        ServerSocket serverSocket = new ServerSocket(8000);
        int count = 0;

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted " + (count++));

            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );

            String request = reader.readLine();
            String response = "#" + count + ", your message length is" + request.length() + "\n";

//            writer.write("HTTP/1.0 200 OK\r\n" +
//                    "Content-type : text/html\r\n" +
//                    "\r\n" +
//                    "<h1>Java Server " + count + "</h1>\r\n");
            writer.write(response);
            writer.flush();
            writer.close();

            clientSocket.close();
        }
    }

}
