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

    static HiloCliente hilo;

    public static void main(String[] args){
        try {
            new InterfazXat();
            sc = new Socket("127.0.0.1", 5554);
            System.out.println("aqui");

            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            String mensaje = in.readUTF();
            System.out.println(mensaje);

            nombre = JOptionPane.showInputDialog("Indique su nombre");
            out.writeUTF(nombre);

            hilo = new HiloCliente(sc);
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
                InterfazXat.frame.dispatchEvent(new WindowEvent(InterfazXat.frame, WindowEvent.WINDOW_CLOSING));
            }else {
                out.writeUTF(nombre + " --> " + InterfazXat.txtEscribe.getText());
                InterfazXat.chat.append(nombre + " --> " + InterfazXat.txtEscribe.getText() + "\n");
                InterfazXat.txtEscribe.setText("");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*public static boolean recibo(){
        try {
            while(!sc.isClosed()) {
            InputStream dis = sc.getInputStream();
            DataInputStream is = new DataInputStream(dis);
            String recibido = is.readUTF();
            InterfazXat.chat.append(recibido + "\n");
            }
        }catch(IOException exc){
            exc.printStackTrace();
        }
        return false;
    }*/

    public static void Salir(){
        try {
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(nombre + " se ha desconectado");
            InterfazXat.frame.dispatchEvent(new WindowEvent(InterfazXat.frame, WindowEvent.WINDOW_CLOSING));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

