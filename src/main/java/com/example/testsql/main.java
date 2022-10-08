package com.example.testsql;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class main {
        static ServerSocket server;
        static Socket socket;
    public static void main(String[] args) {
        try {
            server = new ServerSocket(8189);
            System.out.println("Server start...");
            socket = server.accept();
            System.out.println("Клиент подключился");
            Scanner sc = new Scanner(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true){
                String str = sc.nextLine();
                System.out.println();
                System.out.println("Клиент написал: " + str);
                if (str.equals("/end")){
                    break;
                }
                out.writeUTF("Сервер: " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
