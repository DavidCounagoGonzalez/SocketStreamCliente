package org.example;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.OutputStream;
import java.net.InetSocketAddress;


public class SocketCliente {

    public static void main(String[] args){
        try{
            System.out.println("Obteniendo factoria de sockets cliente");

            SSLSocketFactory SocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            System.out.println("Creando socket cliente");

            SSLSocket clientSocket=(SSLSocket) SocketFactory.createSocket();

            System.out.println("Estableciendo la conexión");

            InetSocketAddress addr=new InetSocketAddress("localhost", 5555);
            clientSocket.bind(addr);

            OutputStream os=clientSocket.getOutputStream();

            System.out.println("Enviando mensaje");

            String mensaje="mensaje desde el cliente transmitido por SSL";
            os.write(mensaje.getBytes());


            System.out.println("Mensaje enviado");

            System.out.println("Cerrando el socket cliente");

            clientSocket.close();

            System.out.println("Terminado");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //https://stackoverflow.com/questions/8901637/re-use-a-java-socket-client-once-again
}

