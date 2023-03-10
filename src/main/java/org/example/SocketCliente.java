package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketCliente {

    public static void main(String[] args){
        try{
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket();
            System.out.println("Estableciendo la conexi�n");

            InetSocketAddress addr=new InetSocketAddress("localhost",5555);
            clienteSocket.connect(addr);

            InputStream is = clienteSocket.getInputStream();
            OutputStream os= clienteSocket.getOutputStream();

            System.out.println("Enviando mensaje");

            String mensaje="mensaje desde el cliente";
            os.write(mensaje.getBytes());

            System.out.println("Mensaje enviado");

            System.out.println("Cerrando el socket cliente");

            clienteSocket.close();

            System.out.println("Terminado");

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

