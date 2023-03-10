package org.example;

import javax.swing.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketCliente {
    static String username;
    static OutputStream envia;
    static InputStream recibe;

    public static void Conexion(String ip, int port) throws IOException {
        //Creando socket
        Socket clientSocket=new Socket(ip, port);

        envia= clientSocket.getOutputStream();
        DataOutputStream envioData = new DataOutputStream(envia);

        envioData.writeUTF(username);

        System.out.println();
    }

    public static void main(String[] args){
        username = JOptionPane.showInputDialog("Indique su nombre de Usuario.");
        new InterfazXat();
        try{
            Conexion("10.0.9.15", 5555);


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

