package org.example;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketCliente {
    static Socket sc;
    static String nombre;

    public static void main(String[] args){

        try {
            sc = new Socket("127.0.0.1", 5554);
            System.out.println("aqui");

            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            String mensaje = in.readUTF();
            System.out.println(mensaje);

            nombre = JOptionPane.showInputDialog("Indique su nombre");
            out.writeUTF(nombre);

            new InterfazXat();

            HiloCliente hilo = new HiloCliente(sc);
            hilo.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void envio(){
        try {
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            if(InterfazXat.txtEscribe.getText().equals("Cerrar")){
                out.writeUTF(nombre + " se ha desconectado");
                System.exit(0);
            }else {
                out.writeUTF(nombre + " --> " + InterfazXat.txtEscribe.getText());
                InterfazXat.txtEscribe.setText("");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void recibo(){
        try {
            InputStream dis = sc.getInputStream();
            DataInputStream is = new DataInputStream(dis);
            String recibido = is.readUTF();
            InterfazXat.chat.append(recibido +"\n");
        }catch(IOException exc){
            exc.printStackTrace();
        }
    }

    public static void Salir(){
        try {
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(nombre + " se ha desconectado");
            System.exit(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

